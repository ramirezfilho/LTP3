/**
 * Programa para controle de vendas
 * @author Ramirez Gon�alves
 */

package Usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

import org.omg.CORBA.SystemException;

import utilitarios.Console;
import utilitarios.LtpUtil;
import cadastro.Cadastro;
import dados.Cliente;
import dados.ItemVenda;
import dados.Produto;
import dados.Venda;
import erros.SisVendasException;

public class Usuario {

	/**
	 * M�todos respons�veis pela leitura e grava��o em arquivo
	 * 
	 * @param args
	 *            -
	 * @throws SisVendasException
	 *             - Caso n�o seja poss�vel ler ou gravar no arquivo
	 */
	public static void main(String[] args) throws SisVendasException {
		if (new File("Vendas.obj").exists()) {
			lerArqVendas();
			try {
				int ultimoValor = Cadastro.venda.get(Cadastro.venda.size() - 1)
						.getNumVenda();
				Venda.setSequence(ultimoValor);
			} catch (Exception e) {
				System.out.println("Base de dados de Vendas vazio.");
			}
		}

		if (new File("Produtos.obj").exists()) {
			lerArqProdutos();

			try {
				int ultimoValor = Cadastro.produto.get(
						Cadastro.produto.size() - 1).getCodigo();
				Produto.setSequence(ultimoValor);
			} catch (Exception e) {
				System.out.println("Base de dados de Produtos vazio");
			}
		}
		if (new File("Clientes.obj").exists()) {
			lerArqClientes();

			try {
				int ultimoValor = Cadastro.clientes.get(
						Cadastro.clientes.size() - 1).getCodigo();
				Cliente.setSequence(ultimoValor);
			} catch (Exception e) {
				System.out.println("Base de dados de Clientes vazio");
			}

		}
		
		if (new File("ItensVendas.obj").exists()) {
			lerArqItensVendas();

			try {
				int ultimoValor = Cadastro.itensVendas.get(
						Cadastro.itensVendas.size() - 1).getNumItem();
				Cliente.setSequence(ultimoValor);
			} catch (Exception e) {
				System.out.println("Base de dados de Itens de vendas vazio");
			}

		}
		
		

		menu();
		gravarArq("Vendas");
		gravarArq("Produtos");
		gravarArq("Clientes");
		gravarArq("ItensVendas");
	}

	private static void lerArq(String obj) {
		ObjectInputStream inp;
		try {
			if (obj.equals("Venda")) {
				inp = new ObjectInputStream(new FileInputStream("Vendas.obj"));
				Cadastro.venda = (ArrayList<Venda>) inp.readObject();
				inp.close();
			} else if (obj.equals("Produto")) {
				inp = new ObjectInputStream(new FileInputStream("Produtos.obj"));
				Cadastro.produto = (ArrayList<Produto>) inp.readObject();

			} else if (obj.equals("Clientes")) {
				inp = new ObjectInputStream(new FileInputStream("Clientes.obj"));
				Cadastro.clientes = (ArrayList<Cliente>) inp.readObject();
			} else {
				inp = new ObjectInputStream(new FileInputStream("ItensVendas.obj"));
				Cadastro.itensVendas = (ArrayList<ItemVenda>) inp.readObject();
			}
			inp.close();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(1); // termino por falha na leitura do arquivo
		}

	}

	private static void gravarArq(String obj) {
		ObjectOutputStream out;

		try {
			if (obj.equals("Vendas")) {
				out = new ObjectOutputStream(new FileOutputStream("Vendas.obj"));
				out.writeObject(Cadastro.venda);

			} else if (obj.equals("Produtos")) {
				out = new ObjectOutputStream(new FileOutputStream(
						"Produtos.obj"));
				out.writeObject(Cadastro.produto);

			} else if (obj.equals("Clientes"))  {

				out = new ObjectOutputStream(new FileOutputStream(
						"Clientes.obj"));
				out.writeObject(Cadastro.clientes);

			} else {
				out = new ObjectOutputStream(new FileOutputStream(
						"ItensVendas.obj"));
				out.writeObject(Cadastro.itensVendas);
			}
			out.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(2); // Termino por falha na grava��o do arquivo
		}

	}

