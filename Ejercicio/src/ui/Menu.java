package ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entidades.Product;
import logic.*;

public class Menu {

	private Scanner s = null;
	private abmcProduct abmcProduct = new abmcProduct();
	private String dateFormat = "dd/MM/yyyy";
	private String timeFormat = "HH;mm:ss";
	private String dateTimeFormat = dateFormat + " " + timeFormat;
	
	
	public void start() {
		System.out.println("Menu");
		System.out.println("1_Listado");
		System.out.println("2_Buscar");
		System.out.println("3_Nuevo");
		System.out.println("4_Editar");
		System.out.println("5_Borrar");
		System.out.println("6_Salir");
		
		s = new Scanner(System.in);
		String opt = s.nextLine();
		
		switch(opt) {
		case "1":
			listado();
			break;
		case "2":
			buscar();
			break;
		case "3":
			nuevo();
			break;
		case "4":
			editar();
			break;
		case "5":
			borrar();
			break;
		case "6":
			break;
		}

	}
	
	public void listado() {
		System.out.println(abmcProduct.getAll());
	}
	
	public void buscar() {
		String opt = s.nextLine();
		System.out.print("Ingrese ID: ");
		System.out.println(abmcProduct.find(opt));
	}
	
	public void nuevo() {
		Product product = new Product();
		System.out.println("Nuevo producto:");
		abmcProduct.add(dataProduct(product));
	}
	
	public void editar() {
		System.out.println("Edicion producto:");
		System.out.print("Ingrese ID: ");
		String opt = s.nextLine();
		Product product = abmcProduct.find(opt);
		System.out.println(product);
		product = dataProduct(product);	
		abmcProduct.update(product);
	}
	
	public void borrar() {
		System.out.println("Borrar producto:");
		System.out.print("Ingrese ID: ");
		String opt = s.nextLine();
		Product product = abmcProduct.find(opt);
		abmcProduct.delete(product);
	}
	
	public Product dataProduct(Product product) {
		
		System.out.print("Ingrese descripcion: ");
		product.setDescription(s.nextLine());	
		System.out.println();
		
		System.out.print("Ingrese precio: ");
		product.setPrice(Double.parseDouble(s.nextLine()));
		System.out.println();
		
		System.out.print("Ingrese stock: ");
		product.setStock(Integer.parseInt(s.nextLine()));
		System.out.println();
		
		System.out.print("Envío incluido: [0] No - [1] Si");
		boolean shipping = s.nextLine().equals("0") ? false : true;
		product.setShippingIncluded(shipping);
		System.out.println();
		
		DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
		System.out.print("Deshabilitado: ");
		product.setDisabledOn(LocalDateTime.parse(s.nextLine(), dtFormat));
		System.out.println();
		
		DateTimeFormatter tFormat = DateTimeFormatter.ofPattern(dateFormat);
		System.out.print("Deshabilitado: ");
		product.setDisabledOn(LocalDateTime.parse(s.nextLine(), tFormat));
		System.out.println();
		
		DateTimeFormatter dFormat = DateTimeFormatter.ofPattern(timeFormat);
		System.out.print("Deshabilitado: ");
		product.setDisabledOn(LocalDateTime.parse(s.nextLine(), dFormat));
		System.out.println();
		
		return product;
	}
}
