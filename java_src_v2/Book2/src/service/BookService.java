package service;

import vo.BookVO;

public class BookService {
	private Dao dao;
	
	public BookService(){
		dao = new BookDAO();
	}
	public void insert(BookVO b) {
		dao.bookinsert(b);
	}

	public void printAll() {
		System.out.println(dao.bookselectAll());
	}

	public BookVO findbook(String id) {
		return dao.bookselect(id);
	}

	public void deletebook(String id) {
		dao.bookdelete(id);
	}

	public void updatebook(BookVO b) {
		dao.bookupdate(b);
	}

}
