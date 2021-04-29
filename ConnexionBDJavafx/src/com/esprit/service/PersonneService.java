/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.service;

import com.esprit.entity.Personne;
import com.esprit.dao.IService;
import com.esprit.utils.MyDb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gogo-
 */
public class PersonneService implements IService<Personne> {

    Connection cnx;
    Statement ste;

    public PersonneService() throws SQLException {
        cnx = MyDb.getInstance().getConnection();
        ste = cnx.createStatement();
    }

    @Override
    public void ajouter(Personne t) throws SQLException {

        String requeteInsert = "INSERT INTO `personne` (`id`, `nom`, `prenom`) VALUES (NULL, '" + t.getNom() + "', '" + t.getPrenom() + "';";
        ste.executeUpdate(requeteInsert);
    }

    public void ajouter1(Personne p) throws SQLException {
        PreparedStatement pre = cnx.prepareStatement("INSERT INTO `esprit`.`personne` ( `nom`, `prenom`) VALUES ( ?, ?);");
        pre.setString(1, p.getNom());
        pre.setString(2, p.getPrenom());
    
        pre.executeUpdate();
    }

    @Override
    public boolean delete(Personne t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Personne t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Personne> readAll() throws SQLException {
        List<Personne> personnes = new ArrayList<>();
        ResultSet result =  ste.executeQuery("select * from personne");
        while(result.next()){
            personnes.add(new Personne(result.getInt(1), result.getString("nom"), result.getString("prenom")));
        }
        
        return personnes;
    }

}
