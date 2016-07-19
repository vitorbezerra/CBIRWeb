/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author pedro
 * @param <T>
 */
public abstract class DAO<T> {
    
    protected Connection connection;
    
    public DAO(Connection connection) {
        this.connection = connection;
    }
    
    public abstract void create(T obj);
    
    public abstract T read(String cpf);
    
    public abstract void update(T obj);
    
    public abstract void delete(String cpf);
    
    public abstract List<T> all();
    
    
}
