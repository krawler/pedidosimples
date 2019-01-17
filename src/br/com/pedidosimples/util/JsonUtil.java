package br.com.pedidosimples.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.pedidosimples.dao.PedidoDao;
import br.com.pedidosimples.json.JSONArray;
import br.com.pedidosimples.json.JSONException;
import br.com.pedidosimples.json.JSONObject;
import br.com.pedidosimples.model.Pedido;

public class JsonUtil {
	
	public static List<Pedido> deserializeJsonToPedido(String json) throws ParseException{
		
		JSONObject joPedidos  = null;
		JSONArray jaArray = null;		
		List<Pedido> pedidos = new ArrayList<Pedido>(); 
		
		try {
			joPedidos = new JSONObject(json);
			if(joPedidos.has("pedidoes")){
				jaArray	   = joPedidos.getJSONArray("pedidoes");
				
				for (int i = 0; i < jaArray.length(); i++) {
					try{
						JSONObject jsonPedido = jaArray.getJSONObject(i);
						
						Pedido pedidoInserir = new Pedido();				
						pedidoInserir.setNumeroControle(Integer.parseInt(jsonPedido.get("numerocontrole").toString()));
						pedidoInserir.setDataCadastro(new SimpleDateFormat().parse(jsonPedido.get("datacadastro").toString()));
						pedidoInserir.setNomeProduto(jsonPedido.get("nomeproduto").toString());
						pedidoInserir.setQuantidade(Double.valueOf(jsonPedido.get("quantidade").toString()));
						pedidoInserir.setValor(Double.valueOf(jsonPedido.get("valor").toString()));
						
						//PedidoDao.getInstance().salvarPedido(pedidoInserir);
						pedidos.add(pedidoInserir);				
					}	
					catch (JSONException e) {
						e.printStackTrace();				
					} catch (ParseException e) {
						e.printStackTrace();				
					}catch(Exception e){
						e.printStackTrace();				
					}
				}
			}else{
				Pedido pedidoInserir = new Pedido();
				joPedidos = joPedidos.getJSONObject("pedido");
				pedidoInserir.setNumeroControle(Integer.parseInt(joPedidos.getString("numerocontrole").toString()));
				//pedidoInserir.setDataCadastro(new SimpleDateFormat().parse(joPedidos.get("datacadastro").toString()));
				pedidoInserir.setNomeProduto(joPedidos.get("nomeproduto").toString());
				pedidoInserir.setQuantidade(Double.valueOf(joPedidos.get("quantidade").toString()));
				pedidoInserir.setValor(Double.valueOf(joPedidos.get("valor").toString()));
				
				//PedidoDao.getInstance().salvarPedido(pedidoInserir);
				pedidos.add(pedidoInserir);
			}
		} catch (JSONException e) {
			e.printStackTrace();			
		}		
		
		return pedidos;		
	}

}
