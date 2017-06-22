package br.edu.theproject.doc;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GerarDoc {
	public void gerarComprovanteMatricula(String nome, int id) throws Exception{
		Document doc = null;
		OutputStream os = null;
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String data = sdf.format(new Date(System.currentTimeMillis()));
			
			
			doc = new Document(PageSize.A4, 72, 72, 72, 72); // defini��o das margens e do tam da folha
			os = new FileOutputStream("Comprovante de Matricula - " + nome + ".pdf"); // nome do arquivo salvo, destino
			PdfWriter geradorPDF = PdfWriter.getInstance(doc, os); // getInstance est� assoiando o documento ao stream de sa�da
			doc.open(); // abre o documento
			
			Font fg = new Font(FontFamily.TIMES_ROMAN, 25);
			Font fs = new Font(FontFamily.TIMES_ROMAN, 14);
			Font t2 = new Font(FontFamily.TIMES_ROMAN, 18);
			Font dcl = new Font(FontFamily.TIMES_ROMAN, 15);
			
			Paragraph titulo = new Paragraph("GymSystem", fg);
			titulo.setAlignment(Element.ALIGN_CENTER);
			doc.add(titulo);
			
			Paragraph subtitulo = new Paragraph("Sistema de Academias", fs);
			subtitulo.setAlignment(Element.ALIGN_CENTER);
			subtitulo.setSpacingAfter(20);
			doc.add(subtitulo);
			
			Paragraph titulo2 = new Paragraph("COMPROVANTE DE MATRICULA", t2);
			titulo2.setAlignment(Element.ALIGN_CENTER);
			titulo2.setSpacingAfter(200);
			doc.add(titulo2);
			
			Paragraph declaracao = new Paragraph("Afirmamos, para os fins que se fizerem necessários, que o(a) cliente " + nome + ", está devidamente"
					+ " matriculado nesta instituição, sob a matricula número: " + id + ".", dcl);
			
			declaracao.setSpacingAfter(300);
			declaracao.setAlignment(Element.ALIGN_JUSTIFIED);
			declaracao.setAlignment(Element.ALIGN_CENTER);
			doc.add(declaracao);
			
			Paragraph rodape = new Paragraph("GymSystem, " + data, fs);
			rodape.setAlignment(Element.ALIGN_CENTER);
			doc.add(rodape);
			//define a img de fundo
			PdfContentByte canvas = geradorPDF.getDirectContentUnder();
		    Image logo = Image.getInstance("src/br/edu/theproject/img/gymsystemrem.png"); //define o caminho da img a ser usada
		    logo.scalePercent(100); //ajusta a escala de exibicao da imagem
		    logo.setAbsolutePosition(25, 250); // o quanto pra esquerda, o quanto pra cima
		    canvas.saveState();
		    PdfGState estado = new PdfGState();
		    estado.setFillOpacity(0.05f); // define o grau de transparencia
		    canvas.setGState(estado);
		    canvas.addImage(logo);
		    canvas.restoreState();
			
		} finally {
			if(doc != null) {
				doc.close(); // fecha o documento
			}if(os != null) {
				os.close(); //fecha o sistema de arquivo
			}
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmação");
			alert.setHeaderText("Comprovante de matricula gerado com sucesso!");
			alert.showAndWait();
		}
	}

}
