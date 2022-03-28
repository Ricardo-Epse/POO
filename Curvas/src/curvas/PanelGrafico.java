/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curvas;

import java.awt.*;
import javax.swing.*;

public class PanelGrafico extends JPanel
{

    // Estas constantes son para indentificar un tipo de gráfica
    
    final static int TIPO_GRAFICA_BORRAR     = -1;
    final static int TIPO_GRAFICA_SENOIDE    = 10;
    final static int TIPO_GRAFICA_COSENOIDE  = 20;
    final static int TIPO_GRAFICA_EPICICLOIDE= 100;
    final static int TIPO_GRAFICA_FIGURA = 120;
   
    int    tipoGrafica = 0;
    Color  color       = Color.white;

    public PanelGrafico()
    {
		setPreferredSize(new Dimension(800,600 ));
		this.setBackground(Color.white);
    }

    public void update(Graphics g)
    {
         paintComponent(g);
    }

    public void graficar(int tipoGrafica)
    {
	this.tipoGrafica = tipoGrafica;
	repaint();
    }

    // Este método se invoca de la vista, nos llega como parámetro
    // el tipo de gráfica y el color elegido por el usuario
    // estos valores se pasan a los atributos de la clase para
    // que puedan ser utilizados por los métodos que están más abajo
    
    
    public void graficar(int tipoGrafica, Color color)  
    {
	this.tipoGrafica = tipoGrafica;  
	this.color       = color;
	repaint(); // Llama a repaint() que a su vez llama a paintComponent()
    }


    // Este método es llamado cada vez que se requiere repintar el área de trazo
    // y desde repaint(), no se puede llamar directamente
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // Realiza la funcionalidad por defecto
	trazarGrafica(g);         // Ahora traza la gráfica indicada
    }

    public void trazarGrafica(Graphics g)
    {
        if(tipoGrafica == TIPO_GRAFICA_BORRAR)
	{
            this.setBackground(Color.white);
	}

	if (tipoGrafica >=10 && tipoGrafica < 100)  trazarCurva(g); // Curva cartesiana
	if (tipoGrafica >=100 && tipoGrafica < 1000) trazarCurvaParemetrica(g); // Curva paramétrica
  
    }

    public void trazarCurva(Graphics g) // Cuando se trata de curva cartesiana
    {
	this.setBackground(Color.white);
	g.setColor((Color.green).darker());
	g.drawLine(0,this.getHeight()/2,this.getWidth(),this.getHeight()/2);
	g.setColor(color);

	switch(tipoGrafica)
	{
		case TIPO_GRAFICA_SENOIDE:
		{
                        // Traza una curva Senoidal
			for( int x=0; x <= this.getWidth(); x++ )
			{
                            g.drawLine( x,this.getHeight()/2-(int)(100*Math.sin(Math.toRadians(x))), x+1,this.getHeight()/2-(int)(100*Math.sin(Math.toRadians(x+1))));
     			}
     			break;
		}

		case TIPO_GRAFICA_COSENOIDE:
		{
                    for( int x=1; x <= this.getWidth(); x++ )
			{
                            g.drawLine( x,this.getHeight()/2-(int)(100*Math.cos(Math.toRadians(x))), x+1,this.getHeight()/2-(int)(100*Math.cos(Math.toRadians(x+1))));
     			}
     			break;
			
		}


	}
    }
    
    public void Nuevo(Graphics g){
        this.setBackground(Color.black);
	g.setColor(Color.white);
	g.drawLine(0,this.getHeight()/2, this.getWidth(),this.getHeight()/2);
	g.drawLine(this.getWidth()/2,0,  this.getWidth()/2,this.getHeight());
	g.setColor(color);
        
        double a=100, b=300;
        for(int t=1;t<= (int) (360*a);t++)
	{
            g.drawLine(this.getWidth()/2+100*computeX(t,a), this.getHeight()/2-100*computeY(t,b),this.getWidth()/2+computeX(t+1,a),this.getHeight()/2-computeY(t+1,b));
	}
        
    }

    public void trazarCurvaParemetrica(Graphics g)
    {
        this.setBackground(Color.black);
	g.setColor(Color.white);
	g.drawLine(0,this.getHeight()/2, this.getWidth(),this.getHeight()/2);
	g.drawLine(this.getWidth()/2,0,  this.getWidth()/2,this.getHeight());
	g.setColor(color);

	double a=100, b=30 ,c=6;
	for(int t=0;t<= (int) (360*a);t++)
	{
            g.drawLine(this.getWidth()/2+computeX(t,a), this.getHeight()/2-computeY(t,b),this.getWidth()/2+computeX(t+1,a),this.getHeight()/2-computeY(t+1,b));
        }
    }

        
    // Metodos para calcular coordenadas rectangulares a partir de las coordenadas paramétricas

    public int computeX(int t, double a)
    {
        return (int) (a*Math.cos(Math.toRadians(t)));
    }

    public int computeY(int t, double b)
    {
    return (int)( b*Math.sin(Math.toRadians(t)));
    }
  
    public int cX(int t, double a, double b,double c)
    {
        return (int) (10.0 * ( (a + b)*Math.cos(Math.toRadians(t)) - c*Math.cos((a/b + 1.0)* Math.toRadians(t))));
    }

    public int cY(int t, double a, double b, double c)
    {
    return (int) (10.0 * ( (a + b)*Math.sin(Math.toRadians(t)) - c*Math.sin((a/b + 1.0)* Math.toRadians(t))));
    }


}
