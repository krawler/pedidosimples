package br.com.pedidosimples.dao;

import java.util.List;

import br.com.pedidosimples.model.Pedido;

public class PedidoDao extends DaoImplementacao<Pedido> implements DaoInterface<Pedido> {

	private static PedidoDao pedidoDaoInstance;
	
	public PedidoDao(Class<Pedido> persistenceClass) {
		super(persistenceClass);		
	}
			
	public static PedidoDao getInstance(){
		if(pedidoDaoInstance == null){
			pedidoDaoInstance = new PedidoDao(Pedido.class);
		}
		
		return pedidoDaoInstance;
	}
	
	public boolean salvarPedido(Pedido pedido){
		try{
			super.salvarOuAtualizar(pedido);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean atualizarPedido(Pedido pedido){
		try{
			super.atualizar(pedido);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public List<Pedido> listarTodosPedidos() throws Exception{
		return super.lista();
	}

}
