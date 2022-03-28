
package animalia;


public class Aguila implements Volador, Depredador 
{
        // Métodos de Volador

        @Override
	public void despegar(){}
        @Override
	public void volar(){}
	@Override
        public void aterrizar(){}

	// Métodos de Depredador

        @Override
	public void acechar(Presa presa){}
	@Override
        public void perseguir(Presa presa){}
	@Override
        public void atrapar(Presa presa){}
}
