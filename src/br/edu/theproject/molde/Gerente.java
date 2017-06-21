package br.edu.theproject.molde;

public class Gerente extends Funcionario {

	public Gerente(String nome, String cpf) {
		super(nome, cpf);
	}
	
	public Gerente(int id, String nome, String cpf, int idC) {
		super(id, nome, cpf, idC);
	}

}
