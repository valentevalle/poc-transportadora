package com.exemplo.sislog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tbl_CTE")
public class Cte {
	@Id
	private String numero;
	private Date data;
	private byte[] documento;
	
	public String getNumero() {
		return numero;
	}
	public Date getData() {
		return data;
	}
	public byte[] getDocumento() {
		return documento;
	}
	
	
}
