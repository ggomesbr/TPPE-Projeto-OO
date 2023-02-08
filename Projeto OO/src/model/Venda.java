package model;
import java.util.*;

public class Venda {
	private Date dataPedido;
	private Date dataEntrega;
	private double valorTotal;
	private String tipoPagamento;
	private int qntdParcelas;
	private String descricao;
	private StatusVenda status;
	private static final double TAXA_PARCELA = 0.10;
	
	public Venda(Date dataPedido, Date dataEntrega, double valorTotal, String tipoPagamento, int qntdParcelas,
			String descricao) {
		super();
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.valorTotal = valorTotal;
		this.tipoPagamento = tipoPagamento;
		this.qntdParcelas = qntdParcelas;
		this.descricao = descricao;
		status = StatusVenda.PENDENTE;
		
	}
	
	public double calcularValorTotal() {
		if (qntdParcelas == 0) {
			return valorTotal;
		}
		else {
			return 0;
		}
	}

	public double calcularValorParcela() {
		return (valorTotal  + valorTotal * TAXA_PARCELA) / qntdParcelas; 
	}
	
	public double calcularComissao() {
		return 0;
	}


	
}





