package pkg.Recursiva.Entidade;

public class LinkedList<T> {

	private Node<T> primeira = null;
	private Node<T> ultimo = null;
	private int size;

	// Adiciona no começo
	public void adiconaNoComeco(T obj) {

		try {

			Node<T> nova = new Node<T>(obj, primeira);

			this.primeira = nova;
			if (this.size == 0) {
				this.ultimo = this.primeira;
			}
			this.size++;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.toString());
		}

	}

	// adiciona
	public void adiciona(T obj) {

		if (this.size == 0) {
			adiconaNoComeco(obj);
			return;
		}
		Node<T> primeiroNode = this.primeira;
		Node<T> ultimoNode = adicionaFinal(primeiroNode);
		Node<T> novoNode = new Node<T>(obj, ultimoNode.getProximo());
		ultimoNode.setProximo(novoNode);
		this.size++;
		/*
		 * if (this.size == 0) { adiconaNoComeco(obj); return; } Node<T> cel = new
		 * Node<T>(obj, null); this.ultimo.setProximo(cel); this.ultimo = cel;
		 * 
		 * this.size++;
		 */
	}

	private Node<T> adicionaFinal(Node<T> obj) {

		if (obj.getProximo() != null) {
			return adicionaFinal(obj.getProximo());
		}
		return obj;
	}

	// adiciona no meio
	public void adionaMeio(T elemento) {

		if (this.size == 1 || this.isEmpty()) {
			this.adiconaNoComeco(elemento);
			return;
		}
		int posicao = (this.size / 2) + 1;
		this.adiciona(posicao, elemento);
	}

	// Adiciona em uma determinada posição
	public void adiciona(int posicao, T elementes) {

		if (posicao == 1) {
			adiconaNoComeco(elementes);
			this.size++;
			return;
		} else if (posicao > this.size)
			throw new IllegalArgumentException("Erro ao remover lista vazia");

		int initial = 1;
		Node<T> first = this.primeira;
		Node<T> value = adicionaRecursiva(initial, posicao, first);
		Node<T> cel = new Node<T>(elementes, value.getProximo());
		value.setProximo(cel);
		this.size++;
	}

	public Node<T> adicionaRecursiva(int initial, int posicao, Node<T> obj) {

		if (initial < posicao - 1) {
			obj = adicionaRecursiva(initial + 1, posicao, obj.getProximo());
			return obj;
		} else {

			return obj;
		}
	}

	// Retorna o valor de uma determinada posição..
	private Node<T> pegaCelula(int posicao) {
		// TODO Auto-generated method stub
		Node<T> atual = this.primeira;
		for (int i = 1; i < posicao; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}

	// Remove em uma deteminada posição
	public Node<T> removePosition(int posicao) {
		if (this.isEmpty())
			throw new IllegalArgumentException("Erro ao remover lista vazia");
		int posiAtual = 1;
		Node<T> atual = this.primeira;
		Node<T> ant = null;
		if (posicao == 1) {
			return removeFirst();
		}

		if(posicao>this.size)
			throw new IllegalArgumentException("Erro ao remover da lista");
		while (posiAtual < posicao) {
			ant = atual;
			atual = atual.getProximo();
			posiAtual++;
		}

		Node<T> value = ant.getProximo();
		ant.setProximo(ant.getProximo().getProximo());
		size--;
		return value;
	}

	// Remove final com recursiva
	public Node<T> removeFinal() {

		if (this.isEmpty())
			throw new IllegalArgumentException("Erro ao remover lista vazia");
		else if (this.size == 1)
			return removeFirst();

		Node<T> primeiroNode = this.primeira;
		Node<T> ultimoNode = removeFinalRecursiva(primeiroNode);
		Node<T> nodeRemovido = ultimoNode.getProximo();
		ultimoNode.setProximo(nodeRemovido.getProximo());
		this.size--;
		return nodeRemovido;
	}

	private Node<T> removeFinalRecursiva(Node<T> node) {
		// TODO Auto-generated method stub
		if (node.getProximo().getProximo() != null)
			return removeFinalRecursiva(node.getProximo());
		else
			return node;
	}

	// Remove o primeiro elemento
	public Node<T> removeFirst() {

		// valida se tem informação a ser removida...
		if (this.size == 0) {
			throw new IllegalArgumentException("Erro ao remover lista vazia");
		}
		Node<T> value = this.primeira;
		this.primeira = this.primeira.getProximo();

		if (this.size == 0) {
			this.ultimo = null;
		}
		size--;
		return value;
	}

	public void removeMeio() {

		if (this.size == 1) {

			this.removeFirst();
			return;
		} else if (this.isEmpty()) {

			throw new IllegalArgumentException("Erro ao remover lista vazia");
		}
		int posicao = (this.size / 2) + 1;
		this.removePosition(posicao);

	}

	// Mostra as informaçoes
	public String toString() {

		if (this.size == 0) {
			return "[]";
		}

		Node<T> atual = primeira;
		StringBuilder builder = new StringBuilder("[");

		return mostrarLista(atual, builder);

	}
	
	public void listaOrdenada() {
		
		Node<T> nodelist = this.primeira;
		
		for(int i =1;i<=4;i++) {
			
			Node<T> node =ordenaList(nodelist);
		 
			int position = this.retornaPosicaoNode(node.getElemento());
			
			this.removePosition(position);
			this.adiciona(i, node.getElemento());
			nodelist =nodelist.getProximo();
			
			
		}
	}

	
	public boolean buscaSequencial(String nome) {
		
		Node<T> node  = this.primeira;
		
		while(node!=null) {
			
			if(node.getElemento()
					.toString()
					.toUpperCase().equals(nome.toUpperCase()))
				  return true;
			node =node.getProximo();
		}
		
		return false;
	}
	public Node<T> ordenaList(Node<T> node) {

		Node<T> inicial = node.getProximo();
		Node<T> compara = node;
		Node<T> troca = null;
		Node<T> troca02 = this.primeira;
		int valor = 0;
		int valor02 = 1;
			
			
			do {
				
				valor++;
				if(inicial == null)break;
				
				boolean result =(inicial.getElemento().toString().toUpperCase()
						.compareTo(compara.getElemento().toString().toUpperCase()) < 0);
				System.out.println(inicial.getElemento().toString().toUpperCase()+""
						+ " > "+compara.getElemento().toString().toUpperCase()+" = "+result);
				if ((inicial.getElemento().toString().toUpperCase()
						.compareTo(compara.getElemento().toString().toUpperCase()) < 0)) {
					//removePosition(7);
					compara =inicial;
					 System.out.println(valor);
					
				}
				
				
				inicial =inicial.getProximo();
			}while(inicial!=null);
			return compara;
	}

	public int retornaPosicaoNode(T elemento) 
	{
	  Node<T> node = this.primeira;
	  int value = 0;
	  while(node!=null) {
		  value++;
		  if(node.getElemento().toString().equals(elemento.toString())){
			  return value;
		  }
		  node= node.getProximo();
	  }
		
	  return -1;
	}
	
	public String mostrarLista(Node<T> nodeList, StringBuilder builder) {

		if (nodeList.getProximo() != null) {
			builder.append(nodeList.getElemento());
			builder.append(",");
			return mostrarLista(nodeList.getProximo(), builder);

		}
		builder.append(nodeList.getElemento());
		builder.append(",");
		builder.append("]");
		return builder.toString();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size == 0;

	}

	public int getSize() {
		return this.size;
	}

}
