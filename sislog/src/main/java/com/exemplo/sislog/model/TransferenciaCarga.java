package com.exemplo.sislog.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_TRANSFERENCIA")
public class TransferenciaCarga {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transferencia_seq")
	@SequenceGenerator(name = "transferencia_seq", sequenceName = "transferencia_seq", allocationSize = 1)
	private Long id;
	private Date data;
	private String nomeTransportadora;
	
	public Long getId() {
		return id;
	}
	public Date getData() {
		return data;
	}
	public String getNomeTransportadora() {
		return nomeTransportadora;
	}
	
	
}
