package domain;

import domain.algorithms.AlgoritmoFactory;
import domain.algorithms.DistribucionEstanteria;
import domain.exceptions.Excepciones;
import util.*;
import java.util.*;

/**
 * La clase {@code UsuarioEstandar} representa un usuario estándar dentro del sistema.
 * Esta clase extiende de {@link Usuario} e introduce funcionalidades específicas como
 * la gestión de productos seleccionados, distribuciones, y algoritmos de optimización.
 *
 * <p>Principales funcionalidades:
 * <ul>
 *     <li>Gestionar y almacenar distribuciones organizadas.</li>
 *     <li>Agregar y priorizar distribuciones según algoritmos de optimización (TSP y QAP).</li>
 *     <li>Intercambiar productos en distribuciones existentes.</li>
 *     <li>Imprimir distribuciones con formatos tabulares para visualización en consola.</li>
 * </ul>
 *
 * <p>Atributos principales:
 * <ul>
 *     <li>{@code productosSeleccionados}: Lista de IDs de productos seleccionados por el usuario.</li>
 *     <li>{@code distribuciones}: Mapa de distribuciones donde cada ID se asocia con una matriz y descripción.</li>
 *     <li>{@code proximoIdDistribucion}: Identificador incremental para nuevas distribuciones.</li>
 *     <li>{@code metodoCalculo}: Algoritmo utilizado para resolver problemas de optimización.</li>
 * </ul>
 *
 * <p>Esta clase incluye varios métodos públicos para manejar y visualizar distribuciones,
 * así como métodos privados auxiliares para formatear la salida.
 *
 * @see Usuario
 * @see AlgoritmosTSP
 * @see AlgoritmosQAP
 * @see CjtProductos
 */
public class UsuarioEstandar extends Usuario {
    /**
     * Lista que almacena los identificadores (IDs) de los productos seleccionados.
     * Se utiliza para gestionar una selección de productos en el contexto de la aplicación.
     */
    private List<Integer> productosSeleccionados;

    /**
     * Mapa que asocia un identificador (ID) el qual es el numero de su distribución y su algorismo.
     *
     * La clave del mapa es un entero que representa el ID de la distribución.
     * El valor es un par compuesto por:
     * - Una matriz de enteros (int[][]) que representa la distribución asociada al producto.
     * - Una cadena de texto (String) con el metodo del algorismo.
     */
    private Map<Integer, Par<int[][], String>> distribuciones;

    /**
     * Mapa que asocia un identificador (ID) de una distribución con el coste y sus pasos.
     *
     * La clave del mapa es un entero que representa el ID de la distribución.
     * El valor es un par compuesto por:
     * - Un entero que representa el coste.
     * - Un long que representan los pasos del algorismo.
     */
    private Map<Integer, Par<Integer, Long>> distribuciones2;

    /**
     * Identificador único incremental para las distribuciones.
     * Se utiliza para asignar un nuevo ID a cada distribución que se agrega.
     */
    private int proximoIdDistribucion;

    /**
     * Instancia de la clase {@link AlgoritmosTSP} utilizada para resolver problemas de TSP (Traveling Salesman Problem).
     * Este atributo define el método de cálculo seleccionado para optimizar rutas en el sistema.
     */
    private AlgoritmosTSP metodoCalculo;

    /**
     * Constructor para la clase UsuarioEstandar.
     * Inicializa un usuario estándar con un nombre y una contraseña, validando que estos no sean nulos ni vacíos.
     * También inicializa los atributos necesarios para gestionar productos seleccionados, distribuciones,
     * y el método de cálculo del TSP.
     *
     * @param nombre El nombre del usuario estándar. No debe ser nulo ni estar vacío.
     * @param contrasena La contraseña del usuario estándar. No debe ser nula ni estar vacía.
     * @throws Excepciones.EntradaInvalidaException Si el nombre o la contraseña son nulos o están vacíos.
     */
    public UsuarioEstandar(String nombre, String contrasena) {
        super(nombre, contrasena);
        if (nombre == null || nombre.isEmpty() || contrasena == null || contrasena.isEmpty()) {
            throw new Excepciones.EntradaInvalidaException("Nombre, contrasena y email no deben ser null ni estar vacios.");
        }
        this.productosSeleccionados = new ArrayList<>();
        this.distribuciones = new HashMap<>();
        this.distribuciones2 = new HashMap<>();
        this.proximoIdDistribucion = 1;
        this.metodoCalculo = AlgoritmosTSP.BRUTEFORCE;
    }

