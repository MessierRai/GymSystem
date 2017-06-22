package br.edu.theproject.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GerarEstatisticasPopUp {
	
	public void stats(Stage palco) {
		final Stage palcoStats = new Stage();
		palcoStats.initModality(Modality.APPLICATION_MODAL);
        palcoStats.initOwner(palco);
        
        GridPane malhaStats = new GridPane();
		malhaStats.setHgap(5);
		malhaStats.setVgap(10);
		malhaStats.setPadding(new Insets(15, 15, 15, 15));
		malhaStats.setAlignment(Pos.CENTER);
		
		Scene cena = new Scene(malhaStats, 350, 400);
		
		Text um = new Text("Quantidade de Funcionarios: ");
		um.setFont(Font.font(null, FontWeight.BOLD, 15));
		GridPane.setConstraints(um, 0, 2);
		Text um2 = new Text("NUM");
		um2.setFont(Font.font(null, FontWeight.NORMAL, 12));
		GridPane.setConstraints(um2, 0, 3);
		
		Text dois = new Text("Quantidade de Clientes: ");
		dois.setFont(Font.font(null, FontWeight.BOLD, 15));
		GridPane.setConstraints(dois, 0, 4);
		Text dois2 = new Text("NUM");
		dois2.setFont(Font.font(null, FontWeight.NORMAL, 12));
		GridPane.setConstraints(dois2, 0, 5);
		
		Text tres = new Text("Quantidade de Atividades Disponiveis: ");
		tres.setFont(Font.font(null, FontWeight.BOLD, 15));
		GridPane.setConstraints(tres, 0, 6);
		Text tres2 = new Text("NUM");
		tres2.setFont(Font.font(null, FontWeight.NORMAL, 12));
		GridPane.setConstraints(tres2, 0, 7);
		
		Text quatro = new Text("Quantidade de Bens Adquiridos: ");
		quatro.setFont(Font.font(null, FontWeight.BOLD, 15));
		GridPane.setConstraints(quatro, 0, 8);
		Text quatro2 = new Text("NUM");
		quatro2.setFont(Font.font(null, FontWeight.NORMAL, 12));
		GridPane.setConstraints(quatro2, 0, 9);
		
		Text cinco = new Text("Quantia Movimentada Até Agora: ");
		cinco.setFont(Font.font(null, FontWeight.BOLD, 15));
		GridPane.setConstraints(cinco, 0, 10);
		Text cinco2 = new Text("NUM");
		cinco2.setFont(Font.font(null, FontWeight.NORMAL, 12));
		GridPane.setConstraints(cinco2, 0, 11);
		
		malhaStats.getChildren().addAll(um, um2, dois, dois2, tres, tres2, quatro, quatro2, cinco, cinco2);
		
		palcoStats.setScene(cena);
		palcoStats.setTitle("Estatisticas");
		palcoStats.show();
	}

}
