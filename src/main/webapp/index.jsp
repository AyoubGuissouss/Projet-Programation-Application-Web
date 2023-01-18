<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
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
    <div class="col-5 text-black fw-bold" style="background:rgba(299,299,299); border-radius: 15px;">
        <h1>Le meilleur repas à Montréal!</h1>
        <p>
            Du cœur de Montréal, nous vous offrons les plats les plus authentique avec des recettes
            soigneusement préparées. Nous utilisons les meilleures viandes d’origine responsable et des ingrédients
            frais pour vous servir un délice à chaque bouchée !
            Nous offrons une variété de choix pour satisfaire tous les goûts.
            Découvrez nos plats et recherchez les saveurs étonnantes que cache chacun d'entre eux.
        </p>
        <p>
            Tout simplement DÉLICIEUX COMME AUCUN AUTRE.
        </p>
    </div>
        <div class="col-1"></div>
    <div id="carouselExampleSlidesOnly" class="carousel slide col-4" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="images/BahnMi.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="images/Calamars.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="images/BatonnetsFromage.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="images/Mergez.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="images/Nicoise.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="images/SandwichViande.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="images/FondantChocolat.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="images/GateauFromage.jpg" class="d-block w-100" alt="...">
            </div>
        </div>
    </div>
        <div class="col-1"></div>
    </div>
</div>
</body>
</html>