package com.javaPeople.cinemaLife.utils;

import com.itextpdf.text.DocumentException;
import com.javaPeople.cinemaLife.service.TicketService;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceGetter {

    public static void main(String[] args) throws URISyntaxException, SAXException, ParserConfigurationException, DocumentException, IOException {


        System.out.println("Resource: " + TicketService.class.getResource(""));
        System.out.println("Resource . : " + TicketService.class.getResource(""));
        System.out.println("ResourceAsStream: " + TicketService.class.getResourceAsStream("") + "\n");



        ClassLoader classLoader = TicketService.class.getClassLoader();
        System.out.println("ClassLoader: " + classLoader + "\n");
        System.out.println("ClassLoader.resource: " + classLoader.getResource(""));
        System.out.println("ClassLoader.resources: " + classLoader.getResources("") + "\n");



        ClassLoader parent = classLoader.getParent();
        System.out.println("Parent ClassLoader.resource: " + parent.getResource(""));


        System.out.println(ClassLoader.getSystemResource("") + "\n");


        System.out.println(URLClassLoader.getSystemResource("") + "\n");


        String current = new File( "" ).getCanonicalPath();
        System.out.println("Current dir:"+current);
        String currentDir = System.getProperty("user.dir");
        System.out.println("Current dir using System:" + currentDir + "\n");


        System.out.println("Working Directory = " + System.getProperty("user.dir") + "\n");


        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s);

        Path resourceDirectory = Paths.get(classLoader.getResource("").toString());


        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        System.out.println("===Current relative path is: " + resourceDirectory);
        System.out.println("===Current relative path is: " + Files.exists(resourceDirectory) + "\n\n");



        Path currentRelativePath2 = Paths.get("resources\\fonts");
        Path currentRelativePath3 = Paths.get("resources" + File.separator + "fonts" + File.separator + "arial.ttf");
        String s2 = currentRelativePath2.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + s2);
        System.out.println("Current relative path is: " + currentRelativePath3);
        System.out.println("Current relative path is: " + Files.exists(currentRelativePath3));
        System.out.println("Current relative path is: " + Files.exists(currentRelativePath));


        System.out.println();
        Path path1 = Paths.get("");
        System.out.println("path: " + Paths.get("").toAbsolutePath());
        System.out.println("EXISTS: " + Files.exists(path1));

        System.out.println();
        URI resURI = ClassLoader.getSystemResource("").toURI();
        Path path2 = Paths.get(resURI) ;
        System.out.println("path: " + Paths.get(resURI).toAbsolutePath());
        System.out.println("EXISTS: " + Files.exists(path2));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(resURI);
        System.out.println(resURI.toURL());
        System.out.println(resURI.toURL().getPath());
        System.out.println(resURI.toURL().getPath());
        Path path3 = Paths.get(resURI.toURL().getPath(), "fonts") ;
        System.out.println("path: " + path3.toAbsolutePath());
        System.out.println("EXISTS: " + Files.exists(path3));

        File[] files = new File(resURI).listFiles();


        Path path4 = Paths.get(resURI.toURL().getPath(), "fonts", "arial.ttf") ;
        System.out.println("path: " + path4.toAbsolutePath());
        System.out.println("EXISTS: " + Files.exists(path4));

    }

}
