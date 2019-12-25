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


    public static final String RESOURSES_PATH = "src\\main\\resources\\";

    public void printTicket(long ticketId) throws IOException, DocumentException {

        /**Способ Наташи**/

        String html = readFile("Ticket.html");

        html = setTicketIdToHtml(html,ticketId);
        htmlToFile(html);

        String htmlPath = RESOURSES_PATH + "setIdTicket.html";

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(new File(htmlPath));
        addFontsFromDirectory (renderer, RESOURSES_PATH + "fonts\\" );
        renderer.layout();

        String outputFile = RESOURSES_PATH + "Ticket.pdf";
        OutputStream os = new FileOutputStream(outputFile);
        renderer.createPDF(os);
        os.close();

    }

    private void addFontsFromDirectory(ITextRenderer renderer, String dir) throws DocumentException, IOException {

            File f = new File(dir);
            for (int i=0; i<f.list().length; i++){

                File childFile = f.listFiles()[i]; /** Берем каждый файл или подпапку в папке fonts **/

                if (childFile.isDirectory()){
                    for (int j=0;j<childFile.list().length;j++)  /** Проходим по все файлы в подпапке **/
                    {

                        String innerFileName = childFile.listFiles()[j].getName(); /** имя файлов в подпапке childFile **/

                        if (innerFileName.endsWith(".ttf")|| innerFileName.endsWith(".otf") ) /**если это файл шрифта .ttf или .otg **/
                        {
                            File innerFile = childFile.listFiles()[j];
                            renderer.getFontResolver().addFont(innerFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                            System.out.println(innerFile.getName());
                        }

                    }
                }
                else /** если же childFile - это файл **/ {
                    if (childFile.getName().endsWith(".ttf")|| childFile.getName().endsWith(".otf")) {
                        renderer.getFontResolver().addFont(childFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                        System.out.println(f.list()[i]);
                    }
                }
            }

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
