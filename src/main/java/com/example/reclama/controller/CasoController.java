package com.example.reclama.controller;

import com.example.reclama.model.entities.Caso;
import com.example.reclama.model.services.CasoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/casos")
public class CasoController {

    private static final Logger log = LoggerFactory.getLogger(CasoController.class);

    @Autowired
    CasoService casoService;

    @GetMapping("/prueba")
    public void algo() {
        log.info("ingresando a /pruebas");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Caso> getAllCasos() {
        log.info("getAllCasos ***");
        return casoService.getAllCasos();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Caso getAllCaso(@PathVariable Long id) {
        log.info("getAllCaso 1 ***");
        return casoService.getAllCaso(id);
    }

    @GetMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public Caso insertCasos() {
        log.info("insertCasos ***");
        try {
            return casoService.getAllCasos1();
        }
        catch (Exception exc) {
            //throw new IllegalStateException("Foo Not Found- HERE", exc);
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found- HERE", exc);
        }
    }


}
