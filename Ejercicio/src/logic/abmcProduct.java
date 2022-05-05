package logic;

import java.sql.*;
import java.util.LinkedList;

import entidades.Product;
import data.DataProduct;

public class abmcProduct {
	
	private DataProduct dp;
	
	public abmcProduct() {
		dp = new DataProduct();
	}
	
	public LinkedList<Product> getAll(){
		return dp.getAll();
	}
	
	public Product find(String id) {
		return dp.getById(id);
	}
	
	public void add(Product product) {		
		dp.add(product);
	}
	
	public void update(Product product) {
		dp.update(product);
	}
	
	public void delete(Product product) {
		dp.delete(product);
	}
		
	
}
