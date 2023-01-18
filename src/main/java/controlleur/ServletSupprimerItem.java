package controlleur;

import dao.ItemMenuDaoImpl;
import entity.ItemMenu;
import entity.ItemPanier;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletSupprimerItem", value = "/ServletSupprimerItem")
public class ServletSupprimerItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        String itemASupprimer = request.getParameter("itemASupprimer");
        List<ItemPanier> listPanier = (List<ItemPanier>) session.getAttribute("listPanier");
        ItemPanier item = null;
        for(ItemPanier tmp : listPanier){
            if(tmp.getNom().equals(itemASupprimer)){
                item = tmp;
            }
        }
        double total = (Double) session.getAttribute( "total");
        total = total - item.getTotalItem();
        total = Math.round(total * 100.0) / 100.0;
        session.setAttribute("total",total);
        listPanier.remove(item);


        RequestDispatcher disp = getServletContext().getRequestDispatcher("/panier.jsp");
        disp.forward(request, response);
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