	/**
	 * Menu principal do programa, onde � feita a interface com o usu�rio
	 * 
	 * @throws SisVendasException
	 */
	public static void menu() throws SisVendasException {
		int option;
		int opcao;
		
		
		do {
			System.out.println(" -- Sistema de Gest�o de Vendas -- "
							 + "\n\n 1 - Menu de op��es de Clientes."
							 + "\n 2 - Menu de op��es de Produtos."
							 + "\n 3 - Menu de op��es de Vendas."
							 + "\n - Digite 16 para finalizar o programa");
			
			opcao = Console.readInt(" - Digite a op��o desejada: ");
			
			
			
			switch (opcao) {
			case 1: { System.out.println("\n MENU DE CLIENTES" 
					+  "\n 1 - Incluir " 
					+ "\n 2 - Alterar "
					+ "\n 3 - Excluir " 
					+ "\n 4 - Buscar "
					+ "\n 5 - Exibir todos os clientes "
					+ "\n 20 - Voltar ao menu anterior ");
			
			option = Console.readInt("Digite a op��o desejada: ");
			
						switch (option) {
								
								case 1:
									incluirCliente();
									break;
								case 2:
									alterarCliente();
									break;
								case 3:
									excluirCliente();
									break;
								case 4:
									pesquisaClienteNomeOrdem();
									break;
								case 5:
									System.out.println(Cadastro.clientes);
									break;
								case 20: break;
						}
						
			}
			case 2: {	System.out.println(
						  "\n\n MENU DE PRODUTOS"
						+ "\n 1 - Incluir " 
						+ "\n 2 - Alterar "
						+ "\n 3 - Excluir "
						+ "\n 4 - Buscar em ordem "
						+ "\n 5 - NOVO M�TODO - Estatistica de venda de Produto"
						+ "\n - Digite 21 para voltar ao menu anterior" );
			
			option = Console.readInt("Digite a op��o desejada: ");
			
							switch (option){
							
								case 1:
									incluirProduto();
									break;
								case 2:
									alterarProduto();
									break;
								case 3:
									excluirProduto();
									break;
								case 4:
									pesqProdOrdem();
									break;
								case 5:
									estatisticaProduto();
									break;
								case 21: break;
								}
			}
			
			case 3: {option = Console.readInt(" ----- MENU DE OP��ES ----- \n"					
					+ "\n\n MENU DE VENDAS"
					+ "\n 11 - Incluir"
					+ "\n 12 - Buscar por per�odo"
					+ "\n 13 - Excluir"
					+ "\n 14 - Estat�stica" 
					+ "\n 15 - Pesquisar em ordem"
					+ "\n"
					+ "\n - Digite 22 para sair do programa." 
					+ "\n -> Qual op��o deseja?");
				
							switch (option) {
								case 1:
									incluirVenda();
									break;
								case 2:
									vendaClientePerido();
									break;
								case 3:
									excluirVenda();
									break;
								case 4: estatisticaVenda();
									break;
								case 5: pesqOrdemVendas(); break;
								case 22: break;
							}
					}
				} 
				
			}while (opcao != 16);
	}

	/**
	 * M�todo respons�vel pelo cadastro de clientes.
	 */
	private static void incluirCliente() {
		String cpf;
		String nome;
		String telefone;
		String email;

		Cliente inclusaoCliente;

		System.out.println(" ---- CADASTRO DE CLIENTES ---- ");
		while (true) {

			cpf = Console.readLine("CPF: ");
			if (!LtpUtil.validarCPF(cpf)) {
				System.out.println("CPF invalido");
				continue;
			}

			try {
				Cliente objCliente1 = Cadastro.buscarClienteCPF(cpf);
				System.out.println("CPF j� cadastrado para o S�cio : "
						+ objCliente1.getNome());
			} catch (SisVendasException erro) {
				break;
			}
		}

		do {
			nome = Console.readLine("NOME: ");
		} while (!nome.matches("^(\\D*)+(\\s*)+(\\D)$"));

		telefone = Console.readLine("TELEFONE: ");

		do {
			email = Console.readLine("EMAIL: ");
		} while (!LtpUtil.validarEmail(email));

		Cadastro.incluirCliente(inclusaoCliente = new Cliente(nome, cpf,
				telefone, email, new GregorianCalendar(),
				new GregorianCalendar()));

	}

