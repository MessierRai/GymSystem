package br.edu.theproject.molde;

public class Bens {
	
	private String nome;
	private int quantidade;
	private int id;
	
	public Bens(String nome, int quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
	public Bens(int id, String nome, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
	}
	
	public String getNome() {
		return nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public int getId() {
		return this.id;
	}
}
