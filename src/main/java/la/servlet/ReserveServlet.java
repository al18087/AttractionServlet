package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.AttractionBean;
import la.dao.AttractionDAO;
import la.dao.DAOException;

/**
 * Servlet implementation class ReserveServlet
 */
@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		if (action == null || action.length() == 0 || action.equals("attraction") ||
				action.equals("isLogin") || action.equals("login")) {
			System.out.println("ok");
			System.out.println(action);
			gotoPage(request, response, "/top.jsp");
		}
		
		// アトラクションを選択したとき
		else if (action.equals("reserve")) {
			int visitorId = Integer.parseInt(request.getParameter("visitor_id"));
			int attractionId = Integer.parseInt(request.getParameter("attraction"));
			
		}
	}
	
	public void init() throws ServletException {
		try {
			AttractionDAO dao = new AttractionDAO();
			List<AttractionBean> list = dao.findAttraction();
			getServletContext().setAttribute("attraction", list);
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}
	
	private void gotoPage(HttpServletRequest request, HttpServletResponse response,
			String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
