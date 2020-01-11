package com.javaPeople.cinemaLife.utils;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.javaPeople.cinemaLife.utils.PdfCreator;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TicketPrintService {

    private String getResourcesPath(String path) throws URISyntaxException {
        URL resourcesURL = ClassLoader.getSystemResource(path);
        return new File(resourcesURL.toURI()).getAbsolutePath();
    }

    void printTicket(long ticketId) throws IOException, DocumentException, URISyntaxException {
        ITextRenderer renderer = new ITextRenderer();
        String html = readFile("Ticket.html");
        html = setTicketIdToHtml(html,ticketId);
        String setIdHtmlPath = htmlToFile(html);

        File setIdHtmlFile = new File(setIdHtmlPath);
        renderer.setDocument(setIdHtmlFile);

        addFontsFromDirectory (getResourcesPath("fonts") , renderer);
        renderer.layout();

        String outputFileName = "ticket" + ticketId + ".pdf";
        OutputStream os = new FileOutputStream(outputFileName);
        renderer.createPDF(os);

        os.close();

    }

    private void addFontsFromDirectory(String dir, ITextRenderer renderer) throws DocumentException, IOException {

        File f = new File(dir);
        for ( File childFile : f.listFiles() ){

            if (childFile.isDirectory()){
                for (File innerFile: childFile.listFiles())
                { acceptFontFile (innerFile, renderer); }
            }
            else { acceptFontFile(childFile, renderer); }
        }
    }


    private void acceptFontFile(File file, ITextRenderer renderer) throws IOException, DocumentException {
        if (file.getName().endsWith(".ttf")|| file.getName().endsWith(".otf") ) {
            renderer.getFontResolver().addFont(file.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        }
    }


    private String readFile(String path) throws IOException, URISyntaxException {
        byte[] encoded = Files.readAllBytes(Paths.get(getResourcesPath("html"), path));
        return new String(encoded);
    }


    private String setTicketIdToHtml(String html, long ticketId) {
        return html.replace("#",String.valueOf(ticketId));
    }


    private String htmlToFile(String html) throws IOException, URISyntaxException {
        String newPath = Paths.get(getResourcesPath("html"), "setIdTicket.html").toString() ;
        BufferedWriter writer = new BufferedWriter(new FileWriter(newPath));
        writer.write(html);
        writer.close();
        return newPath;
    }

    /** Наташины методы **/

    public static void printViaPdfWriter() throws IOException, URISyntaxException, DocumentException {

        URL resourcesURL = ClassLoader.getSystemResource(".");
        String resourcesPathString = new File(resourcesURL.toURI()).getAbsolutePath();
        System.out.println(resourcesPathString);
//        String configPath = URLDecoder.decode(resourcesPathString1, "UTF-8");

        Path ticketHtmlPath = Paths.get(resourcesPathString, "html", "Ticket.html");
        String htmlFilePathString = ticketHtmlPath.toAbsolutePath().toString();

        String targetPdfName = "via_pdf_writer.pdf";
        PdfCreator.createViaPdfWriter(resourcesPathString, htmlFilePathString, targetPdfName);
    }

    public static void printViaITextRenderer() throws IOException, URISyntaxException, DocumentException, ParserConfigurationException, SAXException {

        URL resourcesURL = ClassLoader.getSystemResource(".");
        String resourcesPathString = new File(resourcesURL.toURI()).getAbsolutePath();

        Path ticketHtmlPath = Paths.get(resourcesPathString, "html", "Ticket.html");
        String htmlFilePathString = ticketHtmlPath.toAbsolutePath().toString();

        String targetPdfName = "via_itext.pdf";
        PdfCreator.createViaIText(resourcesPathString, htmlFilePathString, targetPdfName);
    }



}
