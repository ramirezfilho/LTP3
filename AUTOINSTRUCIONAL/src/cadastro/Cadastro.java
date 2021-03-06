package cadastro;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

import dados.Cliente;
import dados.ItemVenda;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;

/**
 * Classe Cadastro, que tem por seu objetivo a ponte para gravacacao de objetos
 * nos ArraysList metodos de pesquisa nos mesmos.
 *
 * @author Ramirez Gon�alves
 */
public class Cadastro {

	/**
	 * Contrutor vazio Tres variaveis do tipo
	 * ArrayList,ArrayList e ArrayList. Para
	 * armazenamento de objetos;
	 *
	 */

	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Produto> produto = new ArrayList<Produto>();
	public static ArrayList<Venda> venda = new ArrayList<Venda>();
	public static ArrayList<ItemVenda> itensVendas = new ArrayList<ItemVenda>();

	public Cadastro() {

	}

	/**
	 * Metodo para inclusao de cliente no Arraylist adiciona um objeto
	 * passado por referencia.
	 *
	 * @param objCliente Objeto do tipo Cliente
	 *            .
	 */
	public static void incluirCliente(Cliente objCliente) {
		clientes.add(objCliente);
	}
	
	public static ArrayList<String> estatisticaVendaCliente(ArrayList<Venda> resp,ArrayList<ItemVenda> resp1,String nome){
		int vendas =0;
		double total =0;
		ArrayList<String> dados = new ArrayList<String>();
		
		
		for (Venda objVEnda : resp) {

			if (objVEnda.getCliente().getNome().contains(nome));
			{
				total =0;
				resp1 = objVEnda.getVendaItens();
				for (ItemVenda objItem : resp1) {

					total += objItem.getValorVenda();
					vendas++;
					dados.add("\n\n\nEstastica cliente : " + objVEnda.getCliente().getNome() + "\n Numero de produto comprados : " + vendas+ "\nValor total de compras: " + total);
				}

			}

		}
		return dados;
	}
	
	
	
	public static ArrayList<String> estatisticaVendaProduto(ArrayList<Venda> vendasCadastradas, ArrayList<ItemVenda> produtosVendidos){
		int total = 0;
		int totalProdutoVendio = 0;
		
		ArrayList<String> dados = new ArrayList<String>();
		ArrayList<Venda> listaVendas = new ArrayList<Venda>();
		ArrayList<ItemVenda> listaProdutos = new ArrayList<ItemVenda>();
		
		
		for(ItemVenda objListaProdutos : produtosVendidos){
			dados.add("\n\n Estat�sticas dos produtos: " + objListaProdutos.getProduto().getNome() + "\n Total de vezes que o produto foi vendido: " + (totalProdutoVendio = objListaProdutos.getQuantVenda()) 
					+ "\n Valor total recebido pelo produto: " + (total = (int) (objListaProdutos.getValorVenda()*objListaProdutos.getQuantVenda())));
			
					
		}
		return dados;		
	}
	
	
	/**
	 * Metodo para exclusao de cliente no Arraylist exclui um objeto
	 * passado por referencia.
	 *
	 * @param objCliente Objeto do tipo Cliente
	 *            .
	 */
	public static void excluirCliente(Cliente objCliente) {
		clientes.remove(objCliente);
	}

	/**
	 * Metodo do tipo Cliente para buscar um objeto no ArraList com
	 * excercao de erros pela clase SisVendasException. Pecorre todo o arrayList
	 * do tipo clientes, Valida se o objeto dentro do array possui a variavel
	 * passada por referencia igual. Se for verdade retorna obejto.
	 *
	 * @param cod vari�vel do c�digo do produto
	 * @return Objeto Cliente.
	 * @throws SisVendasException - Caso n�o seja encontrado o cliente pelo c�digo informado
	 */
	public static Cliente buscarClienteCod(int cod) throws SisVendasException {
		for (Cliente objCliente : clientes) {
			if (objCliente.getCodigo() == cod) {
				return objCliente;
			}
		}
		throw new SisVendasException(
				"N�o existe cliente para o c�digo informado!");
	}

	/**
	 *M�todo respons�vel pela busca de cliente por cpf
	 * @param cpf do Cliente
	 * @return Objeto Cliente.
	 * @throws SisVendasException - caso n�o seja encontrado  o cliente pelo cpf informado.
	 */

	public static Cliente buscarClienteCPF(String cpf)
			throws SisVendasException {
		for (Cliente objCliente : clientes) {
			if (objCliente.getCpf().contains(cpf)) {
				return objCliente;
			}
		}
		throw new SisVendasException("N�o existe cliente para o cpf informado!");
	}

