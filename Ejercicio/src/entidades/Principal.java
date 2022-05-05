package entidades;

import java.util.ArrayList;
import java.util.Scanner;

import ui.Menu;

import java.sql.*;


public class Principal {
	
	private static Scanner lector = new Scanner(System.in);
	private static ArrayList<String> palabras = new ArrayList<>();


	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//ejercicio1();
		
		//ejercicio2();
		
		//ejercicio3();
		
		//ejercicio4();
				
		//ejercicio5();
		
		//ejercicio5b_1();
		//ejercicio5b_2();
		
		ejercicio6();
	}
	
	
	public static void ejercicio1() {
		/* Ejercicio 1
		Mostrar por consola los 10 primeros números enteros y los 10 primeros números impares */
		for(int i = 1; i <=10; i++) {
		    System.out.println(i);
		}
	}
	
	public static void ejercicio2() {
		/* Ejercicio 2
		Leer 10 palabras y mostrarlas en orden inverso al que fueron ingresadas. */
		for(int i = 0; i < 10; i++) {
			System.out.println("Ingrese palabra: ");
		    leerPalabra(lector.nextLine());
		}

		for(int i = palabras.size()-1; i >= 0; i--) {
		    System.out.println(palabras.get(i));
		}
	}
	
	public static void ejercicio3() {
		/* Ejercicio 3
		Leer 10 palabras, luego leer una nueva palabra e indicar si la misma ya había sido ingresada en las 10 primeras. */
		
		Boolean leida = false;
	    System.out.println("Ingrese palabrita: ");

		String nuevaPalabra = lector.nextLine();
		ejercicio2();
		
		for(String palabra : palabras) {
	        if(palabra.equals(nuevaPalabra)) {
	            System.out.println("Esta palabra ya ha sido leída.");
	            leida = true;
	            break;
	        }
	    }
		
		if(!leida) {
		    System.out.println("Esta palabra no ha sido leída.");
		}
		
	}
	
	public static void ejercicio4() {
		/* Ejercicio 4
		Leer un entero y luego una lista de 20 enteros. Guardar los mayores al 
		número inicial y mostrarlos al final. Usar arrays, no otras colecciones. 
		*/
	    System.out.println("Ejercicio 4.");
	    int contadorPosicion = 0;
	    int numeroPivot;
		int[] numerosMayoresAlPivot  = new int[5];
	    System.out.println("Ingresar un numero pivot: ");
		String numString = lector.nextLine();
		numeroPivot = Integer.parseInt(numString);
	    System.out.print("Numero pivot: ");
	    System.out.println(numeroPivot);

		for(int i = 0; i <= numerosMayoresAlPivot.length-1; i++){
		    int numero;
		    System.out.println("Ingresar un num: ");
		    numero = Integer.parseInt(lector.nextLine());
		    if(numero > numeroPivot) {
		        numerosMayoresAlPivot[contadorPosicion] = numero;
		        contadorPosicion++;
			    System.out.print("Almacenado, numero mayor al pivot. Numero ");
			    System.out.println(numero);
		    }
		}
		
	    System.out.println("Resultado mayores: ");
		for(int i = 0; i <= contadorPosicion-1; i++) {
				System.out.println("Numero: ");
			    System.out.println(numerosMayoresAlPivot[i]);	
				System.out.print("Posicion: ");
				System.out.println(i+1);
		}
	}
	
	public static void ejercicio5( ) {
		/*
		Ejercicio 5
		De acuerdo al diagrama de clases resolver:

		Cargar una lista de empleados (máximo 20) preguntado en cada uno si son administrativos o vendedores y cargar todos los datos respectivos.

		Luego listar los empleados indicando: dni, nombre, apellido y sueldo. El sueldo debe calcularse en el método getSueldo() de la siguiente forma:

		Si es administrativo: sueldoBase * ((hsExtra * 1.5)+hsMes) / hsMes
		Si es vendedor: sueldoBase + (porcenComision*totalVtas/100)
		Restricciones

		Utilizar un único array para almacenar a todos los empleados. No usar colecciones dinámicas.
		Hacer uso de las ventajas de la programación orientada a objetos: herencia, redefinición y polimorfismo.
		Las clases lógicas (las del diagrama) no pueden tener entrada o salida de datos por pantalla de ningún tipo. Esto debe ser realizado por otra clase que cree los objetos de las clases lógicas y les asigne los datos necesarios.
		Ejercicio 5b

		Resolver los ejercicios 4 y 5 usando LinkedList o ArrayList en lugar de Arrays.
		*/
		
		Empleado[] empleados  = new Empleado[1];
		int rol;
		
	    System.out.println("Registro de empleados:");
	    System.out.println("[1] Administrativo");
	    System.out.println("[2] Vendedor");
	    
		for(int i = 0; i < empleados.length; i++){
			
		    System.out.print("Ingresar opcion: ");
		    rol = Integer.parseInt(lector.nextLine());
		    
		    switch(rol) {
		    	case 1:
		    	    System.out.println("Creando nuevo administrativo");
		    	    empleados[i] = new Administrativo(35000000,"Melisa","Ortiz","meli@ortiz.com",100000,10,120);
		    		break;
		    	case 2:
		    	    System.out.println("Creando nuevo administrativo");
		    	    empleados[i] = new Vendedor(35000001,"Leonardo","Miceli","leo@miceli.com",100000,10,10);
		    		break;
		    }
		    
		}
		
		for(Empleado empleado : empleados) {
			System.out.print("Empleado: ");
    	    System.out.println(empleado.getDatos());
		}			
		
	}
	
	public static void ejercicio5b_1() {
		
		
		/* Ejercicio 4 refactorizado
		Leer un entero y luego una lista de 20 enteros. Guardar los mayores al 
		número inicial y mostrarlos al final. Usar arrays, no otras colecciones. 
		*/
		
	    System.out.println("Ejercicio 4.");

	    int numeroPivot;
	    ArrayList<Integer> numerosMayoresAlPivot = new ArrayList<Integer>();
		
	    System.out.println("Ingresar un numero pivot: ");
		String numString = lector.nextLine();
		numeroPivot = Integer.parseInt(numString);
	    System.out.print("Numero pivot: ");
	    System.out.println(numeroPivot);
	    
		for(int i = 0; i <= 5; i++){
		    int numero;
		    System.out.println("Ingresar un num: ");
		    numero = Integer.parseInt(lector.nextLine());
		    if(numero > numeroPivot) {
		        numerosMayoresAlPivot.add(numero);

			    System.out.print("Almacenado, numero mayor al pivot. Numero ");
			    System.out.println(numero);
		    }
		}
		
		System.out.println("Resultado mayores: ");
		for(Integer num : numerosMayoresAlPivot) {
			System.out.println("Numero: ");
		    System.out.println(num);	
		}
		
		
	}
	
	public static void ejercicio5b_2() {
		ArrayList<Empleado> empleados  = new ArrayList<Empleado>();
		int rol;
		
	    System.out.println("Registro de empleados:");
	    System.out.println("[1] Administrativo");
	    System.out.println("[2] Vendedor");
	    
		for(int i = 0; i < 2; i++){
			
		    System.out.print("Ingresar opcion: ");
		    rol = Integer.parseInt(lector.nextLine());
		    
		    switch(rol) {
		    	case 1:
		    	    System.out.println("Creando nuevo administrativo");
		    	    Administrativo adm = new Administrativo(35000000,"Melisa","Ortiz","meli@ortiz.com",100000,10,120);
		    	    empleados.add(adm);
		    		break;
		    	case 2:
		    	    System.out.println("Creando nuevo administrativo");
		    	    Vendedor ven = new Vendedor(35000001,"Leonardo","Miceli","leo@miceli.com",100000,10,10);
		    	    empleados.add(ven);
		    		break;
		    }
		    
		}
		
		for(Empleado empleado : empleados) {
			System.out.print("Empleado: ");
    	    System.out.println(empleado.getDatos());
		}		
	}
	
	public static void leerPalabra(String palabra){
	    palabras.add(palabra);
	}
	
	public static void ejercicio6() {
		
		Menu menu = new Menu();
		menu.start();
		
	}

}
