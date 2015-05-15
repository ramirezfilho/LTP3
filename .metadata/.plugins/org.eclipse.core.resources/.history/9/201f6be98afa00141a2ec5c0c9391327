package cadastro;

import java.util.ArrayList;

import dados.Cliente;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;

public class Cadastro {

	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Produto> produto = new ArrayList<Produto>();
	public static ArrayList<Venda> venda = new ArrayList<Venda>();

	
	public Cadastro() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

		// Métodos para Cliente 
		public static void incluirCliente (Cliente objCliente) {			
			clientes.add(objCliente);
		}
		

		public void excluirCliente (Cliente objCliente) {
			clientes.remove(objCliente);
		}
		
		
		public static Cliente buscarClienteCod (String cod) throws SisVendasException {
			for(Cliente objCliente : clientes){
				if(objCliente.getNome().contains(cod)){
					return objCliente;
				}
			}
			throw new SisVendasException("Não existe cliente para o código informado!");
		}
		
		
		
		public static Cliente buscarClienteCPF (String cpf) throws SisVendasException {
			for(Cliente objCliente : clientes){
				if(objCliente.getCpf().contains(cpf)){
					return objCliente;
				}
			}
			throw new SisVendasException("Não existe cliente para o cpf informado!");
		}
		
		
		
		//Métodos para produto
		public static void incluirProduto (Produto objProduto) {
			produto.add(objProduto);
		}
		
		
		public void excluirProduto (Produto objProduto) {
			produto.remove(objProduto);
		}
		
		
		public static Produto buscarProdutoCod (String cod) throws SisVendasException {
			for(Produto objProduto : produto){
				if(objProduto.getNome().contains(cod)){
					return objProduto;
				}
			}
			throw new SisVendasException("Não existe produto para o código informado!");
		}
		
		
		//Métodos para controle de vendas
		public static void incluirVenda (Venda objVenda) {
			venda.add(objVenda);
		}
		
		public static void excluirVenda (Venda objVenda) {
			venda.remove(objVenda);
		}
		
		public static Venda buscarVendaCod (int cod) throws SisVendasException {
			
			for(Venda objVenda : venda){
				if(objVenda.getNumVenda() == cod){
					return objVenda;
				}
			}
			throw new SisVendasException("Não existe venda para o código informado!");
		}
		
}
