/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;

import java.text.DecimalFormat;


public class Calculadora 
{
        private double memoria=0;
	private char ultimoOperador='=';
        private boolean radianes=true;
        DecimalFormat df = new DecimalFormat("#.00");	

	public void operacion(double numero, char operador)
	{
		if(ultimoOperador=='=')
		  memoria = numero;
		else
			switch(ultimoOperador)
			{
				case '+': memoria+=numero; break;
				case '-': memoria-=numero; break;
                                case '*': memoria*=numero; break;
                                case '/': memoria /=numero; break;
                                case 's': memoria = Math.sin(numero); break;
                                case 'c': memoria = Math.cos(numero); break;
                                case 't': memoria = Math.tan(numero); break;
                                case '^': memoria = Math.pow(numero, 2); break;
                                case '√': memoria = Math.sqrt(numero); break;
			}
		     ultimoOperador=operador;
	}

        public void clearMemory()
        {
            memoria=0;
        
        }
        
	public double getMemoria()
	{
            memoria = Math.round(memoria * 100)/100d;
            return memoria;
	}

        public void setRadianes()
        {
            radianes=false;
        }
        
        public void setDegrees()
        {
            radianes=false;
        }
        
        public boolean isRadianes()
        {
            return radianes;
        }
}
