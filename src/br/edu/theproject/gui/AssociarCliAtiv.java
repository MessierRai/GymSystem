package br.edu.theproject.gui;

import br.edu.theproject.molde.Atividade;
import br.edu.theproject.sql.Ops;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AssociarCliAtiv {
	
	public void associar(GridPane malha) {
		
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
		
		Text sds = new Text("Associar cliente");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		GridPane.setConstraints(sds, 0, 0);
		
		Text sds2 = new Text("à atividade");
		sds2.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		GridPane.setConstraints(sds2, 0, 1);
		
		
		Label nLbl = new Label("ID Cliente: ");
		GridPane.setConstraints(nLbl, 0, 2);
		
		TextField txtFld = new TextField();
		GridPane.setConstraints(txtFld, 0, 3);
		
		Label nLbl2 = new Label("Atividades: ");
		GridPane.setConstraints(nLbl2, 1, 2);
		
		ObservableList<Atividade> ativList = FXCollections.observableList(new Ops().lsAtividade());
		ComboBox<Atividade> ativs = new ComboBox<Atividade>(ativList);
        GridPane.setConstraints(ativs, 1, 3);
        
        Button btCds = new Button("Associar");
		GridPane.setConstraints(btCds, 1, 4);
		
		btCds.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(txtFld.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Aviso");
					alert.setHeaderText("Digite um ID!");
					alert.showAndWait();
				} else {
					try {
						int idCli = Integer.parseInt(txtFld.getText());
						Atividade atvAtual = ativs.getValue();
						int idAtiv = atvAtual.getId();
						
						new Ops().cdCliAtiv(idCli, idAtiv);
						new Ops().addValorMensalidade(idCli, atvAtual.getValor()); // atualiza valor da atual mensalidade o cliente
					} catch (NumberFormatException e) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Erro");
						alert.setHeaderText("Digite um ID válido!");
						alert.showAndWait();
					} catch (NullPointerException e) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Erro");
						alert.setHeaderText("Selecione uma atividade!");
						alert.showAndWait();
					}
				}
				
				
			}
		});
        
        malha.getChildren().addAll(sds, sds2, nLbl, txtFld, nLbl2, ativs, btCds);
	}

}
