package br.edu.theproject.gui;

import java.util.ArrayList;

import br.edu.theproject.molde.Pagamento;
import br.edu.theproject.sql.Ops;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PagamentoIn {
	
	public void pagar(GridPane malha){
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
		
		Text sds = new Text("Área Pagamento");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		GridPane.setConstraints(sds, 0, 0);
		
		Label nLbl = new Label("ID Cliente: ");
		GridPane.setConstraints(nLbl, 0, 2);
		
		TextField txtFld = new TextField();
		GridPane.setConstraints(txtFld, 0, 3);
		

		Label n1Lb1 = new Label("Forma de Pagamento : ");
		GridPane.setConstraints(n1Lb1, 0, 4);
		
		ArrayList<String> forma = new ArrayList<String> ();
		forma.add("Dinheiro");
		forma.add("Cartão Débito");
		forma.add("Cartão Crédito");
		
		ObservableList<String> formalist = FXCollections.observableArrayList(forma);
		ComboBox<String> formaP = new ComboBox<String>(formalist);
        GridPane.setConstraints(formaP, 0, 5);
        
        Button btCds = new Button("Salvar");
		GridPane.setConstraints(btCds, 0, 17);
		
		
			btCds.setOnAction(new EventHandler<ActionEvent>() { 
				@Override
				public void handle(ActionEvent event) {
					Pagamento pa = new Pagamento(txtFld.getText(), formaP.getValue()); //campo que vai pegar os valores 
					Ops op = new Ops();
						
					//op.(pa);
				}
			});
			
			malha.getChildren().addAll(sds, nLbl, txtFld, n1Lb1,formaP, btCds);
			
		}

	}


