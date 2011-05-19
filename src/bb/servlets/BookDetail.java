package bb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bb.service.Book;
import bb.service.BookList;
import bb.web.WebUtil;

/**
 * Servlet implementation class BookDetail
 */
public class BookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		BookList list = WebUtil.getBookList(this.getServletContext());
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
			out.println("<h2>Buch:</h2>");
			out.println("<p><b>ISBN:</b> " + book.getIsbn());
			out.println("</p><p><b>Autor:</b> " + book.getAuthor());
			out.println("</p><p><b>Titel:</b> " + book.getTitle());
			out.println("</p><p><b>Preis:</b> " + book.getPrice());
			out.println("</p>");
			
			String url = response.encodeURL("AddToCart?isbn=" + isbn);
			
			out.println("<h3><a href='" + url + "'>Add To Cart</a></h3>");
		}

		String listUrl = response.encodeURL("BookList");
		out.println("<p><a href='" + listUrl + "'>Back to Catalog</a></p>");
		
		out.println("</body></html>");
	}

}
