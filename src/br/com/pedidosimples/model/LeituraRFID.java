package br.com.pedidosimples.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class LeituraRFID {
	
	private Integer id;
	private String codigoLeitura;
	private Integer codigoSessao;	
	private Date dataHora;
	private Integer codEmpresa;
	private Integer codProd;
	private Integer nroNota;
	
	public LeituraRFID(){
		
	}
	
	public LeituraRFID(Integer id, String codigoLeitura, Integer codigoSessao,
			Date dataHora, Integer codEmpresa, Integer codProd) {
		super();
		this.id = id;
		this.codigoLeitura = codigoLeitura;
		this.codigoSessao = codigoSessao;
		this.dataHora = dataHora;
		this.codEmpresa = codEmpresa;
		this.codProd = codProd;
	}
	
	public LeituraRFID(Integer id, String codigoLeitura, Integer codigoSessao,
			Date dataHora, Integer codEmpresa, Integer codProd, Integer nroNota) {
		super();
		this.id = id;
		this.codigoLeitura = codigoLeitura;
		this.codigoSessao = codigoSessao;
		this.dataHora = dataHora;
		this.codEmpresa = codEmpresa;
		this.codProd = codProd;
		this.nroNota = nroNota;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigoLeitura() {
		return codigoLeitura;
	}
	public void setCodigoLeitura(String codigoLeitura) {
		this.codigoLeitura = codigoLeitura;
	}
	public Integer getCodigoSessao() {
		return codigoSessao;
	}
	public void setCodigoSessao(Integer codigoSessao) {
		this.codigoSessao = codigoSessao;
	}
	
	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(Integer codEmpresa) {
		this.codEmpresa = codEmpresa;
	}	
	
	public Integer getCodProd() {
		return codProd;
	}

	public void setCodProd(Integer codProd) {
		this.codProd = codProd;
	}	

	public Integer getNroNota() {
		return nroNota;
	}

	public void setNroNota(Integer nroNota) {
		this.nroNota = nroNota;
	}

	@Override
	public String toString() {
		return "LeituraRFID [id=" + id + ", codigoLeitura=" + codigoLeitura
				+ ", codigoSessao=" + codigoSessao + "]";
	}

}
