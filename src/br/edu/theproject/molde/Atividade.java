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
	
>>>>>>> 6d57bc76b503c3c48c95efa98904d677ebcecce7
	public String getNome() {
		return nome;
	}
	public double getValor() {
		return valor;
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
