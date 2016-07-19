/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import Model.Pontos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class PontosDao extends DAO<Pontos> {
    
    int maxpontos;
    private final String getpontos = "select * from garcia.pontos;";

    public PontosDao(Connection connection) {
        super(connection);
    }
    
    
    public List<Pontos> proporcao(){
        List<Pontos> listapontos;
        //achar os pontos
        //pegar uma parte
        //enviar essa parte
        return null; 
    }

    @Override
    public void create(Pontos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pontos read(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pontos obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pontos> all() {
        try {
            PreparedStatement statement = connection.prepareStatement(getpontos);
            ResultSet result = statement.executeQuery();
            List<Pontos> pontos = new ArrayList<Pontos>();
            Pontos ponto;
            while(result.next()){
                ponto = new Pontos();
                ponto.setX(result.getDouble("x"));
                ponto.setY(result.getDouble("y"));
                ponto.setZ(result.getDouble("z"));
                pontos.add(ponto);
            }
            return pontos;
        } catch (SQLException ex) {
            Logger.getLogger(PontosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
