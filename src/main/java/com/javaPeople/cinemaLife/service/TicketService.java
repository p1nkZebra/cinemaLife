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

    ITextRenderer renderer = new ITextRenderer();
    /** Наверно криво так делать, Да?? )) **/

    public static final String RESOURSES_PATH = "src\\main\\resources\\";

    public void printTicket(long ticketId) throws IOException, DocumentException {

        /**Способ Наташи**/

        String html = readFile("Ticket.html");

        html = setTicketIdToHtml(html,ticketId); /** Вставляем номер билета**/
        String setIdHtmlPath = htmlToFile(html); /** setIdHtmlPath - путь к новому Html**/
        System.out.println(readFile("setIdTicket.html"));
        File setIdHtmlFile = new File(setIdHtmlPath);

        renderer.setDocument(setIdHtmlFile);
        addFontsFromDirectory (RESOURSES_PATH + "fonts\\" );
        renderer.layout();

        String outputFile = RESOURSES_PATH + "Ticket "+String.valueOf(ticketId)+".pdf";
        OutputStream os = new FileOutputStream(outputFile);
        renderer.createPDF(os);
        setIdHtmlFile.delete();
        os.close();

    }

    private void addFontsFromDirectory(String dir) throws DocumentException, IOException {

            File f = new File(dir);
            for (int i=0; i<f.list().length; i++){

                File childFile = f.listFiles()[i]; /** Берем каждый файл или подпапку в папке fonts **/

                if (childFile.isDirectory()){
                    for (int j=0;j<childFile.list().length;j++)  /** Проходим  все файлы в подпапке **/
                    { acceptFontFile (childFile.listFiles()[j]); }
                }

                else /** если же childFile - это файл **/ {
                    acceptFontFile(childFile);
                }
            }


    }

    private void acceptFontFile(File file) throws IOException, DocumentException {
        if (file.getName().endsWith(".ttf")|| file.getName().endsWith(".otf") ) /**если это файл шрифта .ttf или .otg **/
        {
            renderer.getFontResolver().addFont(file.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            System.out.println(file.getName());
        }
    }


    static String readFile(String path) throws IOException{
        byte[] encoded = Files.readAllBytes(Paths.get(RESOURSES_PATH + path));
        return new String(encoded);
    }

    static String setTicketIdToHtml(String html, long ticketId) {
        return html.replace("#",String.valueOf(ticketId));
    }

    static String htmlToFile(String html) throws IOException {
        String newPath = RESOURSES_PATH + "setIdTicket.html";
        BufferedWriter writer = new BufferedWriter(new FileWriter(newPath));
        writer.write(html);
        writer.close();
        return newPath;
    }

    public void save (Ticket ticket) {
        TicketDao dao = new TicketDao();
        dao.save(ticket);
    }

}
