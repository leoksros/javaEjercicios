package entidades;

import java.sql.*;
import java.time.*;
import java.util.LinkedList;

public class Product {
	private int id;
	private String description;
	private double price;
	private int stock;
	private boolean shippingIncluded;
	private LocalDateTime disabledOn;
	private LocalDate disabledDate;
	private LocalTime disabledTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isShippingIncluded() {
		return shippingIncluded;
	}
	public void setShippingIncluded(boolean shippingIncluded) {
		this.shippingIncluded = shippingIncluded;
	}
	public LocalDateTime getDisabledOn() {
		return disabledOn;
	}
	public void setDisabledOn(LocalDateTime disabledOn) {
		this.disabledOn = disabledOn;
	}
	public LocalDate getDisabledDate() {
		return disabledDate;
	}
	public void setDisabledDate(LocalDate disabledDate) {
		this.disabledDate = disabledDate;
	}
	public LocalTime getDisabledTime() {
		return disabledTime;
	}
	public void setDisabledTime(LocalTime disabledTime) {
		this.disabledTime = disabledTime;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", price=" + price + ", stock=" + stock
				+ ", shippingIncluded=" + shippingIncluded + ", disabledOn=" + disabledOn + ", disabledDate="
				+ disabledDate + ", disabledTime=" + disabledTime + "]";
	}
	
	// https://youtu.be/sBKowceVwbk?list=PLm49vB0eFOFHWj_wQzXNL1pmYaI3jt10E&t=1234
	
	
	
}
