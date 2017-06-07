package br.edu.theproject.molde;

public abstract class Funcionario {
	
	private String nome;
	private int id;
	private String CPF;
	
	public Funcionario(String nome, String cpf) {
		this.nome = nome;
		this.CPF = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public int getId() {
		return id;
	}
	public String getCPF() {
		return CPF;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.getId() + " - Nome: " + this.getNome();
	}

}
