package Persistencia;

import domain.RolUsuario;
import util.Par;

import java.util.Map;

/**
 * ControladorPersistencia manages the persistence layer for the application,
 * handling database connections and operations related to products, similarities,
 * distributions, and their details.
 */
public class ControladorPersistencia {
       GestorUsuarios GU;
       GestorProductosYSimilitudes GPS;
       GestorDistribuciones GD;
       GestorConfig GC;

       public ControladorPersistencia(){
              this.GD = new GestorDistribuciones();
              this.GU = new GestorUsuarios();
              this.GPS = new GestorProductosYSimilitudes();
              this.GC = new GestorConfig();
       }

       public void inicializarBaseDeDatos() {
              try {
                     Class.forName("org.sqlite.JDBC");
                     System.out.println("Driver cargado exitosamente.");
              } catch (ClassNotFoundException e) {
                     System.err.println("Error al cargar el driver: " + e.getMessage());
                     e.printStackTrace();
              }
              GD.inicializarBaseDeDatos();
              GU.inicializarBaseDeDatos();
              GPS.inicializarBaseDeDatos();
              GC.inicializarBaseDeDatos();
              this.insertTablaConfig("FijarDatos", 0);
       }

       public void borrarBaseDatos() {
              GD.borrarBaseDeDatos();
              GU.borrarBaseDeDatos();
              GPS.borrarBaseDeDatos();
              GC.borrarBaseDeDatos();
       }

       // PRODUCTO CRUD

       public void insertarProducto(int id, String nombre, double precio, String descripcion, double peso, String marca) {
              GPS.insertarProducto(id,nombre,precio,descripcion,peso,marca);
       }

       public void borrarProducto(int id) {
              GPS.borrarProducto(id);
       }

       public void selectProducto(int id) {
              GPS.selectProducto(id);
       }

       public Object[][] selectTodosLosProductos() {
              return GPS.seleccionarTodosLosProductos();
       }

       // SIMILITUDES CRUD

       public void insertarSimilitud(int idProducto1, int idProducto2, int similitud) {
              GPS.insertarSimilitud(idProducto1, idProducto2, similitud);
       }

       public void modificarSimilitud(int idProducto1, int idProducto2, int similitud) {
              GPS.modificarSimilitud(idProducto1, idProducto2, similitud);
       }

       public Object[][] selectTodasLasSimilitudes(){
              return GPS.seleccionarTodasLasSimilitudes();
       }

       public void deleteTablaSimilitudes(){ GPS.borrarTablaSimilitudes();}

       // DISTRIBUCIONES CRUD

       public void insertarDistribucion(int idDistribucion, String idUsuario, String tipoAlgoritmo, int puntuacion, long steps, int[][] matrizDistribucion) {
            GD.insertarDistribucion(idDistribucion, idUsuario, tipoAlgoritmo, puntuacion, steps, matrizDistribucion);
       }

       public void borrarDistribucion(int idDistribucion, String user) {
              GD.borrarDistribucion(idDistribucion, user);
       }

       public Par<int[][], String> selectDistribucion(int idDistribucion, String user){
              return GD.selectDistribucion(idDistribucion, user);
       }

       public int obtenerPuntuacion(int idDistribucion, String idUsuario) {
              return GD.obtenerPuntuacionDistribucion(idDistribucion, idUsuario);
       }

       public int obtenerSteps(int idDistro, String idUsuario) {
              return GD.obtenerStepsDistribucion(idDistro, idUsuario);
       }

       public Map<Integer, Par<int[][], String>> selectDistrosUser(String idUser) {
              Map<Integer, Par<int[][], String>> result = GD.selectDistrosUser(idUser);
              if (result.isEmpty()) return null;
              return result;
       }

       public Map<Integer, Par<Integer, Long>> selectDistrosUser2(String idUser) {
              Map<Integer, Par<Integer, Long>> result = GD.selectDistrosUser2(idUser);
              if (result.isEmpty()) return null;
              return result;
       }

       public void deleteTodasDistribuciones () {
              GD.borrarBaseDeDatos();
       }

       // USER CRUD

       public void insertTablaUsuarios(String name, String password, String correo, String rol) {
              GU.insertTablaUsuarios(name, password, correo, rol);
       }

       public void deleteTablaUsuarios(String name) {
              GU.deleteTablaUsuarios(name);
       }

       public boolean selectTablaUsuarios(String name, String password) {
              return GU.selectTablaUsuarios(name,password);
       }

       public boolean existeUsuario(String name) {
              return GU.existeUsuario(name);
       }

       public boolean cambiarContrasena(String userName, String oldpass , String newPass, String newPass2) {
              return GU.modificarContraseña(userName, oldpass, newPass, newPass2);
       }

       public void modificarRol(String name, String newrol) {
              GU.modificarRol(name, newrol);
       }

       public RolUsuario selectRolUser(String name) {
              return GU.selectRolUser(name);
       }

       public String recordarContrasena(String name, String email) {
              return GU.selectContra(name, email);
       }

       // CONFIG CRUD
       public void insertTablaConfig(String name, int value){
              GC.insertTablaConfig(name, value);
       }

       public void modificarConfigValue(String name, int value) {
              GC.modificarConfigValue(name, value);
       }

       public int consultConfig(String name) {
              return GC.selectConfig(name);
       }



}
