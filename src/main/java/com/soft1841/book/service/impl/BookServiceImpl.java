package com.soft1841.book.service.impl;

import com.soft1841.book.dao.BookDAO;
import com.soft1841.book.entity.Book;
import com.soft1841.book.service.BookService;
import com.soft1841.book.utils.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = DAOFactory.getBookDAOInstance();

    @Override
    public Long addBook(Book book) {
        long result = 0;
        try {
            result = bookDAO.insertBook(book);
        } catch (SQLException e) {
            System.err.println("新增图书出现异常");
        }
        return result;
    }

    @Override
    public void deleteBook(long id) {
        try {
            bookDAO.deleteBookById(id);
        } catch (SQLException e) {
            System.err.println("删除图书出现异常");
        }
    }

    @Override
    public void updateBook(Book book) {
        try {
            bookDAO.updateBook(book);
        } catch (SQLException e) {
            System.err.println("修改图书信息出现异常");
        }
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDAO.selectAllBooks();
        } catch (SQLException e) {
            System.err.println("查询所有图书信息出现异常");
        }
        return bookList;
    }

    @Override
    public Book getBook(long id) {
        Book book = new Book();
        try {
            book = bookDAO.getBookById(id);
        } catch (SQLException e) {
            System.err.println("查询单个图书信息出现异常");
        }
        return book;
    }

    @Override
    public List<Book> getBooksLike(String keywords) {
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDAO.selectBooksLike(keywords);
        } catch (SQLException e) {
            System.err.println("根据关键字查询图书信息出现异常");
        }
        return bookList;
    }

    @Override
    public List<Book> getBooksByTypeId(long typeId) {
        List<Book> bookList = new ArrayList<>();
        try {
            bookList = bookDAO.selectBooksByTypeId(typeId);
        } catch (SQLException e) {
            System.err.println("根据类别查询图书信息出现异常");
        }
        return bookList;
    }

    @Override
    public int countByType(long typeId) {
        int result = 0;
        try {
            result = bookDAO.countByType(typeId);
        } catch (SQLException e) {
            System.err.println("根据类别统计图书信息出现异常");
        }
        return result;
    }
}
