package bb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookList {

	private static BookList instance = new BookList();
	private HashMap<String, Book> books = new HashMap<String, Book>();
	
	private BookList () {
		books.put("123", new Book ("123", "Testbuch", "Ansgar Meyer-Otte", 10));
		books.put("456", new Book ("456", "Java", "James Gosling", 1));
		books.put("789", new Book ("789", "Tagebuch", "Ansgar Meyer-Otte", 999));
	}

	
	public final static BookList getInstance() {
		return instance;
	}


	public final List<Book> getBooks() {
		return new ArrayList<Book>(books.values());
	}
	
	public final Book getBook (String isbn) {
		return books.get(isbn);
	}
	
}
