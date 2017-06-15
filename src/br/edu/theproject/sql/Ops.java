package br.edu.theproject.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.jdbc.exceptions.jdbc4.*;

import br.edu.theproject.gui.TelaPrincipalG;
import br.edu.theproject.jdbc.ConexaoSQL;
import br.edu.theproject.molde.Atividade;
import br.edu.theproject.molde.Bens;
import br.edu.theproject.molde.Cliente;
import br.edu.theproject.molde.Funcionario;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Ops {
	
	public void cdAtendente(Funcionario na) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO funcionario(nome, cpf, id_cargoFK) VALUES (?, ?, ?)";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setString(1, na.getNome());
			stat.setString(2, na.getCPF());
			stat.setInt(3, 2);
			
			stat.execute();
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}
	
	public void cdGerente(Funcionario ng) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO funcionario(nome, cpf, id_cargoFK) VALUES (?, ?, ?)";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setString(1, ng.getNome());
			stat.setString(2, ng.getCPF());
			stat.setInt(3, 1);
			
			stat.execute();
			stat.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Cadastrado com sucesso!");
			alert.showAndWait();
			
		} catch (MySQLIntegrityConstraintViolationException duplicate) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("CPF já cadastrado!");
			alert.showAndWait();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void cdPersonal(Funcionario prs) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO funcionario(nome, cpf, id_cargoFK) VALUES (?, ?, ?)";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setString(1, prs.getNome());
			stat.setString(2, prs.getCPF());
			stat.setInt(3, 3);
			
			stat.execute();
			stat.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Cadastrado com sucesso!");
			alert.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}
	
	
	public void cdCliente(Cliente cl) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO cliente(nome, endereco1, endereco2, dt_nasc, altura, turno, id_personalFK) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			Calendar data = Calendar.getInstance();
			data.set(Calendar.YEAR, cl.getDt_nascAno());
			data.set(Calendar.MONTH, cl.getDt_nascMes());
			data.set(Calendar.DAY_OF_MONTH, cl.getDt_nascDia());
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setString(1, cl.getNome());
			stat.setString(2, cl.getEndereco1());
			stat.setString(3, cl.getEndereco2());
			stat.setDate(4, new Date(data.getTimeInMillis()));
			stat.setDouble(5, cl.getAltura());
			stat.setString(6, cl.getTurno());
			stat.setInt(7, cl.getId_personalFK());
			
			stat.execute();
			stat.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Cadastrado com sucesso!");
			alert.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void cdBens(Bens bn) {
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO bens(nome, quantidade) VALUES (?, ?)";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setString(1, bn.getNome());
			stat.setDouble(2, bn.getQuantidade());
			
			stat.execute();
			stat.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Cadastrado com sucesso!");
			alert.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}
	
	public void cdAtividade(Atividade atv) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO atividade(nome, valor) VALUES (?, ?)";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setString(1, atv.getNome());
			stat.setDouble(2, atv.getValor());
			
			stat.execute();
			stat.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Cadastrado com sucesso!");
			alert.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}
	
	public void grStats() {
		
	}
	
	public void grComprovante() {
		
	}
	
	public ArrayList<Cliente> lsClientes() {
		
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM cliente;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			ResultSet lCliente = stat.executeQuery();
			
			while(lCliente.next()) {
				int id = lCliente.getInt("id");
				String nome = lCliente.getString("nome");
				String endereco1 = lCliente.getString("endereco1");
				String endereco2 = lCliente.getString("endereco2");
				String dt_nasc = lCliente.getString("dt_nasc");
				double altura = lCliente.getDouble("altura");
				String turno = lCliente.getString("turno");
				int id_personalFK = lCliente.getInt("id_personalFK");
				String nomepersonal = new Ops().lsNomePersonal(id_personalFK);
				
				
				Cliente temp = new Cliente(id, nome, endereco1, endereco2, dt_nasc, altura, turno, nomepersonal);
				
				listaClientes.add(temp);
			}
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return listaClientes;
		
	}
	
	//Obtem dados do cliente usado o id dele
	public Cliente lsUmCliente(int idCliente) {
		
		Cliente listaClientes = null;
		
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM cliente WHERE id = ?";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setInt(1, idCliente);
			ResultSet lCliente = stat.executeQuery();
			
			while(lCliente.next()) {
				String nome = lCliente.getString("nome");
				String endereco1 = lCliente.getString("endereco1");
				String endereco2 = lCliente.getString("endereco2");
				String dt_nasc = lCliente.getString("dt_nasc");
				double altura = lCliente.getDouble("altura");
				String turno = lCliente.getString("turno");
				int id_personalFK = lCliente.getInt("id_personalFK");
				String nomepersonal = new Ops().lsNomePersonal(id_personalFK);
				
				listaClientes = new Cliente(nome, endereco1, endereco2, dt_nasc, altura, turno, nomepersonal);
			}
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return listaClientes;
		
	}
	
	public void lsFuncionarios() {
		
	}
	
	public ArrayList<String> lsPersonal() {
		ArrayList<String> personals = new ArrayList<String>();
		
		try {
			Connection abrirConex = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT nome FROM funcionario WHERE id_cargoFK = 3";
			
			PreparedStatement stat = abrirConex.prepareStatement(sql);
			
			ResultSet prs = stat.executeQuery();
			
			while(prs.next()) {
				personals.add(prs.getString("nome"));
			}
			
			stat.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personals;
	}
	
	public String lsNomePersonal(int id) {
		String nome = null;
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT nome FROM funcionario WHERE id = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setInt(1, id);
			
			ResultSet nomePrs = stat.executeQuery();
			
			while(nomePrs.next()) {
				nome = nomePrs.getString("nome");
			}
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return nome;
		
	}
	
	public ArrayList<Bens> lsBens() {
		ArrayList<Bens> listaBens = new ArrayList<Bens>();
		
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM bens;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			ResultSet lBens = stat.executeQuery();
			
			while(lBens.next()) {
				int id = lBens.getInt("id");
				String nome = lBens.getString("nome");
				int quantidade = lBens.getInt("quantidade");
				Bens temp = new Bens(id, nome, quantidade);
				
				listaBens.add(temp);
			}
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return listaBens;
		
	}
	
	public ArrayList<Atividade> lsAtividade() {
		
		ArrayList<Atividade> listaAtividades = new ArrayList<Atividade>();
		
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM atividade;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			ResultSet lAtividade = stat.executeQuery();
			
			while(lAtividade.next()) {
				int id = lAtividade.getInt("id");
				String nome = lAtividade.getString("nome");
				double valor = lAtividade.getDouble("valor");
				Atividade temp = new Atividade(id, nome, valor);
				
				listaAtividades.add(temp);
			}
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return listaAtividades;
		
	}
		

	
	public int obterCargo(int id) {
		int cod = 0;
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT id_cargoFK FROM funcionario WHERE id = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setInt(1, id);
			
			ResultSet codCargo = stat.executeQuery();
			
			while(codCargo.next()) {
				cod = codCargo.getInt("id_cargoFK");
			}
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return cod;
	}
	
	//obtem ID do funcionario passando um funcionario
	public int obterId(Funcionario ord) {
		int cod = 0;
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT id FROM funcionario WHERE nome = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setString(1, ord.getNome());
			
			ResultSet codCargo = stat.executeQuery();
			
			while(codCargo.next()) {
				cod = codCargo.getInt("id");
			}
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return cod;
		
	}
	
	
	//obtem ID do funcionario pelo nome
	public int obterId(String nome) {
		int cod = 0;
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT id FROM funcionario WHERE nome = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setString(1, nome);
			
			ResultSet codCargo = stat.executeQuery();
			
			while(codCargo.next()) {
				cod = codCargo.getInt("id");
			}
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return cod;
		
	}
	
	public void cdLogin(int id) {
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO login(id_funcionarioFK, senha) VALUES (?, ?);";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			
			stat.setInt(1, id);
			stat.setString(2, "123456");
			
			stat.execute();
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getSenha(int id) {
		String senha = null;
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT senha FROM login WHERE id_funcionarioFK = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			
			stat.setInt(1, id);
			
			ResultSet senhaRes = stat.executeQuery();
			
			while(senhaRes.next()) {
				senha = senhaRes.getString("senha");
			}
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return senha;
	}
	
	public void altSenha(String senha) {
		int idAtual = new TelaPrincipalG().getIdAtual();
		
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "UPDATE login SET senha = ? where id_funcionarioFK = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			
			stat.setString(1, senha);
			stat.setInt(2, idAtual);
			
			stat.execute();
			stat.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Cadastrado com sucesso!");
			alert.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		/*
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2015);
		c.set(Calendar.MONTH, 04);
		c.set(Calendar.DAY_OF_MONTH, 23);
		
		Cliente cl = new Cliente("Mais um ordinario", "Rua da Rainda de Gelo, 02", "Nárnia", 02, 05, 2015, 1.65f, "Noite", 12);
		
		cdCliente(cl);
		*/
		
	}

}
