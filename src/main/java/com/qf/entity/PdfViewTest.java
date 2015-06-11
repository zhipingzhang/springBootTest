package com.qf.entity;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class PdfViewTest extends AbstractPdfView {
	protected void buildPdfDocument(Map model, Document doc, PdfWriter writer,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		PdfReader pdfReader = new PdfReader("test.pdf");
		PdfReaderContentParser parser = new PdfReaderContentParser(pdfReader);
		StringBuffer buff = new StringBuffer();
		TextExtractionStrategy strategy;

		BaseFont bfChi = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
				BaseFont.NOT_EMBEDDED);
		Font fontChi = new Font(bfChi, 12, Font.NORMAL);
		for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
			strategy = parser.processContent(i,
					new SimpleTextExtractionStrategy());
			buff.append(strategy.getResultantText());
		}
		doc.add(new Paragraph(buff.toString(), fontChi));
		// Person person = (Person) model.get("person");
	}
}