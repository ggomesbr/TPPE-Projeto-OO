package controller;

import java.util.*;

import model.Administrador;
import model.Loja;

public class AdministradorController {
	private Loja database;
	
	public AdministradorController() {
		this.database = Loja.getInstance();
	}
	
	
	// se der tempo fazer verificações 
	
	
	public void createAdmin(String email, String endereco, String cidade, String estado, String cep, String bairro,
			String nome, String senha) {
		Administrador admin = new Administrador(email,endereco,cidade,estado,cep,bairro,nome,senha);
		this.database.getAdministradores().add(admin);
	}
	
	public ArrayList<Administrador> readAllAdmins() {
		return this.database.getAdministradores();
	}
	
	public void updateAdmin(Administrador administrador){
		for (int i = 0; i < this.database.getAdministradores().size(); i++) {
			if (this.database.getAdministradores().get(i).getEmail().equals(administrador.getEmail())) {
				this.database.getAdministradores().set(i, administrador);
		        break;
			}
		}
	}
	
	public boolean deleteAdmin(Administrador administrador) {
		for (int i = 0; i < this.database.getAdministradores().size(); i++) {
			if(this.database.getAdministradores().get(i).getEmail().equals(administrador.getEmail())) {
				this.database.getAdministradores().remove(i);
				return true;
			}	
		}
		return false;
	}
	
	public Administrador readOneAdmin(String email) {
	    Administrador adminFound = null;

	    for (Administrador admin : this.database.getAdministradores()) {
	      if (admin.getEmail().equals(email)) {
	        adminFound = admin;
	        break;
	      }
	    }
	    return adminFound;
	}
	
	  public boolean login(String email, String senha) {
		    for (Administrador admin : this.database.getAdministradores()) {
		      if (admin.getEmail().equals(email) && senha.equals(admin.getSenha())) {
		        return true;
		      }
		    }
		    return false;
		  }
}
