<%--это директивы--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.javaPeople.cinemaLife.servlet.logic.ServletService" %>



<html>
<head>
    <title>Test title</title>
</head>

<%
    Date today = new Date();
    String mainHeader = "Today is " + today;
%>


<body>
<h1> <%= mainHeader %> </h1>



<p> <% out.println("test string for out.println()"); %> </p>



<p>
    <%
        for (int i = 0; i < 4; i++) {
            out.println("<p>" + "print paragraph tag in cycle for " + i + "</p>");
        }
    %>
</p>



<p>
    <%
        ServletService service = new ServletService();

    %>


    <%=service.getGreeting()%>
</p>


<p>
    <%
        String name = request.getParameter("name");

    %>


    <%=service.getGreeting(name)%>
</p>

</body>
</html>
