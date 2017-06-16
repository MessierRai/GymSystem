package br.edu.theproject.gui;

import br.edu.theproject.molde.Cliente;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class cadastroCliente {
	
	public void cCliente(GridPane malha) throws Exception {
		
		malha.setAlignment(Pos.CENTER_RIGHT);
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(25, 25, 25, 220)); //define os pixels para as bordas
		
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
		
		HBox caixasNasc = new HBox(10);
		caixasNasc.setAlignment(Pos.CENTER); // posiciona o HBox no centro
			
		TextField nascDia = new TextField();
		nascDia.setMaxWidth(45); //define a largura do campo de texto
		nascDia.appendText("Dia"); // bota o conteudo dentro do campo de texto
		TextField nascMes = new TextField();
		nascMes.setMaxWidth(45);
		nascMes.appendText("Mês");
		TextField nascAno = new TextField();
		nascAno.setMaxWidth(75);
		nascAno.appendText("Ano");
		
		caixasNasc.getChildren().addAll(nascDia, nascMes, nascAno); //add os capos de texto dentro do HBox
		GridPane.setConstraints(caixasNasc, 0, 8);
		
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
		
		ObservableList<String> personalList = FXCollections.observableList(new Ops().lsPersonal());
		ComboBox<String> personal = new ComboBox<String>(personalList);
        GridPane.setConstraints(personal, 0, 14);
        
        Label exame = new Label("Os exames indicam aptidão fisica: ");
        GridPane.setConstraints(exame, 0, 15);
        
        ToggleGroup tgExame = new ToggleGroup();//define um grupo para evitar que os dois sejam selecionados.
		HBox escolhas = new HBox(20);
		escolhas.setAlignment(Pos.CENTER_LEFT);
		RadioButton rbSim = new RadioButton("Sim"); 
		rbSim.setSelected(true); // define como sendo o que esta marcado por padrao
		RadioButton rbNao = new RadioButton("Não");
		tgExame.getToggles().addAll(rbSim, rbNao); // add botoes ao grupo
		escolhas.getChildren().addAll(rbSim, rbNao);
		GridPane.setConstraints(escolhas, 0, 16);

		Button btCds = new Button("Cadastrar");
		GridPane.setConstraints(btCds, 0, 17);
		
		btCds.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ToggleButton resEx = (ToggleButton) tgExame.getSelectedToggle();
				if(resEx.getText().equals("Sim")) { // verifica se o botao selecionado contém a palavra "Sim"s
					int idPersonal = new Ops().obterId(personal.getValue());
					Cliente c = new Cliente(txtFld.getText(), txtFld2.getText(), txtFld3.getText(), Integer.parseInt(nascDia.getText()), Integer.parseInt(nascMes.getText()), Integer.parseInt(nascAno.getText()), Double.parseDouble(txtFld5.getText()), txtFld6.getText(), idPersonal);
					Ops s = new Ops();
					
					s.cdCliente(c);
					int idCli = s.obterIdCli(c.getNome());
					s.addClienteMensalidade(idCli);
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Informação");
					alert.setHeaderText("Cliente não apto fisicamente.");
					alert.showAndWait();
				}
				
			}
		});
		
		malha.getChildren().addAll(sds, nLbl, txtFld, n1Lbl, n1Lb2, n1Lb3, n1Lb4, n1Lb5, n1Lb6, txtFld2, txtFld3, caixasNasc, txtFld5, txtFld6, btCds, personal, exame, escolhas);


	}
}