	/**
	 * M�todo respons�vel pela altera��o dos cadastros dos Clientes. Altera o
	 * cadastro buscando o cliente pelo cpf.
	 */
	private static void alterarCliente() {

		int codigo;
		String opcao;
		Cliente alteracao;

		try {
			codigo = Console
					.readInt("Digite o c�digo do usu�rio que deseja alterar: ");
			System.out.println(Cadastro.buscarClienteCod(codigo));
			alteracao = Cadastro.buscarClienteCod(codigo);
			do {
				opcao = Console
						.readLine("Deseja  realmente alterar o cliente? (S/N): ");
			} while (!(opcao.toUpperCase().charAt(0) == 'S'));

			if (opcao.toUpperCase().charAt(0) == 'S') {

				String cpf;
				String nome;
				String telefone;
				String email;
				GregorianCalendar data = new GregorianCalendar();

				System.out.println(" ---- ALTERA��O DE CLIENTE ---- ");

				do {
					cpf = Console.readLine("CPF: ");
				} while (!LtpUtil.validarCPF(cpf));

				do {
					nome = Console.readLine("NOME: ");
				} while (!nome.matches("^(\\D*)+(\\s*)+(\\D)$"));

				telefone = Console.readLine("TELEFONE: ");

				do {
					email = Console.readLine("EMAIL: ");
				} while (!LtpUtil.validarEmail(email));

				alteracao.setCpf(cpf);
				alteracao.setNome(nome);
				alteracao.setTelefone(telefone);
				alteracao.setEmail(email);
				alteracao.setDataUltAlteracao(data); // Passando data da
														// altera��o
			}

		} catch (SisVendasException e) {
			System.out.println("Deu ruim manolo!!!!!");
		}
	}

	/**
	 * M�todo respons�vel pela exclus�o de clientes
	 * 
	 * @throws SisVendasException
	 *             - Quando n�o � poss�vel encontrar o cliente Necess�rio
	 *             implementar a tratativa caso haja alguma venda registrada
	 *             para o cliente.
	 */
	public static void excluirCliente() throws SisVendasException {

		int codigo = Console
				.readInt("Digite o c�digo do cliente que deseja exlcuir: ");

		try {
			Cadastro.clientes.remove(Cadastro.buscarClienteCod(codigo));
			System.out.println("Cliente exclu�do com sucessso!");
		} catch (Exception e) {
			System.out
					.println("\nN�o foi poss�vel excuir o cliente, c�digo inv�lido!");
		}
	}

	/**
	 * M�todo respons�vel pela busca de clientes pelo CPF
	 * 
	 * @throws SisVendasException
	 *             - Quando n�o � encontrado cliente pelo CPF informado
	 */
	public static void buscarClienteCPF() throws SisVendasException {
		String cpf = Console.readLine("Digite o CPF para buscar: ");
		System.out.println(Cadastro.buscarClienteCPF(cpf));
	}

	/**
	 * M�todo resposns�vel pelo cadastro de produto
	 */

	private static void incluirProduto() {
		String nome;
		double precoUnitatio;
		GregorianCalendar dataInclusao = new GregorianCalendar();
		GregorianCalendar dataUltAlteracao = new GregorianCalendar();

		Produto inclusaoProduto;

		System.out.println(" ---- CADASTRO DE PRODUTOS ---- ");

		do {
			nome = Console.readLine("NOME DO PRODUTO: ");
		} while (nome == "");

		do {
			precoUnitatio = Console.readDouble("PRE�O UNIT�RO: ");
		} while (precoUnitatio <= 0);

		Cadastro.incluirProduto(inclusaoProduto = new Produto(nome,
				precoUnitatio, new GregorianCalendar(), new GregorianCalendar()));

	}

