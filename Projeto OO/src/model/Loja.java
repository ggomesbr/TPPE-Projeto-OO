package model;

import java.util.*;

import models.Address;
import models.Client;
import models.Payment;
import models.Product;
import models.Store;

public class Loja {
	private static String nome;
	private static String endereco;
	private static String telefone;
	private int qntdFuncionarios;
	private double faturamento;
	private ArrayList<Cliente> clientes;
	private ArrayList<Vendedor> vendedores;
	private ArrayList<Administrador> administradores;
	private ArrayList<Automovel> automoveis;
	private ArrayList<Venda> vendas;
	private ArrayList<Marca> marcas;
	
	private static Loja instance = null;
	
	public static Loja getInstance() {
		if (instance == null) {
			instance = new Loja();
			instance.clientes = new ArrayList<Cliente>();
			instance.vendedores = new ArrayList<Vendedor>();
			instance.administradores = new ArrayList<Administrador>();
			instance.automoveis = new ArrayList<Automovel>();
			instance.vendas = new ArrayList<Venda>();
			instance.marcas = new ArrayList<Marca>();
			
			Loja.setNome("Concessionaria FGLADA");
			Loja.setEndereco("Avenida Abada Ferreira numero 420");
			Loja.setTelefone("4002-8922");
		}
		return instance;
	}
	
	public void calcularQntdFuncionarios() {
		this.qntdFuncionarios = vendedores.size() + administradores.size();
	}
	
	// não ta pronto
	public void calcularFaturamento() {
		double faturamento = 0 ;
		for (int i = 0; i < vendas.size(); i++) {
			faturamento += vendas.get(i).getValorTotal() - vendas.get(i).getComissao();
			
		}
		this.faturamento = faturamento;
	}

	  public static void preencherDatabase() {
		    // instance.admins.add(new Admin("admin", "admin@admin.com", "admin"));
		  	// instance.vendedores.add(new Admin(email, endereco, cidade,estado, cep, bairro, nome, login, senha, valorVendas, totalComissao));
		   
		      instance.vendedores.add(new Vendedor("t", "endereco", "cidade","estado", "cep","bairro", "t","t", 0,0));
		      instance.administradores.add(new Administrador("anamelo@gmail.com","rua dos bobos numero 0","gama city","DF","77400000","Ponte alta","Ana Melo","123"));
		      
		      
		      //instancia marcas
		      instance.marcas.add(new Marca("Toyota"));
		      instance.marcas.add(new Marca("Volkswagen"));
		      instance.marcas.add(new Marca("Mercedes-Benz"));
		      instance.marcas.add(new Marca("Ford"));
		      instance.marcas.add(new Marca("BMW"));
		      instance.marcas.add(new Marca("General Motors"));
		      instance.marcas.add(new Marca("Stellantis"));
		      instance.marcas.add(new Marca("Honda"));
		      instance.marcas.add(new Marca("Mitsubishi"));
		      instance.marcas.add(new Marca("Hyundai"));
		      
		      
	  }

	public static String getNome() {
		return nome;
	}

	public static void setNome(String nome) {
		Loja.nome = nome;
	}

	public static String getEndereco() {
		return endereco;
	}

	public static void setEndereco(String endereco) {
		Loja.endereco = endereco;
	}

	public static String getTelefone() {
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

	public void setFaturamento(double faturamento) {
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

	public ArrayList<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(ArrayList<Administrador> administrador) {
		this.administradores = administrador;
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
