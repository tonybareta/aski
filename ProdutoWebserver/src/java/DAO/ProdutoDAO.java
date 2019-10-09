
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Produto;

/**
 *
 * @author tony bareta
 */
public class ProdutoDAO {
   
    
    public ProdutoDAO()
    {
    
    }
    
    public List<Produto> listar()
    {
         String sql = "SELECT * FROM produto";
        List<Produto> retorno = new ArrayList<Produto>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Produto item = new Produto();
                item.setcodProduto(res.getInt("codProduto"));
                item.setdesProduto(res.getString("desProduto"));
                item.setvalProduto(res.getDouble("valProduto"));

                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    public Produto buscar(Produto produto)
    {
        String sql = "SELECT * FROM produto where codProduto=?";
        Produto retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setInt(1, produto.getcodProduto());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Produto();
                retorno.setcodProduto(res.getInt("codProduto"));
                retorno.setdesProduto(res.getString("desProduto"));
                retorno.setvalProduto(res.getDouble("valProduto"));
                
                
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }


}
