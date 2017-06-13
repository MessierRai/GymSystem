package br.edu.theproject.gui;

import br.edu.theproject.molde.Atividade;
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


public class consultarAtividade {
	public void lsAtividades (GridPane malha) throws Exception {
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
		
		Text sds = new Text("Consultar Atividade");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		sds.setTextAlignment(TextAlignment.CENTER);
		GridPane.setConstraints(sds, 0, 0);
		
		TableView<Atividade> tabela = new TableView<>();
		
		ObservableList<Atividade> dados = FXCollections.observableArrayList(new Ops().getAtividade());
		
		tabela.setItems(dados);
		
		TableColumn<Atividade, Integer> colunaId = new TableColumn<>("Id");
		colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tabela.getColumns().add(colunaId);
		
		TableColumn<Atividade, String> colunaNome = new TableColumn<>("Nome");
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tabela.getColumns().add(colunaNome);
		
		TableColumn<Atividade, Double> colunaValor = new TableColumn<>("Valor");
		colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tabela.getColumns().add(colunaValor);
		GridPane.setConstraints(tabela, 0, 1);
		
		malha.getChildren().addAll(sds, tabela);
	}


	}

