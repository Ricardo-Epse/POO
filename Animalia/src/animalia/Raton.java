
package animalia;

public class Raton implements Presa
{
    private String nombre;
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return nombre;
    }
    
    @Override
    public void sufrir()
    {
        System.out.println("Raton sufriendo");
    }
}