	/**
	 *M�todo repsons�vel pela busca de cliente pelo nome, caso seja encontrado retorna um objeto do tipo Cliente;
	 * @param nome do cliente
	 * @return Objeto Cliente.
	 * @throws SisVendasException - Caso n�o seja encontrado cliente pelo nome informado.
	 */
	public static Cliente buscarClienteNome(String nome)
			throws SisVendasException {
		for (Cliente objCliente : clientes) {
			if (objCliente.getNome().toUpperCase().contains(nome.toUpperCase())) {
				return objCliente;
			}
		}
		throw new SisVendasException("N�o existe cliente para o cpf informado!");
	}

	/**
	 *M�todo respons�vel pela busca em ordem de nome de clientes.
	 *Caso seja encontrado o nome indicado, retorna um arraylist com o nome dos clientes em ordem alfab�tica.
	 * @param nome do CLiente
	 * @return ArrayList.
	 * @throws SisVendasException - Caso n�o consiga encontrar o cliente pelo nome
	 */

	public static ArrayList<Cliente> buscarClienteNomeOrdem(String nome)
			throws SisVendasException {
		ArrayList<Cliente> resposta = new ArrayList<Cliente>();
		for (Cliente objCliente : clientes) {
			if (objCliente.getNome().toUpperCase().contains(nome.toUpperCase())) {
				resposta.add(objCliente);
			}
		}
		if (resposta.size() > 0) {
			Collections.sort(resposta, new ClientePorNome());
			return resposta;
		} else {
			throw new SisVendasException("Nao existe Cliente para o nome.");
		}
	}

	/**
	 * Metodo para inclusao de Produto no Arraylist
	 * @param objProduto Objeto Produto
	 */
	public static void incluirProduto(Produto objProduto) {
		produto.add(objProduto);
	}

	/**
	 * Metodo para exclui de Produto no Arraylist
	 *
	 * @param objProduto Objeto Produto
	 */
	public static void excluirProduto(Produto objProduto) {
		produto.remove(objProduto);
	}

	/**
	 * M�todo respons�vel pela busca de um produto por c�digo
	 * Caso encontre retorna um objeto do tipo produto.
	 * @param cod Codigo Produto.
	 * @return Objeto Produto.
	* @exception SisVendasException tratamento de excecao
	 */

	public static Produto buscarProdutoCod(int cod) throws SisVendasException {
		for (Produto objProduto : produto) {
			if (objProduto.getCodigo() == cod) {
				return objProduto;
			}
		}
		throw new SisVendasException(
				"N�o existe produto para o c�digo informado!");
	}

	/**
	 *M�todo respons�vel por percorrer o arraylist de produtos e ordena-lo
	 * @param nome String Cliente
	 *            .
	 * @return ArrayList.
	 * @throws SisVendasException - Caso n�o seja encontrado produto pelo nome indicado
	 */
	public static ArrayList<Produto> buscarProdutoNome(String nome)
			throws SisVendasException {
		ArrayList<Produto> resposta = new ArrayList<Produto>();
		for (Produto objProduto : produto) {
			if (objProduto.getNome().toUpperCase().contains(nome.toUpperCase())) {
				resposta.add(objProduto);
			}
		}
		if (resposta.size() > 0) {
			Collections.sort(resposta, new ProdutoPorNome());
			return resposta;
		} else {
			throw new SisVendasException("Nao existe Produto para o nome.");
		}
	}

	/**
	 * Metodo para inclusao de Venda no Arraylist
	 *
	 * @param objVenda do tipo Venda
	 */
	public static void incluirVenda(Venda objVenda) {
		venda.add(objVenda);
	}

	/**
	 * Metodo para exclusao de Venda no Arraylist
	 * @param objVenda do tipo Venda
	 */
	public static void excluirVenda(Venda objVenda) {
		venda.remove(objVenda);
	}

	/**
	 * M�todo respons�vel pela busca de uma venda pelo c�digo
	 * @param cod - Codigo objeto Venda.
	 * @return Objeto Venda.
	 * @throws SisVendasException - Caso n�o seja encontrado venda para o c�digo
	 */

	public static Venda buscarVendaCod(int cod) throws SisVendasException {

		for (Venda objVenda : venda) {
			if (objVenda.getNumVenda() == cod) {
				return objVenda;
			}
		}
		throw new SisVendasException(
				"N�o existe venda para o c�digo informado!");
	}

	/**
	 * Metodo do tipo Arraylist, com finalidade de percorrer o arrayList e ordena-lo
	 * @param cli Obejto Cliente
	 * @return ArrayList.
	 * @throws SisVendasException - Caso n�o seja encontrado venda para o nome do cliente informado
	 */
	public static ArrayList<Venda> buscarVendaClienteNome(Cliente cli)
			throws SisVendasException {
		ArrayList<Venda> resposta = new ArrayList<Venda>();

		for (Venda objCliente : venda) {
			if (objCliente.getCliente().getNome().equals(cli.getNome())) {
				resposta.add(objCliente);
			}
		}
		if (resposta.size() > 0) {
			Collections.sort(resposta, new VendaPorCliente().reversed());
			return resposta;
		} else {
			throw new SisVendasException("Nao existe Cliente para o nome.");
		}
	}

