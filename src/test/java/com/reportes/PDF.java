package com.reportes;


import java.io.FileOutputStream;
import org.openqa.selenium.WebDriver;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tienda.pruebas.Abstract;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;

public class PDF {

	WebDriver webDriver;

	public void GeneraPDF() throws Exception {
		itextPDF();
		System.out.println("se genero PDF");

	}

	public void itextPDF() throws Exception {

		// estoy llamando a la clase que cree donde guardo los datos string
		// ValidandoFooter valFot = new ValidandoFooter();

		// ProbandoMovil sitioMovil = new ProbandoMovil();

		Document documento = new Document();

		/**
		 * Aqui vamos a crear una variable como fuente y luego a esa fuente le vamos a
		 * setear un color y le vamos a dar un tamaño
		 **/
		Font fuente = new Font();
		fuente.setColor(252, 4, 4);
		fuente.setSize(55);

		/**
		 * Aqui es donde guardaremos el PDF y el nombre que tendra.
		 **/
		PdfWriter.getInstance(documento, new FileOutputStream("D:/PDFTIENDA.pdf"));
		documento.open();

		// Image imagen = Image.getInstance("D:/Previred.png");
		// imagen.scalePercent(155,110);
		// documento.add(imagen);


		documento.add(new Paragraph(
				"---------------------------------------------------------------------------------------------------------------------------"));
		/**
		 * Al agregar fuente al final, vamos a decir que lo que escribimos, tendra el
		 * formato que le seteamos a la fuente 'variable fuente', en este caso el color
		 * y tamaño "
		 **/
		documento.add(new Paragraph("                        Resultado Pruebas            ", fuente));
		documento.add(new Paragraph(
				"---------------------------------------------------------------------------------------------------------------------------"));

		Paragraph parrafo1 = new Paragraph("Prueba N° 1");
		Paragraph parrafo2 = new Paragraph("Validar Mensaje de bienvenida");
		parrafo1.setIndentationLeft(195);
		parrafo2.setIndentationLeft(155);
		documento.add(parrafo1);
		documento.add(parrafo2);

		String Resultado = "Resultado Prueba N°J:";


			if (Abstract.currentMensaje.equals(Abstract.ExpectedMensaje)) {
			documento.add(new Paragraph(Resultado.replace('J', '1')
					+ "        La prueba es 'Exitosa', el mensaje de bienvenida es correcto"));
			} else {
			documento.add(new Paragraph(Resultado.replace('J', '1')
					+ "        La prueba 'Fallo', el mensaje de bienvenida no es correcto"));
			}
		documento.add(new Paragraph(
				"---------------------------------------------------------------------------------------------------------------------------"));

		Paragraph parrafo3 = new Paragraph("Prueba N° 2");
		Paragraph parrafo4 = new Paragraph("Validar Titulo Celulares Smartphones");
		parrafo3.setIndentationLeft(195);
		parrafo4.setIndentationLeft(155);
		documento.add(parrafo3);
		documento.add(parrafo4);

		// Abstract.ExpectedMensajeMobile ESTE FALLO
		if (Abstract.CurrentMensajeMobile.equals(Abstract.ExpectedMensajeMobile)) {

			documento.add(new Paragraph(Resultado.replace('J', '2')
					+ "        La prueba es 'Exitosa', el titulo de los celulares es correcto"));

		} else {
			documento.add(new Paragraph(Resultado.replace('J', '2')
					+ "        La prueba 'Fallo', el titulo de los celulares no es correcto"));

		}
		documento.add(new Paragraph(
				"---------------------------------------------------------------------------------------------------------------------------"));

		Paragraph parrafo5 = new Paragraph("Prueba N° 3");
		Paragraph parrafo6 = new Paragraph("Validar Precio Celular Sony");
		parrafo5.setIndentationLeft(195);
		parrafo6.setIndentationLeft(155);
		documento.add(parrafo5);
		documento.add(parrafo6);

		if (Abstract.currentPriceSony.equals(Abstract.expectedPriceSony)) {
			documento.add(new Paragraph(
					Resultado.replace('J', '3') + "        La prueba es 'Exitosa', el precio del celular Sony"));
		} else {
			documento.add(new Paragraph(Resultado.replace('J', '2')
					+ "        La prueba 'Fallo', el precio del celular Sony no es correcto"));
		}
		documento.add(new Paragraph(
				"---------------------------------------------------------------------------------------------------------------------------"));

		Paragraph parrafo7 = new Paragraph("Prueba N° 4");
		Paragraph parrafo8 = new Paragraph("Validar Precio Celular Iphone");
		parrafo7.setIndentationLeft(195);
		parrafo8.setIndentationLeft(155);
		documento.add(parrafo7);
		documento.add(parrafo8);

		documento.add(new Paragraph(
				"---------------------------------------------------------------------------------------------------------------------------"));


		documento.close();

	}

}
