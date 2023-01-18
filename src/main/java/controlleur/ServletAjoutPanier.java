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

@WebServlet(name = "ServletAjoutPanier", value = "/ServletAjoutPanier")
public class ServletAjoutPanier extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ItemMenuDaoImpl itemMenuDao = new ItemMenuDaoImpl();
        List<ItemPanier> listPanier = (List<ItemPanier>) session.getAttribute("listPanier");
        double total = 0;
        List<ItemMenu> listItemsMenu = itemMenuDao.getAllItemMenu();
        if (listPanier != null) {
            for (ItemPanier tmp : listPanier) {
                total += tmp.getTotalItem();
            }
        }else if (listPanier == null) {
            listPanier = new ArrayList<>();
        }

        for (ItemMenu tmp : listItemsMenu) {
            String nom = tmp.getNom();
            ItemPanier item = null;
            String stringQnt = request.getParameter(nom);
            int qnt = 0;
            double totalItem = 0;
            if (stringQnt != null) {
                qnt = Integer.parseInt(stringQnt);
            }

            if (qnt != 0) {
                boolean flag = true;
                for(ItemPanier itemPanier: listPanier){
                    if(itemPanier.getNom().equals(tmp.getNom())){
                        itemPanier.setTotalItem(itemPanier.getTotalItem() + (tmp.getPrix() * qnt));
                        itemPanier.setQuantite(itemPanier.getQuantite() + qnt);
                        total += tmp.getPrix() * qnt;
                        flag = false;
                    }
                }
                if(flag){
                    totalItem = tmp.getPrix() * qnt;
                    total += totalItem;
                    item = new ItemPanier(nom, qnt, totalItem);
                    listPanier.add(item);

                }
            }
        }

        total = Math.round(total * 100.0) / 100.0;
        session.setAttribute("listPanier", listPanier);
        session.setAttribute("total", total);

        RequestDispatcher disp = getServletContext().getRequestDispatcher("/ServletCreationList");
        disp.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
