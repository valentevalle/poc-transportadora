package com.exemplo.sislog.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//@Entity
//@Table(name = "TBL_ENDERECO")
@Embeddable
public class Endereco {
/*	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
	@SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_seq", allocationSize = 1)
	private Integer id;*/
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String estado;
	private String cidade;


	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEnderecoSimplificado() {
		return (logradouro != null ? logradouro : "") + (numero != null ? ", " + numero : "")
				+ (bairro != null ? "-" + bairro : "") + (cep != null ? "-" + cep : "")
				+ (cidade != null ? "-" + cidade : "") + (estado != null ? "-" + estado : "");
	}
	/*
	 * public static void main(String[] args) { Endereco e = new Endereco();
	 * e.setLogradouro("Rua amapa"); e.setBairro("meier"); e.setCep("20770-130");
	 * e.setCidade("Rio de janeiro"); e.setEstado("rio de janeiro");
	 * e.setNumero("162"); System.out.println(e.getEnderecoSimplificado()); }
	 */
}
