package br.edu.theproject.doc;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
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
			
			
			doc = new Document(PageSize.A4, 72, 72, 72, 72); // definiÁ„o das margens e do tam da folha
			os = new FileOutputStream("out.pdf"); // nome do arquivo salvo, destino
			PdfWriter.getInstance(doc, os); // getInstance est· assoiando o documento ao stream de saÌda
			doc.open(); // abre o objeto documento
			
			Font fg = new Font(FontFamily.TIMES_ROMAN, 25);
			Font fs = new Font(FontFamily.TIMES_ROMAN, 14);
			Font t2 = new Font(FontFamily.TIMES_ROMAN, 18);
			Font dcl = new Font(FontFamily.TIMES_ROMAN, 13);
			Font dcl2 = new Font(FontFamily.TIMES_ROMAN, 13, Font.BOLD);
			
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
			
			Paragraph declaracao = new Paragraph("Afirmamos, para os fins que se fizerem necess√°rios, que o cliente " + nome + ", est√° devidamente"
					+ " matriculado nesta institui√ß√£o, sob o ID n√∫mero: " + id + ".", dcl);
			
			declaracao.setSpacingAfter(300);
			declaracao.setAlignment(Element.ALIGN_JUSTIFIED);
			declaracao.setAlignment(Element.ALIGN_CENTER);
			doc.add(declaracao);
			
			Paragraph rodape = new Paragraph("GymSystem, " + data, dcl);
			rodape.setAlignment(Element.ALIGN_CENTER);
			doc.add(rodape);
			
		} finally {
			if(doc != null) {
				doc.close();
			}if(os != null) {
				os.close();
			}
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirma√ß√£o");
			alert.setHeaderText("Comprovante de matricula gerado com sucesso!");
			alert.showAndWait();
		}
	}

}
