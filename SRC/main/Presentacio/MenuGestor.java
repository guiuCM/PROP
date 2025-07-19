/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacio;

import domain.Producto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import java.io.File;

/**
 * Clase MenuGestor proporciona la interfaz gráfica para gestionar productos en un supermercado.
 * Permite añadir, eliminar, mostrar productos, fijar y desfijar datos, así como importar productos.
 * También permite modificar la contraseña y cerrar sesión.
 *
 * @author guiu
 */
public class MenuGestor extends javax.swing.JFrame {
    private final javax.swing.JFrame padre;
    private Ctrl_Presentacio CP;
    private final String nombre;
    private JPanel panelLateral;
    private String modoPanel;

    /**
     * Crea un nuevo formulario MenuGestor.
     *
     * @param padre Ventana anterior (LoginPanel).
     * @param CP Controlador de presentación.
     * @param nombre Nombre del usuario actual.
     */
    public MenuGestor(LoginPanel padre, Ctrl_Presentacio CP, String nombre) {
        this.padre = padre;
        this.CP = CP;
        this.nombre = nombre;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    }

    /**
     * Inicializa los componentes del formulario.
     * Este método es generado automáticamente por el Editor de Formularios.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cerrarSesion = new javax.swing.JButton();
        añadirProducto = new javax.swing.JButton();
        modificarContra = new javax.swing.JButton();
        eliminarProducto = new javax.swing.JButton();
        mostrarProductos = new javax.swing.JButton();
        fijarDatos = new javax.swing.JButton();
        desfijarDatos = new javax.swing.JButton();
        importar = new javax.swing.JButton();

        titulo.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Gestor Supermercado");

        cerrarSesion.setText("LOG OUT");
        cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionActionPerformed(evt);
            }
        });

        añadirProducto.setText("AÑADIR PRODUCTO");
        añadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirProductoActionPerformed(evt);
            }
        });

        modificarContra.setText("CAMBIAR CONTRASEÑA");
        modificarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarContraActionPerformed(evt);
            }
        });

        eliminarProducto.setText("ELIMINAR PRODUCTO");
        eliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProductoActionPerformed(evt);
            }
        });

        mostrarProductos.setText("MOSTRAR PRODUCTOS");
        mostrarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarProductosActionPerformed(evt);
            }
        });

        fijarDatos.setText("FIJAR DATOS");
        fijarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fijarDatosActionPerformed(evt);
            }
        });

        desfijarDatos.setText("DESFIJAR DATOS");
        desfijarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desfijarDatosActionPerformed(evt);
            }
        });

        importar.setText("IMPORTAR PRODUCTOS");
        importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(añadirProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fijarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(desfijarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificarContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mostrarProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(importar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(382, 382, 382))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cerrarSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(añadirProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mostrarProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fijarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desfijarDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificarContra)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cierra la sesión actual del usuario.
     * Muestra un cuadro de diálogo para confirmar la acción antes de proceder.
     * Si se confirma, vuelve a la pantalla de inicio de sesión y finaliza la sesión activa.
     *
     * @param evt Evento de acción.
     */
    private void cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(null, "Estás seguro de que quieres salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            padre.setVisible(true);
            CP.cerrarSesion();
        }
    }

    /**
     * Inicializa el panel lateral según el modo seleccionado. Este método configura el contenido y el diseño del panel lateral
     * en función del valor de la variable `modoPanel`. Los modos disponibles incluyen "añadir", "eliminar", "mostrar",
     * "cambiarContraseña" e "importar", cada uno con su propia configuración y funcionalidad.
     *
     * <ul>
     *     <li><b>"añadir"</b>: Configura el panel para añadir un nuevo producto, con campos de texto para el ID, nombre,
     *         precio, descripción, peso y marca del producto. Incluye botones para añadir el producto y limpiar los campos.</li>
     *     <li><b>"eliminar"</b>: Configura el panel para eliminar un producto mediante su ID, mostrando un campo de entrada
     *         para el ID y un botón para confirmar la eliminación.</li>
     *     <li><b>"mostrar"</b>: Configura el panel para mostrar una lista de productos disponibles, con detalles como ID,
     *         nombre, descripción, marca, precio y peso. Incluye un botón para eliminar productos.</li>
     *     <li><b>"cambiarContraseña"</b>: Configura el panel para permitir el cambio de contraseña del usuario, con campos
     *         para la contraseña actual y las nuevas contraseñas.</li>
     *     <li><b>"importar"</b>: Configura el panel para importar productos desde un archivo, mostrando un botón para seleccionar
     *         el archivo y un mensaje sobre el archivo seleccionado.</li>
     * </ul>
     *
     * Dependiendo del modo, este método también configura los listeners de los botones y maneja las validaciones correspondientes.
     *
     * @throws IllegalArgumentException Si algún campo de entrada es inválido (por ejemplo, ID negativo o precio no numérico).
     * @throws IllegalStateException Si ocurre un error al interactuar con el modelo de datos, como un producto no encontrado.
     */
    private void inicializarPanelLateral() {
        if (panelLateral == null) {
            panelLateral = new JPanel(new GridLayout(7, 5, 5, 5));
            panelLateral.setPreferredSize(new Dimension(300, 250));
        }

        panelLateral.removeAll();

        if ("añadir".equals(modoPanel)) {
            panelLateral.removeAll();
            panelLateral.setLayout(new GridLayout(7, 5, 5, 5));
            panelLateral.setBorder(BorderFactory.createTitledBorder("Añadir Producto"));

            JTextField idField = new JTextField();
            JTextField nombreField = new JTextField();
            JTextField precioField = new JTextField();
            JTextField descripcionField = new JTextField();
            JTextField pesoField = new JTextField();
            JTextField marcaField = new JTextField();

            panelLateral.add(new JLabel("ID del producto:"));
            panelLateral.add(idField);
            panelLateral.add(new JLabel("Nombre del producto:"));
            panelLateral.add(nombreField);
            panelLateral.add(new JLabel("Precio (€):"));
            panelLateral.add(precioField);
            panelLateral.add(new JLabel("Descripción:"));
            panelLateral.add(descripcionField);
            panelLateral.add(new JLabel("Peso (g):"));
            panelLateral.add(pesoField);
            panelLateral.add(new JLabel("Marca:"));
            panelLateral.add(marcaField);

            JButton agregarButton = new JButton("Añadir Producto");
            panelLateral.add(agregarButton);

            JButton limpiarButton = new JButton("Limpiar Campos");
            panelLateral.add(limpiarButton);

            agregarButton.addActionListener(evt -> {
                try {

                    String nomProd = nombreField.getText();
                    String descripcion = descripcionField.getText();
                    String marca = marcaField.getText();

                    if ("".equals(nomProd) || "".equals(descripcion) || "".equals(marca)) {
                        throw new IllegalArgumentException("Hay parámetros de texto sin completar.");
                    }

                    int idProd = Integer.parseInt(idField.getText());
                    double precio = Double.parseDouble(precioField.getText());
                    double peso = Double.parseDouble(pesoField.getText());

                    if (idProd < 0) throw new IllegalArgumentException("El ID debe ser positivo.");
                    if (precio < 0) throw new IllegalArgumentException("El precio debe ser positivo.");
                    if (peso <= 0) throw new IllegalArgumentException("El peso debe ser mayor que cero.");


                    CP.agregarProducto(idProd, nomProd, precio, descripcion, peso, marca);

                    limpiarButton.doClick();
                    JOptionPane.showMessageDialog(null, "Producto añadido correctamente.");
                    
                } catch (NumberFormatException e) {
                    limpiarButton.doClick();
                    JOptionPane.showMessageDialog(null, "ID, Precio y Peso deben ser valores numéricos válidos.",
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException e) {
                    limpiarButton.doClick();
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalStateException e) {
                    limpiarButton.doClick();
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            limpiarButton.addActionListener(evt -> {

                idField.setText("");
                nombreField.setText("");
                precioField.setText("");
                descripcionField.setText("");
                pesoField.setText("");
                marcaField.setText("");
            });

        } 
        else if ("eliminar".equals(modoPanel)) {
            panelLateral.removeAll();
            panelLateral.setLayout(new GridLayout(7, 5, 5, 5));
            panelLateral.setBorder(BorderFactory.createTitledBorder("Eliminar Producto"));

            JTextField idField = new JTextField();

            panelLateral.add(new JLabel("ID del producto a eliminar:"));
            panelLateral.add(idField);

            JButton eliminarButton = new JButton("Eliminar Producto");
            panelLateral.add(eliminarButton);

            eliminarButton.addActionListener(evt -> {
                try {

                    int idProd = Integer.parseInt(idField.getText());

                    CP.eliminarProducto(idProd);
                    idField.setText("");

                    JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.", 
                                                  "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {

                    idField.setText("");
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un ID numérico válido.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException | IllegalStateException e) {

                    idField.setText("");
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
        else if ("mostrar".equals(modoPanel)) {

            panelLateral.removeAll();
            panelLateral.setBorder(BorderFactory.createTitledBorder("Mostrar Productos"));
            panelLateral.setLayout(new BorderLayout());

            List<Producto> listaProductos = CP.obtenerTodosLosProductos();
            listaProductos.sort(Comparator.comparingInt(Producto::obtenerId));

            JPanel panelPrincipal = new JPanel();
            panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
            panelPrincipal.setBackground(Color.WHITE);

            if (listaProductos.isEmpty()) {
                JLabel mensaje = new JLabel("No hay productos disponibles.");
                mensaje.setHorizontalAlignment(SwingConstants.CENTER);
                mensaje.setFont(new Font("Arial", Font.BOLD, 14));
                panelPrincipal.add(mensaje);
            } else {
                for (Producto producto : listaProductos) {

                    JPanel panelProducto = new JPanel();
                    panelProducto.setLayout(new BorderLayout());
                    panelProducto.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    panelProducto.setBackground(new Color(240, 240, 240));
                    panelProducto.setMaximumSize(new Dimension(Short.MAX_VALUE, 150));

                    JLabel idLabel = new JLabel("ID: " + producto.obtenerId(), SwingConstants.CENTER);
                    idLabel.setFont(new Font("Arial", Font.BOLD, 14));
                    panelProducto.add(idLabel, BorderLayout.NORTH);

                    JPanel panelDetalles = new JPanel();
                    panelDetalles.setLayout(new GridLayout(4, 1));
                    panelDetalles.setBackground(new Color(240, 240, 240));

                    JLabel nombreLabel = new JLabel("Nombre: " + producto.obtenerNombre());
                    nombreLabel.setFont(new Font("Arial", Font.BOLD, 12));

                    JLabel descripcionLabel = new JLabel("Descripción: " + producto.obtenerDescripcion());
                    descripcionLabel.setFont(new Font("Arial", Font.ITALIC, 12));

                    JLabel marcaLabel = new JLabel("Marca: " + producto.obtenerMarca());
                    JLabel pesoYPrecioLabel = new JLabel("Peso: " + producto.obtenerPeso() + " g | Precio: " + producto.obtenerPrecio() + " €");

                    panelDetalles.add(nombreLabel);
                    panelDetalles.add(descripcionLabel);
                    panelDetalles.add(marcaLabel);
                    panelDetalles.add(pesoYPrecioLabel);

                    panelProducto.add(panelDetalles, BorderLayout.CENTER);

                    JButton eliminarButton = new JButton("Eliminar");
                    eliminarButton.addActionListener(evt -> {

                        int confirm = JOptionPane.showConfirmDialog(
                                null,
                                "¿Estás seguro de que deseas eliminar el producto ID " + producto.obtenerId() + "?",
                                "Confirmar eliminación",
                                JOptionPane.YES_NO_OPTION
                        );

                        if (confirm == JOptionPane.YES_OPTION) {
                            try {
                                CP.eliminarProducto(producto.obtenerId());

                                JOptionPane.showMessageDialog(
                                        null,
                                        "Producto eliminado correctamente.",
                                        "Éxito",
                                        JOptionPane.INFORMATION_MESSAGE
                                );

                                panelLateral.removeAll();

                                inicializarPanelLateral();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(
                                        null,
                                        "Error al eliminar el producto: " + e.getMessage(),
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            }
                        }
                    });


                    panelProducto.add(eliminarButton, BorderLayout.SOUTH);
                    panelPrincipal.add(panelProducto);
                    panelPrincipal.add(Box.createVerticalStrut(10));
                }
            }


            JScrollPane scrollPane = new JScrollPane(panelPrincipal);
            scrollPane.setPreferredSize(new Dimension(300, 600));
            scrollPane.setBorder(null);


            panelLateral.add(scrollPane, BorderLayout.CENTER);
        }
        else if ("cambiarContraseña".equals(modoPanel)) {
            panelLateral.removeAll();
            panelLateral.setLayout(new GridLayout(8, 1, 5, 5));
            panelLateral.setBorder(BorderFactory.createTitledBorder("Modificar Contraseña"));

            JTextField oldPasswordField = new JPasswordField();
            JTextField newPasswordField1 = new JPasswordField();
            JTextField newPasswordField2 = new JPasswordField();

            panelLateral.add(new JLabel("Contraseña actual:"));
            panelLateral.add(oldPasswordField);
            panelLateral.add(new JLabel("Nueva contraseña:"));
            panelLateral.add(newPasswordField1);
            panelLateral.add(new JLabel("Repetir nueva contraseña:"));
            panelLateral.add(newPasswordField2);

            JButton cambiarButton = new JButton("Cambiar Contraseña");
            panelLateral.add(cambiarButton);

            cambiarButton.addActionListener(evt -> {

                String oldPassword = oldPasswordField.getText();
                String newPassword1 = newPasswordField1.getText();
                String newPassword2 = newPasswordField2.getText();

                if (oldPassword.isEmpty() || newPassword1.isEmpty() || newPassword2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!CP.comprobarContraseña(oldPassword)) {
                    JOptionPane.showMessageDialog(null, "La contraseña actual es incorrecta.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                    oldPasswordField.setText("");
                    return;
                }

                if (oldPassword.equals(newPassword1)) {
                    JOptionPane.showMessageDialog(null, "La nueva contraseña no puede ser igual a la actual.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                    newPasswordField1.setText("");
                    newPasswordField2.setText("");
                    return;
                }

                if (!newPassword1.equals(newPassword2)) {
                    JOptionPane.showMessageDialog(null, "Las nuevas contraseñas no coinciden.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                    newPasswordField1.setText("");
                    newPasswordField2.setText("");
                    return;
                }

                try {
                    CP.cambiarContrasena(oldPassword, newPassword1, newPassword2);
                    JOptionPane.showMessageDialog(null, "Contraseña cambiada exitosamente.", 
                                                  "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
        else if ("importar".equals(modoPanel)) {
            panelLateral.removeAll();
            panelLateral.setLayout(new BorderLayout());
            panelLateral.setBorder(BorderFactory.createTitledBorder("Importar Productos"));

            JButton importarButton = new JButton("Seleccionar archivo");
            JLabel selectedFileLabel = new JLabel("Archivo seleccionado: Ninguno");

            JPanel importPanel = new JPanel();
            importPanel.setLayout(new GridLayout(2, 1, 5, 5)); // Diseño en dos filas
            importPanel.add(importarButton);
            importPanel.add(selectedFileLabel);

            panelLateral.add(importPanel, BorderLayout.CENTER);

            importarButton.addActionListener(evt -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccionar archivo para importar");

                int userSelection = fileChooser.showOpenDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();

                    selectedFileLabel.setText("Archivo seleccionado: " + filePath);

                    try {
                        CP.importProductosFromFile(filePath);
                        JOptionPane.showMessageDialog(null, "Productos importados exitosamente.", 
                                                      "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al importar productos: " + e.getMessage(), 
                                                      "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    selectedFileLabel.setText("Archivo seleccionado: Ninguno");
                }
            });
        }
        
        panelLateral.revalidate();
        panelLateral.repaint();
    }

    /**
     * Cambia el modo de visualización del panel lateral y lo actualiza.
     * Este método establece el nuevo valor para la variable `modoPanel` y luego llama al método
     * `inicializarPanelLateral` para actualizar el contenido del panel según el nuevo modo.
     *
     * @param nuevoModo El nuevo modo que se establecerá para el panel lateral. Este valor es utilizado
     *                  para configurar el comportamiento y la apariencia del panel.
     */
    private void cambiarModoPanel(String nuevoModo) {
        this.modoPanel = nuevoModo;
        inicializarPanelLateral();
    }

    /**
     * Maneja el evento de acción cuando se selecciona la opción de añadir un producto.
     * Este método cambia el modo del panel lateral a "añadir" y lo actualiza visualmente en la interfaz de usuario.
     * Si el panel lateral aún no está añadido, lo agrega al contenedor principal (borde este) y actualiza la interfaz.
     *
     * @param evt El evento de acción generado al hacer clic en el botón o acción que invoca este método.
     */
    private void añadirProductoActionPerformed(java.awt.event.ActionEvent evt) {
       inicializarPanelLateral();
       cambiarModoPanel("añadir");

       java.awt.Container container = this.getContentPane();

       if (panelLateral.getParent() == null) {
           container.add(panelLateral, BorderLayout.EAST);

           container.revalidate();
           container.repaint();

       }
    }

    /**
     * Maneja el evento de acción cuando se selecciona la opción para modificar la contraseña del usuario.
     * Este método cambia el modo del panel lateral a "cambiarContraseña" y lo actualiza visualmente en la interfaz de usuario.
     * Si el panel lateral aún no está añadido, lo agrega al contenedor principal (borde este) y actualiza la interfaz.
     *
     * @param evt El evento de acción generado al hacer clic en el botón o acción que invoca este método.
     */
    private void modificarContraActionPerformed(java.awt.event.ActionEvent evt) {

        inicializarPanelLateral();
       cambiarModoPanel("cambiarContraseña");

       java.awt.Container container = this.getContentPane();

       if (panelLateral.getParent() == null) {
           container.add(panelLateral, BorderLayout.EAST);

           container.revalidate();
           container.repaint();

       }
    }

    /**
     * Maneja el evento de acción cuando se selecciona la opción para eliminar un producto.
     * Este método cambia el modo del panel lateral a "eliminar" y lo actualiza visualmente en la interfaz de usuario.
     * Si el panel lateral aún no está añadido, lo agrega al contenedor principal (borde este) y actualiza la interfaz.
     *
     * @param evt El evento de acción generado al hacer clic en el botón o acción que invoca este método.
     */
    private void eliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {
       inicializarPanelLateral();
       cambiarModoPanel("eliminar");

       java.awt.Container container = this.getContentPane();

       if (panelLateral.getParent() == null) {
           container.add(panelLateral, BorderLayout.EAST);

           container.revalidate();
           container.repaint();

       }
    }

    /**
     * Maneja el evento de acción cuando se selecciona la opción para mostrar los productos.
     * Este método cambia el modo del panel lateral a "mostrar" y actualiza visualmente la interfaz de usuario.
     * Si el panel lateral aún no está añadido, lo agrega al contenedor principal (borde este) y actualiza la interfaz.
     *
     * @param evt El evento de acción generado al hacer clic en el botón o acción que invoca este método.
     */
    private void mostrarProductosActionPerformed(java.awt.event.ActionEvent evt) {
       inicializarPanelLateral();
       cambiarModoPanel("mostrar");

       java.awt.Container container = this.getContentPane();

       if (panelLateral.getParent() == null) {
           container.add(panelLateral, BorderLayout.EAST);

           container.revalidate();
           container.repaint();

       }
    }

    /**
     * Maneja el evento de acción cuando se selecciona la opción para fijar los datos.
     * Este método verifica si los datos ya han sido fijados o si no hay productos, y muestra un mensaje adecuado.
     * Si los datos no han sido fijados y hay productos disponibles, llama a CP.fijarDatos() para fijar los datos.
     * Luego, muestra un mensaje indicando el estado de la operación.
     *
     * @param evt El evento de acción generado al hacer clic en el botón o acción que invoca este método.
     */
    private void fijarDatosActionPerformed(java.awt.event.ActionEvent evt) {
        if (CP.datosFijados() == 1) JOptionPane.showMessageDialog(null, "Los datos ya han sido fijados", "Error", JOptionPane.ERROR_MESSAGE);
        else if (CP.obtenerProductosLength() == 0) JOptionPane.showMessageDialog(null, "No has añadido ningún producto", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            CP.fijarDatos();
            JOptionPane.showMessageDialog(null, "Datos fijados correctamente.");
        }
    }

    /**
     * Maneja el evento de acción cuando se selecciona la opción para desfijar los datos.
     * Este método verifica si los datos no han sido fijados y muestra un mensaje de error si es necesario.
     * Si los datos están fijados, solicita una confirmación para desfijar los datos (lo que elimina todas las distribuciones).
     * Si la confirmación es positiva, llama a CP.desfijarDatos() para desfijar los datos y muestra un mensaje indicando el estado de la operación.
     *
     * @param evt El evento de acción generado al hacer clic en el botón o acción que invoca este método.
     */
    private void desfijarDatosActionPerformed(java.awt.event.ActionEvent evt) {
        if (CP.datosFijados() == 0) JOptionPane.showMessageDialog(null, "Los datos no han sido fijados", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            int respuesta = JOptionPane.showConfirmDialog(null, "Estás seguro de que quieres Desfijar los datos (Se eliminaran todas las distribuciones)?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                CP.desfijarDatos();
                JOptionPane.showMessageDialog(null, "Datos desfijados correctamente.");
            }
            
        }
    }

    /**
     * Maneja el evento de acción cuando se selecciona la opción para importar datos.
     * Este método cambia el modo del panel lateral a "importar" y actualiza visualmente la interfaz de usuario.
     * Si el panel lateral aún no está añadido, lo agrega al contenedor principal (borde este) y actualiza la interfaz.
     *
     * @param evt El evento de acción generado al hacer clic en el botón o acción que invoca este método.
     */
    private void importarActionPerformed(java.awt.event.ActionEvent evt) {
       inicializarPanelLateral();
       cambiarModoPanel("importar");

       java.awt.Container container = this.getContentPane();

       if (panelLateral.getParent() == null) {
           container.add(panelLateral, BorderLayout.EAST);

           container.revalidate();
           container.repaint();

       }
    }


    private javax.swing.JButton añadirProducto;
    private javax.swing.JButton cerrarSesion;
    private javax.swing.JButton desfijarDatos;
    private javax.swing.JButton eliminarProducto;
    private javax.swing.JButton fijarDatos;
    private javax.swing.JButton importar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton modificarContra;
    private javax.swing.JButton mostrarProductos;
    private javax.swing.JLabel titulo;
}
