package dados;

import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import erros.CelularException;

public class CadClientes {
	
	public static HashMap<String, ClienteCelular> listaClientes 
						= new HashMap<String, ClienteCelular>();

	public static void incluirCliente(ClienteCelular obj){
		listaClientes.put(obj.getCpf(), obj);
	}
	
	public void excluirCliente(ClienteCelular obj) {
		listaClientes.remove(obj.getCpf());
	}
	
	public static ClienteCelular pesquisaClienteCpf (String cpf) throws CelularException{
		if (listaClientes.containsKey(cpf)){
			return listaClientes.get(cpf);
		} else {
			throw new CelularException("N�o existe cliente para o cpf!");
		}
	}
	
	public static ArrayList<ClienteCelular> pesquisaClientesNome (String nome ) throws CelularException {
		ArrayList<ClienteCelular> resp = new ArrayList<ClienteCelular>();
		for (ClienteCelular obj : listaClientes.values()){
			if (obj.getNome().contains(nome.toUpperCase())){
				resp.add(obj);
			}
		}
		if(resp.isEmpty()){
			throw new CelularException("N�o existe cliente para o nome indicado!" );
		}
		Collections.sort(resp, new Comparator<ClienteCelular>() {

			@Override
			public int compare(ClienteCelular o1, ClienteCelular o2) {
				// TODO Auto-generated method stub
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		return resp;
	}
}
