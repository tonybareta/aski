
package WS;

import com.google.gson.Gson;
import dao.ProdutoDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import modelo.Produto;

/**
 * REST Web Service
 *
 * @author santo
 */
@Path("Produto")
public class ProdutoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutoResource
     */
    public ProdutoResource() {
    }

    /**
     * Retrieves representation of an instance of WS.ProdutoResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON) //MediaType.APPLICATION_JSON
    //@Path("")
    public String getJson() {
        List<Produto> lista;
        ProdutoDAO dao = new ProdutoDAO();
        lista = dao.listar();
        //Converter para Json
        Gson g = new Gson();
        
        return g.toJson(lista); //"Meu primeiro webserver restfull!";
    }

    /**
     * PUT method for updating or creating an instance of ProdutoResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
