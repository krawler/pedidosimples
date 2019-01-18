package br.com.pedidosimples.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement(name = "pedido")
@Entity
public class Pedido implements Serializable {		
	
	private static final long serialVersionUID = -1843793362511457003L;

	public Pedido() {
		super();	
	}

	public Pedido(long numeroControle, Date dataCadastro, String nomeProduto, Double valor, Double quantidade,
			Integer codigoCliente, Double valorTotal) {
		super();
		this.numeroControle = numeroControle;
		this.dataCadastro = dataCadastro;
		this.nomeProduto = nomeProduto;
		this.valor = valor;
		this.quantidade = quantidade;
		this.codigoCliente = codigoCliente;
		this.valorTotal = valorTotal;
	}

	@Id
	private long numeroControle;
	
	@Temporal(TemporalType.DATE)
	private Date dataCadastro = Calendar.getInstance().getTime();
	
	private String nomeProduto;
	
	private Double valor;
	
	private Double quantidade;
	
	private Integer codigoCliente;
	
	private Double valorTotal;

	
	public long getNumeroControle() {
		return numeroControle;
	}
	
	@XmlAttribute
	public void setNumeroControle(long numeroControle) {
		this.numeroControle = numeroControle;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	@XmlElement
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	@XmlElement
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValor() {
		return valor;
	}

	@XmlElement
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	@XmlElement
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}
	
	@XmlElement
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}

	@XmlElement
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
