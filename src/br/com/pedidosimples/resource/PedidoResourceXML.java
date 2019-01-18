package br.com.pedidosimples.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Path("/pedidos/numero-controle/{numeroControle}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Pedido> getPedidosByNumeroControle(@PathParam("numeroControle") Long numeroControle){
		return new PedidoController().listarPedidosPorNumeroControle(numeroControle);
	}
	
	@GET
	@Path("/pedidos/data-cadastro/{dataCadastro}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Pedido> getPedidosByDataCadastro(@PathParam("dataCadastro") String dataCadastro){
		return new PedidoController().listarPedidosByDataCadastro(dataCadastro);
	}
	
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public Response sendPedido(Pedido pedido) {
		if(new PedidoController().inserirPedidoDeXML(pedido)) {
			return Response.status(200).entity(pedido.toString()).build();	
		}
		return Response.status(200).entity("Erro ao inserir pedido").build();		
	}	
	

}
