
package br.tec.devpoa.yieldmeter.utils;

import br.tec.devpoa.yieldmeter.model.Usuario;


public class Session 
{
    private static Session instance = null;
    private Usuario usuario;
    
    private Session()
    {
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public static Session getInstance()
    {
        if(instance == null)
        {
            instance = new Session();
        }
        return instance;
    }
    
}
