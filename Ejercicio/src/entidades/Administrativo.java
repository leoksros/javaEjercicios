package entidades;

public class Administrativo extends Empleado {
	
	private int hsExtra;
	private int hsMes;
	
	public Administrativo(int dni, String nombre, String apellido, String email, int sueldoBase, int hsExtra, int hsMes) {
		super(dni, nombre, apellido, email, sueldoBase);
		this.setHsExtra(hsExtra);
		this.setHsMes(hsMes);
	}
	
	
	public int getHsExtra() {
		return hsExtra;
	}
	public void setHsExtra(int hsExtra) {
		this.hsExtra = hsExtra;
	}
	public int getHsMes() {
		return hsMes;
	}
	public void setHsMes(int hsMes) {
		this.hsMes = hsMes;
	}
	
	public int getSueldo() {
		return (int) (this.getSueldoBase() * ((this.getHsExtra() * 2)+ this.getHsMes()) / this.getHsMes());
	}
	
	@Override
	public String getDatos() {
		return super.getDatos()+" - Horas extras: "+ this.getHsExtra() + "- Horas mes: " + this.getHsMes();
	}

}
