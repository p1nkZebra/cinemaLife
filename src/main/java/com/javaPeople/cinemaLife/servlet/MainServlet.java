package com.javaPeople.cinemaLife.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("CinemaPage.jsp").forward(request,response);
//        String name = request.getParameter("name");
//
//        PrintWriter pw = response.getWriter();
//
//        pw.println("<html>");
//        pw.println("<h1>Greeting for " + name + "</h1>");
//        pw.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        super.doPost(request, response);
    }



}