    /**
     * Constructor para la clase UsuarioEstandar.
     * Inicializa un usuario estándar con un nombre, una contraseña, y un mapa de distribuciones.
     * Valida que el nombre y la contraseña no sean nulos ni estén vacíos, y permite inicializar
     * distribuciones desde un mapa existente o comenzar con un mapa vacío.
     *
     * @param nombre El nombre del usuario estándar. No debe ser nulo ni estar vacío.
     * @param contrasena La contraseña del usuario estándar. No debe ser nula ni estar vacía.
     * @param distribuciones Un mapa que asocia IDs de distribuciones con pares que contienen
     *                       una matriz de enteros y una descripción. Si es nulo, se inicializa
     *                       como un mapa vacío.
     * @throws Excepciones.EntradaInvalidaException Si el nombre o la contraseña son nulos o están vacíos.
     */
    public UsuarioEstandar(String nombre, String contrasena, Map<Integer, Par<int[][], String>> distribuciones, Map<Integer, Par<Integer, Long>> distribuciones2) {
        super(nombre, contrasena);
        if (nombre == null || nombre.trim().isEmpty() || contrasena == null || contrasena.trim().isEmpty()) {
            throw new Excepciones.EntradaInvalidaException(
                    "Nombre y contraseña no deben ser nulos ni estar vacíos."
            );
        }
        if (distribuciones == null) {
            this.distribuciones = new HashMap<>();
        } else {
            this.distribuciones = distribuciones;
        }
        if (distribuciones2 == null) {
            this.distribuciones2 = new HashMap<>();
        } else {
            this.distribuciones2 = distribuciones2;
        }
        this.productosSeleccionados = new ArrayList<>();

        if (this.distribuciones.isEmpty()) {
            this.proximoIdDistribucion = 0;
        } else {
            int maxKey = Collections.max(this.distribuciones.keySet());
            this.proximoIdDistribucion = maxKey + 1;
        }

        this.metodoCalculo = AlgoritmosTSP.BRUTEFORCE;
    }


    /**
     * Obtiene el mapa de distribuciones asociado a este usuario.
     * El mapa asocia IDs de distribuciones con pares que contienen una matriz de enteros
     * y una descripción de la distribución.
     *
     * @return Un mapa de distribuciones donde la clave es el ID de la distribución y el valor
     *         es un {@code Par<int[][], String>} que representa la distribución y su descripción.
     */
    public Map<Integer, Par<int[][], String>> obtenerDistribuciones() { // Renombrado from getDistribuciones
        return distribuciones;
    }

    /**
     * Agrega una estantería priorizando la proximidad lateral de los productos según un algoritmo TSP.
     * Este método organiza los productos en baldas de la estantería en base a su similitud y proximidad.
     *
     * @param a El algoritmo TSP a utilizar para optimizar la distribución de los productos.
     * @param numeroBaldas El número de baldas de la estantería. Debe ser mayor que 0.
     * @param productosArray La lista de productos a organizar en la estantería. No debe ser nula ni vacía.
     * @throws IllegalArgumentException Si:
     *         <ul>
     *           <li>La lista de productos es nula o está vacía.</li>
     *           <li>El número de baldas es menor o igual a 0.</li>
     *           <li>El número de productos no es divisible entre el número de baldas.</li>
     *         </ul>
     */
    public void agregarEstanteriaPriorizandoProximidadLateral(AlgoritmosTSP a, int numeroBaldas, List<Producto> productosArray) { // Renombrado from añadirEstanteria
        if (productosArray == null || productosArray.isEmpty()) {
            throw new IllegalArgumentException("No se puede agregar una estantería sin productos. [No hay productos]");
        }
        if (numeroBaldas <= 0) {
            throw new IllegalArgumentException("No se puede crear una estantería con menos de 1 balda. [Número de baldas incorrecto]");
        }
        if (productosArray.size() % numeroBaldas != 0) {
            throw new IllegalArgumentException("No hay suficientes productos para rellenar todas las estanterías. [Número de Productos módulo Número de Baldas != 0]");
        }

        int[] estanteria = new int[productosArray.size()];
        Map<Integer, Producto> decode = new HashMap<>();
        int k = 0;
        for (Producto p : productosArray) {
            int pos = p.obtenerPosMatriz();
            estanteria[k] = pos;
            k++;
            decode.put(pos, p);
        }

        CjtProductos conjunto = CjtProductos.obtenerInstancia();
        int[][] m = conjunto.obtenerMat();
        int[][] matrizSimilitudes = MatrixUtil.convertMatrix(m);
        int numProductos = productosArray.size();
        int[] productos = productosArray.stream().mapToInt(Producto::obtenerId).toArray();

        AlgoritmoFactory.obtenerDistribucionLateral(a, numProductos, numeroBaldas, productos, matrizSimilitudes);
    }

