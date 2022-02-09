/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JOptionPane;

/**
 *
 * @author higor_x
 */
public class DespesaException extends RuntimeException{
    
    private static final long serialVersionUID=1L;
    
    public DespesaException(String msg){
        super(msg);
        JOptionPane.showMessageDialog(null,msg);
    }
    
}
