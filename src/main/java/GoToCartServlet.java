import com.example.shoppingcart.ItemBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GoToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Method to show available items from the shop-items list, to select item for adding to the cart,
     * afte adding item, redirecting to the page to see the items in the cart.
     *
     * Allows duplicate item in the cart, but logically it should not be the case, worked with the thought
     * that user will not add another duplicate item, rather increase the number of the item from /mycart
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] itemname = request.getParameterValues("item");
        if (itemname == null) {
            PrintWriter out = response.getWriter();
            out.println("<h1> Please select items to add. </h1>");

            RequestDispatcher rd = request.getRequestDispatcher(
                    "homepage.jsp");
            rd.include(request, response);
        } else {
            List<ItemBean> itemBeanList = new ArrayList<ItemBean>();
            PrintWriter out = response.getWriter();

            for (String s : itemname) {
                if (s.equals("Chair")) {
                    ItemBean item = new ItemBean();
                    item.setQuantity(1);
                    item.setName("Chair");
                    item.setPrice(1500);
                    itemBeanList.add(item);
                } else if (s.equals("Table")) {
                    ItemBean item = new ItemBean();
                    item.setQuantity(1);
                    item.setPrice(15000);
                    item.setName("Table");
                    itemBeanList.add(item);

                } else if (s.equals("Bed")) {
                    ItemBean item = new ItemBean();
                    item.setQuantity(1);
                    item.setPrice(5500);
                    item.setName("Bed");
                    itemBeanList.add(item);
                } else if (s.equals("Mattress")) {
                    ItemBean item = new ItemBean();
                    item.setQuantity(1);
                    item.setPrice(1800);
                    item.setName("Mattress");
                    itemBeanList.add(item);
                }
            }

            HttpSession session = request.getSession();

            if (session.getAttribute("currentUser") == null) {
                response.sendRedirect("login.html");
            } else {
                List<ItemBean> myItems = (List<ItemBean>) session.getAttribute("CartItems");
                if (myItems == null) {
                    myItems = new ArrayList<ItemBean>();
                }
                for (ItemBean items : itemBeanList) {
                    myItems.add(items);
                }
                session.setAttribute("CartItems", myItems);
            }

            RequestDispatcher rd = request.getRequestDispatcher("mycart");
            rd.include(request, response);

        }
    }
}
