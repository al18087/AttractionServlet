package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.TicketKindBean;
import la.bean.VisitorBean;
import la.dao.DAOException;
import la.dao.TicketKindDAO;

/**
 * Servlet implementation class TicketingServlet
 */
@WebServlet("/TicketingServlet")
public class TicketingServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		try {
			if (action == null || action.length() == 0 || action.equals("ticket")) {
				gotoPage(request, response, "/ticketKind.jsp");
			}
			
			// チケットを選択したとき
			else if (action.equals("purchase_ticket")) {
				int ticketId = Integer.parseInt(request.getParameter("ticket"));
				System.out.println(ticketId);
				TicketKindDAO dao = new TicketKindDAO();
				VisitorBean visitor = dao.saveVisitor(ticketId);
				String ticketName = dao.getTicketName(ticketId);
				
				request.setAttribute("visitor", visitor);
				request.setAttribute("ticketName", ticketName);
				gotoPage(request, response, "/visitor.jsp");
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
	
	public void init() throws ServletException {
		try {
			TicketKindDAO dao = new TicketKindDAO();
			List<TicketKindBean> list = dao.findTicketKind();
			getServletContext().setAttribute("ticket", list);
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServletException();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
