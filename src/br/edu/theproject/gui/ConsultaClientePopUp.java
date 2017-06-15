package br.edu.theproject.gui;

import br.edu.theproject.molde.Cliente;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConsultaClientePopUp {
	
	public ConsultaClientePopUp(Stage palco, Cliente cl) {
		final Stage palcoSobre = new Stage();
		palcoSobre.initModality(Modality.APPLICATION_MODAL);
        palcoSobre.initOwner(palco);
        
        
        BorderPane bp = new BorderPane();
		
		GridPane malhaSobre = new GridPane();
		malhaSobre.setHgap(5);
		malhaSobre.setVgap(10);
		malhaSobre.setPadding(new Insets(15, 15, 15, 15));
		malhaSobre.setAlignment(Pos.CENTER);
		
		Text titulo = new Text("\n--Dados Cliente");
		titulo.setFont(Font.font(20));
		
		VBox vb1 = new VBox(10);
		GridPane.setConstraints(vb1, 0, 2);
		
		VBox vb2 = new VBox(10);
		GridPane.setConstraints(vb2, 1, 2);
		
		Text nome = new Text("Nome: ");
		nome.setFont(Font.font(null, FontWeight.BOLD, 13));
		Text endereco1 = new Text("Rua ");
		endereco1.setFont(Font.font(null, FontWeight.BOLD, 13));
		Text endereco2 = new Text("Bairro: ");
		endereco2.setFont(Font.font(null, FontWeight.BOLD, 13));
		Text dt_nasc = new Text("Nascimento: ");
		dt_nasc.setFont(Font.font(null, FontWeight.BOLD, 13));
		Text altura = new Text("Altura: ");
		altura.setFont(Font.font(null, FontWeight.BOLD, 13));
		Text turno = new Text("Turno: ");
		turno.setFont(Font.font(null, FontWeight.BOLD, 13));
		Text personal = new Text("Personal: ");
		personal.setFont(Font.font(null, FontWeight.BOLD, 13));
		
		vb1.getChildren().addAll(nome, endereco1, endereco2, dt_nasc, altura, turno, personal);
		
		Label nomeCt = new Label(cl.getNome());
		Label endereco1Ct = new Label(cl.getEndereco1());
		Label endereco2Ct = new Label(cl.getEndereco2());
		Label dt_nascCt = new Label(cl.getDt_nasc());
		Label alturaCt = new Label(String.valueOf(cl.getAltura()));
		Label turnoCt = new Label(cl.getTurno());
		Label personalCt = new Label(cl.getNomepersonal());
		
		vb2.getChildren().addAll(nomeCt, endereco1Ct, endereco2Ct, dt_nascCt, alturaCt, turnoCt, personalCt);
		
        
        malhaSobre.getChildren().addAll(vb1, vb2);
        
        bp.setTop(titulo);
        bp.setCenter(malhaSobre);
        
        
        Scene cena = new Scene(bp, 330, 290);
        palcoSobre.setScene(cena);
        palcoSobre.setTitle("Resultado");
        palcoSobre.show();
	}

}
