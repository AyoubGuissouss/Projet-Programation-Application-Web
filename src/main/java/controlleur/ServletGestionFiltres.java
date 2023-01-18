package controlleur;

import dao.ItemMenuDaoImpl;
import entity.ItemMenu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import util.StringVideException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletGestionFiltres", value = "/ServletGestionFiltres")
public class ServletGestionFiltres extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ItemMenu> listMenu = new ArrayList<>();
        ItemMenu item = null;
        ItemMenuDaoImpl itemMenuDao = new ItemMenuDaoImpl();
        boolean filtreNom = request.getParameter("filtreNom") != null;
        boolean filtrePrix = request.getParameter("filtrePrix") != null;
        boolean filtreCategorie = request.getParameter("filtreCategorie") != null;

        if(filtreNom){
            String nom = request.getParameter("nomCherche");
            item = itemMenuDao.findByNom(nom);
            listMenu.add(item);
        }else if(filtrePrix){
            int choixPrix = Integer.parseInt(request.getParameter("choixPrix"));
            listMenu = itemMenuDao.findByPrice(choixPrix);
        }else if(filtreCategorie){
            int choixCategorie = Integer.parseInt(request.getParameter("choixCategorie"));
            String choix = null;
            if(choixCategorie == 1){
                choix = "Entree";
            }else if(choixCategorie == 2){
                choix = "PlatPrincipal";
            }else if(choixCategorie == 3){
                choix = "Dessert";
            }
            listMenu = itemMenuDao.findByCategorie(choix);
        }else{
            listMenu = itemMenuDao.getAllItemMenu();
        }


        request.setAttribute("listMenu", listMenu);

        RequestDispatcher disp = getServletContext().getRequestDispatcher("/menu.jsp");
        disp.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
