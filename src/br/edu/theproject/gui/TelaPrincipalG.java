package br.edu.theproject.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaPrincipalG extends Application {

	@Override
	public void start(Stage palco) throws Exception {
		BorderPane fundoPrincipal = new BorderPane();
		GridPane malha = new GridPane();
		malha.setHgap(10);
		malha.setVgap(10);
		malha.setPadding(new Insets(15, 15, 15, 15));
		malha.setAlignment(Pos.CENTER);
		
		
		Scene cena = new Scene(fundoPrincipal, 700, 500);
		
		Image logo = new Image("/br/edu/theproject/img/gymsystemrem.png");
		ImageView iv = new ImageView(logo);
		
		MenuBar menuzin = new MenuBar(); //cria barra de menu
		
		//Cadastrar - Menu
		Menu cadastrar = new Menu("Cadastrar"); // cria menu
		Menu cdFunc = new Menu("Cadastrar Funcion�rio");
		MenuItem cdGer = new MenuItem("Gerente");
		MenuItem cdAtd = new MenuItem("Atendente");// cria sub items do menu
		MenuItem cdPer = new MenuItem("Personal");
		MenuItem cdCli = new MenuItem("Cadastrar Cliente");
		MenuItem cdBens = new MenuItem("Cadastrar Bens");
		MenuItem cdAtiv = new MenuItem("Cadastrar Atividade");
		MenuItem cdCliAtiv = new MenuItem("Associar Cliente-Atividade");
		MenuItem inc = new MenuItem("Inicio");
		
		// Consultar - Menu
		Menu consulta = new Menu("Consultar");
		MenuItem cnsCliente = new MenuItem("Consultar Cliente");
		MenuItem lsCliente = new MenuItem("Listar Clientes");
		MenuItem cnsBens = new MenuItem("Listar Bens");
		MenuItem cnsFunc = new MenuItem("Listar Funcion�rios");
		MenuItem cnsAtiv = new MenuItem("Listar Atividades");
		MenuItem cnsEst = new MenuItem("Consultar estatisticas");
		
		// Alterar - Menu
		Menu alterar = new Menu("Alterar");
		MenuItem altSenha = new MenuItem("Alterar Senha");
		MenuItem altCliente = new MenuItem("Atualizar Dados Cliente");
		MenuItem apagarR = new MenuItem("Apagar Registro -Cliente");
		
				
		
		// Sobre - Menu
		Menu sobre = new Menu("Sobre");
		MenuItem sobreNois = new MenuItem("Sobre tudo");
		MenuItem sair = new MenuItem("Sair");
		
		
		//Acoes dos botoes
		//cadstrar gerente
		cdGer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				cadastrarFuncionario cf = new cadastrarFuncionario();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear(); //se nao apagar a malha, dá merda.
					cf.cds(malha, 1);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		//cadastrar atendente
		cdAtd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				cadastrarFuncionario cf = new cadastrarFuncionario();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					cf.cds(malha, 2);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//cadastrar personal
		cdPer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				cadastrarFuncionario cp = new cadastrarFuncionario();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					cp.cds(malha, 3);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//consultar cliente
		cnsCliente.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				consultarCliente cc = new consultarCliente();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					cc.consultar(malha);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} );
		//listar clientes
		lsCliente.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				listarClientes lc = new listarClientes();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					lc.lClientes(malha);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} );
		//listar funcionarios
		cnsFunc.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				ListarFuncionarios lf = new ListarFuncionarios();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					lf.lfuncionarios(malha);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} );
		
		//logoff
		sair.setOnAction(new EventHandler<ActionEvent>() { //trata o evento de apertar no botão
			@Override
			public void handle(ActionEvent aperto) {
				Login lgin = new Login();  // volta a tela de login ..É um log-off
				try {
					lgin.start(palco);
				} catch (Exception e) {
					e.printStackTrace();				
				}
				
			}
		});
		//cadastrar cliente
		cdCli.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				cadastroCliente cc = new cadastroCliente();
				try {
					ScrollPane sp = new ScrollPane();
					
					fundoPrincipal.setCenter(sp);
					sp.autosize();
					sp.setContent(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					cc.cCliente(malha);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//consulta bens
		cnsBens.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				consultaBens cb = new consultaBens();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					cb.cnsBens(malha);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} );
		// Consultar atividades
		cnsAtiv.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				consultarAtividade ca = new consultarAtividade();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					ca.lsAtividades(malha);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} );
		
		// cadastrar atividade
		cdAtiv.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				cadastrarAtividade ca = new cadastrarAtividade();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					ca.cadastraAtividade(malha);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		cdCliAtiv.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AssociarCliAtiv aca = new AssociarCliAtiv();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					aca.associar(malha);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		cdBens.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				cadastroBens ca = new cadastroBens();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					ca.cadastraBens(malha);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//alterar senha
		altSenha.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				alterarSenha as = new alterarSenha();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					as.alterar(malha);
							
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} );
		
		//Apagar registro de clientes
		apagarR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				ApagarRegistroC as = new ApagarRegistroC();
				try {
					fundoPrincipal.setCenter(malha);
					malha.getChildren().clear();  //se nao apagar a malha, dá merda.
					as.apagarR(malha);
							
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} );
		
		
				
		//para voltar a tela inicial
		inc.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				malha.getChildren().clear();
				fundoPrincipal.setCenter(iv);
			}
		});
		//sobre
		sobreNois.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent aperto) {
				new Sobre(palco);
			}
		});
		
		
		//Add as coisas a seus devidos lugares
		cadastrar.getItems().addAll(cdFunc, cdCli, cdBens, cdAtiv, cdCliAtiv, inc); // add sub items ao menu
		cdFunc.getItems().addAll(cdGer, cdAtd, cdPer);
		consulta.getItems().addAll(cnsCliente, lsCliente, cnsBens, cnsFunc, cnsAtiv, cnsEst); // add sub items ao menu
		sobre.getItems().addAll(sobreNois, sair); // add sub items ao menu
		
		alterar.getItems().addAll(altSenha, altCliente);
		
		menuzin.getMenus().addAll(cadastrar, consulta, alterar,  sobre); // add menua a barra
		
		
		fundoPrincipal.setTop(menuzin); // seta a barra de menu na borda de cima do BorderPane
		fundoPrincipal.setCenter(iv);
		
		palco.setScene(cena);
		palco.setTitle("GymSystem");
		palco.setResizable(false); // impede que a tela de "sobre" seja maximizada
        palco.sizeToScene();
		palco.show();
		
	}

	public static void main(String[] args) {
		launch();
	}

}
