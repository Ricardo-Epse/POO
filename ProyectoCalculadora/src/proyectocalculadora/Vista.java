/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Vista extends JFrame {

    private Calculadora casio = new Calculadora();
    private boolean nuevo = true;

    private JMenuBar barraMenus = new JMenuBar();

    private JMenu archivo = new JMenu("Archivo");
    private JMenuItem salir = new JMenuItem("Salir");

    private JTextField display = new JTextField();
    private JButton b0 = new JButton("0");
    private JButton b1 = new JButton("1");
    private JButton b2 = new JButton("2");
    private JButton b3 = new JButton("3");
    private JButton b4 = new JButton("4");
    private JButton b5 = new JButton("5");
    private JButton b6 = new JButton("6");
    private JButton b7 = new JButton("7");
    private JButton b8 = new JButton("8");
    private JButton b9 = new JButton("9");
    private JButton mas = new JButton("+");
    private JButton menos = new JButton("-");
    private JButton igual = new JButton("=");
    private JButton cE = new JButton("CE");
    private JButton C = new JButton("C");
    private JButton sen = new JButton("s");
    private JButton cos = new JButton("c");
    private JButton tan = new JButton("t");
    private JButton por = new JButton("*");
    private JButton div = new JButton("/");
    private JButton pot = new JButton("^");
    private JButton raiz = new JButton("√");
    private JButton p = new JButton(".");

    public Vista() {
        initComponents();
        this.setTitle("Calculadora");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLayout(null); // Se deshabilita el Gestor de Distribución
        this.setBounds(100, 100, 270, 400);
        this.setJMenuBar(barraMenus);
        this.setVisible(true);

    }

    public void initComponents() {
        // Diseña el menu

        barraMenus.add(archivo);
        archivo.add(salir);

        // Al desabilitar el LayoutManager, el programador tiene
        // la responsabilidad de situar los componentes
        display.setBounds(10, 5, 220, 40);
        b1.setBounds(10, 50, 50, 50);
        b4.setBounds(10, 110, 50, 50);
        b7.setBounds(10, 170, 50, 50);
        cE.setBounds(10, 230, 50, 50);
        sen.setBounds(10, 290, 50, 50);
        raiz.setBounds(10, 350, 50, 50);

        b2.setBounds(70, 50, 50, 50);
        b8.setBounds(70, 170, 50, 50);
        b5.setBounds(70, 110, 50, 50);
        b0.setBounds(70, 230, 50, 50);
        cos.setBounds(70, 290, 50, 50);
        pot.setBounds(70, 350, 50, 50);

        b3.setBounds(130, 50, 50, 50);
        b6.setBounds(130, 110, 50, 50);
        b9.setBounds(130, 170, 50, 50);
        C.setBounds(130, 230, 50, 50);
        tan.setBounds(130, 290, 50, 50);
        p.setBounds(130, 350, 50, 50);

        mas.setBounds(190, 50, 50, 50);
        menos.setBounds(190, 110, 50, 50);
        igual.setBounds(190, 170, 50, 50);
        por.setBounds(190, 230, 50, 50);
        div.setBounds(190, 290, 50, 50);

        display.setBackground(Color.black);
        display.setForeground(Color.orange);
        display.setFont(new Font("Consolas", Font.BOLD, 26));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        this.add(display);

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(b7);
        this.add(b8);
        this.add(b9);
        this.add(b0);
        this.add(mas);
        this.add(menos);
        this.add(igual);
        this.add(cE);
        this.add(C);
        this.add(sen);
        this.add(cos);
        this.add(tan);
        this.add(por);
        this.add(div);
        this.add(pot);
        this.add(raiz);
        this.add(p);

        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 0
            }
        });
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 0
            }
        });
        sen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 0
            }
        });
        cos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 0
            }
        });
        tan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 0
            }
        });
        por.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 0
            }
        });
        div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 0
            }
        });
        pot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 0
            }
        });
        raiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 0
            }
        });

        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt); // // <== Método que se invoca cuando se hace click sobre la opción Salir
            }
        });

        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 0
            }
        });

        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 1
            }
        });

        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 2
            }
        });

        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 3
            }
        });

        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 4
            }
        });

        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 5
            }
        });

        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 6
            }
        });

        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 7
            }
        });

        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 8
            }
        });

        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla 9
            }
        });

        mas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla +
            }
        });

        menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla -
            }
        });

        igual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarTeclazo(evt); // // <== Método que se invoca cuando se hace click sobre la tecla =
            }
        });

        cE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procesarCe(); // // <== Método que se invoca cuando se hace click sobre la opción tecla Ce
            }
        });

        class MyWindowAdapter extends WindowAdapter {

            public void windowClosing(WindowEvent e) {
                exit();
            }
        }
        addWindowListener(new MyWindowAdapter());

    }

    // Gestión de eventos
    // Salir
    public void salir(java.awt.event.ActionEvent evt) {
        exit();
    }

    public void exit() {
        int respuesta = JOptionPane.showConfirmDialog(rootPane, "Desea salir?", "Federación deportiva", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // Botones de la calculadora
    public void procesarTeclazo(ActionEvent objetoEvento) {
        Object fuenteDelEvento = objetoEvento.getSource();

        // Identifica sobre qué objeto generó el evento
        if (fuenteDelEvento == salir) {
            exit();  // Cierra el Programa
        }

        String teclazo = objetoEvento.getActionCommand();

        char simbolo = teclazo.charAt(0);
        if ((simbolo >= '0' && simbolo <= '9') || simbolo == '.') {
            if (nuevo) {
                display.setText("");
            }
            display.setText(display.getText() + simbolo);
            nuevo = false;
        } else if (simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/' || simbolo == '=' || simbolo == 's' || simbolo == 'c' || simbolo == 't'
                || simbolo == '*' || simbolo == '/' || simbolo == '^' || simbolo == '√') {
            double numero = Double.parseDouble(display.getText());

            casio.operacion(numero, simbolo);         // Invoca la funcionalidad de la calculadora

            display.setText("" + casio.getMemoria());  // Obtiene el estado de la memoria de la calculadora

            nuevo = true;
        } else if (simbolo == 'C') {
            casio.clearMemory();
            display.setText("");
        }
    }

    public void procesarCe() {
        // Codigo para procesar CE
        display.setText("");
        nuevo = true;
    }
}
