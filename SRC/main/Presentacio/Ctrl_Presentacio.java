package Presentacio;
import domain.Producto;
import domain.controller.ControladorDominio;
import domain.RolUsuario;

import java.util.List;
import java.util.Map;

import util.AlgoritmosQAP;
import util.AlgoritmosTSP;
import util.Par;
import util.Tripleta;

/**
 *
 * @author guiu
 */
public class Ctrl_Presentacio {

    private ControladorDominio CD;

    /**
     * Constructor del Controlador de Presentació.
     */
    public Ctrl_Presentacio() {
        iniciarDomini();
        System.out.println("Carregant interfície...");
        LoginPanel PI = new LoginPanel(this);
    }

    private void iniciarDomini() {
        System.out.println("Iniciant controlador de domini...");
        CD = new ControladorDominio();
    }

    //LOGIN

    public boolean existe(String name) {
        return CD.existe(name);
    }


    public String recordarContrasena(String name, String email) {
        return CD.recordarContrasena(name, email);
    }

    public boolean iniciarSesion (String name, String password) {
        return CD.iniciarSesion(name,password);
    }

    public void cerrarSesion () {
        CD.cerrarSesion();
    }

    public boolean crearUsuario(String nombre, String contraseña, String correo) {
        return CD.crearUsuario(nombre, contraseña, correo, RolUsuario.ESTANDAR);
    }

    public boolean crearUsuarioConRol(String nombre, String contraseña, String correo, RolUsuario rol) {
        return CD.crearUsuario(nombre, contraseña, correo, rol);
    }

    public RolUsuario getRol(String nombre){
        return CD.obtenerRol(nombre);
    }


    //MODIFICARCONTRA

    public boolean comprobarContraseña(String oldP){
        return CD.comprobarContraseña(oldP);
    }

    public boolean cambiarContrasena(String oldPasword, String newPasword, String newPasword2) {
        return CD.cambiarContrasena(oldPasword,newPasword, newPasword2);
    }


    //USUARI ESTANDARD

    //num calcul, num passos, matriu id
    public Par<Integer, Tripleta<Integer, Long, int[][]>>  agregarEstanteriaPriorizandoProximidadLateral(AlgoritmosTSP a, int numeroBaldas) {
        return CD.agregarEstanteriaPriorizandoProximidadLateralR(a, numeroBaldas);
    }

    public Par<Integer, Tripleta<Integer, Long, int[][]>> agregarEstanteriaPriorizandoProximidadVecina(AlgoritmosQAP a, int numeroBaldas) {
        return CD.agregarEstanteriaPriorizandoProximidadVecinaR(a, numeroBaldas);
    }

    public void swapDosProductosDistribucion(int idDist, int id1, int id2) {
        CD.swapDosProductosDistribucion(idDist, id1, id2);
    }


    public void borrarDistribucion(int idDistro) {
        CD.borrarDistribucion(idDistro);
    }


    public void agregarProducto(int idProd, String nameProd, double precio, String descripcion, double peso, String marca) {
        CD.agregarProducto(idProd, nameProd, precio, descripcion, peso, marca);
    }

    public void eliminarProducto(int idProd) {
        CD.eliminarProducto(idProd);
    }


    public void fijarDatos() {
        CD.fijarDatos();
    }

    public void reset() {
        CD.reset();
    }

    public void desfijarDatos() {
        CD.desfijarDatos();
    }

    //RESETEJAR TOT EL SUPER
    public void inicializarBaseDeDatos() {
        CD.inicializarBaseDeDatos();
    }

    public List<Producto> obtenerTodosLosProductos() {
        return CD.obtenerTodosLosProductos(); //Accede a CP a través del método público getCjtProductos()
    }

    public void importFromDB(){
        CD.importFromDB();
    }

    public int datosFijados(){
        return CD.datosFijados();
    }

    public void exportarProductosYSimilitudes(){
        CD.InicializarSimilitudes();
    }

    public void exportarConfig(){
        CD.ConfigDatosPersistencia();
    }

    public int obtenerProductosLength(){
        return CD.obtenerProductosLength();
    }

    public Producto obtenerP(int id) {
        return CD.obtenerP(id);
    }

    public Par<int[][], String> obtenerDistribucion(int idDistribucion){
        return CD.obtenerDistribucion(idDistribucion);
    }

    public Map<Integer, Par<int[][], String>> obtenerDistribuciones() {
        return CD.obtenerDistribuciones();
    }

    public void importProductosFromFile(String filePath) {
        CD.importProductosFromFile(filePath);
    }

    public void importAfinidadesFromFile(String filePath) {
        CD.importSimilitudesFromFile(filePath);
    }

    public Integer obtenerCoste(int idDist) {
        return CD.obtenerCoste(idDist);
    }

    public Long obtenerPasos(int idDist) {
        return CD.obtenerPasos(idDist);
    }
}



