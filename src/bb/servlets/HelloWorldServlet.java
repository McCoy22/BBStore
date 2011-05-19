package bb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println ("<html><body><p>Hello <b>");
		out.println (request.getParameter("name2")) ;
		out.println ("</b>!");
		
		String[] namen = request.getParameterValues("name");
		if (namen != null) {
			int i = 1;
			for (String name : namen) {
				out.print("<p>Name " + i++ + ": " + name);
			}
		}
		
		String[] vals = (String[]) request.getParameterMap().get("name3");
		out.println ("<p>#" + vals[0] + "#") ;
		
		out.println ("</p></body></html>");
	}

}
