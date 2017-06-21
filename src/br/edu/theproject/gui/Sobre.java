package br.edu.theproject.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Sobre {
	public Sobre(Stage palco) {
		final Stage palcoSobre = new Stage();
		palcoSobre.initModality(Modality.APPLICATION_MODAL);
        palcoSobre.initOwner(palco);
		
		GridPane malhaSobre = new GridPane();
		malhaSobre.setHgap(10);
		malhaSobre.setVgap(10);
		malhaSobre.setPadding(new Insets(15, 15, 15, 15));
		malhaSobre.setAlignment(Pos.CENTER);
		
		Text produto = new Text("GymSystem 2017(QR)");
		produto.setFont(Font.font(20));
		GridPane.setConstraints(produto, 0, 0);
		
		Text gb = new Text("    ");
		GridPane.setConstraints(gb, 0, 1);
		
		Label textinho = new Label("App desenvolvido para fins avaliativos\ne educacionais na UFAL - Campus Arapiraca.\n :)");
		GridPane.setConstraints(textinho, 0, 2);
		
		Text devsAP = new Text("Desenvolvido por:");
		devsAP.setFont(Font.font(15));
		GridPane.setConstraints(devsAP, 0, 3);
		
		Text devsNms = new Text("Lucas Ferreira\nMonaly Vital\nRaí Lima");
		GridPane.setConstraints(devsNms, 0, 4);
		
        
        malhaSobre.getChildren().addAll(produto, gb, textinho, devsAP, devsNms);
        
        Scene cena = new Scene(malhaSobre, 330, 270);
        palcoSobre.setScene(cena);
        palcoSobre.setResizable(false); // impede que a tela de "sobre" seja maximizada
        palcoSobre.sizeToScene();
        palcoSobre.setTitle("Sobre Tudo");
        palcoSobre.show();
	}

}
