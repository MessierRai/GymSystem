package br.edu.theproject.gui;

import br.edu.theproject.molde.Bens;
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

public class consultaBens {
	
	public void cnsBens(GridPane malha) {
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
		
		Text sds = new Text("Consulta Bens");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		sds.setTextAlignment(TextAlignment.CENTER);
		GridPane.setConstraints(sds, 0, 0);
		
		TableView<Bens> tabela = new TableView<>();
		
		ObservableList<Bens> dados = FXCollections.observableArrayList(new Ops().lsBens());
		
		tabela.setItems(dados);
		
		TableColumn<Bens, Integer> colunaId = new TableColumn<>("Id");
		colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tabela.getColumns().add(colunaId);
		
		TableColumn<Bens, String> colunaNome = new TableColumn<>("Nome");
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tabela.getColumns().add(colunaNome);
		
		TableColumn<Bens, Integer> colunaQtd = new TableColumn<>("Quantidade");
		colunaQtd.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tabela.getColumns().add(colunaQtd);
		GridPane.setConstraints(tabela, 0, 1);
		
		malha.getChildren().addAll(sds, tabela);
	}

}
