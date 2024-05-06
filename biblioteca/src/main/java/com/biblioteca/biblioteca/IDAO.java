package com.biblioteca.biblioteca;
import java.sql.SQLException;
import java.util.List;

public interface IDAO<T> {
    void cadastrar(T entidade) throws SQLException;
    void devolver(T entidade) throws SQLException;
    T emprestar(int id) throws SQLException;
    T buscar(int id);
    List<T> listar();
}