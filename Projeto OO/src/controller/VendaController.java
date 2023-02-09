package controller;

import java.util.ArrayList;
import java.util.Date;

import model.Administrador;
import model.Loja;
import model.Venda;

public class VendaController {
	private Loja database;

	
	public VendaController() {
		this.database = Loja.getInstance();
	}
	
	
	// se der tempo fazer verificações 
	
	
	public void createVenda(Date dataPedido, Date dataEntrega, double valor, String tipoPagamento, int qntdParcelas, String descricao) {
		Venda venda = new Venda(dataPedido, dataEntrega, valor, tipoPagamento, qntdParcelas, descricao, this.database.getVendas().size() + 1);
		this.database.getVendas().add(venda);
	}
	
	public ArrayList<Venda> readAllVendas() {
		return this.database.getVendas();
	}
	
	public void updateVenda(Venda venda){
		for (int i = 0; i < this.database.getVendas().size(); i++) {
			if (this.database.getVendas().get(i).getId() == venda.getId()) {
				this.database.getVendas().set(i, venda);
		        break;
			}
		}
	}
	
	public boolean deleteVenda(Venda venda) {
		for (int i = 0; i < this.database.getVendas().size(); i++) {
			if(this.database.getVendas().get(i).getId() == (venda.getId())) {
				this.database.getVendas().remove(i);
				return true;
			}	
		}
		return false;
	}
	
	public Venda readOneVenda(int id) {
	    Venda vendaFound = null;

	    for (Venda venda : this.database.getVendas()) {
	      if (venda.getId() == id) {
	        return vendaFound;
	        
	      }
	    }
	    return vendaFound;
	}
	

}
