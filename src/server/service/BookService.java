package server.service;

import server.dao.BookDAO;
import server.model.Book;

import java.util.List;

public class BookService {
    private BookDAO dao = new BookDAO();

    public List<Book> getAll() {
        return dao.getAll();
    }

    public boolean add(Book b) {
        return dao.add(b);
    }
}
