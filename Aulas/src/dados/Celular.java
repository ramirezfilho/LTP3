package dados;

public class Celular {

		public static final int CELULAR = 1 ;
		public static final int CELULAR_CARTAO = 2;
		
		private String numero;
		
		public Celular(String numero) {
			this.numero = numero;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public static int getCelular() {
			return CELULAR;
		}

		public static int getCelularCartao() {
			return CELULAR_CARTAO;
		}

		
		public String toString() {
			return 
					"Número: " + numero + "\n";
		}
		
		public int getTipo(){
			return CELULAR;
		}
		
		
}


