package com.example.reclama;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "books")
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByName(String name);

}
