package service;

import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Carta;
import repository.CartaRepository;

@Path("/carta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartaService {

	@EJB
	private CartaRepository cartaRepository;

	@GET
	@Path("/{id}")
	public Response consultar(@PathParam("id") int id) {
		return Response.ok().entity(this.cartaRepository.consultar(id)).build();
	}

	@GET
	public Response pesquisar() {
		return Response.ok().entity(this.cartaRepository.pesquisarTodos()).build();
	}

	@POST
	public Response cadastrar(Carta carta) {
		return Response.ok().entity(this.cartaRepository.inserir(carta)).build();
	}

	@PUT
	public Response atualizar(Carta carta) {
		this.cartaRepository.atualizar(carta);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") int id) throws Exception {
		this.cartaRepository.remover(id);
		return Response.ok().build();
	}

}
