package controlleur;

import entity.ItemPanier;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletModifierItem", value = "/ServletModifierItem")
public class ServletModifierItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        String itemAModifier = request.getParameter("itemAModifier");
        List<ItemPanier> listPanier = (List<ItemPanier>) session.getAttribute("listPanier");
        ItemPanier item = null;
        for(ItemPanier tmp : listPanier){
            if(tmp.getNom().equals(itemAModifier)){
                item = tmp;
            }
        }
        int qtn = Integer.parseInt(request.getParameter(item.getNom()));
        double prix = item.getTotalItem() / item.getQuantite();
        double totalItem = qtn * prix;
        double total = (Double) session.getAttribute( "total");
        if(item.getQuantite() < qtn){
            double augmentation = totalItem - item.getTotalItem();
            total = total + augmentation;
            total = Math.round(total * 100.0) / 100.0;
            session.setAttribute("total",total);
            item.setQuantite(qtn);
            item.setTotalItem(totalItem);
            session.setAttribute("listPanier", listPanier);
        }else if(item.getQuantite() > qtn){
            double deduction = item.getTotalItem() - totalItem;
            total = total - deduction;
            total = Math.round(total * 100.0) / 100.0;
            session.setAttribute("total",total);
            item.setQuantite(qtn);
            item.setTotalItem(totalItem);
            session.setAttribute("listPanier", listPanier);
        }


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
