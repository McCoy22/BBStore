package bb.web;

import javax.servlet.ServletContext;

import bb.service.BookList;

public class WebUtil {
	
	public static BookList getBookList (ServletContext ctx) {
		return (BookList) ctx.getAttribute("bookList");
	}
}
