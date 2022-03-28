
package animalia;

public final class Gato extends Felino
{
    
    private String nombreDueno;  // Atributo privado

    public Gato(String nombre, String nombreDueno)  // Constructor
    {
	super(nombre); 
	this.nombreDueno = nombreDueno;
    }

    public void maullar()
    {
        System.out.println("Miauu");
    }

    public void maullar(int n) // Sobrecarga
    {
        for(int i=0;i<n;i++) maullar();
    }

    @Override
    public void atrapar(Presa presa)
    {   
        presa.sufrir();
    }

    @Override
    public void mostrarInfo() // Sobreescritura de método
    {
		super.mostrarInfo(); // LLama al mostrarInfo() de la superclase
		System.out.println("Es un gato");
		System.out.println("Nombre del Dueño : " + nombreDueno);
    }
    
    @Override
    public void asearse()
    {
        System.out.println("Gato aseandose con su manita");
    }
}
