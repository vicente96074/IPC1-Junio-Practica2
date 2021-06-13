package src;
import java.util.Scanner;

public class IPC1JunioPractica2{
	
	public IPC1JunioPractica2(){
		iniciarComponentes();
	}
	
	private void iniciarComponentes(){
		iniciarInformacionDePeliculas();
		System.out.println("     Memorabilia     ");
		menu();
	}
	
	private void iniciarInformacionDePeliculas(){
		idCliente[0] = 12345;
		//id de las peliculas
		idPelicula[0] = 4;
		idPelicula[1] = 3;
		idPelicula[2] = 7;
		idPelicula[3] = 10;
		idPelicula[4] = 1;
		
		//nombre de las peliculas
		nombrePelicula[0] = "Animales Fantasticos y Donde Encontrarlos";
		nombrePelicula[1] = "Interestelar";
		nombrePelicula[2] = "Harry Potter y la Piedra Filosofal";
		nombrePelicula[3] = "Shrek IV";
		nombrePelicula[4] = "Avatar";
		
		//año de las peliculas
		añoPelicula[0] = 2016;
		añoPelicula[1] = 2014;
		añoPelicula[2] = 2001;
		añoPelicula[3] = 2010;
		añoPelicula[4] = 2009;
		
		//categoria de cada pelicula
		categoriaDeCadaPelicula[0] = categoriaPeliculas[1];
		categoriaDeCadaPelicula[1] = categoriaPeliculas[0];
		categoriaDeCadaPelicula[2] = categoriaPeliculas[1];
		categoriaDeCadaPelicula[3] = categoriaPeliculas[2];
		categoriaDeCadaPelicula[4] = categoriaPeliculas[0];
		
		//disponibilidad de las peliculas
		disponiblePelicula[0] = true;
		disponiblePelicula[1] = true;
		disponiblePelicula[2] = true;
		disponiblePelicula[3] = true;
		disponiblePelicula[4] = true;
		
	}
	
	private void menu(){
		int opcion;
		
		do{
			System.out.println("\n -------- Menú -------- ");
			System.out.print("1. Préstamo de películas"
					  + "\n2. Devolución de películas"
					  + "\n3. Mostrar las películas" 
					  + "\n4. Ingreso de Películas"
					  + "\n5. Ingresar clientes nuevos"
					  + "\n6. Reportes"
					  + "\n7. Salir"
					  + "\nIngrese una opcion entre (1-6): ");		
			opcion = entrada.nextInt();
			
			switch(opcion){
				case 1:
					//Mostramos la opcion prestamo de peliculas
					prestamoDePeliculas();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					ingresarClientesNuevos();
					break;
				case 6:
					break;
				case 7:
					System.out.println("\n¡Saliendo del programa!");
					break;
				default:
					System.out.println("\n!Opción inválida, vuela a digitar!");
			}
		}while(opcion!=7);
	}
	
	
	private void prestamoDePeliculas(){
		//Variables locales
		boolean encontrado = false;
		int posCliente = 1;
		int idCl;
		int idP;
		
		
		System.out.println("\n ----- Préstamo de Películas ----- ");
		System.out.print("Ingrese su id, si no tiene id crea uno en el menu principal: ");
		idCl = entrada.nextInt();
		
		for(int i=0; i<idCliente.length; i++){
			if(idCl == idCliente[i]){
				posCliente = i;
				encontrado = true;
				break;
			}
		}
		
		if(encontrado == true){
			//Mostramos a las peliculas disponibles
			System.out.println("\nPeliculas disponibles:");
			for(int i=0; i<idPelicula.length; i++){
				if(disponiblePelicula[i] == true){
					System.out.println("Id: "+idPelicula[i]+" --  nombre: " + nombrePelicula[i] +
					" --  año: " +añoPelicula[i] + " --  categoria: "+categoriaDeCadaPelicula[i]+
					" --  disponible: "+ disponiblePelicula[i]);
				}
			}
			//Comprobar que el cliente aun no tenga prestado una pelicula
			if(tienePeliculaPrestado[posCliente] == false){
				System.out.println("Seleccione una pelicula ingresando el id de la pelicula: ");
				idP = entrada.nextInt();
				int posEncontrado = 0;
				//Comprobar que exista la pelicula
				for(int i=0; i<idPelicula.length; i++){
					if(idP==idPelicula[i]){
						posEncontrado = i;
						encontrado = true;
						break;
					} else {
						encontrado = false;
					}
				}
				
				if(encontrado == true){
					disponiblePelicula[posEncontrado] = false;
				} else {
					System.out.println("¡Ingresó un id de pelicula inexistente!");
				}
				
			} else {
			
				System.out.println("\n¡Ya tiene una pelicula prestada, devuelvala y presta uno nuevo!");
			}

		} else {
			System.out.println("¡Ingresó un id incorrecta, vuela a intentar!");
		}
	}
	
	
	private void ingresarClientesNuevos(){
	/*
		System.out.println("Ingrese su nombre: ");
		nombreCliente[posicionCliente] = entrada.nextLine();
		System.out.println("Ingrese su id: ");
		idCliente[posicionCliente] = entrada.nextInt();
		System.out.println("Ingrese su telefono: ");
		telefonoCliente[posicionCliente] = entrada.nextInt();
	*/
	}
	
	public static void main(String[] args){
		IPC1JunioPractica2 iPC1JunioPractica2 = new IPC1JunioPractica2();
	}
	
	Scanner entrada = new Scanner(System.in);
	int nPeliculas = 5;
	int nClientes = 1;
	
	//Arreglos para los clientes
	String[] nombreCliente = new String[nClientes];
	int[] idCliente = new int[nClientes];
	int[] telefonoCliente = new int[nClientes];
	boolean[] tienePeliculaPrestado = new boolean[nClientes];
	
	//Arreglos para las peliculas
	int[] idPelicula = new int[nPeliculas];
	String[] nombrePelicula = new String[nPeliculas];
	int[] añoPelicula = new int[nPeliculas];
	String[] categoriaPeliculas = {"Ciencia ficción", "Fantasia", "Animacion", "Comedia", "Drama"};
	String[] categoriaDeCadaPelicula = new String[nPeliculas];
	boolean[] disponiblePelicula = new boolean[nPeliculas];
	
	//Arreglo para los dias  de prestado para cada pelicula
	int[] díasPrestamo = {1,5,15,30};
	
}
