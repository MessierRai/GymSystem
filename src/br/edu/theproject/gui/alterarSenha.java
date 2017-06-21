package br.edu.theproject.gui;

import br.edu.theproject.sql.Ops;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class alterarSenha {
	
	public void alterar(GridPane malha) throws Exception {
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
	
		Text sds = new Text("Alterar Senha ");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		GridPane.setConstraints(sds, 0, 0);
		
		Label nLbl = new Label("ID do Funcionario: ");
		GridPane.setConstraints(nLbl, 0, 1);
		
		TextField txtFld = new TextField();
		GridPane.setConstraints(txtFld, 0, 2);
		
		Label n1Lbl = new Label("Senha Atual: ");
		GridPane.setConstraints(n1Lbl, 0, 3);
		
		TextField txtFld2 = new TextField();
		GridPane.setConstraints(txtFld2, 0, 4);
			
		Label n2Lbl = new Label("Nova Senha (6 digitos): ");
		GridPane.setConstraints(n2Lbl, 0, 5);
			
		TextField txtFld3 = new TextField();
		GridPane.setConstraints(txtFld3, 0, 6);
		
		Button btCds = new Button("Salvar");
		GridPane.setConstraints(btCds, 0, 7);
		
		btCds.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				int idFunc = Integer.parseInt(txtFld.getText());
				String senhaAtual = txtFld2.getText();
				String senhaNova = txtFld3.getText();
				String senhaVld = new Ops().getSenha(idFunc);
				
				try {
					if(senhaAtual.equals(senhaVld)) {
						new Ops().altSenha(idFunc, senhaNova);
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Erro");
						alert.setHeaderText("Senha atual incorreta!");
						alert.showAndWait();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
		});
		
		malha.getChildren().addAll(sds,nLbl, txtFld, n1Lbl, txtFld2, n2Lbl, txtFld3, btCds);

	}
}
