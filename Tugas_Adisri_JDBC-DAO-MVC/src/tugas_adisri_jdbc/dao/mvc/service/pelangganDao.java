/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_adisri_jdbc.dao.mvc.service;

import java.util.List;
import tugas_adisri_jdbc.dao.mvc.entity.pelanggan;
import tugas_adisri_jdbc.dao.mvc.error.PelangganException;

/**
 *
 * @author yustitia arofa
 */
public interface pelangganDao {
 public void insertPelanggan (pelanggan pelanggan) throws PelangganException;
 public void updatePelanggan (pelanggan pelanggan) throws PelangganException;
 public void deletePelanggan (int id) throws PelangganException;
 public pelanggan getPelanggan (int id) throws PelangganException;
  public pelanggan getPelanggan (String email) throws PelangganException;
 public List<pelanggan> selectAllPelanggan() throws PelangganException;
}
