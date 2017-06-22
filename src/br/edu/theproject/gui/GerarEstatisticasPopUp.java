package br.edu.theproject.gui;

import br.edu.theproject.sql.Ops;
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
        
        Font a = Font.font(null, FontWeight.NORMAL, 14);
        Font b = Font.font(null, FontWeight.BOLD, 15);
        
        GridPane malhaStats = new GridPane();
		malhaStats.setHgap(5);
		malhaStats.setVgap(10);
		malhaStats.setPadding(new Insets(15, 15, 15, 15));
		malhaStats.setAlignment(Pos.CENTER);
		
		Scene cena = new Scene(malhaStats, 350, 400);
		
		Text zero = new Text("Estatisticas Gerais");
		zero.setFont(Font.font(30));
		GridPane.setConstraints(zero, 0, 0);
		
		Text um = new Text("Quantidade de Funcionarios: ");
		um.setFont(b);
		GridPane.setConstraints(um, 0, 2);
		Text um2 = new Text(String.valueOf(new Ops().qtdFuncionario()));
		um2.setFont(a);
		GridPane.setConstraints(um2, 0, 3);
		
		Text dois = new Text("Quantidade de Clientes: ");
		dois.setFont(b);
		GridPane.setConstraints(dois, 0, 4);
		Text dois2 = new Text(String.valueOf(new Ops().qtdCliente()));
		dois2.setFont(a);
		GridPane.setConstraints(dois2, 0, 5);
		
		Text tres = new Text("Quantidade de Atividades Disponiveis: ");
		tres.setFont(b);
		GridPane.setConstraints(tres, 0, 6);
		Text tres2 = new Text(String.valueOf(new Ops().qtdAtividade()));
		tres2.setFont(a);
		GridPane.setConstraints(tres2, 0, 7);
		
		Text quatro = new Text("Quantidade de Bens Adquiridos: ");
		quatro.setFont(b);
		GridPane.setConstraints(quatro, 0, 8);
		Text quatro2 = new Text(String.valueOf(new Ops().qtdBens()));
		quatro2.setFont(a);
		GridPane.setConstraints(quatro2, 0, 9);
		
		Text cinco = new Text("Quantia Movimentada Até Agora: ");
		cinco.setFont(b);
		GridPane.setConstraints(cinco, 0, 10);
		Text cinco2 = new Text("R$ " + String.format("%.2f", new Ops().quantiaMov()));
		cinco2.setFont(a);
		GridPane.setConstraints(cinco2, 0, 11);
		
		malhaStats.getChildren().addAll(zero, um, um2, dois, dois2, tres, tres2, quatro, quatro2, cinco, cinco2);
		
		palcoStats.setScene(cena);
		palcoStats.setTitle("Estatisticas");
		palcoStats.show();
	}

}
