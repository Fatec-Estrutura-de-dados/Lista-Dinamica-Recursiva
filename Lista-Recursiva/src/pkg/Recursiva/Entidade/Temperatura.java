package pkg.Recursiva.Entidade;

public class Temperatura implements Comparable<Temperatura>{

	private double graus;
	
	public Temperatura(double graus) {
		// TODO Auto-generated constructor stub
		this.graus = graus;
	}
	
	public void setGraus(double graus) {
		this.graus = graus;
	}
	
	public double getGraus() {
		return graus;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Temperatura "+this.graus;
	}

	@Override
	public int compareTo(Temperatura o) {
		
		return 0;
	}
}
