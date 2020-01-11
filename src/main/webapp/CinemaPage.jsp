<%--это директивы--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.javaPeople.cinemaLife.servlet.logic.ServletService" %>
<%@ page import="com.javaPeople.cinemaLife.*" %>
<%@ page import="com.javaPeople.cinemaLife.service.MainService" %>
<%@ page import="com.javaPeople.cinemaLife.dto.ShowTimeDto" %>


<html>
<head>
    <title>Сеансы 20 декабря</title>
</head>

<%--<%--%>
<%--    Date today = new Date();--%>
<%--    String mainHeader = "Today is " + today;--%>
<%--%>--%>

<%
    String mainHeader = "Сеансы 20 декабря";
%>


<body>
<h1> <%= mainHeader %> </h1>



<p>
    <%
        ServletService service = new ServletService();
        service.getShowTimeDtoList();
    %>


    <% for (ShowTimeDto std:service.getShowTimeDtoList()){
        out.println(std.getDateTime().toLocalTime() + " - film: " + std.getFilmName() + " - screen: " + std.getScreenName());
        out.println("<br>");
    } %>
</p>




</body>
</html>
