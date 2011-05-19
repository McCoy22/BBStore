package test;

import bb.service.Book;
import bb.service.BookList;

public class BookListTest {
	
	public static void main (String[] args) {
		BookList list = BookList.getInstance();
		
		for (Book buch : list.getBooks()) {
			System.out.println(buch);
		}
		
		Book buch = list.getBook("123");
		System.out.println(buch);
		
		buch = list.getBook("123456");
		System.out.println(buch);
		
	}

}
