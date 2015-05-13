// Override reimplementar um m�todo herdado.
// Overload acrescentar um m�todo herdado
/* class SuperClasse {}
 * class SubClasse extends SuperClasse{}
 */
// Bloquear heran�a  = class final SuperClasseBloqueada{}
// Bloquear algum item da class herdada... inserir o final no cabe�alho do m�todo
// super = chamar um m�todo da super classe


package dados;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Venda {
	private int numVenda = 0;
	private Cliente cliente;
	private GregorianCalendar dataVenda = new GregorianCalendar();
	private ArrayList<ItemVenda> vendaItens = new ArrayList<ItemVenda>();	
	
	public Venda(Cliente cliente, GregorianCalendar dataVenda,ArrayList<ItemVenda> vendaItens ) {
		
		numVenda++;
		
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
	
	
	@Override
	public String toString() {
		return "Venda [numVenda=" + numVenda + ", cliente=" + cliente
				+ ", dataVenda=" + dataVenda + "]";
	}
	
	
	

}
