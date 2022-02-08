
package ca.sait.lab4b.servlets;

import ca.sait.lab4b.models.User;
import ca.sait.lab4b.services.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrater
 */
public class LoginServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //to ensure when at the login page, session/ username and password are there, go to home page
        // if home page has no session, go back to login page
        HttpSession session = request.getSession();
        
        // if login successful, bring to home page instead of login/out
        if(session.getAttribute("username") != null){
            
            //to check if it is logout to see if logout in the query string - if it is login, to check if it is logout
            //otherwise it is login, go to home page
            //if it is login with null username and password, will still back to/stay at the login page
            String query = request.getQueryString();
            if(query != null && query.contains("logout")){
                session.invalidate();
                request.setAttribute("message", "You are logged out."); //to display message when logout
            }else{
                response.sendRedirect("home");
                return;
            }

        }  
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username == null || username.isEmpty() || password == null || password.isEmpty()){
            request.setAttribute("message", "Username or password is missing.");
        } else {
            AccountService account = new AccountService();
            
            User user = account.login(username,password);
            
            if(user != null){
                request.getSession().setAttribute("username", username);
                
                response.sendRedirect("home");
                return;  //to ensure go back to home page after submit
            } else {
                request.setAttribute("username", username);
                request.setAttribute("message","Username or password is invalid.");
            }
            
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }


}
