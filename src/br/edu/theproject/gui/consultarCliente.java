package br.edu.theproject.gui;

import br.edu.theproject.molde.Cliente;
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
import javafx.stage.Stage;

public class consultarCliente {

	public void consultar(GridPane malha) throws Exception {
		Stage palco = new Stage();
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
	
		Text sds = new Text("Consultar Cliente ");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		GridPane.setConstraints(sds, 0, 0);
		
		Label space = new Label(" ");
		GridPane.setConstraints(space, 0, 1);
		
		Label nLbl = new Label("ID: ");
		GridPane.setConstraints(nLbl, 0, 2);
		
		TextField txtFld = new TextField();
		GridPane.setConstraints(txtFld, 0, 3);
		
		Button btCds = new Button("Consultar");
		GridPane.setConstraints(btCds, 1, 3);
		
		btCds.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(txtFld.getText().isEmpty()) { // verifica se o campo de ID está vazio
					Alert alert = new Alert(AlertType.WARNING);
					alert.setHeaderText("Campo ID vazio");
					alert.showAndWait();
					
				}else {
					try {
						int id = Integer.parseInt(txtFld.getText());
						Cliente retorno = new Ops().lsUmCliente(id);
						new ConsultaClientePopUp(palco, retorno);
					} catch (NullPointerException npe) { // trata se o id não existir na base de dados dos clientes
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Erro");
						alert.setHeaderText("Digite um ID válido");
						alert.showAndWait();
					}
				}
				
				
				
			}
		});
		
		malha.getChildren().addAll(sds, space, nLbl, txtFld, btCds);

	}
}
