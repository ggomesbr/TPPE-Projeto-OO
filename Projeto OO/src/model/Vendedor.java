package model;
import java.util.*;
public class Vendedor extends Usuario {

	private float valorVendas;
	private float totalComissao;
	private ArrayList<Venda> vendas;
	
	
	public Vendedor(String email, String endereco, String cidade, String estado, String cep, String bairro, String nome,
			String login, String senha, float valorVendas, float totalComissao) {
		super(email, endereco, cidade, estado, cep, bairro, nome, senha);
		this.valorVendas = valorVendas;
		this.totalComissao = totalComissao;
	}
	
	public Vendedor(String email, String endereco, String cidade, String estado, String cep, String bairro, String nome,
			String login, String senha) {
		super(email, endereco, cidade, estado, cep, bairro, nome, senha);
		valorVendas = 0;
		totalComissao = 0;
	}

	
	public boolean cadastrarVenda() {
		return true;
	}
	
	public void editarVenda() {
		
	}
	
	public void removerVenda() {
		
	}
	public float calcularValorVendas() {
		return 0;
	}
	
	public float calcularTotalComissao() {
		return 0;
	}
	
}
