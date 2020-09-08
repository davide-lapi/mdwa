package s21;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s21/choice")
public class Choice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Choice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] userColors = request.getParameterValues("colors");

		if (userColors == null) {
			request.setAttribute("colors", "missing your choice");
			RequestDispatcher rd = request.getRequestDispatcher("/s21/feedback.jsp");
			rd.forward(request, response);
			return;
		}

		List<String> colors = new ArrayList<>();

		for (int i = 0; i < userColors.length; i++) {
			switch (userColors[i]) {
			case "blue":
				colors.add("blu");
				break;
			case "yellow":
				colors.add("giallo");
				break;
			case "green":
				colors.add("verde");
				break;
			case "white":
				colors.add("bianco");
				break;
			case "black":
				colors.add("nero");
				break;

			default:
				colors.add("No Color");
				break;
			}
		}

		request.setAttribute("colors", colors);
		RequestDispatcher rd = request.getRequestDispatcher("/s21/feedback.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}