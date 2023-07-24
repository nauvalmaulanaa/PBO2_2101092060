/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_b.controller;

import uts_b.dao.PenjualanDao;
import uts_b.dao.PenjualanDaoImpl;
import uts_b.dao.Koneksi;
import uts_b.model.Penjualan;
import uts_b.view.FormPenjualan;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nauval
 */
public class PenjualanController {
    private FormPenjualan FormPenjualan;
    private Penjualan penjualan;
    private PenjualanDao PenjualanDao;
    private Connection con;
    private Koneksi koneksi;
    
    
    public PenjualanController(FormPenjualan FormPenjualan) {
        try {
            this.FormPenjualan = FormPenjualan;
            PenjualanDao = (PenjualanDao) new PenjualanDaoImpl();
            con = new Koneksi().getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        FormPenjualan.getTxtKode_pesanan().setText("");
        FormPenjualan.getTxtTanggal().setText("");
        FormPenjualan.getTxtNama_pemesan().setText("");
        FormPenjualan.getTxtTotal_bayar().setText("");
        FormPenjualan.getTxtOngkir().setText("");
        FormPenjualan.getTxtDiskon().setText("");
    }
    
    public void insert(){
        try {
            penjualan = new Penjualan();
            penjualan.setKode_pesanan(FormPenjualan.getTxtKode_pesanan().getText());
            penjualan.setTanggal(
                    FormPenjualan.getTxtTanggal().getText());
            penjualan.setNama_pemesan(
                    FormPenjualan.getTxtNama_pemesan().getText());
            penjualan.setTxtTotal_bayar(
                    FormPenjualan.getTxtTotal_bayar().getText());
            penjualan.setOngkir(
                    FormPenjualan.getTxtOngkir().getText());
            penjualan.setDiskon(
                    FormPenjualan.getTxtDiskon().getText());
           
            PenjualanDao.insert(con,penjualan);
            JOptionPane.showMessageDialog(FormPenjualan, "Entri Ok");
        } catch (Exception ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
   
   
   public void update(){
       
        try {
            penjualan = new Penjualan();
            penjualan.setKodePesanan(FormPenjualan.getTxtKode_pesanan().getText());
            penjualan.setTanggal(
                    FormPenjualan.getTxtTanggal().getText());
            penjualan.setNama_pemesan(
                    FormPenjualan.getNama_pemesan().getText());
            penjualan.setTotal_bayar(
                    FormPenjualan.getTxtTotal_bayar().getText());
            penjualan.setOngkir(
                    FormPenjualan.getTxtOngkir().getText());
            penjualan.setDiskon(
                    FormPenjualan.getTxtDiskon().getText());
            PenjualanDao.update(con,penjualan);
            JOptionPane.showMessageDialog(FormPenjualan, "Update Ok");
        } catch (Exception ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
   public void delete(){
     
        try {
            PenjualanDao.delete(con, penjualan);
            JOptionPane.showMessageDialog(FormPenjualan, "Delete Ok");
        } catch (Exception ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
   
   
   public void tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) FormPenjualan.getTblPenjualan().getModel();
            tabel.setRowCount(0);
            List<Penjualan> list = PenjualanDao.getAllPenjualan(con);
            for (Penjualan penjualan1 : list) {
                Object[] row = {
                    penjualan1.getKode_pesanan(),
                    penjualan1.getTanggal(),
                    penjualan1.getNama_pemesan(),
                    penjualan1.getTotal_bayar(),
                    penjualan1.getOngkir(),
                    penjualan1.getDiskon(),
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PenjualanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


