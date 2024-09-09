package com.gustavo.semana_05.resources;

import com.gustavo.semana_05.entities.Book;
import com.gustavo.semana_05.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> list = bookService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable String id){
        Book book = bookService.findById(id);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Book book){
        bookService.insert(book);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
