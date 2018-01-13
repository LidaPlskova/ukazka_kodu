<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<jsp:useBean id="mesice"
             type="java.util.List<java.lang.String>"
             scope="request"/>

<jsp:useBean id="rostliny"
             type="java.util.List<net.sevecek.zakladniwebapp.Rostlina>"
             scope="request"/>

<html lang="cs">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styly.css">
    <link rel="icon" href="images/favicon.png">
    <title>Činnosti v měsících - Moje zahrádka</title>
</head>
<body>
    <div class="page">


        <div class="menu">Menu:
            <b>Měsíce</b> |
            <a href="/seznam">Seznam</a>
        </div>
        <hr/>

        <h1>Měsíce</h1>

        <jstl:forEach begin="1" end="12" var="cisloMesice">
            <div>
                <h2>${mesice.get(cisloMesice)}</h2>

                <jstl:forEach items="${rostliny}" var="rostlina">


                    <jstl:if test="${rostlina.cinnostiPodleMesicu.get(cisloMesice).size() > 0}">

                        <h5><a href="/detail/${rostlina.id}">${rostlina.nazev}</a></h5>


                        <p> <ul>
                            <jstl:forEach
                                    items="${rostlina.cinnostiPodleMesicu.get(cisloMesice)}"
                                    var="cinnost">

                                <li>${cinnost}</li>

                            </jstl:forEach>


                        </ul>  </p>


                    </jstl:if>
                </jstl:forEach>


            </div>
        </jstl:forEach>

    </div>
</body>
</html>
