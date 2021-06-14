package src;
import java.util.Scanner;

public class IPC1JunioPractica2{
	
	public IPC1JunioPractica2(){
		iniciarComponentes();
	}
	
	private void iniciarComponentes(){
		iniciarInformacionDePeliculas();
		System.out.println("      Memorabilia       ");
		menu();
	}
	
	private void iniciarInformacionDePeliculas(){
		idCliente[0] = 12345;
		nombreCliente[0] = "Augusto";
		telefonoCliente[0] = 44448888;
		tienePeliculaPrestado[0] = false;
		
		idCliente[1] = 23456;
		nombreCliente[1] = "Vicente";
		telefonoCliente[1] = 22224141;
		tienePeliculaPrestado[1] = false;
		
		idCliente[1] = 23456;
		nombreCliente[1] = "Vicente";
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
		//Un hacer mientras para el menu principal
		do{
			System.out.println("\n -------- Menú -------- ");
			System.out.print("1. Préstamo de películas"
					  + "\n2. Devolución de películas"
					  + "\n3. Mostrar las películas" 
					  + "\n4. Ingreso de Películas"
					  + "\n5. Ordenar peliculas"
					  + "\n6. Ingresar clientes nuevos"
					  + "\n7. Mostrar clientes"
					  + "\n8. Reportes"
					  + "\n9. Salir"
					  + "\nIngrese una opcion entre (1-6): ");		
			opcion = entrada.nextInt();
			
			//Swicth que controla al menu principal
			switch(opcion){
				case 1:
					prestamoDePeliculas();
					break;
				case 2:
					devoluciónDePeliculas();
					break;
				case 3:
					mostrarLasPeliculas();
					break;
				case 4:
					ingresoDePeliculas();
					break;
				case 5:
					ordenarLasPeliculas();
					break;
				case 6:
					ingresarClientesNuevos();
					break;
				case 7:
					mostrarClientes();
					break;
				case 8:
					reportes();
					break;
				case 9:
					System.out.println("\n¡Saliendo del programa!");
					break;
				default:
					System.out.println("\n!Opción inválida, vuela a digitar!");
			}
		}while(opcion!=9);
	}
	
