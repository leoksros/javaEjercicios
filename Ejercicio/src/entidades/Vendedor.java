package entidades;

public class Vendedor extends Empleado {
	
	private int porcentajeComision;
	private int totalVentas;
	
	public Vendedor(int dni, String nombre, String apellido, String email, int sueldoBase,int porcentajeComision, int totalVentas) {
		super(dni, nombre, apellido, email, sueldoBase);
		this.setPorcentajeComision(porcentajeComision);
		this.setTotalVentas(totalVentas);
	}
	
	public int getPorcentajeComision() {
		return porcentajeComision;
	}
	public void setPorcentajeComision(int porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}
	public int getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}
	
	public int getSueldo() {
		return this.getSueldoBase() + (this.getPorcentajeComision()*this.getTotalVentas()/100);
	}
	
	@Override
	public String getDatos() {
		return super.getDatos()+" - Comision: "+ this.getPorcentajeComision() + "- Ventas: " + this.getTotalVentas();
	}

}
