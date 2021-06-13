package src;

public class Cliente{
	
	public Cliente(String nombre, int id, int telefono, boolean tienePeliculaPrestado){
		this.nombre = nombre;
		this.id = id;
		this.telefono = telefono;
		this.tienePeliculaPrestado = tienePeliculaPrestado;
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
	
	public void establecerTelefono(int telefono){
		this.telefono = telefono;
	}
	
	public int retornaTelefono(){
		return this.telefono;
	}
	
	public void establecerTtienePeliculaPrestado(boolean tienePeliculaPrestado){
		this.tienePeliculaPrestado = tienePeliculaPrestado;
	}
	
	public boolean retornaTienePeliculaPrestado(){
		return this.tienePeliculaPrestado;
	}
	
	private String nombre;
	private int id;
	private int telefono;
	private boolean tienePeliculaPrestado;
}
