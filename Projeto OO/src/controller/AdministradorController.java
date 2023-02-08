package controller;

import java.util.*;

import model.Administrador;
import model.Loja;

public class AdministradorController {
	private Loja database;
		public ArrayList<Administrador> readAllAdmins() {
		   return this.database.getAdministrador();
			
		  }
}
