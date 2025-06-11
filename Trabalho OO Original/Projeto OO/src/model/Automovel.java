package model;

public class Automovel {

	private Cor cor;
	private int portas;
	private String combustivel;
	private String chassi;
	private float valor;

	public Automovel(Cor cor, int portas, String combustivel, String chassi, float valor, String ano_fabricado,
			Modelo modelo, Marca marca) {
		this.cor = cor;
		this.portas = portas;
		this.combustivel = combustivel;
		this.chassi = chassi;
		this.valor = valor;
		this.ano_fabricado = ano_fabricado;
		this.modelo = modelo;
		this.marca = marca;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getAno_fabricado() {
		return ano_fabricado;
	}

	public void setAno_fabricado(String ano_fabricado) {
		this.ano_fabricado = ano_fabricado;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	private float valor_fabrica;
	private String ano_fabricado;
	private Modelo modelo;
	private Marca marca;

	public String toString() {
		return this.modelo.getNome();
	}

}
