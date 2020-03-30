package com.example.reclama.model.services;

import com.example.reclama.exceptions.ResourceNotFoundException;
import com.example.reclama.model.entities.Caso;
import com.example.reclama.model.repositories.CasoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
public class CasoService {

    @Autowired
    CasoRepository casoRepository;

    private static final Logger log = LoggerFactory.getLogger(CasoService.class);

    public List<Caso> getAllCasos() {
        log.info("getAllCasos()");
        return casoRepository.findAll();
    }

    public Caso getAllCaso(Long id) {
        log.info("getAllCaso()");
        Optional<Caso> optionalUser = casoRepository.findById(id);
        if (!optionalUser.isPresent()) {
            log.info("dentro if");
            throw new ResourceNotFoundException("No encontrado");
            //return optionalUser.get();
        }
        return optionalUser.get();
        //return null;
    }

//    public Caso getAllCaso(Long id) throws Exception {
//        log.info("getAllCaso()");
//        Optional<Caso> optionalUser = casoRepository.findById(id);
//
//        if (!optionalUser.isPresent()) {
//            throw new Exception("No se encontro el usuario.");
//        }
//        return optionalUser.get();
//    }

    public Caso getAllCasos1() {
        log.info("getAllCasos1()");

        Caso c = new Caso();
        c.setNombres("nombres");
        c.setApellidos("apellidos");
        c.setCorreoElectronico("abc@asd.com");
        //c.setDescripcion("descripcion12345678");
        return casoRepository.save(c);

//        try {
//            return casoRepository.save(c);
//        } catch (ConstraintViolationException exc) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
//        }


    }


}
