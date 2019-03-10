package com.exemplo.sislog.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Embeddable
public class NotaFiscal {

	private String numeroNotaFiscal;
	@Temporal(TemporalType.DATE)
	private Date dataEmissao;
	//private byte [] documento;
	public String getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}
	public void setNumeroNotaFiscal(String numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
//	public byte[] getDocumento() {
//		return documento;
//	}
//	public void setDocumento(byte[] documento) {
//		this.documento = documento;
//	}
	
	
}
