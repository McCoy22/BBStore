package bb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bb.domain.ShoppingCart;
import bb.service.Book;

/**
 * Servlet implementation class ShowCart
 */
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		
		HttpSession sess = request.getSession();
		ShoppingCart cart = (ShoppingCart) sess.getAttribute("cart");

		if (cart == null || cart.getContent().size() == 0) {
			out.println("<h2>Cart ist leer!</h2>");
			out.println("</body></html>");
			return;
		}
		
		out.println("<table border='0'>");
		for (Book buch : cart.getContent()) {
			String url = response.encodeURL("BookDetail?isbn=" + buch.getIsbn());
			out.println("<tr><td><a href='"+url+"'>" + buch.getIsbn() + "</a></td>");
			out.println("<td>" + buch.getAuthor() + "</td>");
			out.println("<td>" + buch.getTitle() + "</td>");
			out.println("<td>" + buch.getPrice() + "</td></tr>");
		}
		out.println("</table>");
		
		String listUrl = response.encodeURL("BookList");
		out.println("<p><a href='" + listUrl + "'>Back to Catalog</a></p>");

		out.println("</body></html>");
	}

}
