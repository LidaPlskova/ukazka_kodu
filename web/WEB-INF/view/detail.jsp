<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<jsp:useBean id="rostlina"
             type="net.sevecek.zakladniwebapp.Rostlina"
             scope="request"/>
<jsp:useBean id="mesice"
             type="java.util.List<java.lang.String>"
             scope="request"/>

<html lang="cs">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--<link rel="stylesheet" href="css/styly.css">-->
    <link rel="icon" href="images/favicon.png">
    <title>Seznam rostlin - Moje zahrádka</title>
</head>
<body>
    <div class="page">

        <div class="menu">Menu:
            <a href="/mesice">Měsíce</a> |
            <a href="/seznam">Seznam</a>
        </div>

        <hr/>

        <h1>${rostlina.nazev}</h1>

        <p>${rostlina.popis}</p>

        <ul>
            <jstl:forEach var="nazev" items="${rostlina.mesicePodleCinnosti.keySet()}">
                <li>${nazev}:
                    <jstl:forEach var="mesic" items="${rostlina.mesicePodleCinnosti.get(nazev)}">
                        ${mesice.get(mesic)} |
                    </jstl:forEach>

                </li>
            </jstl:forEach>
        </ul>


    </div>
</body>
</html>