	/**
	 * M�todo respons�vel pela altera��o de produtos pelo c�digo
	 */
	private static void alterarProduto() {

		int codigo;
		String opcao;
		Produto alteracao;

		try {
			codigo = Console
					.readInt("Digite o c�digo do produto que deseja alterar: ");
			System.out.println(Cadastro.buscarProdutoCod(codigo));
			alteracao = Cadastro.buscarProdutoCod(codigo);
			do {
				opcao = Console
						.readLine("Deseja  realmente alterar o produto? (S/N): ");
			} while (!(opcao.toUpperCase().charAt(0) == 'S'));

			if (opcao.toUpperCase().charAt(0) == 'S') {

				String nome;
				double precoUnitatio;
				GregorianCalendar dataAlteracao = new GregorianCalendar();

				System.out.println(" ---- ALTERA��O DE CLIENTE ---- ");

				do {
					nome = Console.readLine("NOME: ");
				} while (nome == "");

				do {
					precoUnitatio = Console.readDouble("PRE�O UNIT�RIO: ");
				} while (precoUnitatio <= 0);

				alteracao.setNome(nome);
				alteracao.setPrecoUnitatio(precoUnitatio);
				alteracao.setDataUltAlteracao(dataAlteracao); // Passando data
																// da altera��o
			}

		} catch (SisVendasException e) {
			System.out.println("Deu ruim manolo!!!!!");
		}
	}

	/**
	 * M�todo respons�vel pela exclus�o de produtos via c�digo
	 * 
	 * @throws SisVendasException
	 *             - Quando n�o � poss�vel encontrar o cliente Necess�rio
	 *             implementar a n�o exclus�o do produco caso o mesmo esteja
	 *             registrado em alguma venda
	 */
	public static void excluirProduto() throws SisVendasException {

		int codigo = Console
				.readInt("Digite o c�digo do produto que deseja exlcuir: ");

		try {
			Cadastro.produto.remove(Cadastro.buscarProdutoCod(codigo));
			System.out.println("Produto exclu�do com sucessso!");
		} catch (Exception e) {
			System.out
					.println("\nN�o foi poss�vel excuir o produto, c�digo inv�lido!");
		}
	}

	/**
	 * M�todo respons�vel pelo cadastro de vendas
	 */
	private static void incluirVenda() {

		Cliente cliente = null;
		GregorianCalendar dataVenda = new GregorianCalendar();
		String cpf;
		int codigoProduto;
		Produto produto = null;
		int quantidade;
		double preco = 0;
		double valor;
		Venda inclusaoVenda;
		int intquantidade;

		System.out.println(" ---- CADASTRO DE VENDAS ---- ");

		try {

			do {
				cpf = Console.readLine("CPF DO CLIENTE ");
			} while (!LtpUtil.validarCPF(cpf));

			cliente = Cadastro.buscarClienteCPF(cpf);
		} catch (SisVendasException e) {
			System.out.println();
		}
		////////////
		intquantidade = Console.readInt("QUANTIDADE DE ITENS: ");

	ArrayList<ItemVenda> itensVendas = new ArrayList<ItemVenda>();
	for(int i =0 ; i<intquantidade;i++) {

			do {
				codigoProduto = Console.readInt("C�DIGO DO PRODUTO: ");

				try {
					produto = Cadastro.buscarProdutoCod(codigoProduto);
					if (produto == null) {
						System.out.println("Nao existe produto neste codigo");
					}
				} catch (SisVendasException e) {
					System.out.println(e.getMessage());
				}

				if (Cadastro.pesqProdtoVenda(produto, itensVendas)) {

					System.out.println("Produto ja registrado para venda, informe outro !!");
				}

			} while ((produto == null) || (Cadastro.pesqProdtoVenda(produto, itensVendas)));

			do {

				quantidade = Console.readInt("QUANTIDADE DO ITEM: ");
				if (quantidade <= 0) {
					System.out.println("A quantidade tem que ser maior que zero!");
				} else {

					do {
						preco = Console.readDouble("PRE�O DO PRODUTO ");
						valor = preco * quantidade;
						if (preco <= 0) {
							System.out
									.println("A quantidade tem que ser maior que zero!");
						}
					} while (preco <= 0);

				}
			} while (quantidade <= 0);

			Cadastro.itensVendas.add(new ItemVenda(produto, preco, quantidade, preco));

		}
		Cadastro.incluirVenda(new Venda(cliente, new GregorianCalendar(),
				itensVendas));

	}

