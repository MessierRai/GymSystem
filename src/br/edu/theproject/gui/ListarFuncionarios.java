package br.edu.theproject.gui;


import br.edu.theproject.molde.Funcionario;
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

public class ListarFuncionarios {
	public void lfuncionarios(GridPane malha) {
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
		
		Text sds = new Text("Lista de Funcionarios");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		sds.setTextAlignment(TextAlignment.CENTER);
		GridPane.setConstraints(sds, 0, 0);
		
		TableView<Funcionario> tabela = new TableView<>();
		
		ObservableList<Funcionario> dados = FXCollections.observableArrayList(new Ops().lsFuncionarios());
		
		tabela.setItems(dados);
		
		TableColumn<Funcionario, Integer> colunaId = new TableColumn<>("Id");
		colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tabela.getColumns().add(colunaId);
		
		TableColumn<Funcionario, String> colunaNome = new TableColumn<>("Nome");
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tabela.getColumns().add(colunaNome);
		
		TableColumn<Funcionario, String> colunaCpf = new TableColumn<>("CPF");
		colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tabela.getColumns().add(colunaCpf);
		
		TableColumn<Funcionario, String> colunaCargo = new TableColumn<>("Cargo");
		colunaCargo.setCellValueFactory(new PropertyValueFactory<>("id_cargpFK"));
		tabela.getColumns().add(colunaCargo);
			
		GridPane.setConstraints(tabela, 0, 1);
		
		malha.getChildren().addAll(sds, tabela);
	}

}
