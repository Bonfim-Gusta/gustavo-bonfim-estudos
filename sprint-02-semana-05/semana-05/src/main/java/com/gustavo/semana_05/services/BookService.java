package com.gustavo.semana_05.services;

import com.gustavo.semana_05.entities.Book;
import com.gustavo.semana_05.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(String id){
        return bookRepository.findById(id).orElseThrow();
    }

    public List<Book> findByAutor(String autor){
        List<Book> allBooks = findAll();
        List<Book> list = new ArrayList<>();
        for (Book b : allBooks){
            if (b.getAutor().equals(autor)){
                list.add(b);
            }
        }
        return list;
    }

    public List<Book> findByTitle(String title){
        List<Book> allBooks = findAll();
        List<Book> list = new ArrayList<>();
        for (Book b : allBooks){
            if (b.getTitle().equals(title)){
                list.add(b);
            }
        }
        return list;
    }

    public List<Book> findByYearAfter(Integer year){
        List<Book> allBooks = findAll();
        List<Book> list = new ArrayList<>();
        for (Book b : allBooks){
            if (b.getPublicationYear() > year){
                list.add(b);
            }
        }
        return list;
    }

    public Book insert(Book book){
        return bookRepository.save(book);
    }

    public Book update(Book book){
        Book bookToUpdate =  findById(book.getId());
        updateData(bookToUpdate, book);

        return bookRepository.save(bookToUpdate);
    }

    private void updateData(Book bookToUpdate, Book book) {
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAutor(book.getAutor());
        bookToUpdate.setPublicationYear(book.getPublicationYear());
        bookToUpdate.setGenre(book.getGenre());
    }

    public void deleteById(String id){
        Book book = findById(id);
        bookRepository.deleteById(book.getId());
    }

    public void deleteByTitle(String title){
        for (Book b : findAll()){
            if (b.getTitle().equals(title)){
                bookRepository.delete(b);
            }
        }
    }
}
