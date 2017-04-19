/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restapi.controllers;

import com.restapi.models.Curso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ronistone
 */
@RestController
public class CursoResource {

    private Map<Integer, Curso> cursos;

    public CursoResource() {
        cursos = new HashMap<>();
        /*Curso c1 = new Curso("Workshop Rest", "24hs");
        Curso c2 = new Curso("Workshop Spring MVC", "24hs");
        Curso c3 = new Curso("Desenvolvimento Web com JSF 2", "60hs");
        
        cursos.put(1, c1);
        cursos.put(2, c2);
        cursos.put(3, c3);*/
    }

    @RequestMapping(value = "/cursos", method = RequestMethod.GET)
    public ResponseEntity<List<Curso>> listar() {

        return new ResponseEntity<>(new ArrayList<>(cursos.values()), HttpStatus.OK);

    }

    @RequestMapping(path = "/cursos", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Integer> criar(@RequestBody Curso c) {

        Map<String, Integer> hash = new HashMap<>();
        Integer status = 200;
        cursos.put(cursos.size() + 1, c);
        hash.put("status", status);
        return hash;

    }

    @RequestMapping(value = "/cursos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Curso> buscar(@PathVariable("id") Integer id) {

        Curso curso = cursos.get(id);
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curso, HttpStatus.OK);

    }

    @RequestMapping(value = "/cursos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {

        Curso curso = cursos.remove(id);
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
