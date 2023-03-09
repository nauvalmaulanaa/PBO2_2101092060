/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PBO2_2101092060;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nauval.dao.Koneksi;

/**
 *
 * @author Nauval
 */
public class PBO2_2101092060 {
    public static void main(String[]args) {
        try {
            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getKoneksi();
            JOptionPane.showMessageDialog(null, "Koneksi Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex.getMessage());
            Logger.getLogger(PBO2_2101092060.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
