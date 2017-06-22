package br.edu.theproject.gui;


import br.edu.theproject.doc.GerarDoc;
import br.edu.theproject.molde.Cliente;
import br.edu.theproject.sql.Ops;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
		
		Font fonte = Font.font(null, FontWeight.BOLD, 13);
		
		Text titulo = new Text("\nDados Cliente");
		titulo.setFont(Font.font(22));
		
		VBox vb1 = new VBox(10);
		GridPane.setConstraints(vb1, 0, 2);
		
		VBox vb2 = new VBox(10);
		GridPane.setConstraints(vb2, 1, 2);
		
		Text nome = new Text("Nome: ");
		nome.setFont(fonte);
		Text endereco1 = new Text("Rua ");
		endereco1.setFont(fonte);
		Text endereco2 = new Text("Bairro: ");
		endereco2.setFont(fonte);
		Text dt_nasc = new Text("Nascimento: ");
		dt_nasc.setFont(fonte);
		Text altura = new Text("Altura: ");
		altura.setFont(fonte);
		Text turno = new Text("Turno: ");
		turno.setFont(fonte);
		Text personal = new Text("Personal: ");
		personal.setFont(fonte);
		Text mensalidade = new Text("Mensalidade: ");
		mensalidade.setFont(fonte);
		
		vb1.getChildren().addAll(nome, endereco1, endereco2, dt_nasc, altura, turno, personal, mensalidade);
		
		Label nomeCt = new Label(cl.getNome());
		Label endereco1Ct = new Label(cl.getEndereco1());
		Label endereco2Ct = new Label(cl.getEndereco2());
		Label dt_nascCt = new Label(cl.getDt_nasc());
		Label alturaCt = new Label(String.valueOf(cl.getAltura()));
		Label turnoCt = new Label(cl.getTurno());
		Label personalCt = new Label(cl.getNomepersonal());
		Label mensalidadeCt = new Label("R$ " + String.valueOf(new Ops().obterValorMensalidade(cl.getId())));
		
		vb2.getChildren().addAll(nomeCt, endereco1Ct, endereco2Ct, dt_nascCt, alturaCt, turnoCt, personalCt, mensalidadeCt);
		
		Button btnGr = new Button("Gerar Comprovante\n  de Matricula");
		GridPane.setConstraints(btnGr, 0, 3);
		
		btnGr.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				try {
					new GerarDoc().gerarComprovanteMatricula(cl.getNome(), cl.getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
        
        malhaSobre.getChildren().addAll(vb1, vb2, btnGr);
        
        bp.setTop(titulo);
        bp.setCenter(malhaSobre);
        
        
        Scene cena = new Scene(bp, 380, 350);
        palcoSobre.setScene(cena);
        palcoSobre.setTitle("Resultado");
        palcoSobre.show();
	}

}
