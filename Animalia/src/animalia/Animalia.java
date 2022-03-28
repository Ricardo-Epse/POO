 
package animalia;

public class Animalia {

    public static void main(String[] args) 
    {
        
        Felino silvestre = new Gato("Silvestre","Abuelita");
        silvestre.mostrarInfo();
        ((Gato)(silvestre)).maullar(5);
        
        Leon simba = new Leon("simba");
        simba.mostrarInfo();
        
        Presa piolin = new Canario();
        Presa speedy = new Raton();
        Presa mickey = new Raton();
        
        simba.acechar(mickey);
        silvestre.atrapar(piolin);
        silvestre.atrapar(speedy);
        simba.asearse();
        silvestre.asearse();
        
        Chita chester = new Chita("Chester Chetoos");
        chester.asearse();
        chester.atrapar(piolin);
    }
    
}
