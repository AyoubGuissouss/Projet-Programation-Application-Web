<%--
  Created by IntelliJ IDEA.
  User: Ayoub
  Date: 2022-12-04
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<fmt:setLocale value="${sessionScope.langue}"/>
<fmt:setBundle basename="ApplicationResource"/>
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
            <input type="hidden" name="src" value="1"/>
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

<table class="table table-light mt-3">
<tr>
    <th>
        <fmt:message key="panier.nom"/>
    </th>
    <th>
        <fmt:message key="panier.quantite"/>
    </th>
    <th>
        <fmt:message key="panier.tatalItem"/>
    </th>
    <th>
        <fmt:message key="panier.modifier2"/>
    </th>
    <th>
        <fmt:message key="panier.supprimer2"/>
    </th>
</tr>
<c:forEach var="item" items="${sessionScope.listPanier}">
    <tr>
        <form action="ServletModifierItem">
        <td>
                ${item.nom}
        </td>
        <td>
            <input type="text" name="${item.nom}" value="${item.quantite}">
        </td>
        <td>
                ${item.totalItem}
        </td>
        <td>
            <button type="submit" class="btn btn-primary"><fmt:message key="panier.modifier"/></button>
            <input type="hidden" name="itemAModifier" value="${item.nom}"/>
        </td>
        </form>
        <td>
            <form action="ServletSupprimerItem">
                <div class="col-2">
                    <button type="submit" class="btn btn-primary"><fmt:message key="panier.supprimer"/></button>
                    <input type="hidden" name="itemASupprimer" value="${item.nom}"/>
                </div>
            </form>
        </td>
    </tr>
</c:forEach>
    <tr class="fw-bold">
        <td colspan="4" style="text-align: right">
            <fmt:message key="panier.total"/>:
        </td>
        <td>
            ${sessionScope.total} $
        </td>
    </tr>
    </table>
    </div>
    </body>
    </html>
