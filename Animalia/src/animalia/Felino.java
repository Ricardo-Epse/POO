
package animalia;

public abstract class Felino extends Mamifero implements Depredador
{
    	protected String nombre;  // Atributo privado

	public Felino(String nombre) // Constructor
	{
		this.nombre = nombre;
	}

	protected void mostrarInfo() // Solo las subclases pueden usar este metodo
	{
		System.out.println("Felino");
		System.out.println("Nombre : " + nombre);
	}

	// Métodos de Mamifero

        @Override
	public void desplazarse()
	{
		System.out.println("Desplazandose en sus cuatro patas");
	}

	// Metodos de depredador
        @Override
	public void acechar(Presa presa)
        {
            System.out.println(this.nombre + " Acechando...");
        }
	@Override
        public void perseguir(Presa presa){}
	@Override
        public void atrapar(Presa presa)
        {
            System.out.println("Felino malo atrata pobre presa");
        }

	public abstract void  asearse();   
}
