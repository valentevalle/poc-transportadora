package com.exemplo.sislog.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "TBL_PEDIDO")
public class Pedido {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
	@SequenceGenerator(name = "pedido_seq", sequenceName = "pedido_seq", allocationSize = 1)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date data;
//	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=false)
//	@JoinColumn(name ="empresa_coleta_cnpj" )
	@ManyToOne
	@JoinColumn(name = "empresa_coleta_cnpj")
	private Empresa empresaColeta;
//	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY,optional=false)
//	@JoinColumn(name ="empresa_entrega_cnpj" )
	@ManyToOne
	@JoinColumn(name = "empresa_entrega_cnpj")
	private Empresa empresaEntrega;
	private Double total;
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "pedido_id")
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER, optional=true)
	private Carga carga;
	@OneToOne(optional=true)
	private TransferenciaCarga transferenciaCarga;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=true)
	private Cte cte;
	@NotNull
	@Enumerated(EnumType.STRING)
	private ModalTransporte modalTransporte;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=true)
	private Expedicao expedicao;
	@OneToMany(orphanRemoval=true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "pedido_id")
	private List<Evento> eventos;
	
	public Carga getCarga() {
		return carga;
	}
	public void setCarga(Carga carga) {
		this.carga = carga;
	}
	public Long getId() {
		return id;
	}
	public Date getData() {
		return data;
	}
	public Empresa getEmpresaColeta() {
		return empresaColeta;
	}
	public Empresa getEmpresaEntrega() {
		return empresaEntrega;
	}
	public Double getTotal() {
		return total;
	}
	
	public TransferenciaCarga getTransferenciaCarga() {
		return transferenciaCarga;
	}
	public Cte getCte() {
		return cte;
	}
	public ModalTransporte getModalTransporte() {
		return modalTransporte;
	}
	public void setModalTransporte(ModalTransporte modalTransporte) {
		this.modalTransporte = modalTransporte;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setEmpresaColeta(Empresa empresaColeta) {
		this.empresaColeta = empresaColeta;
	}
	public void setEmpresaEntrega(Empresa empresaEntrega) {
		this.empresaEntrega = empresaEntrega;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public void setTransferenciaCarga(TransferenciaCarga transferenciaCarga) {
		this.transferenciaCarga = transferenciaCarga;
	}
	public void setCte(Cte cte) {
		this.cte = cte;
	}
	public Expedicao getExpedicao() {
		return expedicao;
	}
	public void setExpedicao(Expedicao expedicao) {
		this.expedicao = expedicao;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	
}
