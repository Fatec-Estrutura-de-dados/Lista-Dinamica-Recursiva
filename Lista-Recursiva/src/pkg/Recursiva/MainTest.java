package pkg.Recursiva;

import pkg.Recursiva.Entidade.Aluno;
import pkg.Recursiva.Entidade.LinkedList;
import pkg.Recursiva.Entidade.Livros;
import pkg.Recursiva.Entidade.Temperatura;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 testTemperatura();
		 testAluno();
		 testLivro();

	}

	private static void testTemperatura() {
		// TODO Auto-generated method stub
		LinkedList<Temperatura> listTemperatura = new LinkedList<>();

		if (listTemperatura.isEmpty())
			System.out.println("lista esta vazia");
		else
			System.out.println("Lista não esta vazia");

		double graus01 = 45.5;
		listTemperatura.adiconaNoComeco(new Temperatura(graus01));

		double graus02 = 60;
		listTemperatura.adiciona(new Temperatura(graus02));

		double graus03 = 70;
		listTemperatura.adiciona(new Temperatura(graus03));

		double graus04 = 7000;
		listTemperatura.adiciona(new Temperatura(graus04));

		System.out.println(listTemperatura.toString());

		// Adiciona Usando recursiva
		listTemperatura.adiciona(2, new Temperatura(500));
		System.out.println(listTemperatura.toString());

		// Remove no começo.
		Temperatura temperaturaRemoveInicio = listTemperatura.removeFirst().getElemento();

		// Remove final
		Temperatura removidoFinal = listTemperatura.removeFinal().getElemento();

		// Remove qualquer posição
		Temperatura temperaturaRemovida = listTemperatura.removePosition(2).getElemento();

		System.out.println(listTemperatura.toString());
	}

	private static void testAluno() {

		LinkedList<Aluno> listAluno = new LinkedList<>();

		// Adiciona no final
		listAluno.adiciona(new Aluno(1245, "Alfredo s", "ADS", "3 - SEMESTRE"));
		
		// Adiciona no começo
		listAluno.adiconaNoComeco(new Aluno(125487, "Jose s", "ADS", "3 - SEMESTRE"));

		// Adiciona no meio
		listAluno.adionaMeio(new Aluno(5874, "Jose s", "logistica", "3 - SEMESTRE"));
		
		// Remove no final
		listAluno.removeFinal();

		// Remove no Inicio
		listAluno.removeFirst();
		// Remove Meio
		listAluno.removeMeio();

		listAluno.adiciona(new Aluno(1245, "Anacleto s", "ADS", "3 - SEMESTRE"));
		// Mostrar elementos
		System.out.println(listAluno.toString());
	}

	private static void testLivro() {
		// TODO Auto-generated method stub
		LinkedList<Livros> listLivros = new LinkedList<>();

		if (listLivros.isEmpty())
			System.out.println("Lista Vazia ");
		else
			System.out.println("A lista contem elementos");
		
		//Adiciona Inicio 
		listLivros.adiconaNoComeco(new Livros("Java test Unit", 10));
		listLivros.adiconaNoComeco(new Livros("C# test Unit", 10));
		listLivros.adiconaNoComeco(new Livros("Javascript test Unit", 10));
		listLivros.adiconaNoComeco(new Livros("Phyton test Unit", 10));
		listLivros.adiconaNoComeco(new Livros("PHP test Unit", 10));
		listLivros.adiciona(new Livros("AAAAAA", 5));
		//adiciona final
		listLivros.adiciona(new Livros("Cobol for beginners", 5));
		
		
	
		
		//adiciona posição
		listLivros.adiciona(2, new Livros("React Native ", 20));
		System.out.println(listLivros.toString());
		//listLivros.ordenaList();
		
		
		listLivros.listaOrdenada();
		System.out.println(listLivros.toString());
		//remove inicio
		//listLivros.removeFirst();
		
		//remove final
		//listLivros.removeFinal();
		
		//Remove de uma determinada posição
		//listLivros.removePosition(3);
		
		



	
	}

}
