/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_adisri_jdbc.dao.mvc.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import tugas_adisri_jdbc.dao.mvc.entity.pelanggan;

/**
 *
 * @author yustitia arofa
 */
public class TableModelPelanggan extends AbstractTableModel{
     private List<pelanggan> list = new ArrayList<pelanggan>();

    public void setList(List<pelanggan> list) {
        this.list = list;
    }
     

    @Override
    public int getRowCount() {
        return list.size();
   

    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    public boolean add(pelanggan e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public pelanggan get(int i) {
        return list.get(i);
    }

    public pelanggan set(int index, pelanggan element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public pelanggan remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NAMA";
            case 2:
                return "ALAMAT";
            case 3:
                return "TELEPON";
            case 4:
                return "EMAIL";
            default:
                return null;
        }
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getAlamat();
            case 3:
                return list.get(rowIndex).getTelepon();
            case 4:
                return list.get(rowIndex).getEmail();
            default:
                return null;
        }
    }

    
}
