package br.com.pedidosimples.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SessaoRFID {
	
	private Integer codigo;
	private Date dataHora;
	private Integer codEmpresa;	
	
	public SessaoRFID() {
		super();
	}
	
	public SessaoRFID(Integer codigo, Date dataHora, Integer codEmpresa) {
		super();
		this.codigo = codigo;
		this.dataHora = dataHora;
		this.codEmpresa = codEmpresa;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	@Override
	public String toString() {
		return "SessaoRFID [codigo=" + codigo + ", dataHora=" + dataHora + ", codEmpresa=" + codEmpresa + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codEmpresa == null) ? 0 : codEmpresa.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessaoRFID other = (SessaoRFID) obj;
		if (codEmpresa == null) {
			if (other.codEmpresa != null)
				return false;
		} else if (!codEmpresa.equals(other.codEmpresa))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		return true;
	}
	

}
