import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Campo c = new Campo(10);
		Scanner s = new Scanner(System.in);
		int entrada;
		boolean fim = true;
		boolean back = false;
		int posB = c.getBolaP();
		while(fim) {
			for(int i = 0;i < c.getTam();++i) {
				System.out.println(c.getCampo()[i]);
			}
			System.out.println();
			entrada = s.nextInt();
			System.out.println("meu turno");
			switch(entrada) {
				case 1:
					entrada = s.nextInt();
					if(entrada == 1) {
						fim = c.moverBola('e');
					}
					else if(entrada == 2) {
						fim = c.moverBola('d');
					}
					break;
				case 2:
					entrada = s.nextInt();
					c.colocarF(entrada);
					break;
				default:
					break;
			}
			for(int i = 0;i < c.getTam();++i) {
				System.out.println(c.getCampo()[i]);
			}
			System.out.println();
			System.out.println("maquina turno");
			if(posB < c.getBolaP()) {
				System.out.println("você moveu para trás");
				back = true;
			}
			if(c.getCampo()[c.getBolaP()-1] == 1 && back == false) {
				System.out.println("posso pular um filosofo");
				if(c.getCampo()[0] != 1 && c.getCampo()[1] == 1) {
					c.colocarF(0);
				}
				else {
					fim = c.moverBola('e');
				}
				
			}
			else if(c.getBolaP()+3 < c.getTam() && c.getCampo()[c.getBolaP()+1] == 0 && c.getCampo()[c.getBolaP()+2] == 0 && c.getCampo()[c.getBolaP()+3] == 0 && back == false) {
				int t = 0;
				for(int i = 0;i < c.getBolaP() && c.getCampo()[i] == 1;i++) {
					System.out.println("achei um filosofo");
					t++;
				}
				System.out.println("vou por um filosofo em " + t);
				c.colocarF(t);
				
			}
			else if(c.getBolaP()+3 < c.getTam() && !(c.getCampo()[c.getBolaP()+1] == 0 && c.getCampo()[c.getBolaP()+2] == 0 && c.getCampo()[c.getBolaP()+3] == 0)){
				System.out.println("invadindo meu territorio");
				c.colocarF(c.getBolaP()-1);
			}
			else if(back) {
				System.out.println("tentando vencer");
				c.colocarF(c.getBolaP()-1);
				back = false;
			}
			else {
				System.out.println("n tenho movimento");
			}
			posB = c.getBolaP();
			 /*if(c.getCampo()[c.getBolaP()+1] == 0) {
				int j = 1;
				for(int i = c.getBolaP();i > 1 && c.getCampo()[i-1] == 1;--i) {
					j++;
				}
				if(j-c.getBolaP()==0) {
					fim = c.moverBola('e');
				}
				else {
					c.colocarF(c.getBolaP()-j);
				}
			}*/
		}
	}

}
