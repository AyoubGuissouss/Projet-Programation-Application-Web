package controlleur;

import dao.ItemMenuDaoImpl;
import entity.ItemMenu;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletCreationList", value = "/ServletCreationList")
public class ServletCreationList extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItemMenuDaoImpl itemMenuDao = new ItemMenuDaoImpl();
        List<ItemMenu> listMenu = itemMenuDao.getAllItemMenu();

        request.setAttribute("listMenu", listMenu);

        RequestDispatcher disp = getServletContext().getRequestDispatcher("/menu.jsp");
        disp.forward(request,response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        /**ItemMenuDaoImpl itemMenuDao = new ItemMenuDaoImpl();
         List<ItemMenu> listMenu = itemMenuDao.getAllItemMenu();

         request.setAttribute("listMenu", listMenu);

         RequestDispatcher disp = getServletContext().getRequestDispatcher("/menu.jsp");
         disp.forward(request,response);*/
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        /**ItemMenuDaoImpl itemMenuDao = new ItemMenuDaoImpl();
         List<ItemMenu> listMenu = itemMenuDao.getAllItemMenu();

         request.setAttribute("listMenu", listMenu);

         RequestDispatcher disp = getServletContext().getRequestDispatcher("/menu.jsp");
         disp.forward(request,response);*/
    }
}
