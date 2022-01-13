import com.example.shoppingcart.ItemBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Saves the username and password of a user, so we did not have not hard code the username and password.
     * Saves the shop item list information as a global list variable.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("signupUsername", request.getParameter("signupUsername"));
        session.setAttribute("signupPassword",request.getParameter("signupPassword"));

        List<ItemBean> itemBeanShop = new ArrayList<ItemBean>();
        ItemBean item = new ItemBean();
        item.setQuantity(15);
        item.setName("Chair");
        item.setPrice(1500);
        itemBeanShop.add(item);
        ItemBean item2 = new ItemBean();
        item2.setQuantity(10);
        item2.setPrice(15000);
        item2.setName("Table");
        itemBeanShop.add(item2);
        ItemBean item3 = new ItemBean();
        item3.setQuantity(20);
        item3.setPrice(5500);
        item3.setName("Bed");
        itemBeanShop.add(item3);
        ItemBean item4  = new ItemBean();
        item4.setQuantity(22);
        item4.setPrice(1800);
        item4.setName("Mattress");
        itemBeanShop.add(item4);
        getServletContext().setAttribute("ShopItems", itemBeanShop);
        session.setAttribute("ShopItems", itemBeanShop);

            PrintWriter out = response.getWriter();
            out.println("<h1> Successfully signed up. Log in to continue. </h1>");

            RequestDispatcher rd = request.getRequestDispatcher(
                    "login.html");
            rd.include(request, response);

    }
}
