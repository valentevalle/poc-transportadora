package com.exemplo.sislog.model;

public class Trajeto {

	private Endereco enderecoOrigem;
	private Endereco enderecoDestino;

	public Endereco getEnderecoOrigem() {
		return enderecoOrigem;
	}

	public void setEnderecoOrigem(Endereco enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}

	public Endereco getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(Endereco enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}
	public String getEnderecoOrigemDestino() {
		
		if ((this.enderecoOrigem!=null) && (this.enderecoDestino!=null)) {
			StringBuilder sb = new StringBuilder("?");
			sb.append("origins="+this.getEnderecoOrigem().getEnderecoSimplificado()+"&");
			sb.append("destinations="+this.getEnderecoDestino().getEnderecoSimplificado());
			return sb.toString();
		}else {
			return "";
		}
	}
}
