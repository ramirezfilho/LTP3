package cadastro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;

import dados.Cliente;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;

/**
 * Classe Cadastro, que tem por seu objetivo a ponte para gravacacao de objetos
 * nos ArraysList metodos de pesquisa nos mesmos.
 *
 * @author Tharyck Gusmao Metzker
 */
public class Cadastro {

	/**
	 * Contrutor vazio Tres variaveis do tipo
	 * ArrayList<Cliente>,ArrayList<Produto> e ArrayList<Venda>. Para
	 * armazenamento de objetos nas mesmas;
	 *
	 */

	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	public static ArrayList<Produto> produto = new ArrayList<Produto>();
	public static ArrayList<Venda> venda = new ArrayList<Venda>();

	public Cadastro() {

	}

	/**
	 * Metodo para inclusao de cliente no Arraylist<Cliente> adiciona um objeto
	 * passado por referencia.
	 *
	 * @param objCliente Objeto do tipo Cliente
	 *            .
	 */
	public static void incluirCliente(Cliente objCliente) {
		clientes.add(objCliente);
	}

	/**
	 * Metodo para exclusao de cliente no Arraylist<Cliente> exclui um objeto
	 * passado por referencia.
	 *
	 * @param objCliente Objeto do tipo Cliente
	 *            .
	 */
	public static void excluirCliente(Cliente objCliente) {
		clientes.remove(objCliente);
	}

	/**
	 * Metodo do tipo Cliente para buscar um objeto no ArraList<Cliente> com
	 * excercao de erros pela clase SisVendasException. Pecorre todo o arrayList
	 * do tipo clientes, Valida se o objeto dentro do array possui a variavel
	 * passada por referencia igual. Se for verdade retorna obejto.
	 *
	 * @param cod variavel refente ao codigo do produto.
	 * @return Objeto Cliente.
	 */
	public static Cliente buscarClienteCod(int cod) throws SisVendasException {
		for (Cliente objCliente : clientes) {
			if (objCliente.getCodigo() == cod) {
				return objCliente;
			}
		}
		throw new SisVendasException(
				"Não existe cliente para o código informado!");
	}

	/**
	 * Metodo do tipo Cliente para buscar um objeto no ArraList<Cliente> com
	 * excercao de erros pela clase SisVendasException. Pecorre todo o arrayList
	 * do tipo clientes, Valida se o objeto dentro do array possui a variavel
	 * passada por referencia igual. Se for verdade retorna obejto.
	 *
	 * @param cpf do Cliente
	 * @return Objeto Cliente.
	 */

	public static Cliente buscarClienteCPF(String cpf)
			throws SisVendasException {
		for (Cliente objCliente : clientes) {
			if (objCliente.getCpf().contains(cpf)) {
				return objCliente;
			}
		}
		throw new SisVendasException("Não existe cliente para o cpf informado!");
	}

	/**
	 * Metodo do tipo Cliente para buscar um objeto no ArraList<Cliente> trata
	 * excecoes de erros pela classe SisVendasException. Pecorre todo o
	 * arrayList do tipo clientes, Valida se o objeto dentro do array possui a
	 * variavel passada por referencia igual. Se for verdade retorna obejto.
	 *
	 * @param nome do cliente
	 * @return Objeto Cliente.
	 */
	public static Cliente buscarClienteNome(String nome)
			throws SisVendasException {
		for (Cliente objCliente : clientes) {
			if (objCliente.getNome().toUpperCase().contains(nome.toUpperCase())) {
				return objCliente;
			}
		}
		throw new SisVendasException("Não existe cliente para o cpf informado!");
	}

	/**
	 * Metodo do tipo Arraylist<Cliente>, com finalidade de percorrer o
	 * arrayList e ordernar-lo. Percorrer o arrayList do tipo Clientes, valida
	 * se o objeto pertence ao mesmo e add em outro arrayList<Cliente> auxiliar,
	 * Valida se a valores dentro do ArrayList<Clientes> auxiliar, se for
	 * verdade ele orderna os valores, pelo metodo customizado Collections.sort.
	 *
	 * @param nome do CLiente
	 * @return ArrayList<Cliente>.
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
	 * Metodo para inclusao de Produto no Arraylist<Produto> adiciona um objeto
	 * passado por referencia.
	 *
	 * @param objProduto Objeto Produto
	 */
	public static void incluirProduto(Produto objProduto) {
		produto.add(objProduto);
	}

