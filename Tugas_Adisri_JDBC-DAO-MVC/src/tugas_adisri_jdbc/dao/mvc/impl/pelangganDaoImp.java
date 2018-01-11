/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_adisri_jdbc.dao.mvc.impl;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tugas_adisri_jdbc.dao.mvc.entity.pelanggan;
import tugas_adisri_jdbc.dao.mvc.error.PelangganException;
import tugas_adisri_jdbc.dao.mvc.service.pelangganDao;

/**
 *
 * @author yustitia arofa
 */
public class pelangganDaoImp implements pelangganDao {
    
    private Connection connection;
    
    private final String insertPelanggan = "INSERT INTO PELANGGAN (NAMA,ALAMAT,TELEPON,EMAIL)VALUE(?,?,?,?)";
    private final String updatePelanggan = "UPDATE PELANGGAN SET NAMA=?,ALAMAT=?,TELEPON=?,EMAIL=? WHERE ID=?";
    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";
    private final String getById = "SELECT * FROM PELANGGAN WHERE ID = ?";
    private final String getByEmail = "SELECT * FROM PELANGGAN WHERE EMAIL = ?";
    private final String selectAll = "SELECT * FROM PELANGGAN";
    public pelangganDaoImp(Connection connection) {
        this.connection = connection;
    }
    
    

    @Override
    public void insertPelanggan(pelanggan pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(insertPelanggan);
            statement.setString(1,pelanggan.getNama());
            statement.setString(2,pelanggan.getAlamat());
            statement.setString(3,pelanggan.getTelepon());
            statement.setString(4,pelanggan.getEmail());
            statement.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            
            
            }
        
        }
    }


    @Override
    public void updatePelanggan(pelanggan pelanggan) throws PelangganException {
    PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePelanggan);
            statement.setString(1,pelanggan.getNama());
            statement.setString(2,pelanggan.getAlamat());
            statement.setString(3,pelanggan.getTelepon());
            statement.setString(4,pelanggan.getEmail());
            statement.setInt(5,pelanggan.getId());
            statement.executeUpdate();
             connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            
            
            }
        
        }
    }

    @Override
    public void deletePelanggan(int id) throws PelangganException {
    PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePelanggan);
            statement.setInt(1, id);
            statement.executeUpdate();
             connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            
            
            }
        
        }
    }

    @Override
    public pelanggan getPelanggan(int id) throws PelangganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, id);
            
            ResultSet result = statement.executeQuery();
            pelanggan pelanggan = null;
            if (result.next()) {
                pelanggan = new pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                
                
            }else{
            
                throw new PelangganException("Pelanggan dengan id "
                        + id + " tidak ditemukan");
            
            }  connection.commit();
            return pelanggan;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            
            
            }
        
        }
        
    }

    @Override
    public pelanggan getPelanggan(String email) throws PelangganException {
              PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByEmail);
            statement.setString(1, email);
            
            ResultSet result = statement.executeQuery();
            pelanggan pelanggan = null;
            if (result.next()) {
                pelanggan = new pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                
            }else{
            
                throw new PelangganException("Pelanggan dengan email "
                        + email + " tidak ditemukan");
            
            } connection.commit(); 
            return pelanggan;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            
            
            }
        
        }
    }

    @Override
    public List<pelanggan> selectAllPelanggan() throws PelangganException {
        Statement statement = null;
        List<pelanggan> list = new ArrayList<pelanggan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(selectAll);
            pelanggan pelanggan = null;
            while (result.next()) {
                pelanggan = new pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                list.add(pelanggan);
                
            }connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            
            
            }
        
        }
    }
    
}
