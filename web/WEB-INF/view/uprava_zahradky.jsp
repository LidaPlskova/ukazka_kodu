<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>

<jsp:useBean id="seznamIdMychRostlin"
             type="java.util.List<java.lang.Integer>"
             scope="request"/>


<jsp:useBean id="vsechnyRostliny"
             type="java.util.List<net.sevecek.zakladniwebapp.Rostlina>"
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

        <h1>Upravit zahrádku</h1>

        <p>Tohle je malý pomocník pro každého, kdo má zahrádku a chce mít přehled, kdy se věnovat konkrétní rostlince.</p>

        <h3>Založ vlastní zahrádku a vyber si rostliny, které pěstuješ.</h3>

        <form method="post">
            <ul>
                <jstl:forEach items="${vsechnyRostliny}" var="rostlina">
                    <li>
                        <input type="checkbox"
                               name="rostliny"
                               value="${rostlina.id}"
                            ${seznamIdMychRostlin.contains(rostlina.id) ? 'checked="checked"' : ''}
                        /> ${rostlina.nazev}

                    </li>

                </jstl:forEach>
            </ul>

            <button>Uložit</button>
        </form>
    </div>
</body>
</html>