	/**
	 * Metodo para exclui de Produto no Arraylist<Produto> exclui um objeto
	 * passado por referencia.
	 *
	 * @param objProduto Objeto Produto
	 */
	public static void excluirProduto(Produto objProduto) {
		produto.remove(objProduto);
	}

	/**
	 * Metodo do tipo Cliente para buscar um objeto no ArraList<Produto> trata
	 * excecoes de erros pela classe SisVendasException. Pecorre todo o
	 * arrayList do tipo Produto, Valida se o objeto dentro do array possui a
	 * variavel passada por referencia igual. Se for verdade retorna obejto.
	 *
	 * @param cod Codigo Cliente.
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
				"Não existe produto para o código informado!");
	}

	/**
	 * Metodo do tipo Arraylist<Produto>, com finalidade de percorrer o
	 * arrayList e ordernar-lo. Percorrer o arrayList do tipo Produto, valida se
	 * o objeto pertence ao mesmo e adiciona em outro arrayList<Produto>
	 * auxiliar, Valida se a valores dentro do ArrayList<Produto> auxiliar, se
	 * for verdade ele orderna os valores, pelo metodo customizado
	 * Collections.sort.
	 *
	 * @param nome String Cliente
	 *            .
	 * @return ArrayList<Cliente>.
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
	 * Metodo para inclusao de Venda no Arraylist<Venda> adiciona um objeto
	 * passado por referencia.
	 *
	 * @param objVenda do tipo Venda
	 */
	public static void incluirVenda(Venda objVenda) {
		venda.add(objVenda);
	}

	/**
	 * Metodo para exclusao de Venda no Arraylist<Venda> adiciona um objeto
	 * passado por referencia.
	 *
	 * @param objVenda do tipo Venda
	 */
	public static void excluirVenda(Venda objVenda) {
		venda.remove(objVenda);
	}

	/**
	 * Metodo do tipo Venda para buscar um objeto no ArraList<Venda> com
	 * excercao de erros pela clase SisVendasException. Pecorre todo o arrayList
	 * do tipo Venda, Valida se o objeto dentro do array possui a variavel
	 * passada por referencia igual. Se for verdade retorna obejto.
	 *
	 * @param cod - Codigo objeto Venda.
	 * @return Objeto Venda.
	 */

	public static Venda buscarVendaCod(int cod) throws SisVendasException {

		for (Venda objVenda : venda) {
			if (objVenda.getNumVenda() == cod) {
				return objVenda;
			}
		}
		throw new SisVendasException(
				"Não existe venda para o código informado!");
	}

	/**
	 * Metodo do tipo Arraylist<Venda>, com finalidade de percorrer o arrayList
	 * e ordernar-lo reversamente. Percorrer o arrayList do tipo Venda, valida
	 * se o objeto pertence ao mesmo e adiciona em outro arrayList<Venda>
	 * auxiliar, Valida se a valores dentro do ArrayList<Venda> auxiliar, se for
	 * verdade ele orderna os valores, pelo metodo customizado Collections.sort.
	 *
	 * @param cli Obejto Cliente
	 *            .
	 * @return ArrayList<Venda>.
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
	 * Metodo do tipo Arraylist<Venda>, com finalidade de percorrer o arrayList
	 * e ordernar-lo reversamente pelo perido de data informado pelo usuario.
	 * Percorrer o arrayList do tipo Venda, valida se o objeto pertence ao mesmo
	 * e adiciona em outro arrayList<Venda> auxiliar, Valida se a valores dentro
	 * do ArrayList<Venda> auxiliar, se for verdade ele orderna os valores, pelo
	 * metodo customizado Collections.sort.
	 *
	 * @param data1 GregorianCalendar.
	 * @param data2 GregorianCalendar.
	 * @return ArrayList<Venda>.
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

}

/**
 * Classe ClientPorNome onde implementa os metodos definidos na interface
 * Comparator.
 *
 * @author Tharyck Gusmao Metzker.
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
 * @author Tharyck Gusmao Metzker.
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
 * @author Tharyck Gusmao Metzker.
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
 * @author Tharyck Gusmao Metzker.
 */
class ordenaVendasClientesPeriodo implements Comparator<Venda> {
	/**
	 * Override do metodo compare localizado na interface Comparator, com o
	 * bjetivo de comprar dois objetos.
	 *
	 * @return int retornado pelo metodo compareTo.
	 * @author Tharyck Gusmao Metzker.
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