    /**
     * Agrega una estantería priorizando la proximidad lateral de los productos según un algoritmo TSP.
     * Devuelve un par que contiene el identificador único de la distribución generada y una tripleta con
     * el resultado de la distribución.
     *
     * @param a El algoritmo TSP utilizado para optimizar la distribución de los productos.
     * @param numeroBaldas El número de baldas de la estantería. Debe ser mayor que 0.
     * @param productosArray La lista de productos a organizar en la estantería. No debe ser nula ni vacía.
     * @return Un {@code Par<Integer, Tripleta<Integer, Long, int[][]>>}, donde:
     *         <ul>
     *           <li>El primer elemento es el ID único de la nueva distribución.</li>
     *           <li>El segundo elemento es una tripleta que contiene:
     *               <ul>
     *                 <li>Un entero representando la distancia o coste total de la distribución.</li>
     *                 <li>Un tiempo en milisegundos indicando la duración del cálculo.</li>
     *                 <li>Una matriz bidimensional representando la distribución final de los productos.</li>
     *               </ul>
     *           </li>
     *         </ul>
     * @throws IllegalArgumentException Si:
     *         <ul>
     *           <li>La lista de productos es nula o está vacía.</li>
     *           <li>El número de baldas es menor o igual a 0.</li>
     *           <li>El número de productos no es divisible entre el número de baldas.</li>
     *         </ul>
     */
    @Override
    public Par<Integer, Tripleta<Integer, Long, int[][]>> agregarEstanteriaPriorizandoProximidadLateralR(AlgoritmosTSP a, int numeroBaldas, List<Producto> productosArray) {
        if (productosArray == null || productosArray.isEmpty()) {
            throw new IllegalArgumentException("No se puede agregar una estantería sin productos. [No hay productos]");
        }
        if (numeroBaldas <= 0) {
            throw new IllegalArgumentException("No se puede crear una estantería con menos de 1 balda. [Número de baldas incorrecto]");
        }
        if (productosArray.size() % numeroBaldas != 0) {
            throw new IllegalArgumentException("No hay suficientes productos para rellenar todas las estanterías. [Número de Productos % Número de Baldas != 0]");
        }

        int[] estanteria = new int[productosArray.size()];
        Map<Integer, Producto> decode = new HashMap<>();
        int k = 0;
        for (Producto p : productosArray) {
            int pos = p.obtenerPosMatriz();
            estanteria[k] = pos;
            k++;
            decode.put(pos, p);
        }

        CjtProductos conjunto = CjtProductos.obtenerInstancia();
        int[][] m = conjunto.obtenerMat();
        int[][] matrizSimilitudes = MatrixUtil.convertMatrix(m);
        int numProductos = productosArray.size();
        int[] productos = productosArray.stream().mapToInt(Producto::obtenerId).toArray();

        Tripleta<Integer, Long, int[][]> resultado = AlgoritmoFactory.obtenerDistribucionLateralR(a, numProductos, numeroBaldas, productos, matrizSimilitudes);

        int id = proximoIdDistribucion++;

        int[][] aux = resultado.obtenerTercero();
        for(int i = 0; i < aux.length; ++i){
            for (int j = 0; j < aux[0].length; ++j) {
                int aux2 = aux[i][j];
                aux[i][j] = productos[aux2];
            }
        }

        resultado = new Tripleta<>(resultado.obtenerPrimero(), resultado.obtenerSegundo(), aux);

        distribuciones.put(id, new Par<>(resultado.obtenerTercero(), a.toString()));
        distribuciones2.put(id, new Par<>(resultado.obtenerPrimero(), resultado.obtenerSegundo()));

        return new Par<>(id, resultado);
    }

