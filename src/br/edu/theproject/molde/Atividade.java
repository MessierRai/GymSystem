package br.edu.theproject.molde;

public class Atividade {
	private int id;
	private String nome;
	private double valor;
	

	public int getId() {
		return id;
	}

	public Atividade(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public double getValor() {
		return valor;
	}
	
	public Atividade(int id, String nome, double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
}
