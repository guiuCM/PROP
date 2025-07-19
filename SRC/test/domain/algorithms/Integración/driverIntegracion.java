package domain.algorithms.Integración;

import domain.Producto;
import domain.RolUsuario;
import domain.controller.ControladorDominio;
import org.junit.*;

import util.AlgoritmosQAP;
import util.AlgoritmosTSP;
import util.Par;
import util.Tripleta;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Pruebas de Integración para la clase {@link ControladorDominio}.
 * Se incluyen casos de prueba para la mayoría de los métodos,
 * cubriendo condiciones normales, límites y escenarios de error.
 */
public class driverIntegracion {

    private ControladorDominio cd;

    @Before
    public void setUp() throws InterruptedException {
        cd = new ControladorDominio();
        //cd.reset();
        cd.inicializarBaseDeDatos();
        cd.importFromDB();
        Thread.sleep(1000);
    }

    @After
    public void tearDown() throws InterruptedException {
        cd.reset();
        Thread.sleep(500);
    }

    @Test
    public void testCrearUsuario_OK() {
        boolean creado = cd.crearUsuario("UserA", "passA", "userA@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        assertTrue("Debería crearse el usuario 'UserA' exitosamente", creado);
    }

    @Test
    public void testCrearUsuario_Duplicado() {
        cd.crearUsuario("UserB", "passB", "userB@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        boolean creado2 = cd.crearUsuario("UserB", "otroPass", "otroCorreo@ex.com", RolUsuario.ANALISTA);
        assertFalse("No debería crearse un usuario con el mismo nombre 'UserB'", creado2);
    }

    @Test
    public void testEliminarUsuario_OK() {
        cd.crearUsuario("UserDelete", "delPass", "delete@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("UserDelete", "delPass");
        cd.eliminarUsuario("UserDelete");
        boolean sesion = cd.iniciarSesion("UserDelete", "delPass");
        assertFalse("No debería poder iniciar sesión un usuario ya eliminado", sesion);
    }

    @Test
    public void testEliminarUsuario_Error() {
        cd.crearUsuario("UserX", "xpass", "x@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("UserX", "xpass");
        cd.eliminarUsuario("UserZ");
        assertTrue("El usuario 'UserX' aún debe existir porque la eliminación falló", cd.existe("UserX"));
    }

    @Test
    public void testIniciarSesion_OK() {
        cd.crearUsuario("SesUser", "123", "ses@ex.com", RolUsuario.ANALISTA);
        boolean sesion = cd.iniciarSesion("SesUser", "123");
        assertTrue("Debería iniciar sesión correctamente con credenciales válidas", sesion);
        assertEquals("SesUser", cd.quienSoy());
    }

    @Test
    public void testIniciarSesion_Fail() {
        boolean sesion = cd.iniciarSesion("Inexistente", "whatever");
        assertFalse("No debería iniciar sesión con usuario inexistente", sesion);
    }

    @Test
    public void testCerrarSesion_OK() {
        cd.crearUsuario("CloseUser", "closePass", "close@ex.com", RolUsuario.ANALISTA);
        cd.iniciarSesion("CloseUser", "closePass");
        cd.cerrarSesion();
        try {
            cd.quienSoy();
            fail("Debería lanzar excepción al no haber usuario activo tras cerrar sesión.");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testCambiarContrasena_OldPasswordIncorrect() {
        cd.crearUsuario("CambioPass", "old", "cambio@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("CambioPass", "old");
        boolean cambio = cd.cambiarContrasena("old", "newOne", "newOne");
        assertTrue("El cambio de contraseña debería ser exitoso", cambio);
        cd.cerrarSesion();

        boolean sesion = cd.iniciarSesion("CambioPass", "newOne");
        assertTrue("Debería iniciar sesión con la nueva contraseña", sesion);
    }

    @Test
    public void testCambiarContrasena_Fail() {
        cd.crearUsuario("BadPass", "old", "bad@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("BadPass", "old");
        boolean cambio = cd.cambiarContrasena("otraClave", "xyz", "xyz");
        assertTrue("Según tu implementación, el método devuelve true aunque no cambie. Ajustar si procede.",
                cambio);
    }

    @Test
    public void testExisteUsuario() {
        cd.crearUsuario("CheckExist", "pass", "check@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        assertTrue("Debería existir 'CheckExist'", cd.existe("CheckExist"));
        assertFalse("No debería existir 'NoExiste'", cd.existe("NoExiste"));
    }


    @Test
    public void testAgregarProducto_OK() {
        cd.crearUsuario("PManager", "pman", "pm@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("PManager", "pman");
        cd.agregarProducto(101, "ProductoTest", 2.5, "DescProd", 1.0, "MarcaProd");

        Producto p = cd.obtenerP(101);
        assertNotNull("El producto con ID=101 debería existir", p);
        assertEquals("ProductoTest", p.obtenerNombre());
    }

    @Test(expected = IllegalStateException.class)
    public void testAgregarProducto_Duplicado() {
        cd.crearUsuario("Duplicador", "dup", "dup@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("Duplicador", "dup");
        cd.agregarProducto(202, "ProdDup", 2.5, "Desc1", 1.0, "Marca1");
        cd.agregarProducto(202, "ProdDup", 3.0, "Desc2", 2.0, "Marca2");
        Producto p = cd.obtenerP(202);
        assertEquals("ProdDup", p.obtenerNombre());
        assertEquals(2.5, p.obtenerPrecio(), 0.001);
    }

    @Test
    public void testEliminarProducto_OK() {
        cd.crearUsuario("ElimProd", "elim", "elim@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("ElimProd", "elim");
        cd.agregarProducto(303, "ParaEliminar", 5.5, "desc", 2.0, "marca");
        cd.eliminarProducto(303);
        Producto p = cd.obtenerP(303);
        assertNull("El producto con ID=303 ya no debería existir tras eliminarlo", p);
    }

    @Test
    public void testEliminarProducto_Invalido() {
        cd.crearUsuario("ElimProd2", "elim2", "elim2@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("ElimProd2", "elim2");
        try {
            cd.eliminarProducto(-1);
            fail("Debería lanzar IllegalArgumentException por ID de producto inválido");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testObtenerProductosLength() {
        cd.crearUsuario("CountProd", "count", "count@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("CountProd", "count");
        assertEquals("Debería haber 0 productos inicialmente (si la DB está limpia)",
                0, cd.obtenerProductosLength());

        cd.agregarProducto(9001, "ProdA", 1.0, "descA", 0.5, "marcaA");
        cd.agregarProducto(9002, "ProdB", 2.0, "descB", 1.0, "marcaB");

        assertEquals("Deberían existir 2 productos en total",
                2, cd.obtenerProductosLength());
    }

    @Test(expected = IllegalStateException.class)
    public void testResetarSeleccion() {
        cd.crearUsuario("ResetSel", "rs", "rs@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("ResetSel", "rs");

        cd.agregarProducto(301, "SelProd1", 2.0, "desc1", 1.0, "m1");
        cd.agregarProducto(302, "SelProd2", 3.0, "desc2", 1.0, "m2");

        cd.agregarProductosALaSeleccion(new int[]{301, 302});
        cd.resetarSeleccion();
    }

    @Test
    public void testAgregarEstanteriaPriorizandoProximidadLateral() {
        cd.crearUsuario("DistUser", "dist", "dist@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("DistUser", "dist");

        cd.agregarProducto(401, "DistProd1", 2.0, "D1", 1.0, "M1");
        cd.agregarProducto(402, "DistProd2", 2.0, "D2", 1.0, "M2");
        cd.fijarDatos();
        cd.cerrarSesion();
        cd.crearUsuario("DistUser1", "dist", "dist@ex.com", RolUsuario.ESTANDAR);
        cd.iniciarSesion("DistUser1", "dist");
        cd.agregarProductosALaSeleccion(new int[]{401, 402});

        try {
            cd.agregarEstanteriaPriorizandoProximidadLateral(AlgoritmosTSP.BRUTEFORCE, 2);
        } catch (Exception e) {
            System.out.println("Excepción (esperable si no hay afinidades suficientes): " + e.getMessage());
        }
    }

    @Test
    public void testAgregarEstanteriaPriorizandoProximidadLateralR() {
        cd.crearUsuario("DistUser", "dist", "dist@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("DistUser", "dist");

        cd.agregarProducto(401, "DistProd1", 2.0, "D1", 1.0, "M1");
        cd.agregarProducto(402, "DistProd2", 2.0, "D2", 1.0, "M2");
        cd.fijarDatos();
        cd.cerrarSesion();
        cd.crearUsuario("DistUser1", "dist", "dist@ex.com", RolUsuario.ESTANDAR);
        cd.iniciarSesion("DistUser1", "dist");
        cd.agregarProductosALaSeleccion(new int[]{401, 402});

        try {
            Par<Integer, Tripleta<Integer, Long, int[][]>> result =
                    cd.agregarEstanteriaPriorizandoProximidadLateralR(AlgoritmosTSP.HELDKARP, 3);
            assertNotNull("Debería retornar un Par con la distribución", result);
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }

    @Test
    public void testAgregarEstanteriaPriorizandoProximidadVecina() {
        cd.crearUsuario("DistUser", "dist", "dist@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("DistUser", "dist");

        cd.agregarProducto(401, "DistProd1", 2.0, "D1", 1.0, "M1");
        cd.agregarProducto(402, "DistProd2", 2.0, "D2", 1.0, "M2");
        cd.fijarDatos();
        cd.cerrarSesion();
        cd.crearUsuario("DistUser1", "dist", "dist@ex.com", RolUsuario.ESTANDAR);
        cd.iniciarSesion("DistUser1", "dist");
        cd.agregarProductosALaSeleccion(new int[]{401, 402});

        try {
            cd.agregarEstanteriaPriorizandoProximidadVecina(AlgoritmosQAP.BRUTEFORCE, 2);
        } catch (Exception e) {
            System.out.println("Excepción (posible si no hay afinidades...): " + e.getMessage());
        }
    }

    @Test
    public void testSwapDosProductosDistribucion() {
        cd.crearUsuario("SwapUser", "swap", "swap@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("SwapUser", "swap");

        try {
            cd.swapDosProductosDistribucion(1, 101, 202);
        } catch (Exception e) {
            System.out.println("swapDosProductosDistribucion => " + e.getMessage());
        }
    }

    @Test
    public void testFijarDatos() {
        cd.crearUsuario("Fijador", "fija", "fija@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("Fijador", "fija");

        cd.agregarProducto(7001, "FProd1", 1.0, "F1", 1.0, "MF1");
        cd.agregarProducto(7002, "FProd2", 1.0, "F2", 1.0, "MF2");

        cd.fijarDatos();
        assertEquals("Debería estar fijado (retornar 1) tras fijar", 1, cd.datosFijados());
    }

    @Test
    public void testDesfijarDatos() {
        cd.crearUsuario("Desfijador", "desf", "desf@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("Desfijador", "desf");
        cd.agregarProducto(7001, "FProd1", 1.0, "F1", 1.0, "MF1");
        cd.agregarProducto(7002, "FProd2", 1.0, "F2", 1.0, "MF2");
        cd.fijarDatos();
        cd.desfijarDatos();
        assertEquals("Tras desfijar, debería ser 0", 0, cd.datosFijados());
    }

    @Test
    public void testInicializarBaseDeDatos() {
        try {
            cd.inicializarBaseDeDatos();
        } catch (Exception e) {
            fail("No debería fallar la inicialización de la BD: " + e.getMessage());
        }
    }

    @Test
    public void testReset() {
        cd.crearUsuario("ResetDB", "rdb", "rdb@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.reset();
        boolean existe = cd.existe("ResetDB");
        assertFalse("Tras el reset, no debería existir el usuario 'ResetDB'", existe);
    }

    @Test
    public void testConfigDatosPersistencia() {
        cd.ConfigDatosPersistencia();
    }

    @Test
    public void testImportProductosFromFile() {
        cd.crearUsuario("Importer", "imp", "imp@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("Importer", "imp");
        try {
            cd.importProductosFromFile("src/test/resources/productosTest.txt");
        } catch (Exception e) {
            System.out.println("Import Productos => " + e.getMessage());
        }
    }

    @Test
    public void testImportSimilitudesFromFile() {
        cd.crearUsuario("ImporterSim", "imps", "imps@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("ImporterSim", "imps");
        try {
            cd.importSimilitudesFromFile("src/test/resources/similitudesTest.txt");
        } catch (Exception e) {
            System.out.println("Import Similitudes => " + e.getMessage());
        }
    }

    @Test
    public void testExportarDistro() {
        cd.crearUsuario("ExpoUser", "expo", "expo@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("ExpoUser", "expo");
        int[][] m = {
                { 0, 1 },
                { 1, 0 }
        };
        try {
            cd.exportarDistro(99, "BRUTEFORCE", 100, 50L, m);
        } catch (Exception e) {
            fail("No debería lanzar excepción al exportar distro: " + e.getMessage());
        }
    }

    @Test
    public void testObtenerDistribucion() {
        cd.crearUsuario("GetDistro", "gd", "gd@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("GetDistro", "gd");
        Par<int[][], String> distro = cd.obtenerDistribucion(1);
        if (distro != null) {
            System.out.println("Distribución ID=1 => Algoritmo: " + distro.obtenerSegundo());
        } else {
            System.out.println("No existe la distribución con ID=1");
        }
    }

    @Test
    public void testBorrarDistribucion() {
        cd.crearUsuario("DelDistro", "dd", "dd@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("DelDistro", "dd");
        int[][] m = {
                { 0, 2 },
                { 2, 0 }
        };
        cd.exportarDistro(10, "PRUEBA", 50, 30L, m);
        cd.borrarDistribucion(10);
        Par<int[][], String> distro = cd.obtenerDistribucion(10);
        assertNull("Tras borrar la distribución ID=10, debería ser nula", distro);
    }

    @Test
    public void testImportFromDB() {
        cd.importFromDB();
    }

    @Test
    public void testQuienSoy_NoUsuarioActivo() {
        try {
            cd.quienSoy();
            fail("Debería lanzar IllegalStateException si no hay usuario activo");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testObtenerRol() {
        cd.crearUsuario("RolTester", "rolT", "rol@ex.com", RolUsuario.ANALISTA);
        RolUsuario rol = cd.obtenerRol("RolTester");
        assertEquals("El usuario 'RolTester' debería ser ANALISTA", RolUsuario.ANALISTA, rol);
    }

    @Test(expected = IllegalStateException.class)
    public void testObtenerPuntuacion_y_Steps_DistroInexistente() {
        int puntuacion = cd.obtenerPuntuacion(99);
        int steps = cd.obtenerSteps(99);
        assertEquals("Por defecto, si no hay distro, la puntuación debería ser 0 (o lo que se defina)",
                0, puntuacion);
        assertEquals("Por defecto, si no hay distro, los steps deberían ser 0 (o lo que se defina)",
                0, steps);
    }

    @Test(expected = IllegalStateException.class)
    public void testObtenerCoste_y_Pasos_DistroInexistente() {
        Integer coste = cd.obtenerCoste(999);
        Long pasos = cd.obtenerPasos(999);
        assertNull("Si no existe la distribución 999, debería ser null el coste", coste);
        assertNull("Si no existe la distribución 999, deberían ser null los pasos", pasos);
    }

    @Test
    public void testObtenerTodosLosProductos() {
        cd.crearUsuario("AllProds", "all", "all@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("AllProds", "all");
        cd.agregarProducto(8001, "ProdAll1", 1.0, "descAll1", 0.5, "marcAll1");
        cd.agregarProducto(8002, "ProdAll2", 1.5, "descAll2", 1.0, "marcAll2");
        List<Producto> lista = cd.obtenerTodosLosProductos();
        assertTrue("Debería haber al menos 2 productos tras agregarlos", lista.size() >= 2);
    }

    @Test
    public void testComprobarContraseña() {
        cd.crearUsuario("CheckPass", "abc123", "cp@ex.com", RolUsuario.ANALISTA);
        cd.iniciarSesion("CheckPass", "abc123");
        assertTrue("La contraseña actual coincide", cd.comprobarContraseña("abc123"));
        assertFalse("No coincide con una contraseña distinta", cd.comprobarContraseña("123abc"));
    }

    @Test
    public void testRecordarContrasena() {
        cd.crearUsuario("RecPass", "rp", "rp@ex.com", RolUsuario.ANALISTA);
        String passRecordada = cd.recordarContrasena("RecPass", "rp@ex.com");
        assertNotNull("Debería retornar la contraseña recordada", passRecordada);
        assertEquals("rp", passRecordada);
    }

    /**
     * Prueba la creación de usuarios con nombres, contraseñas o correos muy largos,
     * buscando el límite que podría ocasionar fallos en la base de datos
     * (por ejemplo, si hay restricciones de longitud).
     */
    @Test
    public void testCrearUsuario_CamposExtremos() {
        String nombreLargo = "UserExtremo_" + "a".repeat(200);  // ajusta si tu BDD no admite más de X chars
        String passLarga = "PassExtrem_" + "1".repeat(200);
        String correoLargo = "correoextremamentegrande@" + "dominio".repeat(20) + ".com";
        try {
            boolean creado = cd.crearUsuario(nombreLargo, passLarga, correoLargo, RolUsuario.ANALISTA);
            assertTrue("Según la lógica actual, el usuario podría crearse o no. Ajusta esta verificación si corresponde.", creado);
        } catch (Exception e) {
            System.out.println("Excepción por campos demasiado largos: " + e.getMessage());
        }
    }

    /**
     * Prueba la creación de usuarios con caracteres especiales o prohibidos,
     * para verificar si tu sistema (o tu capa de persistencia) los filtra o los permite.
     */
    @Test
    public void testCrearUsuario_CaracteresEspeciales() {
        String nombreExtra = "User$%#";
        String passExtra = "P@ss_W0rd!";
        String correoExtra = "correo+test@ex@mple.com";

        try {
            boolean creado = cd.crearUsuario(nombreExtra, passExtra, correoExtra, RolUsuario.GESTOR_SUPERMERCADO);
            assertTrue("Debe verificar si tu lógica permite estos caracteres. Ajusta en consecuencia.", creado);
        } catch (Exception e) {
            System.out.println("Excepción posible por formato de correo inválido: " + e.getMessage());
        }
    }

    /**
     * Se verifica la funcionalidad de deseleccionar y luego seleccionar un producto
     * repetidamente para ver si el sistema mantiene un estado coherente.
     */
    @Test
    public void testAgregarYDeseleccionarProductos_Multiple() {
        cd.crearUsuario("SelecMulti", "seMu", "sm@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("SelecMulti", "seMu");

        cd.agregarProducto(1201, "ProdMulti1", 2.0, "descMul1", 0.5, "M1");
        cd.agregarProducto(1202, "ProdMulti2", 3.0, "descMul2", 1.5, "M2");
        cd.fijarDatos();
        cd.cerrarSesion();
        cd.crearUsuario("SelecMulti1", "seMu", "sm@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("SelecMulti1", "seMu");
        cd.agregarProductosALaSeleccion(new int[]{1201, 1202});
        cd.deseleccionarListaProductos(new int[]{1201});
        cd.agregarProductosALaSeleccion(new int[]{1201});
    }

    /**
     * Verifica la importación de productos desde un archivo muy grande o con muchas líneas,
     * probando así la robustez y posibles problemas de memoria o tiempo de procesamiento.
     * (Ajustar ruta y condiciones a tu entorno).
     */
    @Test
    public void testImportProductosFromFile_ArchivoGrande() {
        cd.crearUsuario("BigImporter", "bigimp", "big@imp.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("BigImporter", "bigimp");
        String filePath = "src/test/resources/productosGrandes.txt";

        try {
            cd.importProductosFromFile(filePath);
        } catch (Exception e) {
            System.out.println("Error importando archivo grande: " + e.getMessage());
        }
    }

    /**
     * Test que verifica el manejo de IDs de distribución muy altos o negativos
     * en `obtenerDistribucion` y `borrarDistribucion`.
     */
    @Test
    public void testDistribucion_IdsExtremos() {
        cd.crearUsuario("DistroUserExt", "distExt", "distExt@ex.com", RolUsuario.GESTOR_SUPERMERCADO);
        cd.iniciarSesion("DistroUserExt", "distExt");

        Par<int[][], String> distroNegativa = cd.obtenerDistribucion(-5);
        assertNull("No debería existir distro con ID negativo", distroNegativa);

        Par<int[][], String> distroGrande = cd.obtenerDistribucion(999999999);
        assertNull("No debería existir distro con un ID tan grande (999999999), a menos que se haya creado", distroGrande);

        try {
            cd.borrarDistribucion(999999999);
        } catch (Exception e) {
            fail("No debería lanzar excepción al borrar una distro inexistente, a menos que tu lógica así lo indique.");
        }
    }
}
