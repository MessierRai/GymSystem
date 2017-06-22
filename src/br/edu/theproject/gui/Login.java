package br.edu.theproject.gui;

import br.edu.theproject.sql.Ops;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane malha = new GridPane();
		malha.setAlignment(Pos.CENTER);
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(25, 25, 25, 25)); //define os pixels para as bordas
		malha.setBackground(new Background(new BackgroundFill(Color.DEEPSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY))); // responsavel por colorir o GridPane
		
		Image icone = new Image("/br/edu/theproject/img/gymsystemicn.png");
		
		Scene cena = new Scene(malha, 300, 190);
		
		Text sds = new Text("Olá!");
		sds.setFont(Font.font(25)); //define o tamanho da fonte, pode-se colocar que fonte quer tambem
		GridPane.setConstraints(sds, 0, 0);
		
		Label userLbl = new Label("Usuário: ");
		GridPane.setConstraints(userLbl, 0, 1);
		
		TextField caixaId = new TextField();
		GridPane.setConstraints(caixaId, 1, 1);
		
		Label pwdLbl = new Label("Senha: ");
		GridPane.setConstraints(pwdLbl, 0, 2);
		
		PasswordField caixaPwd = new PasswordField(); // especialmente para senhas
		GridPane.setConstraints(caixaPwd, 1, 2);
		
		Button btnLog = new Button("Okay? Okay!");
		
		
		btnLog.setOnAction(new EventHandler<ActionEvent>() { // qualquer comportamento antes de fazer login está aqui.
			
			@Override
			public void handle(ActionEvent apertar) {
				try {
					int id = Integer.parseInt(caixaId.getText());
					int cdCargo  = new Ops().obterCargo(id); //new Ops().obterCargo(id); // retorna o cod do cargo, baseado no id do funcionario
					String senhaVld = new Ops().getSenha(id);//new Ops().getSenha(id); // retorna a senha, baseado no id do funcionario
					
					if(caixaPwd.getText().equals(senhaVld)) { //compara se a senha inserida é igual a senha armazenada no BD
						if(cdCargo == 1) { //decide para qual tela ir dependendo do cargo do dono do login (1: Gerente -- 2: Atendente)
							TelaPrincipalG telaG = new TelaPrincipalG();
							try {
								telaG.start(primaryStage);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}else if(cdCargo == 2) {
							TelaPrincipalA telaA = new TelaPrincipalA();
							try {
								
								telaA.start(primaryStage);
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Erro");
						alert.setHeaderText("Senha incorreta!");
						alert.showAndWait();
					}
				} catch (NumberFormatException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Erro");
					alert.setHeaderText("Digite um ID válida!");
					alert.showAndWait();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
				
		});
		
		caixaPwd.setOnKeyPressed(new EventHandler<KeyEvent>() { // qualquer comportamento antes de fazer login está aqui.
		
			@Override
			public void handle(KeyEvent evento) {
				try {
					int id = Integer.parseInt(caixaId.getText());
					int cdCargo  = new Ops().obterCargo(id); //new Ops().obterCargo(id); // retorna o cod do cargo, baseado no id do funcionario
					String senhaVld = new Ops().getSenha(id);//new Ops().getSenha(id); // retorna a senha, baseado no id do funcionario
					
					if(evento.getCode() == KeyCode.ENTER) {
						if(caixaPwd.getText().equals(senhaVld)) { //compara se a senha inserida é igual a senha armazenada no BD
							if(cdCargo == 1) { //decide para qual tela ir dependendo do cargo do dono do login (1: Gerente -- 2: Atendente)
								TelaPrincipalG telaG = new TelaPrincipalG();
								try {
									telaG.start(primaryStage);
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}else if(cdCargo == 2) {
								TelaPrincipalA telaA = new TelaPrincipalA();
								try {
									
									telaA.start(primaryStage);
									
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else {
							Alert alert = new Alert(AlertType.WARNING);
							alert.setTitle("Erro");
							alert.setHeaderText("Senha incorreta!");
							alert.showAndWait();
						}
					}
				} catch (NumberFormatException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Erro");
					alert.setHeaderText("Digite um ID válida!");
					alert.showAndWait();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		HBox setBtn = new HBox(10);
		setBtn.setAlignment(Pos.CENTER_RIGHT); // faz o botao de login ficar mais a direita
		setBtn.getChildren().add(btnLog);
		GridPane.setConstraints(setBtn, 1, 3);
		
		malha.getChildren().addAll(sds, userLbl, caixaId, pwdLbl, caixaPwd, setBtn);
		
		primaryStage.setScene(cena);
		primaryStage.setTitle("Log-In");
		primaryStage.setResizable(false); // impede que a tela de "sobre" seja maximizada
        primaryStage.sizeToScene();
		primaryStage.getIcons().add(icone);
		primaryStage.show();
	}

	
	public static void main(String[] args) {
		launch(); // método que inicializa a aplicacao
	}

}
