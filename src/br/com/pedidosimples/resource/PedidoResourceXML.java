package br.com.pedidosimples.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.pedidosimples.controller.PedidoController;
import br.com.pedidosimples.model.Pedido;

@Path("/xml")
public class PedidoResourceXML {
	
	@GET
	@Path("/pedidos")
	@Produces(MediaType.APPLICATION_XML)
	public List<Pedido> getAll(){
		return new PedidoController().listarTodosPedidos();
	}
	
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_XML)
	public Response sendPedido(Pedido pedido) {
		return Response.status(200).entity(pedido.toString()).build();		
	}
	
	

}
