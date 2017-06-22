package br.edu.theproject.gui;

import br.edu.theproject.sql.Ops;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ApagarRegistroF {
	public void apagarRF(GridPane malha) {
		
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
		
		Text sds = new Text("Apagar cadastro de funcionario");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		GridPane.setConstraints(sds, 0, 0);
		
		Text sds2 = new Text("Para recadastrar (ou não)");
		sds2.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		GridPane.setConstraints(sds2, 0, 1);

		Label nLbl = new Label("ID Funcionario: ");
		GridPane.setConstraints(nLbl, 0, 2);
		
		TextField txtFld = new TextField();
		GridPane.setConstraints(txtFld, 0, 3);
		
		Button btCds = new Button("Apagar");
		GridPane.setConstraints(btCds, 1, 4);
			
		btCds.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int idFunc = Integer.parseInt(txtFld.getText());
				new Ops().apagarRegistroF(idFunc);
			}
				
		});
	        
	    malha.getChildren().addAll(sds, sds2, nLbl, txtFld, btCds);
	}

}
