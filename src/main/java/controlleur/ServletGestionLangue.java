package controlleur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletGestionLangue", value = "/ServletGestionLangue")
public class ServletGestionLangue extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String langue = (String)session.getAttribute("langue");
        if (langue==null || request.getParameter("src").equals("1"))
        {
            String langueChoisie = request.getParameter("langue");
            session.setAttribute("langue",langueChoisie);
        }

        RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
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
