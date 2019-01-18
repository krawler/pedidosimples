package br.com.pedidosimples.controller;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import br.com.pedidosimples.dao.PedidoDao;
import br.com.pedidosimples.model.Pedido;
import br.com.pedidosimples.util.JsonUtil;

public class PedidoController {
	
	private static Logger logger = Logger.getLogger("Pedidocontroller");
	
	public List<Pedido> listarTodosPedidos(){		
		List<Pedido> pedidos = null;
		try{
			 pedidos = PedidoDao.getInstance().listarTodosPedidos();
			 if(pedidos.size() > 0){
				return pedidos;
			 }
		}catch(Exception e){
			return null;
		}
		
		
		return null;
	}
	
	//proxima alteracao metodo retornara string
	public boolean inserirPedidoDeJson(Pedido pedido) throws Exception{		
		
		pedido = this.aplicaRegrasPedido(pedido);				
		return PedidoDao.getInstance().salvarPedido(pedido);		
	}
	
	public boolean inserirPedidoDeXML(Pedido pedido){
		try{
		 	return PedidoDao.getInstance().salvarPedido(pedido);
		}catch(Exception e){
			return false;
		}
	}
	
	
	private Pedido aplicaRegrasPedido(Pedido pedido) throws Exception {
		
		if (null == pedido.getQuantidade() || pedido.getQuantidade() < 1){
			pedido.setQuantidade(1.0);
		}
		
		if(PedidoDao.getInstance().lista("numeroControle", pedido.getNumeroControle()).size() > 0){
		   return null;	
		}
		
		if (null == pedido.getDataCadastro()){
			pedido.setDataCadastro(Calendar.getInstance().getTime());
		}
		
		pedido.setValorTotal(pedido.getValor() * pedido.getQuantidade());
		
		//setar valor total
		//se quantidade > 5 desconto de 5% no total
		if(pedido.getQuantidade() > 5){
		   pedido.setValorTotal(pedido.getValorTotal() - ((pedido.getValorTotal()/100) * 5));	
		}
		//a partir de 10, desconto de 10% no total
		if(pedido.getQuantidade() >= 10){
		   pedido.setValorTotal(pedido.getValorTotal() - ((pedido.getValorTotal()/100) * 10));	
		}
		
		//codigo do cliente de 1 a 10, apos o metodo passar a retorna string exibir msg de erro
		if(pedido.getCodigoCliente() > 10 || pedido.getCodigoCliente() < 1){
		   return null;	
		}
		
		return pedido;
	}
	
	//proxima alteracao metodo retornara string
	public boolean atualizarPedidoDeJson(Pedido pedido) throws Exception{
			
		pedido = this.aplicaRegrasPedido(pedido);
		
		return PedidoDao.getInstance().atualizarPedido(pedido);		
	}
	

	public List<Pedido> listarTodosPedidos(Long numeroControle) {
		List<Pedido> pedidos = null;
		try{
			 pedidos = PedidoDao.getInstance().lista("numeroControle", numeroControle);
			 if(pedidos.size() > 0){
				return pedidos;
			 }
		}catch(Exception e){
			return null;
		}
		
		
		return null;
	}
	
	public List<Pedido> listarPedidosPorNumeroControle(Long numeroControle) {
		List<Pedido> pedidos = null;
		try{
			 pedidos = PedidoDao.getInstance().lista("numeroControle", numeroControle);
			 if(pedidos.size() > 0){
				return pedidos;
			 }
		}catch(Exception e){
			return null;
		}		
		return null;
	}

	public List<Pedido> listarPedidosPorDataCadastro(String dataCadastro) {
		List<Pedido> pedidos = null;
		try{
			 pedidos = PedidoDao.getInstance().listaPorData("dataCadastro", dataCadastro);
			 if(pedidos.size() > 0){
				return pedidos;
			 }
		}catch(Exception e){
			return null;
		}
		
		return null;
	}
	
	
}
