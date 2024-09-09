package com.gustavo.semana_05.config;

import com.gustavo.semana_05.entities.Book;
import com.gustavo.semana_05.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class StartCollectionConfig implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book book1 = new Book(null, "1984", "George Orwell", 1949, "Ficcção Científica");
        Book book2 = new Book(null, "Dom Casmurro", "Machado de Assis", 1899, "Romance");
        Book book3 = new Book(null, "The Lord of the Rings", "J.R.R. Tolkien", 1954, "Fantasia");
        Book book4 = new Book(null, "Animal Farm", "George Orwell", 1945, "Fábula");

        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4));
    }
}
