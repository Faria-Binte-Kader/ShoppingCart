import com.example.shoppingcart.ItemBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class QuantityModifierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String add = request.getParameter("add");
        String subtract = request.getParameter("subtract");
        String itemName = request.getParameter("itemName");
        int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));
        HttpSession session = request.getSession();
        List<ItemBean> myItems = (List<ItemBean>) session.getAttribute("CartItems");
        int i = 0;
        if(add!=null && subtract==null)
        {
            for( ItemBean items : myItems)
            {
                if (items.getName().equals(itemName)) {
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
