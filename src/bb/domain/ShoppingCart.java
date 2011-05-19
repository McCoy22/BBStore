/**
 * 
 */
package bb.domain;

import java.util.ArrayList;
import java.util.List;

import bb.service.Book;

/**
 * @author B999982
 *
 */
public class ShoppingCart {
	
	private List<Book> content = new ArrayList<Book>();
	
	public void addBook (Book buch) {
		content.add(buch);
	}

	public List<Book> getContent () {
		return content;
	}
}
