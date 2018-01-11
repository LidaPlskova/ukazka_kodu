<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<jsp:useBean id="rostlina"
             type="net.sevecek.zakladniwebapp.Rostlina"
             scope="request"/>
<jsp:useBean id="nazvyCinnosti"
             type="java.util.List<java.lang.String>"
             scope="request"/>
<jsp:useBean id="mapaCinnosti"
             type="java.util.Map<java.lang.String,java.util.List<java.lang.Integer>>"
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
            <jstl:forEach var="nazev" items="${nazvyCinnosti}">
                <jstl:if test="${mapaCinnosti.get(nazev).size() > 0}">

                    <li>${nazev}:
                        <jstl:forEach var="mesic" items="${mapaCinnosti.get(nazev)}">
                            ${mesice.get(mesic)} |
                        </jstl:forEach>

                    </li>


                </jstl:if>
            </jstl:forEach>
        </ul>


    </div>
</body>
</html>
