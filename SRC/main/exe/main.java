package exe;

import Presentacio.Ctrl_Presentacio;
/**
 *
 * @author guiu
 */
public class main {
    private static Ctrl_Presentacio CP;
    public static void main (String[] args) throws Exception {
        System.out.println("Iniciant controlador de presentació...");
        CP = new Ctrl_Presentacio();
        CP.inicializarBaseDeDatos();
        CP.importFromDB();
        
    }
    
}
