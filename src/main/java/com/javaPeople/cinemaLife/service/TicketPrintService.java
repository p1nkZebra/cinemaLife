package com.javaPeople.cinemaLife.service;

import com.itextpdf.text.DocumentException;
import com.javaPeople.cinemaLife.utils.PdfCreator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TicketPrintService {

    public static void main(String[] args) throws DocumentException, IOException, URISyntaxException, ParserConfigurationException, SAXException {
        printViaPdfWriter();
        printViaITextRenderer();
    }

    public static void printViaPdfWriter() throws IOException, URISyntaxException, DocumentException {

        URL resourcesURL = ClassLoader.getSystemResource("");
        String resourcesPathString = new File(resourcesURL.getFile()).getAbsolutePath();

        Path ticketHtmlPath = Paths.get(resourcesPathString, "html", "Ticket.html");
        String htmlFilePathString = ticketHtmlPath.toAbsolutePath().toString();

        String targetPdfName = "via_pdf_writer.pdf";
        PdfCreator.createViaPdfWriter(resourcesPathString, htmlFilePathString, targetPdfName);
    }

    public static void printViaITextRenderer() throws IOException, URISyntaxException, DocumentException, ParserConfigurationException, SAXException {

        URL resourcesURL = ClassLoader.getSystemResource("");
        String resourcesPathString = new File(resourcesURL.getFile()).getAbsolutePath();

        Path ticketHtmlPath = Paths.get(resourcesPathString, "html", "Ticket.html");
        String htmlFilePathString = ticketHtmlPath.toAbsolutePath().toString();

        String targetPdfName = "via_itext.pdf";
        PdfCreator.createViaIText(resourcesPathString, htmlFilePathString, targetPdfName);
    }



}
