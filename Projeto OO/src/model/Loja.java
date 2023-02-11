package model;

import java.util.*;

import javax.swing.text.html.HTMLEditorKit.Parser;

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
	private ArrayList<Modelo> modelos;

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
			instance.modelos = new ArrayList<Modelo>();

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
	/*
	 * public void calcularFaturamento() { double faturamento = 0 ; for (int i = 0;
	 * i < vendas.size(); i++) { faturamento += vendas.get(i).getValorTotal() -
	 * vendas.get(i).getComissao();
	 * 
	 * } this.faturamento = faturamento; }
	 */

	public static void preencherDatabase() {
		// instance.admins.add(new Admin("admin", "admin@admin.com", "admin"));
		// instance.vendedores.add(new Admin(email, endereco, cidade,estado, cep,
		// bairro, nome, login, senha, valorVendas, totalComissao));

		instance.vendedores.add(new Vendedor("emmanuelbarros@gmail.com", "rua dos bobos numero 0", "gurupi","TO", "77400000","centro", "Emmanuel Barros","123", 0,0,"61xxxxxxxx"));
		instance.administradores.add(new Administrador("anamelo@gmail.com", "rua dos bobos numero 0", "gama city", "DF",
				"77400000", "Ponte alta", "Ana Melo", "123", "61xxxxxxxxxx"));

		// instancia marcas
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

		instance.modelos.add(new Modelo("corsa", TipoVeiculo.CARRO, instance.marcas.get(0)));

		for (Marca marca : instance.marcas) {
			for (int i = 0; i < 2; i++) {
				instance.automoveis.add(new Automovel(Cor.Preto, 4, "Gasolina", UUID.randomUUID().toString(),
						(20000 * (i + 1)), "2023", instance.modelos.get(0), marca));
			}
		}

		for (int index = 0; index < 15; index++) {
			instance.clientes.add(new Cliente("@gmail.com", "rua dos bobos numero 0", "gama city",
					"DF", "77400000", "Ponte alta", index, "123", "61xxxxxxxxxx"));
		
		}
		
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

	public void setMarcas(ArrayList<Marca> marcas) {
		this.marcas = marcas;
	}

	public ArrayList<Marca> getMarcas() {
		return marcas;
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

	public ArrayList<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(ArrayList<Modelo> modelos) {
		this.modelos = modelos;
	}

}