    /**
     * Agrega una estantería priorizando la proximidad vecina de los productos utilizando un algoritmo QAP.
     * Devuelve un par que contiene el identificador único de la distribución generada y una tripleta con
     * el resultado de la distribución.
     *
     * @param a El algoritmo QAP utilizado para optimizar la distribución de los productos.
     * @param numeroBaldas El número de baldas de la estantería. Debe ser mayor que 0.
     * @param productosArray La lista de productos a organizar en la estantería. No debe ser nula ni vacía.
     * @return Un {@code Par<Integer, Tripleta<Integer, Long, int[][]>>}, donde:
     *         <ul>
     *           <li>El primer elemento es el ID único de la nueva distribución.</li>
     *           <li>El segundo elemento es una tripleta que contiene:
     *               <ul>
     *                 <li>Un entero representando la distancia o coste total de la distribución.</li>
     *                 <li>Un tiempo en milisegundos indicando la duración del cálculo.</li>
     *                 <li>Una matriz bidimensional representando la distribución final de los productos.</li>
     *               </ul>
     *           </li>
     *         </ul>
     * @throws IllegalArgumentException Si:
     *         <ul>
     *           <li>La lista de productos es nula o está vacía.</li>
     *           <li>El número de baldas es menor o igual a 0.</li>
     *           <li>El número de productos no es divisible entre el número de baldas.</li>
     *         </ul>
     */
    @Override
    public Par<Integer, Tripleta<Integer, Long, int[][]>> agregarEstanteriaPriorizandoProximidadVecinaR(AlgoritmosQAP a, int numeroBaldas, List<Producto> productosArray) {
        if (productosArray == null || productosArray.isEmpty()) {
            throw new IllegalArgumentException("No se puede agregar una estantería sin productos. [No hay productos]");
        }
        if (numeroBaldas <= 0) {
            throw new IllegalArgumentException("No se puede crear una estantería con menos de 1 balda. [Número de baldas incorrecto]");
        }
        if (productosArray.size() % numeroBaldas != 0) {
            throw new IllegalArgumentException("No hay suficientes productos para rellenar todas las estanterías. [Número de Productos % Número de Baldas != 0]");
        }

        int[] estanteria = new int[productosArray.size()];
        Map<Integer, Producto> decode = new HashMap<>();
        int k = 0;
        for (Producto p : productosArray) {
            int pos = p.obtenerPosMatriz();
            estanteria[k] = pos;
            k++;
            decode.put(pos, p);
        }

        CjtProductos conjunto = CjtProductos.obtenerInstancia();
        int[][] m = conjunto.obtenerMat();
        int[][] matrizSimilitudes = MatrixUtil.convertMatrix(m);
        int numProductos = productosArray.size();
        int[] productos = productosArray.stream().mapToInt(Producto::obtenerId).toArray();

        Tripleta<Integer, Long, int[][]> resultado = AlgoritmoFactory.obtenerDistribucionVecinosR(a, numProductos, numeroBaldas, productos, matrizSimilitudes);

        int id = proximoIdDistribucion++;

        int[][] aux = resultado.obtenerTercero();
        for(int i = 0; i < aux.length; ++i){
            for (int j = 0; j < aux[0].length; ++j) {
                int aux2 = aux[i][j];
                aux[i][j] = productos[aux2];
            }
        }
        resultado = new Tripleta<>(resultado.obtenerPrimero(), resultado.obtenerSegundo(), aux);

        distribuciones.put(id, new Par<>(resultado.obtenerTercero(), a.toString()));
        distribuciones2.put(id, new Par<>(resultado.obtenerPrimero(), resultado.obtenerSegundo()));
        return new Par<>(id, resultado);
    }

