package dados;

import java.io.Serializable;

public class ItemVenda implements Serializable{
	private static int sequence = 0;
	
	private Produto produto;
	private int numItem = 0;
	private double precoUnitario;
	private int quantVenda;
	private double valorVenda;
	public ItemVenda(Produto produto, double precoUnitario, int quantVenda,
			double valorVenda) {
		
		
		this.numItem = ++sequence;
		this.produto = produto;
		this.precoUnitario = precoUnitario;
		this.quantVenda = quantVenda;
		this.valorVenda = valorVenda;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public int getQuantVenda() {
		return quantVenda;
	}
	public void setQuantVenda(int quantVenda) {
		this.quantVenda = quantVenda;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	
	
	
	public static int getSequence() {
		return sequence;
	}
	public static void setSequence(int sequence) {
		ItemVenda.sequence = sequence;
	}
	public int getNumItem() {
		return numItem;
	}
	public void setNumItem(int numItem) {
		this.numItem = numItem;
	}
	@Override
	public String toString() {
		return "ItemVenda [produto=" + produto + ", precoUnitario="
				+ precoUnitario + ", quantVenda=" + quantVenda
				+ ", valorVenda=" + valorVenda + "]";
	}
	
	
	
	
	
	
	

}
