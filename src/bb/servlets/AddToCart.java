package bb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bb.domain.ShoppingCart;
import bb.service.Book;
import bb.service.BookList;

/**
 * Servlet implementation class AddToCart
 */
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		BookList list = BookList.getInstance();
		String isbn = request.getParameter("isbn");

		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		if (isbn == null) {
			out.println("<p>isbn parameter missing!</p></body></html>");
			return;
		}
		
		Book book = list.getBook(isbn);
		
		if (book == null) {
			out.println("<p>Book not found!</p>");
		} else {
			HttpSession sess = request.getSession();
			ShoppingCart cart;
			synchronized (this) {
				cart = (ShoppingCart) sess.getAttribute("cart");
				if (cart == null) {
					cart = new ShoppingCart();
					sess.setAttribute("cart", cart);
				}
			}
			cart.addBook(book);
			
			out.println("<p>Buch <b>" + book.getTitle() + "</b> hinzugef&uuml;gt!</p>");
			
			String bookUrl = response.encodeURL("BookDetail?isbn=" + isbn);
			out.println("<p><a href='" + bookUrl + "'>Back to Book</a></p>");
		}

		String listUrl = response.encodeURL("BookList");
		out.println("<p><a href='" + listUrl + "'>Back to Catalog</a></p>");
		
		out.println("</body></html>");		
	}

}