    /**
     * Agrega una estantería priorizando la proximidad vecina de los productos utilizando un algoritmo QAP.
     * Este método organiza los productos en baldas de la estantería en base a su similitud y proximidad.
     *
     * @param a El algoritmo QAP utilizado para optimizar la distribución de los productos.
     * @param numeroBaldas El número de baldas de la estantería. Debe ser mayor que 0.
     * @param productosArray La lista de productos a organizar en la estantería. No debe ser nula ni vacía.
     * @throws IllegalArgumentException Si:
     *         <ul>
     *           <li>La lista de productos es nula o está vacía.</li>
     *           <li>El número de baldas es menor o igual a 0.</li>
     *           <li>El número de productos no es divisible entre el número de baldas.</li>
     *         </ul>
     */
    public void agregarEstanteriaPriorizandoProximidadVecina(AlgoritmosQAP a, int numeroBaldas, List<Producto> productosArray) { // Renombrado from añadirEstanteria
        if (productosArray == null || productosArray.isEmpty()) {
            throw new IllegalArgumentException("No se puede agregar una estantería sin productos. [No hay productos]");
        }
        if (numeroBaldas <= 0) {
            throw new IllegalArgumentException("No se puede crear una estantería con menos de 1 balda. [Número de baldas incorrecto]");
        }
        if (productosArray.size() % numeroBaldas != 0) {
            throw new IllegalArgumentException("No hay suficientes productos para rellenar todas las estanterías. [Número de Productos módulo Número de Baldas != 0]");
        }

        int[] estanteria = new int[productosArray.size()];
        Map<Integer, Producto> decode = new HashMap<>();
        int k = 0;
        for (Producto p : productosArray) {
            int pos = p.obtenerPosMatriz();
            estanteria[k] = pos;
            k++;
            decode.put(pos, p);
        }

        CjtProductos conjunto = CjtProductos.obtenerInstancia();
        int[][] m = conjunto.obtenerMat();
        int[][] matrizSimilitudes = MatrixUtil.convertMatrix(m);
        int numProductos = productosArray.size();
        int[] productos = productosArray.stream().mapToInt(Producto::obtenerId).toArray();

        AlgoritmoFactory.obtenerDistribucionVecinos(a, numProductos, numeroBaldas, productos, matrizSimilitudes);
    }

    /**
     * Cambia el método de cálculo utilizado para resolver problemas de optimización.
     *
     * @param nuevoMetodo El nuevo método de cálculo a utilizar. No debe ser nulo.
     * @throws IllegalArgumentException Si el nuevo método de cálculo es nulo.
     */
    public void cambiarMetodoCalculo(AlgoritmosTSP nuevoMetodo) {
        if (nuevoMetodo == null) {
            throw new IllegalArgumentException("El método de cálculo no puede ser null.");
        }
        this.metodoCalculo = nuevoMetodo;
        System.out.println("Método de cálculo cambiado a: " + nuevoMetodo);
    }

