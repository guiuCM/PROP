/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacio;

import domain.RolUsuario;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase LoginPanel que representa la interfaz de inicio de sesión para los usuarios.
 * Permite a los usuarios iniciar sesión, registrarse, recuperar contraseñas y acceder al sistema.
 *
 * Esta clase extiende de javax.swing.JFrame y utiliza componentes de la biblioteca Swing.
 *
 * @author guiu
 */
public class LoginPanel extends javax.swing.JFrame {
    private final Ctrl_Presentacio CP;
    private String nombre;
    private String contraseña;
    private String email;
    private RolUsuario rol;
    private String token;

    /**
     * Constructor de la clase LoginPanel.
     * Inicializa los componentes y configura el panel en el centro de la pantalla.
     *
     * @param CP Controlador de presentación.
     */
    LoginPanel(Ctrl_Presentacio CP) {
        this.CP = CP;
        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true); 
    }

    /**
     * Inicializa los componentes gráficos del panel.
     * Este método es generado automáticamente por el editor de formularios.
     */
    private void initComponents() {

        título = new java.awt.Label();
        lamina2 = new javax.swing.JPanel();
        lamina1 = new javax.swing.JPanel();
        textoNombre = new javax.swing.JTextField();
        textoContra = new javax.swing.JPasswordField();
        txtContra = new javax.swing.JLabel();
        txtNom = new javax.swing.JLabel();
        logIn = new javax.swing.JButton();
        signIn = new javax.swing.JButton();
        recordarContra = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        help = new javax.swing.JButton();

        título.setText("label1");

        javax.swing.GroupLayout lamina2Layout = new javax.swing.GroupLayout(lamina2);
        lamina2.setLayout(lamina2Layout);
        lamina2Layout.setHorizontalGroup(
            lamina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        lamina2Layout.setVerticalGroup(
            lamina2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        textoNombre.setCaretColor(new java.awt.Color(255, 255, 0));
        textoNombre.addActionListener(new java.awt.event.ActionListener() {
            /**
             * Maneja la acción al ingresar el nombre de usuario.
             *
             * @param evt Evento de acción.
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombreActionPerformed(evt);
            }
        });

        textoContra.addActionListener(new java.awt.event.ActionListener() {
            /**
             * Procesa el evento al hacer clic en el botón de iniciar sesión.
             * Valida las credenciales y redirige al menú correspondiente según el rol del usuario.
             *
             * @param evt Evento de acción.
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoContraActionPerformed(evt);
            }
        });

        txtContra.setText("CONTRASEÑA");

        txtNom.setText("NOMBRE");

        logIn.setBackground(new java.awt.Color(51, 51, 255));
        logIn.setForeground(new java.awt.Color(255, 255, 255));
        logIn.setText("ACCEDER");
        logIn.addActionListener(new java.awt.event.ActionListener() {
            /**
             * Procesa el evento al ingresar la contraseña.
             *
             * @param evt Evento de acción.
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInActionPerformed(evt);
            }
        });

        signIn.setText("REGISTRARTE");
        signIn.addActionListener(new java.awt.event.ActionListener() {
            /**
             * Procesa el registro de un nuevo usuario.
             * Muestra un formulario para ingresar nombre, contraseña, email y seleccionar un rol.
             *
             * @param evt Evento de acción.
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInActionPerformed(evt);
            }
        });

        recordarContra.setForeground(new java.awt.Color(0, 51, 255));
        recordarContra.setText("<html><u>Recordar contraseña<u><html>");
        recordarContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordarContraMouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RESETEAR SUPER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            /**
             * Resetea el super.
             * Resetea el super, resetea todos los productos, usuarios, afinidades y distribuciones.
             *
             * @param evt Evento de acción.
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lamina1Layout = new javax.swing.GroupLayout(lamina1);
        lamina1.setLayout(lamina1Layout);
        lamina1Layout.setHorizontalGroup(
            lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lamina1Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lamina1Layout.createSequentialGroup()
                        .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContra)
                            .addComponent(txtNom)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(textoContra, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(recordarContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lamina1Layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addGroup(lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(logIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lamina1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        lamina1Layout.setVerticalGroup(
            lamina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lamina1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(40, 40, 40)
                .addComponent(txtNom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtContra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoContra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recordarContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(logIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signIn)
                .addGap(20, 20, 20))
        );

        jLabel3.setBackground(new java.awt.Color(102, 255, 255));

        titulo.setFont(new java.awt.Font("Liberation Sans", 0, 30)); // NOI18N
        titulo.setText("¡Bienvenidos al supermercado!");

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            /**
             * Cierra la aplicación y guarda los datos antes de salir.
             *
             * @param evt Evento de acción.
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            /**
             * Abre el manual de usuario en formato PDF.
             *
             * @param evt Evento de acción.
             */
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(help))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(titulo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lamina1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lamina1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exit)
                            .addComponent(help))
                        .addGap(56, 56, 56)
                        .addComponent(titulo)
                        .addGap(175, 175, 175)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }

    /**
     * Maneja la acción al ingresar el nombre de usuario.
     * Este método se ejecuta cuando el usuario presiona Enter en el campo de texto del nombre.
     * Actualmente, no implementa ninguna funcionalidad específica.
     *
     * @param evt Evento de acción generado por el campo de texto del nombre.
     */
    private void textoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombreActionPerformed
    }

    /**
     * Procesa el evento al hacer clic en el botón de iniciar sesión.
     *
     * Valida las credenciales del usuario ingresadas en los campos de texto. Si las credenciales son correctas,
     * se asigna el rol correspondiente al usuario y se abre el menú correspondiente (Estandar, Analista o Gestor).
     * En caso de credenciales inválidas, muestra un mensaje de error.
     *
     * @param evt Evento de acción generado por el botón de iniciar sesión.
     */
    private void logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInActionPerformed
        nombre = textoNombre.getText();
        contraseña =  String.valueOf(textoContra.getPassword());
        if (CP.existe(nombre)){
            if(CP.iniciarSesion(nombre,contraseña) == true) {
                
                textoContra.setBackground(Color.WHITE);
                
  
                this.setVisible(false);
                rol = CP.getRol(nombre);
                if(rol == null | rol == RolUsuario.ESTANDAR){  //mirar
                    MenuEstandard m = new MenuEstandard(this, CP, nombre);
                    m.setVisible(true);
                }
                else if(rol == RolUsuario.ANALISTA){  
                    MenuAnalista m1 = new MenuAnalista(this, CP, nombre);
                    m1.setVisible(true);
                }
                else{
                    MenuGestor m2 = new MenuGestor(this, CP, nombre);
                    m2.setVisible(true);
                }
                textoNombre.setText("");
                textoContra.setText("");
            } 
            
            else {
                textoContra.setText("");
                textoContra.setBackground(new Color(255, 204, 204)); 
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            textoNombre.setText("");
            textoContra.setText("");
            textoContra.setBackground(Color.WHITE);
            JOptionPane.showMessageDialog(null, "Usuario no registrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * Procesa el evento al ingresar la contraseña.
     *
     * @param evt Evento de acción.
     */
    private void textoContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoContraActionPerformed
    }

    /**
     * Procesa el registro de un nuevo usuario.
     * Muestra un formulario para ingresar nombre, contraseña, email y seleccionar un rol.
     *
     * @param evt Evento de acción.
     */
    private void signInActionPerformed(java.awt.event.ActionEvent evt) {
        JTextField nombreField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField emailField = new JTextField();
        
        RolUsuario[] roles = {RolUsuario.ESTANDAR, RolUsuario.ANALISTA, RolUsuario.GESTOR_SUPERMERCADO};
        JList<RolUsuario> rolField = new JList<>(roles);
        rolField.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        rolField.setVisibleRowCount(1);
        JScrollPane scrollPane = new JScrollPane(rolField);
        
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Nombre del usuario:"));
        panel.add(nombreField);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passwordField);
        panel.add(new JLabel("email:"));
        panel.add(emailField);
        panel.add(new JLabel("Rol del usuario:"));
        panel.add(scrollPane); 
        
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Registro",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            nombre = nombreField.getText();
            contraseña = new String(passwordField.getPassword());
            email = emailField.getText();
            rol = rolField.getSelectedValue();
            
            if("".equals(nombre) | "".equals(contraseña) | "".equals(email)) {
                JOptionPane.showMessageDialog(null, "Quedan parámetros sin completar", "Error", JOptionPane.ERROR_MESSAGE);
                
            }

            else if(rol == null){
                
                if(CP.crearUsuario(nombre, contraseña, email)){
                    JOptionPane.showMessageDialog(null, "Registro completado satisfactoriamente.");
                    }
                else JOptionPane.showMessageDialog(null, "Este nombre de usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            }

            else {
                if(CP.crearUsuarioConRol(nombre, contraseña, email, rol)){
                    JOptionPane.showMessageDialog(null, "Registro completado satisfactoriamente.");
                    }
                else JOptionPane.showMessageDialog(null, "Este nombre de usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Cierra la aplicación y guarda los datos antes de salir.
     *
     * @param evt Evento de acción.
     */
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0); // Finaliza la aplicación 
        if (0 == CP.datosFijados()) CP.exportarProductosYSimilitudes();
        CP.exportarConfig();    
    }

    /**
     * Abre el manual de usuario en formato PDF.
     *
     * @param evt Evento de acción.
     */
    private void helpActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            URL pdfURL = getClass().getClassLoader().getResource("/PROP_manual_de_usuario.pdf");
            System.out.println("Ruta del archivo PDF: " + pdfURL);

            if (pdfURL != null) {
                File pdfFile = new File(pdfURL.toURI());
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    if (pdfFile.exists()) {
                        desktop.open(pdfFile);
                    } else {
                        System.out.println("El archivo PDF no se encontró.");
                    }
                } else {
                    System.out.println("Desktop no es compatible en este sistema.");
                }
            } else {
                System.out.println("El archivo PDF no se encontró en el classpath.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Procesa el recordatorio de contraseña.
     * Muestra un formulario para recuperar la contraseña ingresando nombre y email.
     *
     * @param evt Evento del clic del ratón.
     */
    private void recordarContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordarContraMouseClicked
        JTextField nombreField = new JTextField();
        JTextField emailField = new JTextField();
        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Nombre del usuario:"));
        panel.add(nombreField);
        panel.add(new JLabel("email:"));
        panel.add(emailField);
        
        int result = JOptionPane.showConfirmDialog(null, panel, "Recordatorio Contraseña",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            nombre = nombreField.getText();
            email = emailField.getText();
            
            if("".equals(nombre) | "".equals(email)) {
                JOptionPane.showMessageDialog(null, "Quedan parámetros sin completar", "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            else {
                String p = CP.recordarContrasena(nombre, email);
                if(p != null) {                
                    JOptionPane.showMessageDialog(null, "Tu contraseña es : " + p);
                }
                else if(CP.existe(nombre)){
                    JOptionPane.showMessageDialog(null, "Email incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else JOptionPane.showMessageDialog(null, "El nombre de usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Restaura los datos del sistema a su estado inicial.
     * Elimina todos los productos y distribuciones, pero conserva los usuarios registrados.
     *
     * @param evt Evento de acción.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Estás seguro de que quieres resetear el super (Se eliminaran todas los productor y distribuciones, pero no los usuarios)?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                CP.reset();
                JOptionPane.showMessageDialog(null, "Datos reseteados correctamente.");
            }
            
    }


    private javax.swing.JButton exit;
    private javax.swing.JButton help;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel lamina1;
    private javax.swing.JPanel lamina2;
    private javax.swing.JButton logIn;
    private javax.swing.JLabel recordarContra;
    private javax.swing.JButton signIn;
    private javax.swing.JPasswordField textoContra;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtContra;
    private javax.swing.JLabel txtNom;
    private java.awt.Label título;
    // End of variables declaration//GEN-END:variables
}
