package com.javaPeople.cinemaLife.service;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

//import com.itextpdf.tool.xml.XMLWorkerFontProvider;
//import com.itextpdf.tool.xml.XMLWorkerHelper;
//import com.itextpdf.text.Document;

public class TicketService {

    public static final String FONT_COMIC ="fonts/Comic Sans/comic.ttf";
    public static final String FONT_ARIAL = "fonts/Arial/arial.ttf";
    public static final String RESOURSES_PATH = "src\\main\\resources\\";

    public void printTicket(long ticketId) throws IOException, URISyntaxException, DocumentException, SAXException, ParserConfigurationException {

        /**Через PDFwriter**/
//
//        Document document = new Document();
//        // Создаем writer для записи в pdf
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));
//        // Открываем для чтения html страничку
//        document.open();
//        // Парсим её и записываем в PDF
//        XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
//        fontImp.register(FONT_COMIC);
//        fontImp.register(FONT_ARIAL);
//        FontFactory.setFontImp(fontImp);
//        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream("C:\\Users\\Александр\\IdeaProjects\\cinemaLife\\src\\main\\resources\\ticket.html"),null, Charset.forName("UTF-8"),fontImp);
//        FileInputStream is = new FileInputStream("C:\\Users\\Александр\\IdeaProjects\\cinemaLife\\src\\main\\resources\\ticket.html");
//        document.close();
//
//        System.out.println( "Ваш PDF файл - Создан!" );


            /**Способ Наташи**/

        String html = readFile("Ticket.html");
        html = setTicketIdToHtml(html,ticketId);
        htmlToFile(html);

        String htmlPath = RESOURSES_PATH + "fileName.html";

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(new File(htmlPath));
        renderer.getFontResolver().addFont(FONT_COMIC, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        renderer.getFontResolver().addFont(FONT_ARIAL, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

        renderer.layout();

        String outputFile = RESOURSES_PATH + "Ticket.pdf";
        OutputStream os = new FileOutputStream(outputFile);
        renderer.createPDF(os);
        os.close();

//        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//        Document doc = builder.parse(new ByteArrayInputStream(html.getBytes("UTF-8")));
//
////        System.out.println(doc.getXmlEncoding());
//        System.out.println(doc.getDocumentURI());
//        ITextRenderer renderer = new ITextRenderer();
//        renderer.setDocument(doc, null);
//
//        File file = new File("test.pdf");
//        OutputStream os = new FileOutputStream(file);
//
//        renderer.getFontResolver().addFont(FONT_COMIC, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//        renderer.getFontResolver().addFont(FONT_ARIAL, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//        renderer.layout();
//        renderer.createPDF(os);
//
//        os.close();



        /**Приколы с JSOUP**/

//          org.jsoup.nodes.Document doc1 = Jsoup.parse(html);
////          Element setNumberID = doc1.select("h1").first();
////        System.out.println(String.valueOf(ticketId));
////        setNumberID.append("<p1>"+String.valueOf(ticketId)+"</p1>");
////        html = doc1.html();
////        html = html.replace("doctype","DOCTYPE");
////        System.out.println(html);

    }



    static String readFile(String path) throws IOException{
        byte[] encoded = Files.readAllBytes(Paths.get(RESOURSES_PATH + path));
        return new String(encoded);
    }

    static String setTicketIdToHtml(String html, long ticketId) {
        return html.replace("#",String.valueOf(ticketId));
    }

    static void htmlToFile(String html) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(RESOURSES_PATH + "fileName.html"));
        writer.write(html);
        writer.close();
    }
}
