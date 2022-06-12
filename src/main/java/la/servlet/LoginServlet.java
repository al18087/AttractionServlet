package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.dao.DAOException;
import la.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		try {
			// ログインしているか判定
			if (action.equals("isLogin")) {
				HttpSession session = request.getSession(true);
				Integer visitorId = (Integer)session.getAttribute("login");
				
				// ログインしていないとき
				if (visitorId == null) {
					gotoPage(request, response, "/login.jsp");
					return;
				}
				
				// ログインしているとき
				LoginDAO dao = new LoginDAO();
				visitorId = dao.findVisitorId(visitorId);
				session.setAttribute("login", visitorId);
				gotoPage(request, response, "/ReserveServlet");
			}
			
			// 入場者番号を入力してログイン
			else if (action.equals("login")) {
				Integer visitorId = Integer.parseInt(request.getParameter("visitor_id"));
				LoginDAO dao = new LoginDAO();
				visitorId = dao.findVisitorId(visitorId);
				
				// ログイン成功
				if (visitorId != null) {
					HttpSession session = request.getSession(true);
					session.setAttribute("login", visitorId);
					gotoPage(request, response, "/ReserveServlet");
				}
				
				// ログイン失敗
				else {
					request.setAttribute("message", "ログインに失敗しました。");
					gotoPage(request, response, "/errInternal.jsp");
				}
			}
			
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
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
