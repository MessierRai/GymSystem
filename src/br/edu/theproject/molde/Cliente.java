package br.edu.theproject.molde;


public class Cliente {
	
	private String nome;
	private String endereco1;
	private String endereco2;
	private int dt_nascDia;
	private int dt_nascMes;
	private int dt_nascAno;
	private double altura;
	private String turno;
	private int id_personalFK;
	
	public Cliente(String nome, String endereco1, String endereco2, int dt_nascDia, int dt_nascMes, int dt_nascAno, double altura, String turno, int id_personalFK) {
		this.nome = nome;
		this.endereco1 = endereco1;
		this.endereco2 = endereco2;
		this.dt_nascDia = dt_nascDia;
		this.dt_nascMes = dt_nascMes;
		this.dt_nascAno = dt_nascAno;
		this.altura = altura;
		this.turno = turno;
		this.id_personalFK = id_personalFK;
	}
	
	public String getNome() {
		return nome;
	}
	public String getEndereco1() {
		return endereco1;
	}
	public String getEndereco2() {
		return endereco2;
	}
	public int getDt_nascDia() {
		return dt_nascDia;
	}

	public int getDt_nascMes() {
		return dt_nascMes;
	}

	public int getDt_nascAno() {
		return dt_nascAno;
	}

	public double getAltura() {
		return altura;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public int getId_personalFK() {
		return id_personalFK;
	}
	public void setId_personalFK(int id_personalFK) {
		this.id_personalFK = id_personalFK;
	}
	
	

}
