package com.gustavo.semana_05.resources;

import com.gustavo.semana_05.entities.Book;
import com.gustavo.semana_05.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

    @GetMapping(value = "/filter")
    public ResponseEntity<List<Book>> findByAutor(@RequestParam(value = "autor", required = false) String autorBook){
        List<Book> books = bookService.findByAutor(autorBook);
        return ResponseEntity.ok().body(books);
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Book book, @PathVariable String id){
        book.setId(id);
        bookService.update(book);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable String id){
        bookService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{title}")
    public ResponseEntity<Book> deleteByTitle(@PathVariable String title){
        bookService.deleteByTitle(title);

        return ResponseEntity.noContent().build();
    }
}
