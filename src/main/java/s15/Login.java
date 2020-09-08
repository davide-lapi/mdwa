package s15;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s15/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		request.setAttribute("user", user);
		
        if (user != null && password != null && !user.isEmpty() && !password.isEmpty()) {

             RequestDispatcher rd = request.getRequestDispatcher("/s15/logged.jsp");
             rd.forward(request, response);
        }
        else {

       	 RequestDispatcher rd = request.getRequestDispatcher("/s15/unknown.jsp");
         rd.forward(request, response);
        }
	    // forward logged.jsp o unknown.jsp
	}

}