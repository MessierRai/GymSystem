package br.edu.theproject.gui;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class cadastroCliente {
	
	public void cCliente(GridPane malha) throws Exception {
		
		Text sds = new Text("Cadastrar Cliente ");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		GridPane.setConstraints(sds, 0, 0);
		
		Label nLbl = new Label("Nome: ");
		GridPane.setConstraints(nLbl, 0, 1);
		
		TextField txtFld = new TextField();
		GridPane.setConstraints(txtFld, 0, 2);
			
		Label n1Lbl = new Label("Endereço : ");
		GridPane.setConstraints(n1Lbl, 0, 3);
			
		TextField txtFld2 = new TextField();
		GridPane.setConstraints(txtFld2, 0, 4);
		
		Label n1Lb2 = new Label("Bairro : ");
		GridPane.setConstraints(n1Lb2, 0, 5);
			
		TextField txtFld3 = new TextField();
		GridPane.setConstraints(txtFld3, 0, 6);
		
		Label n1Lb3 = new Label("Data de Nascimento : ");
		GridPane.setConstraints(n1Lb3, 0, 7);
			
		TextField txtFld4 = new TextField();
		GridPane.setConstraints(txtFld4, 0, 8);
		
		Label n1Lb4 = new Label("Altura : ");
		GridPane.setConstraints(n1Lb4, 0, 9);
			
		TextField txtFld5 = new TextField();
		GridPane.setConstraints(txtFld5, 0, 10);
		
		Label n1Lb5 = new Label("Turno : ");
		GridPane.setConstraints(n1Lb5, 0, 11);
			
		TextField txtFld6 = new TextField();
		GridPane.setConstraints(txtFld6, 0, 12);
		
		Label n1Lb6 = new Label("Personal: ");
		GridPane.setConstraints(n1Lb6, 0, 13);
		
		ComboBox<String> personal = new ComboBox<String>();
        personal.getItems().addAll(
            "jacob.smith@example.com",
            "michael.brown@example.com"  
        );
        GridPane.setConstraints(personal, 0, 14);

		Button btCds = new Button("Cadastrar");
		GridPane.setConstraints(btCds, 0, 15);
		
		malha.getChildren().addAll(sds,nLbl, txtFld, n1Lbl,n1Lb2,n1Lb3,n1Lb4,n1Lb5,n1Lb6,txtFld2, txtFld3,txtFld4,txtFld5,txtFld6, btCds,personal);

	}
}