	/**
	 * M�todo respons�vel pela excluus�o de venda pelo c�digo da venda.
	 * 
	 * @throws SisVendasException
	 *             - Caso a venda n�o seja encontrada.
	 */
	public static void excluirVenda() throws SisVendasException {

		int codigo = Console
				.readInt("Digite o n�mero da venda que deseja exlcuir: ");

		try {
			Cadastro.venda.remove(Cadastro.buscarVendaCod(codigo));
			System.out.println("Venda eclu�da com sucesso!");
		} catch (Exception e) {
			System.out
					.println("\nN�o foi poss�vel excuir o produto, c�digo inv�lido!");
		}
	}

	private static boolean fileExist() {
		if (new File("Vendas.obj").exists()
				&& new File("Clientes.obj").exists()
				&& new File("Produtos.obj").exists()) {
			return true;
		}

		return false;
	}

	private static void lerArqVendas() {
		try {
			ObjectInputStream inp = new ObjectInputStream(new FileInputStream(
					"Vendas.obj"));
			Cadastro.venda = (ArrayList<Venda>) inp.readObject();
			inp.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(1); // termino por falha na leitura do arquivo
		}
	}

	private static void lerArqClientes() {
		try {
			ObjectInputStream inp = new ObjectInputStream(new FileInputStream(
					"Clientes.obj"));
			Cadastro.clientes = (ArrayList<Cliente>) inp.readObject();
			inp.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(1); // termino por falha na leitura do arquivo
		}
	}

	private static void lerArqProdutos() {
		try {
			ObjectInputStream inp = new ObjectInputStream(new FileInputStream(
					"Produtos.obj"));
			Cadastro.produto = (ArrayList<Produto>) inp.readObject();
			inp.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(1); // termino por falha na leitura do arquivo
		}
	}
	
	private static void lerArqItensVendas() {
		try {
			ObjectInputStream inp = new ObjectInputStream(new FileInputStream(
					"ItensVendas.obj"));
			Cadastro.itensVendas = (ArrayList<ItemVenda>) inp.readObject();
			inp.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			System.exit(1); // termino por falha na leitura do arquivo
		}
	}