	//Funcion para el prestamo de las peliculas
	private void prestamoDePeliculas(){
		//Variables locales
		boolean encontrado = false;
		int posCliente = 0;
		int idCl;
		int idP;
		
		
		System.out.println("\n ----- Préstamo de Películas ----- ");
		System.out.print("Ingrese su id, si no tiene id crea uno en el menu principal: ");
		idCl = entrada.nextInt();
		
		//Buscar el id del cliente en el arreglo idCliente[]
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
				System.out.print("\nSeleccione una pelicula ingresando el id de la pelicula: ");
				idP = entrada.nextInt();
				int posPelicula = 0;
				
				//Comprobar que exista la pelicula
				for(int i=0; i<idPelicula.length; i++){
					if(idP==idPelicula[i]){
						posPelicula = i;
						encontrado = true;
						break;
					} else {
						encontrado = false;
					}
				}
				
				//Llamamos a la funcion que archive a las peliculas prestadas
				if(encontrado == true){
					tablaPrestamos(posCliente, posPelicula);
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
	
	private void tablaPrestamos(int posCliente, int posPelicula){
		int opcion;
		do{
			System.out.println("\nLa pelicula se guardara en al tabla préstamo");
			System.out.print("1. Continuar"
					  + "\n2. Cancelar"
					  + "\nDigite una opcion: ");
			opcion = entrada.nextInt();
								
			switch(opcion){
				case 1:
					int dia;
					boolean continuar = false;
					//Pedir al usuario los días que quiere prestar una pelicula
					do{
						
						System.out.print("\nCantidad de días disponibles para prestar una pelicula:"
								  + "\n1. 1 día"
								  + "\n2. 5 días"
								  + "\n3. 15 días"
								  + "\n4. 30 días"
								  + "\nSeleccione una opción: ");
						dia = entrada.nextInt();
						if(dia>=1 && dia<=4){
							continuar = true;
						} else {
							System.out.println("¡Opción incorrecta, vuelva a digitar!");
							continuar = false;
						}
						
					}while(continuar == false);
					
					//Hacemos los cambios a los estados del cliente y la pelicula

					tienePeliculaPrestado[posCliente] = true;
					disponiblePelicula[posPelicula] = false;
					idClientePrestador[peliculasPrestados/*-1*/] = idCliente[posCliente];
					idPeliculaPrestado[peliculasPrestados/*-1*/] = idPelicula[posPelicula];
					peliculasPrestados++;					
					//Agregamos los días que se presta una pelicula
					switch(dia){
						case 1:
							diaPrestadoPelicula[peliculasPrestados /*-1*/] = 1;
							break;
						case 2:
							diaPrestadoPelicula[peliculasPrestados  /*-1*/] = 5;
							break;
						case 3:
							diaPrestadoPelicula[peliculasPrestados /*-1*/] = 10;
							break;
						case 4:
							diaPrestadoPelicula[peliculasPrestados /*-1*/] = 30;
							break;
					}
					System.out.println("\n¡Pelicula prestado exitosamente!");
					break;
				case 2:
					System.out.println("¡Regresando!");
					break;
				default:
					System.out.println("\n¡Opción inválida, vuelva a digitar!");
			}
		}while(opcion!=1 && opcion!=2);
	}
	
	//Funcion para devolver las peliculas
	private void devoluciónDePeliculas(){
		int posPelicula = 0;
		int posCliente = 0;
		boolean encontrado = false;
		int idP = 0;
		int posIdPelicula = 0;
		int auxiliarIdPelicula = 0;
		int auxiliarIdCliente = 0;
		int auxiliarDiaPrestado = 0;
		//Mostrar a todas las peliculas prestadas
		if(peliculasPrestados>0){
			System.out.println("\nPeliculas prestados");
			for(int i=0; i<peliculasPrestados; i++){
				for(int j=0; j<idPelicula.length; j++){
					//Buscar en que posicion se encuentra la pelicula
					if(idPeliculaPrestado[i] == idPelicula[j]){
						posPelicula = j;
						break;
					}
				}
				
				for(int j=0; j<idPelicula.length; j++){
					//Buscar en que posicion se encuentra el cliente
					if(idClientePrestador[i] == idCliente[j]){
						posCliente = j;
						break;
					}
				}
				
				System.out.println("ǀId pelicula: " + idPeliculaPrestado[i] + "ǀ nombre de la pelicula: "
						  + nombrePelicula[posPelicula] + "ǀ Id del cliente: "+idClientePrestador[i]
						  + "ǀ nombre del cliente: " + nombreCliente[posCliente] + " ǀ");
			}
			
			do{
				System.out.print("\nIngrese el id de la pelicula a devolver: ");
				idP = entrada.nextInt();
				
				//Comprobar que el id de la pelicula esta en la tabla de prestamos
				for(int i=0; i<peliculasPrestados; i++){
					if(idP == idPeliculaPrestado[i] ){
						posIdPelicula = i;
						auxiliarIdPelicula = idP;
						auxiliarIdCliente = idClientePrestador[i];
						auxiliarDiaPrestado = diaPrestadoPelicula[i];
						encontrado = true;
						break;
					}
				}
				
				if(encontrado == false){
					System.out.println("¡Id no encontrada, vuelva a ingresar!");
				}
				
			}while(encontrado == false);
			
			if(encontrado){
				elimiarPelicula(posIdPelicula, auxiliarIdPelicula, auxiliarIdCliente, auxiliarDiaPrestado);
			}
			
		} else {
			System.out.println("\n¡No hay peliculas prestados aún!");
		}
		
	}
	
	//Funcion para remover una pelicula de tabla de prestamos
	private void elimiarPelicula(int posIdPelicula, int auxiliarIdPelicula, int auxiliarIdCliente, int auxiliarDiaPrestado){
		System.out.println("\n¡Devolviendo la pelicula!");
			
			//Buscar donde se encuentra el id de la pelicula y regresdarlo a peliculas disponibles
			for(int i=0; i<idPelicula.length; i++){
				if(idPeliculaPrestado[posIdPelicula] == idPelicula[i]){
					disponiblePelicula[i] = true;
					break;
				}
			}
			
			for(int i=0; i<peliculasPrestados; i++){
				if(i>=posIdPelicula){
					//Remover una casilla de la tabla de prestamos
					idPeliculaPrestado[i] = idPeliculaPrestado[i+1];
					idClientePrestador[i] = idClientePrestador[i+1];
					diaPrestadoPelicula[i] = diaPrestadoPelicula[i+1];
					if(i == peliculasPrestados-1){
						
						//Mover el id del cliente y la pelicula hasta el final y luego ocultarlo
						idPeliculaPrestado[i] = auxiliarIdPelicula;
						idClientePrestador[i] = auxiliarIdCliente;
						diaPrestadoPelicula[i] = auxiliarDiaPrestado;
						peliculasPrestados--;
					}
				}
			}

			//Liberar al cliente para que pueda prestar una nueva pelicula
			for(int i = 0; i<idCliente.length; i++){
				if(idCliente[i] == auxiliarIdCliente){
					tienePeliculaPrestado[i] = false;
				}
			}
					
		
	}
	
	//Funcion para mostrar todas las peliculas
	private void mostrarLasPeliculas(){
		System.out.println("\nTodas las peliculas");
			for(int i=0; i<nPeliculas; i++){
				System.out.println("Id: "+idPelicula[i]+" --  nombre: " + nombrePelicula[i] +
				" --  año: " +añoPelicula[i] + " --  categoria: "+categoriaDeCadaPelicula[i]+
				" --  disponible: "+ disponiblePelicula[i]);
			}
	}
	
	//Funcion Ingreso de Películas
	private void ingresoDePeliculas(){
		boolean continuar = false;
		int idPeliculaIngresado;
		
		System.out.println("\nIngrese la información de la pelicula a continuación.");
		do{
			System.out.print("Ingrese el id de la pelicula: ");
			idPeliculaIngresado = entrada.nextInt();
			
			for(int i=0; i<nPeliculas; i++){
				if(idPelicula[i] == idPeliculaIngresado){
					continuar = false;
					System.out.println("¡El Id de la pelicula ya existe, ingrese uno nuevo!");
					break;
				} else {
					continuar = true;
				}
			}
			
		}while(continuar == false);
		
		if(continuar){
			idPelicula[nPeliculas] = idPeliculaIngresado;
			System.out.print("Ingrese el nombre de la pelicula: ");
			nombrePelicula[nPeliculas] = String.valueOf(entrada.next());
			System.out.print("Ingrese el año de la pelicula: ");
			añoPelicula[nPeliculas] = entrada.nextInt();
			
			do{
				continuar = false;
				System.out.print("Ingrese la categoria de la pelicula, "
						+ "1. Ciencia ficción 2. Fantasia 3. Animacion 4. Comedia o 5. Drama: ");
				int categoria = entrada.nextInt();
				switch(categoria){
					case 1:
						categoriaDeCadaPelicula[nPeliculas] = categoriaPeliculas[0];
						continuar = true;
						break;
					case 2:
						categoriaDeCadaPelicula[nPeliculas] = categoriaPeliculas[0];
						continuar = true;
						break;
					case 3:
						categoriaDeCadaPelicula[nPeliculas] = categoriaPeliculas[0];
						continuar = true;
						break;
					case 4:
						categoriaDeCadaPelicula[nPeliculas] = categoriaPeliculas[0];
						continuar = true;
						break;
					case 5:
						categoriaDeCadaPelicula[nPeliculas] = categoriaPeliculas[0];
						continuar = true;
						break;
					default:
						System.out.println("Ingresó una categoria inexistente, intentelo de nuevo");
				}
			}while(continuar == false);
			disponiblePelicula[nPeliculas] = true;
			nPeliculas++;
			System.out.println("\n¡Pelicula agregado exitosamente!");
		}
		
	}
	
	//Funcion ordenar peliculas respecto al id
	private void ordenarLasPeliculas(){
		
		
	}
	
	//Funcion ingresar clientes nuevos
	private void ingresarClientesNuevos(){
		boolean continuar = false;
		int idClienteIngresado;
		do{
			System.out.print("Ingrese su id: ");
			idClienteIngresado = entrada.nextInt();
			
			for(int i=0; i<nClientes; i++){
				if(idCliente[i] == idClienteIngresado){
					continuar = false;
					System.out.println("¡El Id del cliente ya existe, ingrese uno nuevo!");
					break;
				} else {
					continuar = true;
				}
			}
			
		}while(continuar == false);
		
		if(continuar){
			idCliente[nClientes] = idClienteIngresado;
			System.out.print("Ingrese su nombre: ");
			nombreCliente[nClientes] = entrada.next();
			System.out.print("Ingrese su telefono: ");
			telefonoCliente[nClientes] = entrada.nextInt();
			nClientes++;
			System.out.println("\n¡Cliente agregado exitosamente!");
		}
	}
	
	//Funcion para mostrar clientes
	private void mostrarClientes(){
		System.out.println("\n\n                          Clientes                              "
				  +"\nNombre        Id      Telefono        Pelicula Prestado");
		for(int i=0; i<nClientes; i++){
			System.out.printf("\n%s     %d     %d              %b", nombreCliente[i], idCliente[i], 
			telefonoCliente[i], tienePeliculaPrestado[i]);
		}
		System.out.println("");

	}
	
	//Funcion para Reportes	
	private void reportes(){
		
		
	}
	
	//Metodo principal
	public static void main(String[] args){
		IPC1JunioPractica2 iPC1JunioPractica2 = new IPC1JunioPractica2();
	}
	
	//Variables y el scanner
	Scanner entrada = new Scanner(System.in);
	int nPeliculas = 5;
	int nClientes = 2;
	
	//Arreglos para los clientes
	String[] nombreCliente = new String[20];
	int[] idCliente = new int[20];
	int[] telefonoCliente = new int[20];
	boolean[] tienePeliculaPrestado = new boolean[20];
	
	//Arreglos para las peliculas
	int[] idPelicula = new int[20];
	String[] nombrePelicula = new String[20];
	int[] añoPelicula = new int[20];
	String[] categoriaPeliculas = {"Ciencia ficción", "Fantasia", "Animacion", "Comedia", "Drama"};
	String[] categoriaDeCadaPelicula = new String[20];
	boolean[] disponiblePelicula = new boolean[20];
	
	//Arreglo para los dias  de prestado para cada pelicula
	int peliculasPrestados = 0;
	int[] díasPrestamo = {1,5,15,30};
	int[] idClientePrestador  = new int[20];
	int[] idPeliculaPrestado  = new int[20];
	int[] diaPrestadoPelicula = new int[20]; 
}
