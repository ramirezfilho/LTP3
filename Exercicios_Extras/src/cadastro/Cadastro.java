package cadastro;

import java.util.ArrayList;

import dados.Funcionario;
import dados.Horista;
import dados.Mensalista;

public class Cadastro {
	
	public static ArrayList<Horista> listaHorista = new ArrayList<Horista>();
	public static ArrayList<Mensalista> listaMensalista = new ArrayList<Mensalista>();

		public Cadastro(){
		}


	public static void CadastroHorista (Horista objFuncionario){
		listaHorista.add(objFuncionario);
	}
	
	public static void CadastroMensalista (Mensalista objFuncionario){
		listaMensalista.add(objFuncionario);
	}


}


