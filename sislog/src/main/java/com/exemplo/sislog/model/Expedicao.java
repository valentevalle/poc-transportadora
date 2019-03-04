package com.exemplo.sislog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_EXPEDICAO")
public class Expedicao {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expedicao_seq")
	@SequenceGenerator(name = "expedicao_seq", sequenceName = "expedicao_seq", allocationSize = 1)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date data;
	private String cnhMotorista;
	private String placaVeiculo;

	public Long getId() {
		return id;
	}

	public Date getData() {
		return data;
	}

	public String getCnhMotorista() {
		return cnhMotorista;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

}
