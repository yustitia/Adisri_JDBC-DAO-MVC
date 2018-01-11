 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_adisri_jdbc.dao.mvc.event;

import tugas_adisri_jdbc.dao.mvc.entity.pelanggan;
import tugas_adisri_jdbc.dao.mvc.model.ModelPelanggan;

/**
 *
 * @author yustitia arofa
 */
public interface PelangganListener {
  
    
    

    public void onChange(ModelPelanggan model);

    public void onInsert(pelanggan pelanggan);

    public void onUpdate(pelanggan pelanggan);

    public void onDelete();

    
   

   
}
