
package ejemplo01;

public class Ejemplo01 {

    public static void main(String[] args) 
    {
        
       // INVOCA a un método estático (de la clase System de java.lang)
       String carpetaTrabajo = System.getProperty("user.dir");
       
       // INVOCA a un método para de 'out' para mostrar un mensaje
       System.out.println("La carpeta de trabajo es " + carpetaTrabajo);
       
       // Crea una INSTANCIA de la clase Vista
       Vista myFrame = new Vista();
       
       // INVOCA a un método de myFrame
       myFrame.setVisible(true);
       
    }
    
}
