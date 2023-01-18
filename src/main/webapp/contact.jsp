<%--
  Created by IntelliJ IDEA.
  User: Ayoub
  Date: 2022-12-01
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<fmt:setLocale value="${sessionScope.langue}" />
<fmt:setBundle basename="ApplicationResource" />
<div class="container">
    <div class="row mt-5">
        <div class="col-2">
            <img src="images/Logo.png" style="width:100% ;">
        </div>
        <div class="col-2">
            <div class="row">
                <h1 class="fw-bold">BenAli</h1>
            </div>
            <div class="row">
                <h2>Restaurant</h2>
            </div>
        </div>
        <div class="col-6"></div>
        <div class="col-2">
            <form action="ServletGestionLangue">
                <select class="form-select mt-5" name="langue" onchange="submit()">
                    <option>Langue</option>
                    <option value="fr_CA">fr</option>
                    <option value="en_US">en</option>
                </select>
                <input type="hidden" name="src" value="1" />
            </form>
        </div>
    </div>
    <div class="row bg-dark my-1">
        <ul class="nav nav-pills nav-fill">
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="index.jsp"><fmt:message key="menu.acceuil"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ServletCreationList"><fmt:message key="menu.menu"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="contact.jsp"><fmt:message key="menu.contact"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="panier.jsp"><fmt:message key="menu.panier"/></a>
            </li>
        </ul>
    </div>
    <div class="row mt-5">
        <div class="col-1"></div>
        <div class="col-4 fw-bold"  style="background:rgba(299,299,299); border-radius: 15px;">
            <div class="container">
                <div class="row mt-3">
                    <h2>BenAli Restaurant Info</h2>
                </div>
                <div class="row mt-5">
                    <div class="col-3">
                        <span class="badge"><img src="images/IconEmplacement.jpg" alt="" style="height: 50px;"></span>
                    </div>
                    <div class="col-8">
                        <p> 10555 Ave de Bois-de-Boulogne, Montreal, Quebec H4N 1L4</p>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-3">
                        <span class="badge"><img src="images/IconTelephone.png" alt="" style="height: 50px;"></span>
                    </div>
                    <div class="col-8">
                        <p> 514-000-0000</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-2"></div>
        <div class="col-4 background"  style="background:rgba(299,299,299); border-radius: 15px;">
            <table class="table">
                <tr>
                    <th colspan="2">
                        <h2><fmt:message key="contact.titre"/></h2>
                    </th>
                </tr>
                <tr>
                    <td><fmt:message key="contact.lundi"/></td>
                    <td>11:00 - 22:00</td>
                </tr>
                <tr>
                    <td><fmt:message key="contact.mardi"/></td>
                    <td>11:00 - 22:00</td>
                </tr>
                <tr>
                    <td><fmt:message key="contact.mercredi"/></td>
                    <td>11:00 - 22:00</td>
                </tr>
                <tr>
                    <td><fmt:message key="contact.jeudi"/></td>
                    <td>11:00 - 22:00</td>
                </tr>
                <tr>
                    <td><fmt:message key="contact.vendredi"/></td>
                    <td>11:00 - 23:00</td>
                </tr>
                <tr>
                    <td><fmt:message key="contact.samedi"/></td>
                    <td>11:00 - 23:00</td>
                </tr>
                <tr>
                    <td><fmt:message key="contact.dimanche"/></td>
                    <td>11:00 - 22:00</td>
                </tr>
            </table>
        </div>
        <div class="col-1"></div>
    </div>
</div>
</body>
</html>