	/**
	 * Metodo respons�vel pela busca de clientes por ordem de nome, onde �
	 * passado o nome completo ou parte do nome do cliente;
	 */
	private static void pesquisaClienteNomeOrdem() {
		try {
			String nome = Console
					.readLine("Nome/Parte do nome para pesquisar: ");
			ArrayList<Cliente> resp = Cadastro.buscarClienteNomeOrdem(nome);
			if (resp.isEmpty()) {
				System.out.println("Nao existe nehum cliente para o nome.");
			} else {
				for (Cliente objSocio : resp) {
					System.out.println(objSocio.toString());

				}
			}

		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
	}

	/**
	 * M�todo respons�vel pela busca de cliente em ordem, onde � passado o nome
	 * do produti.
	 */
	private static void pesqProdOrdem() {
		try {
			String nome = Console
					.readLine("Informe o nome ou parte do nome do produto para pesquisar: ");
			ArrayList<Produto> resp = Cadastro.buscarProdutoNome(nome);
			if (resp.isEmpty()) {
				System.out.println("Nao existe nenhum produto para o nome.");
			} else {
				for (Produto objSocio : resp) {
					System.out.println(objSocio.toString());

				}
			}
		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
	}

	/**
	 * M�todo respons�vel pela busca de vendas por ordem de cliente
	 */
	private static void pesqOrdemVendas() {
		try {
			String nome = Console
					.readLine("Informe o nome do cliente para buscar as vendas: ");
			Cliente cli = Cadastro.buscarClienteNome(nome);
			ArrayList<Venda> resp = Cadastro.buscarVendaClienteNome(cli);
			if (resp.isEmpty()) {
				System.out.println("Nao existe nehum cliente para o nome.");
			} else {
				for (Venda objSocio : resp) {
					System.out.println(objSocio.toString());

				}
			}

		} catch (SisVendasException erro) {
			System.out.println(erro.getMessage());
		}
	}

	/**
	 * M�todo respons�vel pela busca de vendas por um per�odo determinado.
	 */
	private static void vendaClientePerido() {

		String data;
		GregorianCalendar dt1 = new GregorianCalendar();
		GregorianCalendar dt2 = new GregorianCalendar();

		do {

			data = Console
					.readLine("Favor informar a data1 :\n EX: DD/MM/YYYY ");

			if (!LtpUtil.validarData(data, dt1)) {
				System.out.println("Data invalida.");
				continue;
			}

			if (dt1.after(new GregorianCalendar())) {
				System.out.println(" Data maior que a data atual !!");
			}

		} while ((data.matches("^(\\d{2}\\/\\d{2}\\/\\d{4})$"))
				&& (dt1.after(new GregorianCalendar())));

		do {

			data = Console
					.readLine("Favor informar a data2 :\n EX: DD/MM/YYYY ");

			if (!LtpUtil.validarData(data, dt2)) {
				System.out.println("Data invalida.");
				continue;
			}

			if (dt2.after(new GregorianCalendar())) {
				System.out.println(" Data maior que a data atual !!");
			}

		} while ((data.matches("^(\\d{2}\\/\\d{2}\\/\\d{4})$"))
				&& (dt2.after(new GregorianCalendar())));

		ArrayList<Venda> resp = Cadastro.vendaClientePerido(dt1, dt2);
		if (resp.isEmpty()) {
			System.out
					.println("Nao existe nehuma venda cadastrada neste periodo.");
		} else {
			for (Venda objProduto : resp) {
				System.out.println(objProduto.toString());

			}
		}

	}
	
	
	private static void estatisticaVenda() {

		String data;
		GregorianCalendar dt1 = new GregorianCalendar();
		GregorianCalendar dt2 = new GregorianCalendar();
		Cliente cli = null;
		int vendas = 0;
		double total = 0;
		String nome;

		while (true) {
			try {

				do {
					nome = Console.readLine("NOME: ");

				} while (!nome.matches("^(\\D*)+(\\s*)+(\\D)$"));
				cli = Cadastro.buscarClienteNome(nome);
				if (cli == null) {

					System.out
							.println("Nao existe nenhum cliente para o nome :");
					continue;
				}
				break;

			} catch (SisVendasException erro) {

				System.err.println(erro.getMessage());
			}

		}

		do {

			data = Console
					.readLine("Favor informar a data1 :\n EX: DD/MM/YYYY ");

			if (!LtpUtil.validarData(data, dt1)) {
				System.out.println("Data invalida.");
				continue;
			}

			if (dt1.after(new GregorianCalendar())) {
				System.out.println(" Data maior que a data atual !!");
			}

		} while ((data.matches("^(\\d{2}\\/\\d{2}\\/\\d{4})$"))
				&& (dt1.after(new GregorianCalendar())));

		do {

			data = Console
					.readLine("Favor informar a data2 :\n EX: DD/MM/YYYY ");

			if (!LtpUtil.validarData(data, dt2)) {
				System.out.println("Data invalida.");
				continue;
			}

			if (dt2.after(new GregorianCalendar())) {
				System.out.println(" Data maior que a data atual !!");
			}

		} while ((data.matches("^(\\d{2}\\/\\d{2}\\/\\d{4})$"))
				&& (dt2.after(new GregorianCalendar())));

		ArrayList<Venda> resp = Cadastro.vendaClientePerido(dt1, dt2);
		ArrayList<ItemVenda> resp1 = new ArrayList<ItemVenda>();

		System.out.println(Cadastro.estatisticaVendaCliente(resp, resp1, nome));

	}

	public static void estatisticaProduto(){
		ArrayList<Venda> venda = new ArrayList<Venda>();
		ArrayList<ItemVenda> itens = new ArrayList<ItemVenda>();	
		itens = Cadastro.itensVendas;
		System.out.println(Cadastro.estatisticaVendaProduto(venda, itens));
	}

}