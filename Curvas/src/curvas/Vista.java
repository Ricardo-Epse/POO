/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curvas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;

public class Vista extends JFrame 
{
    // Elementos Graficos de GUI

		private JMenuBar   menuBar   	= new JMenuBar();
		private JMenu      archivo   	= new JMenu("Archivo");
		private JMenuItem  salir     	= new JMenuItem("Salir");
		private JMenu      graficar  	= new JMenu("Graficar");
		private JMenuItem  senoide   	= new JMenuItem("Senoide");
		private JMenuItem  cosenoide 	= new JMenuItem("Cosenoide");
		private JMenuItem  epicicloide  = new JMenuItem("Epicicloide");
                private JMenuItem  borrar    	= new JMenuItem("Borrar");
		private JMenu      preferencias = new JMenu("Preferencias");
		private JMenuItem  eligeColor   = new JMenuItem("Elige Color");
		private JLabel     muestraColor = new JLabel("COLOR");
                private JMenuItem  figura = new JMenuItem("Figura");
                
		// Elementos para graficacion

		private PanelGrafico panelG            = new PanelGrafico();
		private JScrollPane  contenedorGrafico = new JScrollPane(panelG);

		// Elementos Auxiliares

		private Color         color            = Color.red;

		public Vista()
		{
			// Propiedades del Frame

			this.setTitle("Ejemplo Grafico");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(new Rectangle(0,0,600,600));
			setLayout(new BorderLayout()); // Administrador de aspecto
                       
                        
			// Agrega componentes

			muestraColor.setForeground(color);
			this.add(contenedorGrafico, BorderLayout.CENTER);
			this.add(muestraColor,BorderLayout.SOUTH);
   
			// Diseño de Menu

			menuBar.add(archivo);
			menuBar.add(graficar);
			menuBar.add(preferencias);
			archivo.add(salir);
			graficar.add(senoide);
			graficar.add(cosenoide);
			graficar.add(epicicloide);
                        graficar.add(figura);
			graficar.add(new JSeparator());
        		graficar.add(borrar);
			preferencias.add(eligeColor);
			this.setJMenuBar(menuBar);

                       
			// Especifica Listener

                        salir.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                        procesaEvento(evt); }});

                        senoide.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                        procesaEvento(evt); }});

                        epicicloide.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                        procesaEvento(evt); }});
                        
                        cosenoide.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                        procesaEvento(evt); }});
                        
                        figura.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                        procesaEvento(evt); }});
                        

                        borrar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                        procesaEvento(evt); }});

                        eligeColor.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                        procesaEvento(evt); }});

                       

                        // Gestionar la X (Exit) de la ventana mediante una clase interna
                        class MyWindowAdapter extends WindowAdapter
                        {
                            public void windowClosing(WindowEvent evt)
                            {
                                exit();
                            }
                        }
                        addWindowListener(new MyWindowAdapter());
                        
                }


		// Un solo método para gestionar los eventos

		public void procesaEvento(ActionEvent evento)
		{
			Object origenEvento = evento.getSource();

			// Quien fue?

			if(origenEvento == salir)
			{
				exit();
			}

			if(origenEvento == senoide)
			{
				panelG.graficar(PanelGrafico.TIPO_GRAFICA_SENOIDE,color);
			}


			if(origenEvento == epicicloide)
			{
				panelG.graficar(PanelGrafico.TIPO_GRAFICA_EPICICLOIDE,color);
			}
                        
                        if(origenEvento == cosenoide)
			{
				panelG.graficar(PanelGrafico.TIPO_GRAFICA_COSENOIDE,color);
			}
                        
                        if(origenEvento == figura)
                        {
                                panelG.graficar(PanelGrafico.TIPO_GRAFICA_FIGURA,color);

                        }

			if(origenEvento == borrar)
			{
				panelG.graficar(PanelGrafico.TIPO_GRAFICA_BORRAR);
			}

			if(origenEvento == eligeColor)
			{
				Color nuevoColor = JColorChooser.showDialog(rootPane, "Elija el Color de Lapiz", color);
				if(nuevoColor != null) color = nuevoColor;
				muestraColor.setForeground(color);
			}
		}


		public void exit()
		{
			String mensaje = "Gracias";
			javax.swing.JOptionPane.showConfirmDialog(rootPane,mensaje,"Mi programa",JOptionPane.DEFAULT_OPTION ,JOptionPane.INFORMATION_MESSAGE );
			dispose();
			System.exit(0);
		}
}
