/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_adisri_jdbc.dao.mvc.model;

import java.sql.SQLException;
import tugas_adisri_jdbc.dao.mvc.database.databaseBarbershop;
import tugas_adisri_jdbc.dao.mvc.entity.pelanggan;
import tugas_adisri_jdbc.dao.mvc.error.PelangganException;
import tugas_adisri_jdbc.dao.mvc.event.PelangganListener;
import tugas_adisri_jdbc.dao.mvc.service.pelangganDao;

/**
 *
 * @author yustitia arofa
 */
public class ModelPelanggan {
    private int id;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    private PelangganListener listener;

    public PelangganListener getListener() {
        return listener;
    }

    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(pelanggan pelanggan) {
        if (listener != null) {
            listener.onInsert(pelanggan);
        }
    }

    protected void fireOnUpdate(pelanggan pelanggan) {
        if (listener != null) {
            listener.onUpdate(pelanggan);
        }
    }

    protected void fireOnDelete() {

        if (listener != null) {
            listener.onDelete();
        }
    }
     public void insertPelanggan() throws SQLException, PelangganException {
       pelangganDao dao = databaseBarbershop.getpelangganDao();

        pelanggan pelanggan = new pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);

        dao.insertPelanggan(pelanggan);
        fireOnInsert(pelanggan);

    }

    public void updatePelanggan() throws SQLException, PelangganException {
           pelangganDao dao = databaseBarbershop.getpelangganDao();

        pelanggan pelanggan = new pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        pelanggan.setId(id);

        dao.updatePelanggan(pelanggan);
        fireOnUpdate(pelanggan);
    }

    public void deletePelanggan() throws SQLException, PelangganException {
        
           pelangganDao dao = databaseBarbershop.getpelangganDao();
        dao.deletePelanggan(id);
        fireOnDelete();
    }
    
   
    public void resetPelanggan(){
        setId(0);
        setNama("");
        setAlamat("");
        setTelepon("");
        setEmail("");
    
    }
     
   }
    
    
