package br.edu.theproject.molde;

public class Atividade {
	private String nome;
	private double valor;
	
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
	
}
