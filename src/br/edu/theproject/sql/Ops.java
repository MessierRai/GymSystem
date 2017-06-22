package br.edu.theproject.sql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.mysql.jdbc.exceptions.jdbc4.*;

import br.edu.theproject.jdbc.ConexaoSQL;
import br.edu.theproject.molde.Atividade;
import br.edu.theproject.molde.Bens;
import br.edu.theproject.molde.Cliente;
import br.edu.theproject.molde.Funcionario;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Ops {
	//cadastrar atendente
	public void cdAtendente(Funcionario na) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO funcionario(nome, cpf, id_cargoFK) VALUES (?, ?, ?);";
			
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
	//cadastrar gerente
	public void cdGerente(Funcionario ng) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO funcionario(nome, cpf, id_cargoFK) VALUES (?, ?, ?);";
			
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
	//cadastrar personal
	public void cdPersonal(Funcionario prs) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO funcionario(nome, cpf, id_cargoFK) VALUES (?, ?, ?);";
			
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
	
	//cadastrar cliente
	public void cdCliente(Cliente cl) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO cliente(nome, endereco1, endereco2, dt_nasc, altura, turno, id_personalFK) VALUES (?, ?, ?, ?, ?, ?, ?);";
			
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
			
			int idCli = obterIdCliente(cl.getNome(), cl.getEndereco1());
			//add o cliente a lista de mensalidade
			String sql2 = "INSERT INTO mensalidade(id_clienteFK, mensalidade) VALUES (?, ?);";
			
			PreparedStatement stat2 = abrirConx.prepareStatement(sql2);
			stat2.setInt(1, idCli);
			stat2.setDouble(2, 10.0);
			
			stat2.execute();
			stat2.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Cadastrado com sucesso!");
			alert.setContentText("ID: " + idCli + "\nNome: " + cl.getNome());
			alert.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//cadastrar bens
	public void cdBens(Bens bn) {
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO bens(nome, quantidade) VALUES (?, ?);";
			
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
	//cadastrar atividade
	public void cdAtividade(Atividade atv) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO atividade(nome, valor) VALUES (?, ?);";
			
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
	//apagar registro usuario
	public void apagarRegistro(int idCli){
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			String sql = "DELETE FROM mensalidade WHERE id_clienteFK = ?;"; //deleta da lista de mensalidade, antes de deletar o cliente, questoes de dependencia do BD
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setInt(1, idCli);

			stat.execute();
			stat.close();
			
			String sql1 = "DELETE FROM cliente_atividade WHERE id_clienteFK = ?;"; //deleta da lista de associacoes com atividade, antes de deletar o cliente, questoes de dependencia do BD
			
			PreparedStatement stat1 = abrirConx.prepareStatement(sql1);
			stat1.setInt(1, idCli);

			stat1.execute();
			stat1.close();
			
			String sqlUltimo = "DELETE FROM cliente WHERE id = ?;";
			
			PreparedStatement statUltimo = abrirConx.prepareStatement(sqlUltimo);
			statUltimo.setInt(1, idCli);

			
			statUltimo.execute();
			statUltimo.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Deletado com sucesso!");
			alert.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}
	//listar clientes
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
			
			String sql = "SELECT * FROM cliente WHERE id = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setInt(1, idCliente);
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
				
				listaClientes = new Cliente(id, nome, endereco1, endereco2, dt_nasc, altura, turno, nomepersonal);
			}
			
			stat.close();
			
		}  catch (Exception e) {
			e.printStackTrace();		
		}
		return listaClientes;
		
	}
	//obter id do cliente usando seu nome e primeiro campo de endereco
	public int obterIdCliente(String nome, String endereco) {
		int id = 0;
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT id FROM cliente WHERE nome = ? AND endereco1 = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setString(1, nome);
			stat.setString(2, endereco);
			ResultSet lCliente = stat.executeQuery();
			
			while(lCliente.next()) {
				id = lCliente.getInt("id");
			}
			
			stat.close();
			
		}  catch (Exception e) {
			e.printStackTrace();		
		}
		return id;
	}
	
	//listar funcionarios
	public ArrayList<Funcionario> lsFuncionarios() {
		ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT * FROM funcionario;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			ResultSet lFuncionario = stat.executeQuery();
			
			while(lFuncionario.next()) {
				int id = lFuncionario.getInt("id");
				String nome = lFuncionario.getString("nome");
				String cpf = lFuncionario.getString("cpf");
				int idCargo = lFuncionario.getInt("id_cargoFK");
				
				Funcionario temp = new Funcionario(id, nome, cpf, idCargo) {
				};
				
				listaFuncionarios.add(temp);
			}
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return listaFuncionarios;
		
	}
	//listar personal's
	public ArrayList<String> lsPersonal() {
		ArrayList<String> personals = new ArrayList<String>();
		
		try {
			Connection abrirConex = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT nome FROM funcionario WHERE id_cargoFK = 3;";
			
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
	//listar nome personal's
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
	//listar bens
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
	//listar atividades
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
	//associar cliente a atividade
	public void cdCliAtiv(int idCli, int idAtiv) {
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO cliente_atividade(id_clienteFK, id_atividadeFK) VALUES (?, ?);";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setInt(1, idCli);
			stat.setInt(2, idAtiv);
			
			stat.execute();
			stat.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Associado com sucesso!");
			alert.showAndWait();
			
		}catch (MySQLIntegrityConstraintViolationException duplicate) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setHeaderText("Cliente ja usufrui desta atividade!");
			alert.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	//cadastra pagamentos
	public void cdsPagamento(int id, String formaPgmt) {
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "INSERT INTO pagamento(id_clienteFK, mensalidade, forma_pagamento, dt_pagamento) VALUES (?, ?, ?, ?);";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setInt(1, id);
			stat.setDouble(2, new Ops().obterValorMensalidade(id));
			stat.setString(3, formaPgmt);
			stat.setDate(4, new Date(System.currentTimeMillis()));
			
			stat.execute();
			stat.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Pago com sucesso!");
			alert.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	public void addValorMensalidade(int id, double valor) {
		try {
			double valorAtual = obterValorMensalidade(id);
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "UPDATE mensalidade SET mensalidade = ? WHERE id_clienteFK = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			
			stat.setDouble(1, (valorAtual + valor));
			stat.setInt(2, id);
			
			stat.execute();
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	//auto-explicativo
	public double obterValorMensalidade(int id) { //o nome é auto-explicativo
			double valor = 0;
			try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT mensalidade FROM mensalidade WHERE id_clienteFK = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setInt(1, id);
			ResultSet valorMens = stat.executeQuery();
			
			while(valorMens.next()) {
				valor = valorMens.getDouble("mensalidade");
			}
			
			stat.execute();
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return valor;
	}
	//obter codigo do cargo baseado no id do funcionario
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
	//obter id do cliente baseado no nome - EM TESTES
	public int obterIdCli(String nome) {
		int cod = 0;
		try {
			
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT id FROM cliente WHERE nome = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			stat.setString(1, nome);
			
			ResultSet codCli = stat.executeQuery();
			
			while(codCli.next()) {
				cod = codCli.getInt("id");
			}
			
			stat.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return cod;
		
	}
	//cadastrar login do funcionario, chamado na hora do cadastro dele
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
	//obtem a senha baseado no id do funcionario
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
	//altera senha do funcionario, baseado no seu id, e recebendo a nova senha
	public void altSenha(int idFunc, String senha) {
		
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "UPDATE login SET senha = ? where id_funcionarioFK = ?;";
			
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			
			stat.setString(1, senha);
			stat.setInt(2, idFunc);
			
			stat.execute();
			stat.close();
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Alterado com sucesso!");
			alert.showAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int qtdFuncionario() {
		int qtd = 0;
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT COUNT(id) AS quantidade FROM funcionario;";
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			ResultSet qtdAtual = stat.executeQuery();
			
			while(qtdAtual.next()) {
				qtd = qtdAtual.getInt("quantidade");
			}
			
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public int qtdCliente() {
		int qtd = 0;
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT COUNT(id) AS quantidade FROM cliente;";
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			ResultSet qtdAtual = stat.executeQuery();
			
			while(qtdAtual.next()) {
				qtd = qtdAtual.getInt("quantidade");
			}
			
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public int qtdAtividade() {
		int qtd = 0;
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT COUNT(id) AS quantidade FROM atividade;";
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			ResultSet qtdAtual = stat.executeQuery();
			
			while(qtdAtual.next()) {
				qtd = qtdAtual.getInt("quantidade");
			}
			
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public int qtdBens() {
		int qtd = 0;
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT COUNT(id) AS quantidade FROM bens;";
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			ResultSet qtdAtual = stat.executeQuery();
			
			while(qtdAtual.next()) {
				qtd = qtdAtual.getInt("quantidade");
			}
			
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qtd;
	}
	
	public double quantiaMov() {
		double quantia = 0;
		try {
			Connection abrirConx = ConexaoSQL.getInstance().getConnection();
			
			String sql = "SELECT SUM(mensalidade) AS quantia FROM pagamento;";
			PreparedStatement stat = abrirConx.prepareStatement(sql);
			ResultSet qtdAtual = stat.executeQuery();
			
			while(qtdAtual.next()) {
				quantia = qtdAtual.getDouble("quantia");
			}
			
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantia;
	}

}
