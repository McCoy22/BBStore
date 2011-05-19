package bb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bb.service.Book;
import bb.web.WebUtil;

/**
 * Servlet implementation class BookList
 */
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		bb.service.BookList bookList = WebUtil.getBookList(this.getServletContext());
		List<Book> list = bookList.getBooks();
		
		out.println("<html><body><table border='0'>");
		
		for (Book buch : list) {
			out.println("<tr><td><a href='BookDetail?isbn=" + buch.getIsbn() + "'>" + buch.getIsbn() + "</a></td>");
			out.println("<td>" + buch.getAuthor() + "</td>");
			out.println("<td>" + buch.getTitle() + "</td>");
			out.println("<td>" + buch.getPrice() + "</td></tr>");
		}
		out.println("</table>");
		
		String url = response.encodeURL("ShowCart");
		out.println("<p><a href='" + url + "'>Cart</a></p>");

		
		out.println("</body></html>");
	}

}
