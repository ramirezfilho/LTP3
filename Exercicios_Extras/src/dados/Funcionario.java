package dados;

public abstract class Funcionario {
	
	public final static int MENSALISTA = 1;
	public final static int HORISTA = 2;
	
	
	public static int sequencia = 0;
	
	private String nome;
	private String cpf;
	private int matricula = ++sequencia;
	
	public Funcionario(String nome, String cpf ) {
		this.nome = nome;
		this.cpf = cpf;
	}
		
	
	public static void setSequencia(int sequencia) {
		Funcionario.sequencia = sequencia;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cpf=" + cpf + ", matricula="
				+ matricula + "]";
	}


	public abstract double getSalario (int mes, int ano);
	
	public abstract int getTipo();

}


