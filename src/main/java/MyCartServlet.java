import com.example.shoppingcart.ItemBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MyCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * To create the mycart page with the checkout, add, subtract and delete buttons.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = null;
        int i = 0;
        HttpSession session = request.getSession();

        if (session.getAttribute("currentUser")==null)
        {
            response.sendRedirect("login.html");
        }
        else
        {
            user = session.getAttribute("currentUser").toString();
        }
        PrintWriter out = response.getWriter();
        out.println("<h1>" + user + "\'s cart</h1>");
        List<ItemBean> myItems = (List<ItemBean>) session.getAttribute("CartItems");
        RequestDispatcher rd = request.getRequestDispatcher("addtocart.jsp");
        rd.include(request, response);
        for( ItemBean items : myItems)
        {
            out.println("<h3>Item name: " + items.getName()+"</h3>");
            out.println("<h3>Quantity : " + items.getQuantity()+"</h3>");
            out.println("<h3>Price: " + items.getPrice()*items.getQuantity()+"</h3>");
            out.println("<form method=\"post\" action=\"quantity\"><input type=\"hidden\" name=\"itemName\" value=\""+ items.getName()+"\">");
            out.println("<input type=\"hidden\" name=\"itemQuantity\" value=\""+ items.getQuantity()+"\">");
            out.println("<input type=\"submit\" name=\"add\" value=\"+\"><input name=\"subtract\" type=\"submit\" value=\"-\"></form>");
            out.println("<form method=\"post\" action=\"delete\"><input type=\"hidden\" name=\"itemName\" value=\""+ items.getName()+"\">");
            out.println("<input type=\"submit\" value=\"Delete\"></form>");
            out.println("<br>");
        }

        out.println("<form method=\"post\" action=\"checkout\"><input type=\"submit\" value=\"Check Out\"></form>");
    }
}
