package com.javaPeople.cinemaLife.service;

import com.itextpdf.text.DocumentException;
import com.javaPeople.cinemaLife.utils.PdfCreator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TicketPrintService {

    public static void main(String[] args) throws DocumentException, IOException, URISyntaxException, ParserConfigurationException, SAXException {
        printViaPdfWriter();
        printViaITextRenderer();
    }

    public static void printViaPdfWriter() throws IOException, URISyntaxException, DocumentException {

        URI resourcesURI = ClassLoader.getSystemResource("").toURI();
        String resourcesPathString = resourcesURI.toURL().getPath();

        Path ticketHtmlPath = Paths.get(resourcesPathString, "html", "Ticket.html");
        String htmlFilePathString = ticketHtmlPath.toAbsolutePath().toString();

        String targetPdfName = "via_pdf_writer.pdf";
        PdfCreator.createViaPdfWriter(resourcesPathString, htmlFilePathString, targetPdfName);
    }

    public static void printViaITextRenderer() throws IOException, URISyntaxException, DocumentException, ParserConfigurationException, SAXException {

        URI resourcesURI = ClassLoader.getSystemResource("").toURI();
        String resourcesPathString = resourcesURI.toURL().getPath();

        Path ticketHtmlPath = Paths.get(resourcesPathString, "html", "Ticket.html");
        String htmlFilePathString = ticketHtmlPath.toAbsolutePath().toString();

        String targetPdfName = "via_itext.pdf";
        PdfCreator.createViaIText(resourcesPathString, htmlFilePathString, targetPdfName);
    }



}
