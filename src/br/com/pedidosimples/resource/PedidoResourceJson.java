package br.com.pedidosimples.resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.pedidosimples.controller.PedidoController;
import br.com.pedidosimples.json.JSONArray;
import br.com.pedidosimples.json.JSONException;
import br.com.pedidosimples.json.JSONObject;
import br.com.pedidosimples.model.Pedido;
import br.com.pedidosimples.util.JsonUtil;

@Path("/json")
public class PedidoResourceJson {
	
	@GET
	@Path("/pedidos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pedido> getAll(){
		return new PedidoController().listarTodosPedidos();
	}
	
    @POST
	@Path("/send")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
	public Response sendPedido(String json) throws ParseException{
    	List<Pedido> pedidos = JsonUtil.deserializeJsonToPedido(json);
    	try {
    		for (Pedido pedido : pedidos) {
    			new PedidoController().inserirPedidoDeJson(pedido);	
				   	
			}			
		} catch (Exception e) {			
			e.printStackTrace();
			return Response.status(200).entity("Erro ao inserir pedido: " + e.getMessage()).build();
		}
    
    	return Response.status(200).entity("Pedido inserido com sucesso").build();
	} 

}
