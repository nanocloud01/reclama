package com.example.reclama;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository repository;

    @GetMapping("/bookSave")
    public String bookSave() {
        log.info("Saving...");
        repository.save(new Book("Java"));
        repository.save(new Book("Node"));
        repository.save(new Book("Python"));

        return "bookSave";
    }

    @GetMapping("/book")
    public String book() {
        log.info("GetBooks...");

        log.info("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));

        log.info("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        log.info("\nfindByName('Node')");
        repository.findByName("Node").forEach(x -> System.out.println(x));

        return "book";
    }
}
