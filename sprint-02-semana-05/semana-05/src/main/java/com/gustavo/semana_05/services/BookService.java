package com.gustavo.semana_05.services;

import com.gustavo.semana_05.entities.Book;
import com.gustavo.semana_05.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Book insert(Book book){
        return bookRepository.save(book);
    }
}
