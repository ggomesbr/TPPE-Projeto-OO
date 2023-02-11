package model;

import java.util.*;

public class FolhaPagamento {
	public Date dataPagamento;
	public Date horaPagamento;
	public float valorBruto;
	public float descontoSalario;
	public float valorLiquido;

	public FolhaPagamento(Date dataPagamento, Date horaPagamento, float valorBruto, float descontoSalario) {
		super();
		this.dataPagamento = dataPagamento;
		this.horaPagamento = horaPagamento;
		this.valorBruto = valorBruto;
		this.descontoSalario = descontoSalario;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getHoraPagamento() {
		return horaPagamento;
	}

	public void setHoraPagamento(Date horaPagamento) {
		this.horaPagamento = horaPagamento;
	}

	public float getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(float valorBruto) {
		this.valorBruto = valorBruto;
	}

	public float getDescontoSalario() {
		return descontoSalario;
	}

	public void setDescontoSalario(float descontoSalario) {
		this.descontoSalario = descontoSalario;
	}

	public float calcularSalarioLiquido(float valorBruto, float valorLiquido, float comissao, float descontoSalario) {
		valorLiquido = (valorBruto + comissao) - descontoSalario;
		return valorLiquido;
	}

}
