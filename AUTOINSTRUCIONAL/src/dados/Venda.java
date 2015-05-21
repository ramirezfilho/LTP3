package dados;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class Venda implements Serializable{
	
	private static int sequence = 0;
	
	private int numVenda;
	private Cliente cliente;
	private GregorianCalendar dataVenda = new GregorianCalendar();
	private ArrayList<ItemVenda> vendaItens = new ArrayList<ItemVenda>();	
	
	public Venda(Cliente cliente, GregorianCalendar dataVenda,ArrayList<ItemVenda> vendaItens ) {
		
		
		this.numVenda = ++sequence;
		this.cliente = cliente;
		this.dataVenda = dataVenda;
	}
	public int getNumVenda() {
		return numVenda;
	}
	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public GregorianCalendar getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(GregorianCalendar dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public static void setSequence(int sequence) {
		Venda.sequence = sequence;
	}
	
	
	
	
	public ArrayList<ItemVenda> getVendaItens() {
		return vendaItens;
	}
	public void setVendaItens(ArrayList<ItemVenda> vendaItens) {
		this.vendaItens = vendaItens;
	}
	@Override
	public String toString() {
		return "\n\nVenda \n  Número da Venda = " + numVenda + " \n  " + cliente
				+ ",\n  Data da Venda = " + LtpUtil.formatarData(dataVenda, "dd/MM/yyyy hh:mm");
	}
	
	
	

}
