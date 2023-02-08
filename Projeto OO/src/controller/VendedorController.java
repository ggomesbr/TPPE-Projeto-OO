package controller;

import java.util.*;

import model.Loja;
import model.StatusVenda;
import model.Vendedor;

public class VendedorController {
	private Loja database;
	
	
	// Construtor
	
	public VendedorController() {
		this.database = Loja.getInstance();
	}
	
	  /**
	   * Adiciona um vendedor ao banco de dados.
	   * 
	   * @param name     Nome do vendedor
	   * @param email    Email do vendedor
	   * @param password Senha do vendedor
	   */
	
	public static boolean CadastrarVendedor(String [] dadosFuncionarios) {
		Vendedor vendedor = new Vendedor()
	}
}
