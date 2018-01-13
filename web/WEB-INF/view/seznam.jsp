<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<jsp:useBean id="rostliny"
             type="java.util.List<net.sevecek.zakladniwebapp.Rostlina>"
             scope="request"/>

<html lang="cs">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styly.css">
    <link rel="icon" href="images/favicon.png">
    <title>Seznam rostlin - Moje zahrádka</title>
</head>
<body>
    <div class="page">

        <div class="menu">Menu:
            <a href="/mesice">Měsíce</a> |
            <b>Seznam</b>

        </div>

        <hr/>

        <h1>Moje zahrádka</h1>

        <h4><a href="/uprava-zahradky">Upravit zahrádku</a></h4>

        <ul class="bez_puntiku">
            <jstl:forEach var="rostlina" items="${rostliny}">
                <li>
                    <p><a href="/detail/${rostlina.id}">${rostlina.nazev}</a></p>
                </li>
            </jstl:forEach>
        </ul>

    </div>
</body>
</html>
