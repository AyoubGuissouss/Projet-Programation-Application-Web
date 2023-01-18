<%--
  Created by IntelliJ IDEA.
  User: Ayoub
  Date: 2022-11-19
  Time: 18:23
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
    <script src="gestionFiltre.js"></script>
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
    <div class="row">
        <div class="accordion" id="accordionExample">
            <div class="accordion-item">
                <h2 class="accordion-header" id="flush-headingOne">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                            data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                        <fmt:message key="filtre.titre"/>
                    </button>
                </h2>
                <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne"
                     data-bs-parent="#accordionFlushExample">
                    <div class="accordion-body">
                        <form name="formFiltres" action="ServletGestionFiltres">
                            <div class="container" id="divForm">
                                <div class="row mt-3">
                                    <div class="col-1">
                                        <input type="checkbox" name="filtreNom" id="filtreNom"
                                               onclick="enable_FiltreNom(this.checked)"/>
                                    </div>
                                    <div class="col-2">
                                        <label><fmt:message key="filtre.nom"/></label>
                                    </div>
                                    <div class="col-9">
                                        <input type="text" name="nomCherche" id="nomCherche" value="" disabled/>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-1">
                                        <input type="checkbox" name="filtrePrix" id="filtrePrix"
                                               onclick="enable_FiltrePrix(this.checked)"/>
                                    </div>
                                    <div class="col-2">
                                        <label><fmt:message key="filtre.prix"/></label>
                                    </div>
                                    <div class="col-9">
                                        <input type="radio" name="choixPrix" id="choixPrix1" value="1" disabled>
                                        <fmt:message key="filtre.prix.1"/>
                                        <input type="radio" name="choixPrix" id="choixPrix2" value="2" class="ms-3"
                                               disabled> <fmt:message key="filtre.prix.2"/>
                                        <input type="radio" name="choixPrix" id="choixPrix3" value="3" class="ms-3"
                                               disabled> <fmt:message key="filtre.prix.3"/>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-1">
                                        <input type="checkbox" name="filtreCategorie" id="filtreCategorie"
                                               onclick="enable_FiltreCategorie(this.checked)"/>
                                    </div>
                                    <div class="col-2">
                                        <label><fmt:message key="filtre.categorie"/></label>
                                    </div>
                                    <div class="col-9">
                                        <input type="radio" name="choixCategorie" id="choixCategorie1" value="1"
                                               disabled> <fmt:message key="filtre.categorie.1"/>
                                        <input type="radio" name="choixCategorie" id="choixCategorie2" value="2"
                                               class="ms-3" disabled> <fmt:message key="filtre.categorie.2"/>
                                        <input type="radio" name="choixCategorie" id="choixCategorie3" value="3"
                                               class="ms-3" disabled> <fmt:message key="filtre.categorie.3"/>
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <button type="submit" class="btn btn-primary"><fmt:message
                                            key="filtre.appliquer"/></button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:forEach var="item" items="${requestScope.listMenu}">
    <div class="row my-3">
        <div class="col-3">
            <img src="${item.urlPhoto}" class="img-thumbnail" style="height: 100%" alt="${item.nom}">
        </div>
        <div class="col-6" style="background:rgba(299,299,299)">
            <div class="row">
                <h1>${item.nom}</h1>
            </div>
            <div class="row">
                <p style="margin-bottom: 0px;">${item.description}</p>
            </div>
            <div class="row">
                <p class="fs-1">${item.prix}$</p>
            </div>
            <div class="row">
                <form action="ServletAjoutPanier">
                        <input type="number" min="1" max="100" value="0" class="text-center" name="${item.nom}">

                        <button type="submit" class="btn btn-primary"><fmt:message key="menu.ajouterPanier"/></button>
                </form>
            </div>
        </div>
    </div>
</c:forEach>
</div>
</body>
</html>