    /**
     * Intercambia las posiciones de dos productos en una distribución específica, identificada por su ID.
     * Actualiza la matriz de distribución y genera un reporte visual con los nombres de los productos.
     *
     * @param idDist El ID de la distribución donde se realizará el intercambio.
     * @param id1 El ID del primer producto a intercambiar.
     * @param id2 El ID del segundo producto a intercambiar.
     * @return Un {@code Par<int[][], String>} actualizado que contiene:
     *         <ul>
     *           <li>La matriz bidimensional modificada con los productos intercambiados.</li>
     *           <li>La descripción de la distribución.</li>
     *         </ul>
     * @throws IllegalArgumentException Si:
     *         <ul>
     *           <li>La distribución con el ID proporcionado no existe.</li>
     *           <li>Uno o ambos productos no existen.</li>
     *           <li>Uno o ambos productos no se encuentran en la distribución.</li>
     *         </ul>
     */
    public Par<int[][], String> swapDosProductosDistribucion(int idDist, int id1, int id2) {
        Par<int[][], String> p = distribuciones.get(idDist);
        if (p == null) {
            throw new IllegalArgumentException("La distribución con ID " + idDist + " no existe.");
        }

        int[][] m = p.obtenerPrimero();
        String s = p.obtenerSegundo();
        CjtProductos conjunto = CjtProductos.obtenerInstancia();

        if (conjunto.obtenerProducto(id1) == null || conjunto.obtenerProducto(id2) == null) {
            throw new IllegalArgumentException("Uno o ambos productos no existen.");
        }

        int pos1i = -1, pos1j = -1, pos2i = -1, pos2j = -1;
        boolean encontrado1 = false, encontrado2 = false;

        for (int i = 0; i < m.length; ++i) {
            for (int j = 0; j < m[0].length; ++j) {
                if (!encontrado1 && m[i][j] == id1) {
                    pos1i = i;
                    pos1j = j;
                    encontrado1 = true;
                }
                if (!encontrado2 && m[i][j] == id2) {
                    pos2i = i;
                    pos2j = j;
                    encontrado2 = true;
                }
                if (encontrado1 && encontrado2) break;
            }
            if (encontrado1 && encontrado2) break;
        }

        if (pos1i == -1 || pos2i == -1) {
            throw new IllegalArgumentException("No se encontraron ambos productos en la distribución.");
        }

        m[pos1i][pos1j] = id2;
        m[pos2i][pos2j] = id1;

        p = new Par<>(m, s);
        distribuciones.put(idDist, p);

//        CjtProductos CP = CjtProductos.obtenerInstancia();
//        int[][] m2 = new int[m.length][m[0].length];
//        //passar a una matriu amb les posicions
//        for(int i = 0; i < m.length; ++i){
//            for (int j = 0; j < m[0].length; ++j){
//                m2[i][j] = CP.obtenerProducto(m[i][j]).obtenerPosMatriz();
//            }
//        }
//
//        //actualitzar cost i steps
//        Integer newCost = 0;
//        if(s.equals("BRUTEFORCE") || s.equals("HILLCLIMBING") || s.equals("SIMULATED_ANNEALING")) newCost = DistribucionEstanteria.calcularBondadSolucionQAP(m2);
//        if(s.equals("BRUTEFORCE") || s.equals("HELDKARP") || s.equals("MST2APPROXIMATION") || s.equals("CHRISTOFIDES")) newCost = DistribucionEstanteria.calcularBondadSolucionTSP(m2);
//
//        Long steps = distribuciones2.get(idDist).obtenerSegundo() + 1;
//        Par<Integer, Long> p2 = new Par<>(newCost, steps);
//        distribuciones2.put(newCost, p2);

        Map<Integer, Producto> productosDinamicos = conjunto.obtenerProductosDinamicos();
        String[][] estanteriaRes = new String[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                Producto producto = productosDinamicos.get(m[i][j]);
                estanteriaRes[i][j] = (producto != null) ? producto.obtenerNombre() : "Producto desconocido";
            }
        }

