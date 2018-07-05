package org.tact.base.util;

import java.io.ByteArrayOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFUtil {

	public static byte[] getSamplePDFContent() throws DocumentException{
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		Document document = new Document(PageSize.LETTER, 0.75F, 0.75F, 0.75F, 0.75F);
		PdfWriter.getInstance(document, byteArrayOutputStream);
		
        document.open();
        document.add(new Paragraph("Basic PDF Page"));
        document.close();		
        
        byte[] contents = byteArrayOutputStream.toByteArray();
        
        return contents;
	}
}
