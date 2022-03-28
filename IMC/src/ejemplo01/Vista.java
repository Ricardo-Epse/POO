/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vista extends JFrame implements ActionListener {

    // Componentes principales
    private final JTextField jEstatura = new JTextField();
    private final JTextField jPeso = new JTextField();
    private final JButton jBotonProcesar = new JButton("Procesar");
    private final JButton jBotonLimpiar = new JButton("Limpiar");
    private final ButtonGroup sexo = new ButtonGroup();
    private final JRadioButton masculino = new JRadioButton("Masculino");
    private final JRadioButton femenino = new JRadioButton("Femenino", true);
    private final JTextArea jDiagnostico = new JTextArea();
    private final JLabel jImagen = new JLabel();
    private final JMenuBar barraMenus = new JMenuBar();
    private final JMenu archivo = new JMenu("Archivo");
    private final JMenu configuracion = new JMenu("Configuración");
    private final JMenuItem abrir = new JMenuItem("Abrir");
    private final JMenuItem salir = new JMenuItem("Salir");
    private ImageIcon icon = new ImageIcon();

    public Vista() // Constructor
    {
        iniciarComponents();
    }

    public final void iniciarComponents() {
        // Características del Frame
        this.setTitle("Cuerpo sano");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(150, 50, 640, 480);

        // Diseña menú
        this.setJMenuBar(barraMenus);
        barraMenus.add(archivo);
        barraMenus.add(configuracion);
        archivo.add(abrir);
        archivo.add(new JSeparator());
        archivo.add(salir);

        // Componentes auxiliares
        JLabel etiqueta1 = new JLabel("Peso (kg):");
        JLabel etiqueta2 = new JLabel("Estatura (mts):");
        JLabel etiqueta3 = new JLabel("Sexo:");

        // Posiciones de los componentes
        this.setLayout(null); // El programador indica coordenadas y tamaño
        etiqueta1.setBounds(100, 50, 100, 30);
        etiqueta2.setBounds(100, 80, 100, 30);
        etiqueta3.setBounds(100, 120, 100, 30);
        jPeso.setBounds(200, 50, 100, 30);
        jEstatura.setBounds(200, 80, 100, 30);
        masculino.setBounds(200, 120, 100, 30);
        femenino.setBounds(200, 150, 100, 30);
        jBotonProcesar.setBounds(100, 200, 90, 40);
        jBotonLimpiar.setBounds(210, 200, 90, 40);
        jImagen.setBounds(310, 50, 300, 300);
        jDiagnostico.setBounds(100, 250, 200, 100);

        // Características de los componentes
        jPeso.setHorizontalAlignment(JTextField.RIGHT);
        jEstatura.setHorizontalAlignment(JTextField.RIGHT);
        jBotonLimpiar.setBackground(new Color(120, 120, 120));
        jBotonLimpiar.setForeground(Color.white);
        jBotonLimpiar.setBorder(BorderFactory.createRaisedBevelBorder());
        jDiagnostico.setLineWrap(true);
        jDiagnostico.setWrapStyleWord(true);
        jDiagnostico.setEditable(false);
        masculino.setSelected(true);
        icon = new ImageIcon("slim-girl.jpg");
        jImagen.setIcon(icon);

        // Agrupa RadioBotones
        sexo.add(masculino);
        sexo.add(femenino);

        // Coloca componentes
        this.add(etiqueta1);
        this.add(etiqueta2);
        this.add(etiqueta3);
        this.add(jPeso);
        this.add(jEstatura);
        this.add(masculino);
        this.add(femenino);
        this.add(jBotonProcesar);
        this.add(jBotonLimpiar);
        this.add(jImagen);
        this.add(jDiagnostico);

        // Gestión de eventos (Agrega los LISTENERS)
        // Agrega Listener al JMenuItem 'salir'
        salir.addActionListener(this);

        // Agrega Listener al botón 'procesar'
        jBotonProcesar.addActionListener(this);

        // Agrega Listener al botón 'limpiar'
        jBotonLimpiar.addActionListener(this);

        // Agrega Listener al boton 'X' del JFrame
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarFrame();
            }
        });
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        Object eventSource = evt.getSource();

        if (eventSource == salir) {
            cerrarFrame();
        } else if (eventSource == jBotonProcesar) {
            gestionarBotonProcesar();
        } else if (eventSource == jBotonLimpiar) {
            gestionarBotonLimpiar();
        }
    }

    public void salir(java.awt.event.ActionEvent evt) {
        cerrarFrame();
    }

    public void cerrarFrame() {
        int respuesta = JOptionPane.showConfirmDialog(this, "Desea salir?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void gestionarBotonProcesar() {
        String estaturaCapturada = jEstatura.getText();
        String pesoCapturado = jPeso.getText();
        float estatura, peso;

        if (estaturaCapturada.length() > 0 && pesoCapturado.length() > 0) // Se capturadon datos?
        {
            // Bloque try para tratar el caso de que tecleen algo distinto de un número en jEstatura
            try {
                estatura = Float.parseFloat(estaturaCapturada);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valor invalido en estatura", "Error de Captura", JOptionPane.ERROR_MESSAGE);
                estatura = 0;
            }

            // Bloque try para tratar el caso de que tecleen algo distinto de un número en jPeso
            try {
                peso = Float.parseFloat(pesoCapturado);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Valor invalido en peso", "Error de Captura", JOptionPane.ERROR_MESSAGE);
                peso = 0;
            }

            boolean hombre = true;
            if (femenino.isSelected()) {
                hombre = false;
            }

            if (estatura > 0 && peso > 0) {
                double imc = peso / Math.pow(estatura, 2);
                diagnosticar(imc, hombre);
            }
        } else {
            JOptionPane.showConfirmDialog(this, "No capturaste texto!!", "Aviso", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
    }

    public void gestionarBotonLimpiar() {
        jEstatura.setText("");
        jPeso.setText("");
        jDiagnostico.setText("");
        masculino.setSelected(true);
        icon = new ImageIcon("slim-girl.jpg");
        jImagen.setIcon(icon);
    }

    public void diagnosticar(double imc, boolean hombre) {
        String diagnostico = "";
        icon = new ImageIcon("labuena.jpg");
        String simc = String.format("%.2f", imc);

        if (hombre) // La persona es hombre
        {
            if (imc < 17) {
                diagnostico = "Desnutrición";
                icon = new ImageIcon("skinny-pete.jpg");
            } else if (imc >= 17 && imc < 20) {
                diagnostico = "bajo peso";
                icon = new ImageIcon("bajo-peso.jpg");
            } else if (imc >= 20 && imc < 25) {
                diagnostico = "normal";
                icon = new ImageIcon("normal.jpg");
            } else if (imc >= 25 && imc < 29) {
                diagnostico = "ligero sobrepeso";
                icon = new ImageIcon("ligero-sobrepeso.jpg");
            } else if (imc >= 30 && imc < 40) {
                diagnostico = "Obesidad severa";
                icon = new ImageIcon("obesidad.jpg");

            } else if (imc >= 40) {
                diagnostico = "Obesidad morbida";
                icon = new ImageIcon("morbida-hombre.jpg");
            }

        } else // La persona es mujer
        {
            if (imc < 16) {
                diagnostico = "Desnutricion";
                icon = new ImageIcon("desnutricion.jpg");

            } else if (imc >= 16 && imc < 20) {
                diagnostico = "bajo peso";
                icon = new ImageIcon("bajopeso.jpg");
            } else if (imc >= 20 && imc < 24) {
                diagnostico = "normal";
                icon = new ImageIcon("normalita.jpg");
            } else if (imc >= 24 && imc < 29) {
                diagnostico = "ligero sobrepeso";
                icon = new ImageIcon("ligerosobrepeso.jpg");
            } else if (imc >= 29 && imc < 37) {
                diagnostico = "Obesidad severa";
                icon = new ImageIcon("obesidad-mujer.jpg");
            } else if (imc >= 37) {
                diagnostico = "Obesidad morbida";
                icon = new ImageIcon("morbida-mujer.jpg");
            }

        }
        jDiagnostico.setText("Su indice de masa corporal es " + simc + " usted padece " + diagnostico);
        jImagen.setIcon(icon);
    }
}
