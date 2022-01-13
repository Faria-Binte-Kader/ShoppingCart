import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * sets the current user attribute to null, logging out the user from the system.
     * does not invalidate the session, as it will remove the information of a signed up user.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("yesbtn") != null) {
            HttpSession session = request.getSession();
            if(session != null){
                session.setAttribute("currentUser", null);
            }
            response.sendRedirect("login.html");
        } else if (request.getParameter("nobtn") != null) {
            response.sendRedirect("homepage.jsp");
        }
    }
}
