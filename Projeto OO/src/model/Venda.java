package model;
import java.util.*;

public class Venda {
	private Integer id;
	private Date dataPedido;
	private Date dataEntrega;
	private double valor;
	private double valorTotal;
	private String tipoPagamento;
	private int qntdParcelas;
	private double valorParcela;
	private String descricao;
	private StatusVenda status;
	private static final double TAXA_PARCELA = 0.10;
	
	public Venda(Date dataPedido, Date dataEntrega, double valor, String tipoPagamento, int qntdParcelas,
			String descricao, int id) {
		super();
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.valor = valor;
		this.tipoPagamento = tipoPagamento;
		this.qntdParcelas = qntdParcelas;
		this.descricao = descricao;
		valorTotal = calcularValorTotal();
		valorParcela = calcularValorParcela();
		status = StatusVenda.PENDENTE;
		this.id = id;
		
	}
	
	public double calcularValorTotal() {
		if (qntdParcelas == 0) {
			return valor;
		}
		else {
			return valor + valor * TAXA_PARCELA;
		}
	}

	public double calcularValorParcela() {
		return (valor  + valor * TAXA_PARCELA) / qntdParcelas; 
	}
	
	public double calcularComissao() {
		
		return valor*0.02;
	}

	public int getId() {
		return id;
	}


	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getQntdParcelas() {
		return qntdParcelas;
	}

	public void setQntdParcelas(int qntdParcelas) {
		this.qntdParcelas = qntdParcelas;
	}

	public double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusVenda getStatus() {
		return status;
	}

	public void setStatus(StatusVenda status) {
		this.status = status;
	}


	
}