	/**
	 * Metodo do tipo Arraylist, com finalidade de percorrer o arrayList
	 * e ordernar-lo reversamente pelo perido de data informado pelo usuario.	 *
	 * @param data1 GregorianCalendar.
	 * @param data2 GregorianCalendar.
	 * @return ArrayList.
	 */
	public static ArrayList<Venda> vendaClientePerido(GregorianCalendar data1,
			GregorianCalendar data2) {
		ArrayList<Venda> resposta = new ArrayList<Venda>();

		for (Venda obj : venda) {
			if (obj.getDataVenda().compareTo(data1) >= 0
					&& obj.getDataVenda().compareTo(data2) <= 0) {
				resposta.add(obj);
			}
		}
		Collections
				.sort(resposta, new ordenaVendasClientesPeriodo().reversed());
		return resposta;
	}

	public static ArrayList<Venda> estatisticaVendaCliente(
			GregorianCalendar data1, GregorianCalendar data2) {
		ArrayList<Venda> resposta = new ArrayList<Venda>();

		for (Venda obj : venda) {
			if (obj.getDataVenda().compareTo(data1) >= 0
					&& obj.getDataVenda().compareTo(data2) <= 0) {
				resposta.add(obj);
			}
		}
		Collections
				.sort(resposta, new ordenaVendasClientesPeriodo().reversed());
		return resposta;
	}

	/**
	 * Metodo bolleano para validar se a obejtos do tipo Produto cadastrado nos
	 * obejtos do tipo venda.
	 *
	 * @param buscarProdutoCod Objeto do tipo Produto
	 *            .
	 * @return True e false.
	 */
	public static boolean pesqProdtoVenda(Produto buscarProdutoCod) {
		for (Venda objVenda : venda) {

			objVenda.getVendaItens().contains(buscarProdutoCod);
			return true;
		}

		return false;

	}

	
	public static boolean pesqProdtoVenda(Produto buscarProdutoCod , ArrayList<ItemVenda> itemArray) {
		
		
		for (ItemVenda objVenda :itemArray) {

			 if(objVenda.getProduto().getCodigo() ==buscarProdutoCod.getCodigo()){
			return true;
			 }
		}

		return false;

	}
	
	
	
}

/**
 * Classe ClientPorNome onde implementa os metodos definidos na interface
 * Comparator.
 *
 * @author Ramirez Gon�alves
 */

class ClientePorNome implements Comparator<Cliente> {

	/**
	 * Override do metodo compare localizado na interface Comparator, com o
	 * bjetivo de comprar dois objetos.
	 *
	 * @return int retornado pelo metodo compareTo.
	 */

	@Override
	public int compare(Cliente o1, Cliente o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}

/**
 * Classe ProdutoPorNome onde implementa os metodos definidos na interface
 * Comparator.
 *
 * @author Ramirez Gon�alves
 */

class ProdutoPorNome implements Comparator<Produto> {
	/**
	 * Override do metodo compare localizado na interface Comparator, com o
	 * bjetivo de comprar dois objetos.
	 *
	 * @return int retornado pelo metodo compareTo.
	 */
	@Override
	public int compare(Produto o1, Produto o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}

/**
 * Classe VendaPorCliente onde implementa os metodos definidos na interface
 * Comparator.
 *
 *@author Ramirez Gon�alves
 */
class VendaPorCliente implements Comparator<Venda> {
	/**
	 * Override do metodo compare localizado na interface Comparator, com o
	 * bjetivo de comprar dois objetos.
	 *
	 * @return int retornado pelo subtracao do atributo dentro dos objetos..
	 */
	@Override
	public int compare(Venda o1, Venda o2) {
		return o1.getNumVenda() - o2.getNumVenda();
	}

}

/**
 * Classe ordenaVendasClientesPeriodo onde implementa os metodos definidos na
 * interface Comparator.
 *
 * @author Ramirez Gon�alves
 */
class ordenaVendasClientesPeriodo implements Comparator<Venda> {
	/**
	 * Override do metodo compare localizado na interface Comparator, com o
	 * bjetivo de comprar dois objetos.
	 *
	 * @return int retornado pelo metodo compareTo.
	 * @author Ramirez Gon�alves
	 */
	@Override
	public int compare(Venda obj1, Venda obj2) {
		int resp = obj1.getCliente().getNome()
				.compareTo(obj2.getCliente().getNome());
		if (resp != 0)
			return resp;
		return obj1.getDataVenda().compareTo(obj2.getDataVenda());
	}

}

