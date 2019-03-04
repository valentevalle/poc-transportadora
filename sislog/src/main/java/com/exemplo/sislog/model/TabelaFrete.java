package com.exemplo.sislog.model;

import javax.persistence.Column;
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
@Table(name = "TBL_FRETE")
public class TabelaFrete {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "frete_seq")
	@SequenceGenerator(name = "frete_seq", sequenceName = "frete_seq", allocationSize = 1)
	private Long id;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoCarga tipoCarga;
	@NotNull
	@Enumerated(EnumType.STRING)
	private ModalTransporte modalTransporte;
	@NotNull
	private Double valor;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoCarga getTipoCarga() {
		return tipoCarga;
	}
	public void setTipoCarga(TipoCarga tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public ModalTransporte getModalTransporte() {
		return modalTransporte;
	}
	public void setModalTransporte(ModalTransporte modalTransporte) {
		this.modalTransporte = modalTransporte;
	}
	
}
