package controller;

import java.util.*;

import model.Loja;
import model.Vendedor;

public class VendedorController {
	private Loja database;
	
	
	// Construtor
	
	public VendedorController() {
		this.database = Loja.getInstance();
	}
	
	
	// se der tempo fazer verificações 
	
	public void createVendedor(String email, String endereco, String cidade, String estado, String cep, String bairro, String nome,
			String login, String senha) {
		Vendedor vendedor = new Vendedor(email,endereco,cidade,estado,cep,bairro,nome,senha,0,0);
		this.database.getVendedores().add(vendedor);
	}
	
	public ArrayList<Vendedor> readAllVendedores() {
		return this.database.getVendedores();
	}
	
	public void updateVendedor(Vendedor vendedor){
		for (int i = 0; i < this.database.getVendedores().size(); i++) {
			if (this.database.getVendedores().get(i).getEmail().equals(vendedor.getEmail())) {
				this.database.getVendedores().set(i, vendedor);
		        break;
			}
		}
	}
	
	public boolean deleteVendedor(Vendedor vendedor) {
		for (int i = 0; i < this.database.getVendedores().size(); i++) {
			if(this.database.getVendedores().get(i).getEmail().equals(vendedor.getEmail())) {
				this.database.getVendedores().remove(i);
				return true;
			}	
		}
		return false;
	}
	
	public Vendedor readOneVendedor(String email) {
	    for (Vendedor vendedor : this.database.getVendedores()) {
	      if (vendedor.getEmail().equals(email)) {
	        return vendedor;
	      }
	    }
	    return null;

	}
	
	public boolean existeVendedor(String email) {
		
		for (Vendedor vendedor : this.database.getVendedores()) {
		      if (vendedor.getEmail().equals(email)) {
		        return true;
		        
		      }
		    }
		    return false;
	}
	
	  public boolean login(String email, String senha) {
		    for (Vendedor vendedor : this.database.getVendedores()) {
		      if (vendedor.getEmail().equals(email) && senha.equals(vendedor.getSenha())) {
		        return true;
		      }
		    }
		    return false;
		  }
}
