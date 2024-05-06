package com.biblioteca.biblioteca;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;


@SpringBootApplication
public class BibliotecaApplication {

	  @Autowired
    private LivroDAO livroDAO;

	public static void main(String[] args) {
        SpringApplication.run(BibliotecaApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() throws SQLException {
        DBConfig.createTables();
        LivroController livroController = new LivroController(livroDAO);
        BibliotecaView bibliotecaView = new BibliotecaView(livroController);
        bibliotecaView.iniciar();
    }
}