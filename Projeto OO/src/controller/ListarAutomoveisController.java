package controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Automovel;
import model.Loja;

public class ListarAutomoveisController {

	private Loja database;

	public ListarAutomoveisController() {
		this.database = Loja.getInstance();

	}

	public DefaultTableModel generateTable(Object[] header) {
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);

		for (Automovel automovel : this.database.getAutomoveis()) {
			Object[] data = { automovel.getMarca().getNome(), automovel.getModelo().getNome(),
					automovel.getAno_fabricado(), automovel.getChassi(), automovel.getCor().toString(),
					automovel.getValor()};
			tableModel.addRow(data);
		}
			
		return tableModel;
	}
	
	public Automovel getAutomovel(String chassi) {
		for (Automovel automovel : this.database.getAutomoveis()) {
			if(automovel.getChassi().equals(chassi))
				return automovel;
		} 
		return null;
	}
	
	public void removerAutomovel(JScrollPane scroll) {
		JTable view = ((JTable)scroll.getViewport().getView());
		int linha = view.getSelectedRow();
		if(linha > -1) {
			this.database.getAutomoveis().remove(getAutomovel(view.getValueAt(linha, 3).toString()));
		}else {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Selecione algum carro antes!!");
		}
	}
	
	public void editarAutomovel(JScrollPane scroll,float novoValor) {
		JTable view = ((JTable)scroll.getViewport().getView());
		int linha = view.getSelectedRow();
		if(linha > -1) {
			Automovel automovel = getAutomovel(view.getValueAt(linha, 3).toString());
			automovel.setValor(novoValor);

		 	String[] header = { "Marca", "Modelo", "Ano", "Chassi", "Cor", "Valor" };
			scroll.setViewportView(new JTable(generateTable(header)));
		}else {
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Selecione algum carro antes!!");
		}
	}
}
