package dados;

public class CelularCartao extends Celular {
	private double creditos;

	public CelularCartao(String numero, double creditos) {
		super(numero);
		this.creditos = creditos;
	}

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}
	
	public int getTipo(){
		return CELULAR_CARTAO;
	}
	
	public String toString() {
		return
		super.toString() + 
		"Créditos: " + creditos + "\n";
	}
	
	
}
