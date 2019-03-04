package com.exemplo.sislog.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_CARGA")
public class Carga {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carga_seq")
	@SequenceGenerator(name = "carga_seq", sequenceName = "carga_seq", allocationSize = 1)
	private Long id;
	@Embedded
	private NotaFiscal notaFiscal;
	private String nomeProduto;
	private Double peso;
	private Long volumes;
	private Long altura;
	private Long largura;
	private Long comprimento;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoCarga tipoCarga;
	public String getNomeProduto() {
		return nomeProduto;
	}
	public Double getPeso() {
		return peso;
	}
	public Long getVolumes() {
		return volumes;
	}
	public Long getAltura() {
		return altura;
	}
	public Long getLargura() {
		return largura;
	}
	public Long getComprimento() {
		return comprimento;
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public TipoCarga getTipoCarga() {
		return tipoCarga;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public void setVolumes(Long volumes) {
		this.volumes = volumes;
	}
	public void setAltura(Long altura) {
		this.altura = altura;
	}
	public void setLargura(Long largura) {
		this.largura = largura;
	}
	public void setComprimento(Long comprimento) {
		this.comprimento = comprimento;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public void setTipoCarga(TipoCarga tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	
	
	
}
