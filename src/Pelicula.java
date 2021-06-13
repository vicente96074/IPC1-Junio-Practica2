package src;

public class Pelicula{
	
	public Pelicula(String nombre, int id, int año, String categoria, boolean disponible){
		this.nombre = nombre;
		this.id = id;
		this.año = año;
		this.categoria = categoria;
		this.disponible = disponible;
	}
	
	public void establecerNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String retornaNombre(){
		return this.nombre;
	}
	
	public void establecerId(int id){
		this.id = id;
	}
	
	public int retornaId(){
		return this.id;
	}
	
	public void establecerAño(int año){
		this.año = año;
	}
	
	public int retornaAño(){
		return this.año;
	}
	
	public void establecerCategoria(String categoria){
		this.categoria = categoria;
	}
	
	public String retornaCategoria(){
		return this.categoria;
	}
	
	public void establecerDisponible(boolean disponible){
		this.disponible = disponible;
	}
	
	public boolean retornaDisponible(){
		return this.disponible;
	}
	
	//Variables ocultas a cualquier otra clase
	private String nombre;
	private int id;
	private int año;
	private String categoria;
	private boolean disponible;
}
