package com.javaPeople.cinemaLife.service;

        import com.itextpdf.text.DocumentException;
        import com.itextpdf.text.pdf.BaseFont;
        import com.javaPeople.cinemaLife.dao.TicketDao;
        import com.javaPeople.cinemaLife.domain.Ticket;
        import org.xhtmlrenderer.pdf.ITextRenderer;

        import java.io.*;
        import java.nio.file.Files;
        import java.nio.file.Paths;

//import com.itextpdf.tool.xml.XMLWorkerFontProvider;
//import com.itextpdf.tool.xml.XMLWorkerHelper;
//import com.itextpdf.text.Document;

public class TicketService {

    public static final String FONT_COMIC ="fonts/Comic Sans/comic.ttf";
    public static final String FONT_ARIAL = "fonts/Arial/arial.ttf";
    public static final String RESOURSES_PATH = "src\\main\\resources\\";

    public void printTicket(long ticketId) throws IOException, DocumentException {

        /**Способ Наташи**/

        String html = readFile("Ticket.html");

        html = setTicketIdToHtml(html,ticketId);
        htmlToFile(html);

        String htmlPath = RESOURSES_PATH + "setIdTicket.html";

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(new File(htmlPath));
        renderer.getFontResolver().addFont(FONT_COMIC, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        renderer.getFontResolver().addFont(FONT_ARIAL, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        renderer.layout();

        String outputFile = RESOURSES_PATH + "Ticket.pdf";
        OutputStream os = new FileOutputStream(outputFile);
        renderer.createPDF(os);
        os.close();

    }

    static String readFile(String path) throws IOException{
        byte[] encoded = Files.readAllBytes(Paths.get(RESOURSES_PATH + path));
        return new String(encoded);
    }

    static String setTicketIdToHtml(String html, long ticketId) {
        return html.replace("#",String.valueOf(ticketId));
    }

    static void htmlToFile(String html) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(RESOURSES_PATH + "setIdTicket.html"));
        writer.write(html);
        writer.close();
    }

    public void save (Ticket ticket) {

        TicketDao dao = new TicketDao();
        dao.save(ticket);
    }

}
