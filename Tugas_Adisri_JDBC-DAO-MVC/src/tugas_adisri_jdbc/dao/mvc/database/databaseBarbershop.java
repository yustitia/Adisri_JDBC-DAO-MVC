/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_adisri_jdbc.dao.mvc.database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import tugas_adisri_jdbc.dao.mvc.impl.pelangganDaoImp;
import tugas_adisri_jdbc.dao.mvc.service.pelangganDao;


/**
 *
 * @author yustitia arofa
 */
public class databaseBarbershop {
    private static Connection connection;
    private static pelangganDao pelangganDao;
    public static Connection getConnection()throws SQLException{
    if(connection==null){
        
        MysqlDataSource dataAja = new MysqlDataSource();
        dataAja.setURL("jdbc:mysql://localhost:3306/adisribarbershop");
        dataAja.setUser("root");
        dataAja.setPassword("");
        connection = (Connection) dataAja.getConnection();
        
    }
        
    return connection;
    }
    
    public static pelangganDao getpelangganDao() throws SQLException{
        if(pelangganDao==null){
        pelangganDao = new pelangganDaoImp(getConnection());
        
        }
        
        
        return pelangganDao;
    
    }
    
}
