package br.edu.theproject.gui;


import br.edu.theproject.molde.Atendente;
import br.edu.theproject.molde.Funcionario;
import br.edu.theproject.molde.Gerente;
import br.edu.theproject.molde.Personal;
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

public class cadastrarFuncionario {
	
	public void cds(GridPane malha, int who) throws Exception {
		
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
		
		Text sds = new Text();
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		GridPane.setConstraints(sds, 0, 0);
		
		if(who == 1) {
			sds.setText("Cadastrar Gerente");
		}else if(who == 2) {
			sds.setText("Cadastrar Atendente");
		}else if(who == 3) {
			sds.setText("Cadastrar Personal");
		}
			
		Label nLbl = new Label("Nome: ");
		GridPane.setConstraints(nLbl, 0, 1);
		
		TextField txtFld = new TextField();
		GridPane.setConstraints(txtFld, 0, 2);
			
		Label n1Lbl = new Label("CPF (11 dígitos): ");
		GridPane.setConstraints(n1Lbl, 0, 3);
			
		TextField txtFld2 = new TextField();
		GridPane.setConstraints(txtFld2, 0, 4);
		
		Button btCds = new Button("Cadastrar");
		GridPane.setConstraints(btCds, 0, 5);
		
		
		btCds.setOnAction(new EventHandler<ActionEvent>() { //bloco de "GE"
			@Override
			public void handle(ActionEvent event) {
				if(txtFld.getText().isEmpty() || txtFld2.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Aviso");
					alert.setHeaderText("Há campos vazios!");
					alert.showAndWait();
				}else {
					if(who == 1) {
						try {
							Funcionario ng = new Gerente(txtFld.getText(), txtFld2.getText());
							Ops op = new Ops();
							
							op.cdGerente(ng);
							
							int idNg = op.obterId(ng);
							op.cdLogin(idNg);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}else if(who == 2) {
						try {
							Funcionario na = new Atendente(txtFld.getText(), txtFld2.getText());
							Ops op = new Ops();
							
							op.cdAtendente(na);
							
							int idNg = op.obterId(na);
							op.cdLogin(idNg);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else if(who == 3) {
						try {
							Funcionario np = new Personal(txtFld.getText(), txtFld2.getText());
							Ops op = new Ops();
							
							op.cdPersonal(np);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
			}
		});
		
		malha.getChildren().addAll(sds, nLbl, txtFld, n1Lbl, txtFld2, btCds);
		
	}

}
