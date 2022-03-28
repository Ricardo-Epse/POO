package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VistaGato extends JFrame {

    // Componentes principales
    private JButton[][] casilla = new JButton[3][3]; // El tablero VISUAL
    private char[][] tablero = new char[3][3];       // El tablero en MEMORIA
    private int jugador = 1;   // Variable que guarda el número de jugador que hace la jugada 
    private int contador = 0;  // Contador de jugadas

    public VistaGato() // Constructor
    {
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBounds(150, 50, 620, 665);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("gatito.jpg"));
        initComponents();
    }

    public void initComponents() {
        // Diseña menú
        JMenuBar barraMenus = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenuItem reset = new JMenuItem("Restituir");
        JMenuItem salir = new JMenuItem("Salir");
        this.setJMenuBar(barraMenus);
        barraMenus.add(archivo);
        archivo.add(reset);
        archivo.add(new JSeparator());
        archivo.add(salir);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casilla[i][j] = new JButton(i + "-" + j); // Coloca sobre la cara del evento el texto 'i-j'
                casilla[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
            }
        }
        resetTablero();

        // Coordenadas
        casilla[0][0].setBounds(0, 0, 198, 198);
        casilla[0][1].setBounds(200, 0, 198, 198);
        casilla[0][2].setBounds(400, 0, 198, 198);
        casilla[1][0].setBounds(0, 200, 198, 198);
        casilla[1][1].setBounds(200, 200, 198, 198);
        casilla[1][2].setBounds(400, 200, 198, 198);
        casilla[2][0].setBounds(0, 400, 198, 198);
        casilla[2][1].setBounds(200, 400, 198, 198);
        casilla[2][2].setBounds(400, 400, 198, 198);

        // Componentes auxiliares
        // Posiciones de los componentes
        this.setLayout(null); // El programador indica coordenadas y tamaño

        // Coloca componentes
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.add(casilla[i][j]);
            }
        }

        // Gestión de eventos (Agrega los LISTENERS)
        // Agrega Listener al JMenuItem 'salir'
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetTablero();
            }
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casilla[i][j].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        jugar(evt);  // Delega la tarea al método 'jugar' pasándole referencia a 'evt'
                    }
                });
            }
        }

        // Agrega Listener al boton 'X' del JFrame
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarFrame();
            }
        });
    }

    // Métodos delegados de los Listeners
    public void salir(java.awt.event.ActionEvent evt) {
        cerrarFrame();
    }

    public void cerrarFrame() {
        int respuesta = JOptionPane.showConfirmDialog(this, "Desea salir?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // Este método se invoca desde el Listener de todos los botones del tablero
    // La referencia evt contiene información sobre el objeto que generó el evento
    public void jugar(java.awt.event.ActionEvent evt) {
        contador++; // Incrementa el contador de jugadas

        String actionCommand = evt.getActionCommand();  // Recupera el texto de la cara del botón que generó el evento
        int i = actionCommand.charAt(0) - 48; // Obtiene el primer caracter del texto, como ASCII
        int j = actionCommand.charAt(2) - 48; // Obtiene el tercer caracter del texto, como ASCII

        JButton elegido = (JButton) evt.getSource(); // Obtiene referencia al objeto que generó el evento
        elegido.setEnabled(false); // Desabilita el botón correspondiente a la casilla jugada

        if (jugador == 1) {
            elegido.setIcon(new ImageIcon("x.jpg"));
            tablero[i][j] = 'X';
        } else {
            elegido.setIcon(new ImageIcon("o.jpg"));
            tablero[i][j] = 'O';
        }

        // Revisa tablero para ver si el jugador actual ha ganado
        if (revisaTablero(tablero[i][j])) {
            JOptionPane.showMessageDialog(this, "Ha ganado el jugador: " + jugador, "Aviso", JOptionPane.ERROR_MESSAGE);
        }

        // Revisa si ya se completado el tablero
        if (contador == 9) {
            JOptionPane.showMessageDialog(this, "Se ha alcanzado el maximo de jugadas", "Aviso", JOptionPane.ERROR_MESSAGE);
            resetTablero();
        }

        // Switchea jugador
        if (jugador == 1) {
            jugador = 2;
        } else {
            jugador = 1;
        }

    }

    /* 
        Método para verificar si un jugador ha ganado, utilizando el 
        símbolo de la última jugada, revisa si ese símbolo ha completado
        una línea de 3 (horizontal, vertical o diagonal)
     */
    public boolean revisaTablero(char letra) {
        boolean ganador = false;

        //Ciclo Con Instrucciones Para Comprobar Las 3 Posibilidades De Ganar De Forma Horizontal.
    for(int i=0;i<3;i++){
      for(int j=1;j<2;j++){
       if(tablero[i][j]==tablero[i][j-1]&&tablero[i][j]==tablero[i][j+1]){
            System.out.println(tablero[i][j]);
        }          
      }        
    }
   
    //Ciclo Con Instrucciones Para Comprobar Las 3 Posibilidades De Ganar De Forma Vertical.  
    for(int i=0;i<3;i++){
      for(int j=1;j<2;j++){
        if(tablero[j][i]==tablero[j-1][i]&&tablero[j][i]==tablero[j+1][i]){
            System.out.println(tablero[j][i]);
        }            
      }
    }
   
    //Instrucciones Para Comprobar La Unica Posibilidad De Ganar De Forma Diagonal.  
    if(tablero[1][1]==tablero[0][0]&&tablero[1][1]==tablero[2][2]){
        System.out.println(tablero[1][1]);
    }  
       
    //Ciclo Con Instrucciones Para Comprobar La Unica Posibilidade De Ganar De Forma Diagonal Inversa.
    if(tablero[1][1]==tablero[0][2]&&tablero[1][1]==tablero[2][0]){
        System.out.println(tablero[1][1]);
    }    
   
        return ganador;
    }

    // Método para que establece el estado inicial del tablero visual e interno
    public void resetTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Establece la imagen en la casilla i,j tomando la imagen "img-i-j.png"
                casilla[i][j].setIcon(new ImageIcon("img-" + i + "-" + j + ".png"));
                tablero[i][j] = ' ';
                casilla[i][j].setEnabled(true);
            }
        }
        jugador = 1;
        contador = 0; // Reinicia el contador de jugadas
    }
// Fin de la clase
}
