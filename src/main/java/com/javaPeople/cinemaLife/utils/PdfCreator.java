package com.javaPeople.cinemaLife.utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PdfCreator {

    public static void createViaPdfWriter(String resourcesFolder,
                                         String htmlFile,
                                         String pdfFileName) throws IOException, DocumentException {

        /**Через PDFwriter**/

        Document document = new Document();
        // Создаем writer для записи в pdf
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
        // Открываем для чтения html страничку
        document.open();
        // Парсим её и записываем в PDF
        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);

        Path arial = Paths.get(resourcesFolder, "fonts", "arial.ttf");
        Path comic = Paths.get(resourcesFolder, "fonts", "comic.ttf");

        String arialFontFile = arial.toAbsolutePath().toString();
        String comicFontFile = comic.toAbsolutePath().toString();

        fontImp.register(arialFontFile);
        fontImp.register(comicFontFile);
        FontFactory.setFontImp(fontImp);

        XMLWorkerHelper.getInstance().parseXHtml(
                writer,
                document,
                new FileInputStream(htmlFile),
                null,
                Charset.forName("UTF-8"),
                fontImp
        );

        FileInputStream is = new FileInputStream(htmlFile);
        document.close();

        System.out.println("Ваш PDF файл - Создан!");
    }


    public static void createViaIText(String resourcesFolder,
                                         String htmlFile,
                                         String pdfFileName) throws IOException, DocumentException, ParserConfigurationException, SAXException {

        Path arial = Paths.get(resourcesFolder, "fonts", "arial.ttf");
        Path comic = Paths.get(resourcesFolder, "fonts", "comic.ttf");

        String arialFontFile = arial.toAbsolutePath().toString();
        String comicFontFile = comic.toAbsolutePath().toString();

        ITextRenderer renderer = new ITextRenderer();

        renderer.getFontResolver().addFont(arialFontFile, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        renderer.getFontResolver().addFont(comicFontFile, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse(new ByteArrayInputStream(Files.readAllBytes(Paths.get(htmlFile))));
        renderer.setDocument(doc, null);

        renderer.layout();

        OutputStream os = new FileOutputStream(pdfFileName);
        renderer.createPDF(os);
        os.close();
    }

}
