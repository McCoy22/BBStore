/**
 * 
 */
package bb.service;

/**
 * @author B999982
 *
 */
public class Book {
	
	String isbn;
	String title;
	String author;
	int price;
	
	public Book(String isbn, String title, String author, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public final String getIsbn() {
		return isbn;
	}
	public final String getTitle() {
		return title;
	}
	public final String getAuthor() {
		return author;
	}
	public final int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return isbn + " - " + title + " - " + author + " : " + price;
	}

}
