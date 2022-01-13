import com.example.shoppingcart.ItemBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QuantityModifierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Method to increase or decrease the quantity of the items in the cart.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String add = request.getParameter("add");
        String subtract = request.getParameter("subtract");
        String itemName = request.getParameter("itemName");
        int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));

        HttpSession session = request.getSession();
        List<ItemBean> myItems = (List<ItemBean>) session.getAttribute("CartItems");
        List<ItemBean> shopItems = (List<ItemBean>) session.getAttribute("ShopItems");


        Map<String, Integer> availableQuantity = new HashMap<>();

        for( ItemBean items : shopItems) {

            availableQuantity.put(items.getName(),items.getQuantity());
        }

        int i = 0;
        if(add!=null && subtract==null)
        {
            for( ItemBean items : myItems)
            {
                if (items.getName().equals(itemName) ) {
                   if(availableQuantity.get(itemName)>itemQuantity)
                    myItems.get(i).setQuantity(itemQuantity+1);
                }
                i++;
            }

        }
        else if(add==null && subtract!=null)
        {
            for( ItemBean items : myItems)
            {
                if (items.getName().equals(itemName)) {
                    if(itemQuantity>0)
                        myItems.get(i).setQuantity(itemQuantity-1);
                }
                i++;
            }

        }
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher("mycart");
        rd.include(request, response);
    }
}
