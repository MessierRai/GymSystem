package br.edu.theproject.gui;


import br.edu.theproject.molde.Cliente;
import br.edu.theproject.sql.Ops;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class listarClientes {
	public void lClientes(GridPane malha) {
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
		
		Text sds = new Text("Lista de Clientes Cadastrados");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		sds.setTextAlignment(TextAlignment.CENTER);
		GridPane.setConstraints(sds, 0, 0);
		
		TableView<Cliente> tabela = new TableView<>();
		
		ObservableList<Cliente> dados = FXCollections.observableArrayList(new Ops().lsClientes());
		
		tabela.setItems(dados);
		
		TableColumn<Cliente, Integer> colunaId = new TableColumn<>("Id");
		colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tabela.getColumns().add(colunaId);
		
		TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tabela.getColumns().add(colunaNome);
		
		TableColumn<Cliente, String> colunaEndereco = new TableColumn<>("Endereço");
		colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco1"));
		tabela.getColumns().add(colunaEndereco);
		
		TableColumn<Cliente, String> colunaEndereco2 = new TableColumn<>("Bairro");
		colunaEndereco2.setCellValueFactory(new PropertyValueFactory<>("endereco2"));
		tabela.getColumns().add(colunaEndereco2);
	
		TableColumn<Cliente, String> colunaDataNasc = new TableColumn<>("Dt. Nasc.");
		colunaDataNasc.setCellValueFactory(new PropertyValueFactory<>("dt_nasc"));
		tabela.getColumns().add(colunaDataNasc);
		
		TableColumn<Cliente, Double> colunaAltura = new TableColumn<>("Altura");
		colunaAltura.setCellValueFactory(new PropertyValueFactory<>("altura"));
		tabela.getColumns().add(colunaAltura);
		
		TableColumn<Cliente, String> colunaTurno = new TableColumn<>("Turno");
		colunaTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
		tabela.getColumns().add(colunaTurno);
		
		TableColumn<Cliente, String> colunaNomePersonal = new TableColumn<>("Personal");
		colunaNomePersonal.setCellValueFactory(new PropertyValueFactory<>("nomepersonal"));
		tabela.getColumns().add(colunaNomePersonal);
		
		
		GridPane.setConstraints(tabela, 0, 1);
		
		malha.getChildren().addAll(sds, tabela);
	}

}


