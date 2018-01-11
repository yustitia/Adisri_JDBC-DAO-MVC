/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_adisri_jdbc.dao.mvc.controller;

import javax.swing.JOptionPane;
import tugas_adisri_jdbc.dao.mvc.model.ModelPelanggan;
import tugas_adisri_jdbc.dao.mvc.view.ViewPelanggan;

/**
 *
 * @author yustitia arofa
 */
public class pelangganController {
    private  ModelPelanggan model;

    public void setModel(ModelPelanggan model) {
        this.model = model;
    }
    public void resetPelanggan(ViewPelanggan view) {
       model.resetPelanggan();

    }

    public void insertPelanggan(ViewPelanggan view) {
        String nama = view.getTxtnama().getText();
        String alamat = view.getTxtalamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtemail().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Masih Kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama Depan tak boleh lebih dari 255");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Number telepon tak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Ditambahkan");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void updatePelanggan(ViewPelanggan view) {

        
        if (view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }

        Integer id = Integer.parseInt(view.getTxtId().getText());

        String nama = view.getTxtnama().getText();
        String alamat = view.getTxtalamat().getText();
        String telepon = view.getTxtTelepon().getText();
        String email = view.getTxtemail().getText();

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Masih Kosong");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama Depan tak boleh lebih dari 255");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Number telepon tak boleh lebih dari 12 digit");
        } else if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        } else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Di Ubah");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void deletePelanggan(ViewPelanggan view) {

      
        if (view.getTablePelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {

            Integer id = Integer.parseInt(view.getTxtId().getText());
            model.setId(id);

            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Di Hapus");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

   
}
