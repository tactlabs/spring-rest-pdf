package org.tact.base.rest;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.util.PDFUtil;

import com.itextpdf.text.DocumentException;

@RestController
@RequestMapping(value = "/base")
public class BaseController {
	
	/**
	 * 
	 * @return
	 * 
	 * Possible urls:
	 * 		http://localhost:1878/base/
	 */
    @GetMapping(value = "")
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    /**
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @throws DocumentException
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/pdf
     */
    @GetMapping(value = "/pdf", produces = "application/pdf")
	public ResponseEntity<byte[]> testPDF1(
			HttpServletRequest request,
			HttpServletResponse response) throws IOException, DocumentException {
		
		byte[] contents = PDFUtil.getSamplePDFContent();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    String filename = "output.pdf";
	    headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    
	    ResponseEntity<byte[]> pdfResponse = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
	    
	    return pdfResponse;
	}
}
