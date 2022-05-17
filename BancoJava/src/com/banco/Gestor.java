package com.banco;

public class Gestor {

	private int id;
	private String usuario;
	private String password;
	private String correo;
	
	// constructor parametrizado
	public Gestor(int id, String usuario, String password, String correo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.correo = correo;
	}
	
	// métodos getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Gestor [id=" + id + ", usuario=" + usuario + ", password=" + password + ", correo=" + correo + "]";
	}
	
}
