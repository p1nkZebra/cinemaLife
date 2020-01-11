<%--это директивы--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.javaPeople.cinemaLife.servlet.logic.ServletService" %>
<%@ page import="com.javaPeople.cinemaLife.*" %>
<%@ page import="com.javaPeople.cinemaLife.service.MainService" %>
<%@ page import="com.javaPeople.cinemaLife.dto.ShowTimeDto" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.util.List" %>
<%@ page import="com.javaPeople.cinemaLife.domain.Cinema" %>
<%@ page import="com.javaPeople.cinemaLife.service.CinemaService" %>


<html>
<head>
    <style>
        td{
            padding-left: 4px;
            border: 1px solid black;
            height: 28px;
        }
        table {
            width: 40%; /* Ширина таблицы */
            border-collapse: collapse; /* Отображать только одинарные линии */
        }
        .label_tr{
            font-weight:bold;
            font-size: 1.2rem;
        }
        .label_tr td{
        }
    </style>
    <title>Сеансы</title>
</head>


    <%
    //    LocalDate date = LocalDate.now();

        LocalDate date = LocalDate.parse("2019-12-21");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd MMMM yyyy");
        String mainHeader = date.format(formatter);
    %>


<body>
    <h1> <%= "Сеансы" + mainHeader %> </h1>





    <%
        ServletService service = new ServletService();
        List<ShowTimeDto> showTimeDtoList = service.getShowTimeDtoList(date);
        if (showTimeDtoList.isEmpty()) {
            out.println("<br>В этот день нет сеансов");
        }
        else {
    %>

    <table >
        <tr class="label_tr">
            <td>Time</td>
            <td>Film</td>
            <td>Cinema</td>
            <td>Screen</td>
        </tr>

        <%
            for (ShowTimeDto std:showTimeDtoList){
        %>
        <tr>
            <td><%=std.getDateTime().toLocalTime()%></td>
            <td><%=std.getFilmName()%></td>
            <td><%=std.getCinemaName()%></td>
            <td><%=std.getScreenName()%></td>
        </tr>
        <%
            }
        }
        %>

</table>

    <%  String cinemaName = new CinemaService().findCinemaById(1L).getName(); %>
    <br>
    <br>
    <h1> <%= "Сеансы" + mainHeader + " в кинотеатре " + "\""+ cinemaName + "\"" %> </h1>





    <%
        List<ShowTimeDto> showTimeForCinemaList = service.getShowTimeForCinema(date,cinemaName);
        if (showTimeForCinemaList.isEmpty()) {
            out.println("<br>В этот день нет сеансов");
        }
        else {
    %>

    <table >
        <tr class="label_tr">
            <td>Time</td>
            <td>Film</td>
            <td>Screen</td>
        </tr>

        <%
            for (ShowTimeDto std:showTimeForCinemaList){
        %>
        <tr>
            <td><%=std.getDateTime().toLocalTime()%></td>
            <td><%=std.getFilmName()%></td>
            <td><%=std.getScreenName()%></td>
        </tr>
        <%
                }
            }
        %>

    </table>


</body>
</html>
