
package br.tec.devpoa.yieldmeter.dao;

import br.tec.devpoa.yieldmeter.connect.Connect;
import br.tec.devpoa.yieldmeter.model.Usuario;
import br.tec.devpoa.yieldmeter.utils.Session;
import java.sql.*;
import javax.swing.JOptionPane;



public class UsuarioDAO {
    
    private Connection con = Connect.getConnection();
    
    public UsuarioDAO()
    {
        
    }
    
    /**
     * Método que cadastra usuário
     * @param usuario 
     */
    public void registerUser(Usuario usuario)
    {
        String sql = "INSERT INTO TB_USUARIO "
                + "(nome, nome_usuario, senha, empresa) "
                + "VALUES (?, ?, ? , ?)";
        
        try(PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getNomeUsuario());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, "CANOASTEC" );
            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
        }
    }
    
    /**
     * Método que checa se usuário e senha estão cadastrados
     * @param userName
     * @param pass
     * @return 
     */
    public boolean checkLogin(String userName, String pass)
    {
        boolean check = false;
        
        String sql = "SELECT "
                + "nome_usuario, "
                + "senha "
                + "FROM "
                + "TB_USUARIO "
                + "WHERE "
                + "nome_usuario = ? "
                + "AND "
                + "senha = ?" ;
        
        if(!userName.isEmpty() && !pass.isEmpty())
        {
            try(PreparedStatement stmt = con.prepareStatement(sql))
            {
                stmt.setString(1, userName);
                stmt.setString(2, pass);

                ResultSet rs = stmt.executeQuery();
                if(rs.next())
                {
                    check = true;
                }
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0);
            }
        }
        return check;
    }
      
    public Usuario autenticar(Usuario usuarioLogado)
    {
        String sql = "SELECT "
                + "nome, "
                + "nome_usuario, "
                + "senha, "
                + "empresa "
                + "FROM TB_USUARIO "
                + "WHERE nome_usuario = ?"
                + "AND"
                + "senha = ?";
        
        try(PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setString(1, usuarioLogado.getNomeUsuario());
            stmt.setString(2, usuarioLogado.getSenha());
            
            ResultSet rs = stmt.executeQuery();
                if(rs.next())
                {
                    Usuario user = new Usuario();
                    
                    user.setIdUsuario(rs.getInt("ID_USUARIO"));
                    user.setNome(rs.getString("NOME"));
                    user.setNomeUsuario(rs.getString("NOME_USUARIO"));
                    
                    return user;
                }
        }
        catch(SQLException ex)
        {
            ex.getMessage();
        }
        return null;
    }
}
