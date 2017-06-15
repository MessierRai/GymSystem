package br.edu.theproject.molde;

public abstract class Funcionario {
	
	private int id;
	private String nome;
	private String CPF;
	private int id_cargoFK;
	
	public Funcionario(String nome, String cpf) {
		this.nome = nome;
		this.CPF = cpf;
	}
	
	public Funcionario(int id, String nome, String cpf, int idC) {
		this.id = id;
		this.nome = nome;
		this.CPF = cpf;
		this.id_cargoFK =idC;
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
	
	public int getId_cargoFK() {
		return id_cargoFK;
	}

	@Override
	public String toString() {
		return "ID: " + this.getId() + " - Nome: " + this.getNome();
	}

}
