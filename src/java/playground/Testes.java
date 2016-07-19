/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playground;

import Dao.DAOFactory;
import Dao.PontosDao;
import Model.Pontos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class Testes {
    
    public static void main(String args[]){
        try {
            DAOFactory daoFactory = new DAOFactory();
            PontosDao pontosdao = daoFactory.getPontosDAO();
            List<Pontos> listapontos = pontosdao.all();
            for(Pontos ponto:listapontos){
                System.out.println("X:"+ponto.getX());
                System.out.println("Y:"+ponto.getY());
                System.out.println("X:"+ponto.getZ());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
    
}
