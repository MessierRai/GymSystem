package br.edu.theproject.molde;

public class Atividade {
	private int id;
	private String nome;
	private double valor;
	
<<<<<<< HEAD
	public int getId() {
		return id;
	}
=======
	public Atividade(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
<<<<<<< HEAD
	public Atividade(int id, String nome, double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
=======
>>>>>>> 6d57bc76b503c3c48c95efa98904d677ebcecce7
>>>>>>> 290326f25ac46b3d179bd78f19913e1cc14d6036
	public String getNome() {
		return nome;
	}
	public double getValor() {
		return valor;
	}

	public int getId() {
		return id;
	}
	
	public Atividade(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public Atividade(int id, String nome, double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
}
