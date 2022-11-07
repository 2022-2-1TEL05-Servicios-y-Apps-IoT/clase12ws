package com.example.clase12ws.controller;

import com.example.clase12ws.entity.Product;
import com.example.clase12ws.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Environment environment;

    @GetMapping("")
    public List<Product> listar() {
        List<Product> lista = productRepository.findAll();
        String portStr = environment.getProperty("local.server.port");
        int port = Integer.parseInt(portStr);

        for(int i = 0; i < lista.size(); i++){
            lista.get(i).setPort(port);
        }
        return lista;
    }

    @GetMapping("/{id}")
    public Product buscarPorId(@PathVariable("id") int id) {
        Optional<Product> optional = productRepository.findById(id);
        return optional.orElse(null);
    }
}
