import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.text.LayoutQueue;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Check_in extends Application{
	public static void main(String[] args) {
		launch();
	}
	
	public void start(Stage telaCheckin)throws Exception{
		VBox layoutPrincipal = new VBox();
		layoutPrincipal.setPadding(new Insets(10,15,10,15));
		
		BorderPane layoutNome = new BorderPane();
		Label labelNome = new Label("Nome:");
		labelNome.setPadding(new Insets(0,0,8,0));
		TextField textNome = new TextField();
		textNome.setMaxWidth(500);	
		layoutNome.setTop(labelNome);
		layoutNome.setBottom(textNome);
		
		BorderPane layoutEnd = new BorderPane();
		Label labelEnd = new Label("Endereço:");
		labelEnd.setPadding(new Insets(8,0,8,0));
		TextField textEnd = new TextField();
		textEnd.setMaxWidth(500);		
		layoutEnd.setTop(labelEnd);
		layoutEnd.setBottom(textEnd);
		
		BorderPane layoutCpf = new BorderPane();
		Label labelCpf = new Label("CPF:");
		labelCpf.setPadding(new Insets(8,0,8,0));
		TextField textCpf = new TextField();
		textCpf.setMaxWidth(500);		
		layoutCpf.setTop(labelCpf);
		layoutCpf.setBottom(textCpf);
		
		BorderPane layoutRg = new BorderPane();
		Label labelRg = new Label("RG:");
		labelRg.setPadding(new Insets(8,0,8,0));
		TextField textRg = new TextField();
		textRg.setMaxWidth(500);		
		layoutRg.setTop(labelRg);
		layoutRg.setBottom(textRg);
		
		BorderPane layoutIdade = new BorderPane();
		Label labelIdade = new Label("Idade:");
		labelIdade.setPadding(new Insets(8,0,8,0));
		TextField textIdade = new TextField();
		textIdade.setMaxWidth(500);		
		layoutIdade.setTop(labelIdade);
		layoutIdade.setBottom(textIdade);
		
		BorderPane layoutSexo = new BorderPane();
		Label labelSexo = new Label("Sexo:");
		labelSexo.setPadding(new Insets(8,0,8,0));
		layoutSexo.setLeft(labelSexo);
		
		HBox layoutSexo2 = new HBox(25);
		layoutSexo2.setPadding(new Insets(0,0,8,0));
		RadioButton buttonMasc = new RadioButton("M");
		RadioButton buttonFem = new RadioButton("F");
		layoutSexo2.getChildren().addAll(buttonFem, buttonMasc);
		
		BorderPane layoutQuarto = new BorderPane();
		Label labelQuarto = new Label("Quarto:");
		labelQuarto.setPadding(new Insets(8,0,8,0));
		TextField textQuarto = new TextField();
		textQuarto.setMaxWidth(40);		
		layoutQuarto.setTop(labelQuarto);
		layoutQuarto.setBottom(textQuarto);
		
		HBox layoutCheck = new HBox(20);
		layoutCheck.setPadding(new Insets(20,0,8,0));
		CheckBox in = new CheckBox("Check in");
		CheckBox out = new CheckBox("Check out");	
		layoutCheck.getChildren().addAll(in, out);
		
		HBox layoutBotoes = new HBox(20);
		layoutBotoes.setPadding(new Insets(20,0,8,0));
		Button save = new Button("Salvar");
        Button buscar = new Button("Buscar");
		Button remover = new Button("Remover");	
		save.setPrefWidth(80);
        buscar.setPrefWidth(80);
		remover.setPrefWidth(80);
		layoutBotoes.getChildren().addAll(save, buscar, remover);
		
		layoutPrincipal.getChildren().addAll(layoutNome, layoutEnd, layoutCpf, layoutRg, layoutIdade, layoutSexo, layoutSexo2, layoutQuarto, layoutCheck, layoutBotoes);
		
		EventHandler<ActionEvent> eventoAdicionar = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				adicionar(textNome, textEnd, textCpf, textRg, textIdade, textQuarto);
			}
		};

		EventHandler<ActionEvent> eventoAtualizar = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				atualizar(textNome, textEnd, textCpf, textRg, textIdade, textQuarto);
			}
		};

		EventHandler<ActionEvent> eventoRemover = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent evento) {
				remover(textNome, textEnd, textCpf, textRg, textIdade, textQuarto);
			}
		};

		save.setOnAction(eventoAdicionar);
		buscar.setOnAction(eventoAtualizar);
		remover.setOnAction(eventoRemover);

		Scene cena = new Scene(layoutPrincipal, 400, 520);
		telaCheckin.setScene(cena);
		telaCheckin.setTitle("Cadastro");
		telaCheckin.show();

	}
	
	static HashMap<String, Quarto> mapaClientes = new HashMap<String, Quarto>();
	static ArrayList<Hospede> arrayHospedes = new ArrayList<Hospede>();
	static ArrayList<Quarto> arrayQuarto = new ArrayList<Quarto>();

	public static void adicionar(TextField nome, TextField end, TextField cpf, TextField rg, TextField idade, TextField q){
		String endereco = end.getText();
		String c = cpf.getText();
		String r = rg.getText();
		String i = idade.getText();
		String numQUarto = q.getText();
		String n = nome.getText();
		
	    Hospede hospede = new Hospede(c, r, n, i, endereco);	
		arrayHospedes.add(hospede);
		Quarto quarto = new Quarto(q.getText(), hospede);
		arrayQuarto.add(quarto);
		JOptionPane.showMessageDialog(null, "Hóspede cadastrado com sucesso!");
		mapaClientes.put(c, quarto);		
	}

	public static void atualizar(TextField nome, TextField end, TextField cpf, TextField rg, TextField idade, TextField q){
		Quarto quartoMapa = mapaClientes.get(cpf.getText());
		if(quartoMapa==null){
			JOptionPane.showMessageDialog(null, "Não há nenhum hóspede com este CPF!");
		}else{
			nome.setText(quartoMapa.getHospede().getNome()); 
			end.setText(quartoMapa.getHospede().getEndereco());
			rg.setText(quartoMapa.getHospede().getRG());
			idade.setText(quartoMapa.getHospede().getIdade());
			q.setText(quartoMapa.getNumero());
		} 
	}

	public static void remover(TextField nome, TextField end, TextField cpf, TextField rg, TextField idade, TextField q){
		Quarto quartoMapa = mapaClientes.get(cpf.getText());
		if (quartoMapa==null){
			JOptionPane.showMessageDialog(null, "Não há nenhum hóspede com este CPF!");
		}else {
			JOptionPane.showMessageDialog(null, "Gostaria de remover o hóspede "+quartoMapa.getHospede().getNome()+"?");
			arrayQuarto.remove(quartoMapa);
			mapaClientes.remove(cpf.getText(), quartoMapa);			
		}
	}	
}

