package br.com.pedidosimples.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RFIDAcessorio {
	
	private String tag01; //Tag01
	private String tag02; //Tag02
	private Integer produto; // Produto
	private String descricao;
	
	public RFIDAcessorio() {
		super();
	}
	public RFIDAcessorio(String tag01, String tag02, Integer produto,
			String descricao) {
		super();
		this.tag01 = tag01;
		this.tag02 = tag02;
		this.produto = produto;
		this.descricao = descricao;
	}
	public String getTag01() {
		return tag01;
	}
	public void setTag01(String tag01) {
		this.tag01 = tag01;
	}
	public String getTag02() {
		return tag02;
	}
	public void setTag02(String tag02) {
		this.tag02 = tag02;
	}
	public Integer getProduto() {
		return produto;
	}
	public void setProduto(Integer produto) {
		this.produto = produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
