package com.example.prototipo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.prototipo.model.Empresa;
import com.example.prototipo.service.EmpresaService;


@RestController
@RequestMapping("/api/empresa")
@CrossOrigin(maxAge = 3600)
public class EmpresaRestController {

      
      private EmpresaService empresaService;
 
      public EmpresaRestController(EmpresaService empresaService) {
            this.empresaService = empresaService;
      }


      @GetMapping("/buscar")
      public ResponseEntity<List<Empresa>> findAll(){
            List<Empresa> empresas = empresaService.buscarTodos();
            return ResponseEntity.ok(empresas);
      }

      @PostMapping("/crear")
      public Empresa crearEmpresa(@RequestBody Empresa empresa) {
            return empresaService.crearEmpresa(empresa);
      }

}

