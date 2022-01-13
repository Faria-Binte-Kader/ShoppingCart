import com.example.shoppingcart.ItemBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class DeleteItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemName = request.getParameter("itemName");
        HttpSession session = request.getSession();
        List<ItemBean> myItems = (List<ItemBean>) session.getAttribute("CartItems");

        for (Iterator<ItemBean> iterator = myItems.iterator(); iterator.hasNext(); ) {
            ItemBean value = iterator.next();
            if (value.getName().equals(itemName)) {
                iterator.remove();
            }
        }

        PrintWriter out = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher("mycart");
        rd.include(request, response);
        out.println("<h3>"+itemName+" was removed from the cart </h3>");
    }
}
