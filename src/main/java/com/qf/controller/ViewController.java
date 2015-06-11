package com.qf.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.qf.entity.Person;

@Controller
public class ViewController {

	@Autowired
	private HttpServletRequest request;

	@RequestMapping("/view")
	public Person getPerson(Model model) {
		Person person = new Person();
		person.setId(1);
		person.setName("test");
		model.addAttribute("person", person);
		return person;
	}

	@RequestMapping("/pdf")
	public ResponseEntity<byte[]> download() throws IOException {
		String path = request.getServletContext().getRealPath("/") + "test.pdf";
		// File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		String fileName = new String("test.pdf".getBytes("UTF-8"), "iso-8859-1");// 为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(File2byte(path), headers,
				HttpStatus.CREATED);
	}

	public static byte[] File2byte(String filePath) {
		byte[] buffer = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			buffer = bos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}

}
