package Test;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.PdfWidgetAnnotation;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfTest {


    @Test
    public void testPDF() throws FileNotFoundException {

        String path = "C:\\GeneratePDF\\Sample.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);

        //Create a PDF Document
        PdfDocument pdfDocument =new PdfDocument(pdfWriter);

        Text text = new Text("Hellow I am Text added in PDF by java test class");
        text.setFontColor(Color.RED);
        text.setFontSize(50);
        Paragraph paragraph = new Paragraph(text);
        //Add a new page
        pdfDocument.addNewPage();

        //Create a New Document
        Document document = new Document(pdfDocument);
        document.add(paragraph);
        document.close();
        System.out.println("Pdf creation done");

    }

    @Test(priority = 1, dependsOnMethods = "testPDF")
    public void verifyPdfText() throws IOException {
        URL url= new URL("file:///C:/GeneratePDF/Sample.pdf");
        InputStream is = url.openStream();


        BufferedInputStream testPDF = new BufferedInputStream(is);
        PDDocument pd = null;
        pd= PDDocument.load(testPDF);

        String s = new PDFTextStripper().getText(pd);
        System.out.println(s);

        Assert.assertTrue(s.contains("Hellow I am Text"));



    }
}
