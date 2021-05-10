
package br.tec.devpoa.yieldmeter.utils;

import javax.swing.JOptionPane;


public class Validator {
    
    public static boolean isValidPassword(String pass)
    {
        if(pass.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Senha não pode ser vazia", "Erro", 0);
            return false;
        }
        
        if(pass.length() < 6)
        {
            JOptionPane.showMessageDialog(null, "Senha não pode possuir menos de 6 caracteres", "Erro", 0);
            return false;
        }
        return true;
    }
}
