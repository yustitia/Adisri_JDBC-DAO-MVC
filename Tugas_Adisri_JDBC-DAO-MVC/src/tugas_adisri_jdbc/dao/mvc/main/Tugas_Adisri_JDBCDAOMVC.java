/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_adisri_jdbc.dao.mvc.main;

import java.sql.SQLException;
import tugas_adisri_jdbc.dao.mvc.database.databaseBarbershop;
import tugas_adisri_jdbc.dao.mvc.entity.pelanggan;
import tugas_adisri_jdbc.dao.mvc.error.PelangganException;
import tugas_adisri_jdbc.dao.mvc.service.pelangganDao;

/**
 *
 * @author yustitia arofa
 */
public class Tugas_Adisri_JDBCDAOMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws SQLException, PelangganException {
        // TODO code application logic here
        pelangganDao dao = databaseBarbershop.getpelangganDao();
        pelanggan pelanggan = new pelanggan();
        pelanggan.setNama("adis");
        pelanggan.setAlamat("cigagak");
        pelanggan.setTelepon("0224567");
        pelanggan.setEmail("ganteng@gg.com");
        
        dao.insertPelanggan(pelanggan);
                
                
                }
    
}
