package pkg.Recursiva.Entidade;


public class Livros implements Comparable<Livros>{

	private String titulo;
	private int qtdExenplares;
	
	public Livros(String titulo, int qtdExemplates) {
		// TODO Auto-generated constructor stub
		this.titulo = titulo;
		this.qtdExenplares = qtdExemplates;
	}
	
	public int getQtdExenplares() {
		return qtdExenplares;
	}
	
	public void setQtdExenplares(int qtdExenplares) {
		this.qtdExenplares = qtdExenplares;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitutlo(String titutlo) {
		this.titulo = titutlo;
	}

	@Override
	public int compareTo(Livros o) {
		// TODO Auto-generated method stub		
		 return this.getTitulo().toUpperCase().compareTo(o.getTitulo().toUpperCase()) ;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.titulo;
	}
	
}
