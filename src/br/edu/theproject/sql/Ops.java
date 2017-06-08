package br.edu.theproject.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.exceptions.jdbc4.*;

import br.edu.theproject.jdbc.ConexaoSQL;
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
			
			Alert alert = new Alert(AlertType.INFORMATION);
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
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}
	
	public static void cdCliente(Cliente cl) {
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
			stat.setFloat(5, cl.getAltura());
			stat.setString(6, cl.getTurno());
			stat.setInt(7, cl.getId_personalFK());
			
			stat.execute();
			stat.close();
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Cadastrado com sucesso!");
			alert.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void cdBens() {
		
	}
	
	public void cdAtividade() {
		
	}
	
	public void grStats() {
		
	}
	
	public void grComprovante() {
		
	}
	
	public void lsClientes() {
		
	}
	
	public void lsFuncionarios() {
		
	}
	
	public void lsBens() {
		
	}
	
	public void lsAtividades() {
		
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
