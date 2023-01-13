package model;

import java.util.*;

import models.Store;

public class Loja {
	private static String nome;
	private static String endereco;
	private static String telefone;
	private int qntdFuncionarios;
	private double faturamento;
	private ArrayList<Cliente> clientes;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Gerente> gerentes;
	private ArrayList<Automovel> automoveis;
	private ArrayList<Venda> vendas;
	
	private static Loja instance = null;
	
	public static Loja getInstance() {
		if (instance == null) {
			instance = new Loja();
			instance.clientes = new ArrayList<Cliente>();
			instance.vendedores = new ArrayList<Vendedor>();
			instance.gerentes = new ArrayList<Gerente>();
			instance.automoveis = new ArrayList<Automovel>();
			instance.vendas = new ArrayList<Venda>();
			
			Loja.setNome("Concessionaria FGLADA");
			Loja.setEndereco("Avenida Abada Ferreira numero 420");
			Loja.setTelefone("4002-8922");
		}
		return instance;
	}
	
	public void calcularQntdFuncionarios() {
		this.qntdFuncionarios = vendedores.size() + gerentes.size();
	}
	
	// não ta pronto
	public void calcularFaturamento() {
		double faturamento = 0 ;
		for (int i = 0; i < vendas.size(); i++) {
			faturamento += vendas[i].valorTotal - vendas[i].comissao;
			
		}
		this.faturamento = faturamento;
	}

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		Loja.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public static void setEndereco(String endereco) {
		Loja.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public static void setTelefone(String telefone) {
		Loja.telefone = telefone;
	}

	public int getQntdFuncionarios() {
		return qntdFuncionarios;
	}

	public void setQntdFuncionarios(int qntdFuncionarios) {
		this.qntdFuncionarios = qntdFuncionarios;
	}

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(float faturamento) {
		this.faturamento = faturamento;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(ArrayList<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public ArrayList<Gerente> getGerentes() {
		return gerentes;
	}

	public void setGerentes(ArrayList<Gerente> gerentes) {
		this.gerentes = gerentes;
	}

	public ArrayList<Automovel> getAutomoveis() {
		return automoveis;
	}

	public void setAutomoveis(ArrayList<Automovel> automoveis) {
		this.automoveis = automoveis;
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}

	public static void setInstance(Loja instance) {
		Loja.instance = instance;
	}
	
}
