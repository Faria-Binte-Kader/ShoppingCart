import com.example.shoppingcart.ItemBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CheckOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int i = 0;

        List<ItemBean> shopItems = (List<ItemBean>) getServletContext().getAttribute("ShopItems");
        List<ItemBean> myItems = (List<ItemBean>) session.getAttribute("CartItems");

        for(ItemBean shopitems: shopItems)
        {
            for(ItemBean cartItems: myItems)
            {
                if (cartItems.getName().equals(shopitems.getName())) {
                    shopitems.setQuantity(shopitems.getQuantity() - cartItems.getQuantity());
                }
            }
        }
        session.setAttribute("ShopItems", shopItems);
        getServletContext().setAttribute("ShopItems", shopItems);
        session.setAttribute("CartItems", null);
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher(
                "addtocart.jsp");
        rd.include(request, response);
        out.println("<h3>Congratulations!</h3>");
        out.println("<h3>We checked you out with all your products with our dummy payment method.</h3>");
        out.println("<h3>Happy shopping.</h3>");

    }
}