        imprimirMatriz(idDist, estanteriaRes);
        System.out.println("Intercambio de productos realizado correctamente en la distribución ID: " + idDist);
        return p;
    }

    /**
     * Imprime todas las distribuciones disponibles, mostrando las matrices asociadas a cada distribución
     * con los nombres de los productos. Si no hay distribuciones o productos seleccionados, muestra un
     * mensaje informativo.
     */
    public void printAllDistributions() {
        if (distribuciones.isEmpty()) {
            System.out.println("No hay distribuciones aún.");
            return;
        }

        CjtProductos CP = CjtProductos.obtenerInstancia();
        Map<Integer, Producto> productosDinamicos = CP.obtenerProductosDinamicos();

        if (productosDinamicos == null || productosDinamicos.isEmpty()) {
            System.out.println("No hay productos seleccionados.");
            return;
        }

        System.out.println("Distribuciones disponibles: " + distribuciones.keySet());

        for (Integer it : distribuciones.keySet()) {
            int[][] distribucion = distribuciones.get(it).obtenerPrimero();
            int numFilas = distribucion.length;
            int numColumnas = distribucion[0].length;
            String[][] estanteriaRes = new String[numFilas][numColumnas];

            for (int i = 0; i < numFilas; i++) {
                for (int j = 0; j < numColumnas; j++) {
                    int idProducto = distribucion[i][j];
                    Producto producto = productosDinamicos.get(idProducto);
                    estanteriaRes[i][j] = (producto != null) ? producto.obtenerNombre() : "Producto desconocido";
                }
            }
            imprimirMatriz(it, estanteriaRes);
            System.out.println();
        }
    }

    /**
     * Imprime en consola la matriz de una distribución específica, identificada por su ID.
     * Cada fila de la matriz se imprime en una línea separada.
     *
     * @param numero El ID de la distribución que se desea imprimir.
     * @throws IllegalArgumentException Si no existe una distribución con el ID proporcionado.
     */
    public void imprimirDistribucionID(int numero) { // Renombrado from printDistribution
        Par<int[][], String> distribucion = distribuciones.get(numero);
        if (distribucion == null) {
            throw new IllegalArgumentException("La distribución con ID " + numero + " no existe.");
        }
        int[][] dist = distribucion.obtenerPrimero();
        System.out.println("Distribución ID " + numero + ":");
        for (int[] fila : dist) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Imprime en consola una distribución específica identificada por su ID, mostrando los nombres
     * de los productos en la matriz correspondiente.
     *
     * @param idDist El ID de la distribución que se desea imprimir.
     * @throws IllegalArgumentException Si no existe una distribución con el ID proporcionado.
     */
    public void imprimirDistribucion(int idDist) { // Renombrado from printDistribution
        Par<int[][], String> distribucion = distribuciones.get(idDist);
        if (distribucion == null) {
            throw new IllegalArgumentException("La distribución con ID " + idDist + " no existe.");
        }
        int[][] m = distribucion.obtenerPrimero();
        CjtProductos CP = CjtProductos.obtenerInstancia();

        Map<Integer, Producto> productosDinamicos = CP.obtenerProductosDinamicos();
        String[][] estanteriaRes = new String[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                Producto producto = productosDinamicos.get(m[i][j]);
                estanteriaRes[i][j] = (producto != null) ? producto.obtenerNombre() : "Producto desconocido";
            }
        }

        imprimirMatriz(idDist, estanteriaRes);
    }

    /**
     * Imprime una matriz bidimensional con formato tabular en consola, añadiendo un título con el ID de la distribución.
     * Cada celda se ajusta al ancho del contenido más largo en su respectiva columna.
     *
     * @param titulo El ID o título asociado a la matriz que se imprimirá.
     * @param matriz La matriz bidimensional de cadenas que se desea imprimir.
     */
    private void imprimirMatriz(int titulo, String[][] matriz) {
        System.out.println("Distribución ID " + titulo + ":");

        int numRows = matriz.length;
        int numCols = matriz[0].length;

        int[] columnWidths = new int[numCols];

        for (int j = 0; j < numCols; j++) {
            int maxWidth = 0;
            for (int i = 0; i < numRows; i++) {
                String value = matriz[i][j];
                if (value.length() > maxWidth) {
                    maxWidth = value.length();
                }
            }
            columnWidths[j] = maxWidth + 2;
        }

        int totalWidth = 0;
        for (int width : columnWidths) {
            totalWidth += width;
        }
        totalWidth += numCols + 1;

        imprimirLineaHorizontal(totalWidth);

        for (int i = 0; i < numRows; i++) {
            StringBuilder filaBuilder = new StringBuilder();
            for (int j = 0; j < numCols; j++) {
                filaBuilder.append("|");
                String formatString = " %-" + (columnWidths[j] - 2) + "s ";
                String value = matriz[i][j];
                filaBuilder.append(String.format(formatString, value));
            }
            filaBuilder.append("|");
            System.out.println(filaBuilder.toString());

            imprimirLineaHorizontal(totalWidth);
        }
    }

    /**
     * Imprime una línea horizontal en consola utilizando el carácter '-' con un ancho especificado.
     * Se utiliza para separar filas en tablas impresas.
     *
     * @param ancho La longitud de la línea horizontal en caracteres.
     */
    private void imprimirLineaHorizontal(int ancho) {
        for (int i = 0; i < ancho; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Elimina todas las distribuciones almacenadas, reinicia la lista de productos seleccionados y
     * restablece el contador de identificadores de distribuciones al valor inicial.
     * Si no hay distribuciones disponibles, muestra un mensaje indicativo.
     * En caso de error, imprime un mensaje de error en consola.
     */
    @Override
    public void borrarDistribuciones(){
        try {
            if (distribuciones.isEmpty()) {
                System.out.println("No hay distribuciones para borrar.");
            } else {
                distribuciones.clear();
                distribuciones2.clear();
                productosSeleccionados.clear();
                proximoIdDistribucion = 1;
                System.out.println("Todas las distribuciones han sido borradas correctamente.");
            }
        } catch (Exception e) {
            System.err.println("Error al borrar las distribuciones: " + e.getMessage());
        }
    }

    public Integer obtenerCoste(int idDist) {
        return distribuciones2.get(idDist).obtenerPrimero();
    }

    public Long obtenerPasos(int idDist) {
        return distribuciones2.get(idDist).obtenerSegundo();
    }

}
