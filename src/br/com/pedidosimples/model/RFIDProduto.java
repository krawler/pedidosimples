package br.com.pedidosimples.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RFIDProduto {
	
	private String tag;
	private Integer codigo;
	private String produto;
	private Double Estoque;
	private String imei;
	
	public RFIDProduto() {
	}

	public RFIDProduto(String tag, Integer codigo, String produto, Double estoque, String imei) {
		super();
		this.tag = tag;
		this.codigo = codigo;
		this.produto = produto;
		this.Estoque = estoque;		
		this.imei = (null == imei ? "" : imei);
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getEstoque() {
		return Estoque;
	}

	public void setEstoque(Double estoque) {
		Estoque = estoque;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}	

}
