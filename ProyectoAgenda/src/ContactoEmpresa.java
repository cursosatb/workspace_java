
public class ContactoEmpresa extends Contacto {

	private String paginaWeb;

	public ContactoEmpresa(String nombre, int telefono, String paginaWeb) {
		super(nombre, telefono);
		this.paginaWeb = paginaWeb;
	}
	
	@Override
	public void mostrarInfo() {
		System.out.println(this.nombre 
				+ " tiene el teléfono " + this.telefono
				+ " y página web " + this.paginaWeb);
		
	}	


	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	@Override
	public String toString() {
		return "ContactoEmpresa [paginaWeb=" + paginaWeb + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
}
