
public class Campo {
	private int tam;
	private int[] campo;
	private int bolaP; 
	
	public Campo(int t) {
		tam = t;
		campo = new int[tam];

		campo[t/2] = -1;
		setBolaP(t/2);
	}
	
	public void colocarF(int i) {
		if(i < tam && campo[i] == 0 && campo[i] != -1) {
			campo[i] = 1;
		}
	}
	public boolean moverBola(char side) {
		int mov = bolaP;
		

		
		if(side == 'd') {
			
			for(int i = bolaP;i < tam-1 && campo[i+1] == 1;++i) {
				mov++;
				
			}
			if(mov+1 == tam) {
				System.out.println("venceu");
				return false;
			}			
			else {
				if(mov - bolaP != 0) {
					for(int i = bolaP - mov;i <= 0;++i) {
						campo[mov+i] = 0;
					}		
					campo[mov+1] = -1;
					bolaP = mov+1;
				}

				
			}
		}
		else if(side == 'e') {
			for(int i = bolaP;i > 1 && campo[i-1] == 1;--i) {
				mov--;
			}
			if(mov-1 == 0) {
				System.out.println("venceu");
				return false;

			}			
			else {
				if(mov - bolaP != 0) {
					for(int i = bolaP - mov;i >= 0;--i) {
						campo[mov+i] = 0;
					}
					campo[mov-1] = -1;
					bolaP = mov-1;
				}

				
			}
		}
		else {
			System.out.println("Bad side");
		}

		for(int i = 0;i < tam;++i) {
			System.out.println(campo[i]);
		}
		System.out.println();
		
		return true;

		
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}

	public int[] getCampo() {
		return campo;
	}

	public void setCampo(int campo[]) {
		this.campo = campo;
	}

	public int getBolaP() {
		return bolaP;
	}

	public void setBolaP(int bolaP) {
		this.bolaP = bolaP;
	}
}
