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
    <link rel="stylesheet" href="/css/styly.css">
    <title>Seznam rostlin - Moje zahrádka</title>
</head>

<body>
    <div class="page">

        <div class="menu">Menu:
            <a href="/mesice">Měsíce</a> |
            <a href="/seznam">Seznam</a>
        </div>

        <hr/>

        <h2> ${rostlina.nazev} </h2>


         <p> ${rostlina.popis} </p>

        <ul class="detail">
            <h5><jstl:forEach var="nazev" items="${rostlina.mesicePodleCinnosti.keySet()}">
                <li>  ${nazev}:
                    <ul class ="mesice">
                        <jstl:forEach var="mesic" items="${rostlina.mesicePodleCinnosti.get(nazev)}">
                            &nbsp; ${mesice.get(mesic)} </li>
                        </jstl:forEach>
                    </ul>

                </li>
            </jstl:forEach></h5>
        </ul>

    </div>

</body>

</html>
