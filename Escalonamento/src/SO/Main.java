package SO;

import javax.swing.JOptionPane;

public class Main/* extends Escalona*/{
	
	
	/*public void entrada() {
		String entrada = JOptionPane.showInputDialog("Numero de processos (maximo 20): ");
		n =  Integer.parseInt(entrada);
		
		System.out.println("Numero de Burst de cada processo: ");
		for (int l = 0; l < n; l++) {
			entrada = JOptionPane. showInputDialog("P["+l+"]:");
			burst[l] = Integer.parseInt(entrada);
			
		}
		tEsp[0] = 0;
	}
*/
	public static void main(String[] args) {
		String menu;
		do{
			menu = JOptionPane.showInputDialog(
					"1 - FSFC\n2 - SJF\n3 - SRTF\n"
					+ "4 - Round RobinR\n5 - Multinível");
			
			if( menu != null ){
				switch( menu ){
				case "1" : FCFS fcfs = new FCFS(); fcfs.calcular();/*FCFS*/
					break;
				case "2" : SJF sjf = new SJF(); sjf.calcular();/*SJF*/
					break;
				case "3" : /*SRTF*/
					break;
				case "4" : /*RR*/
					break;
				case "5" : /*Multinivel*/
					break;
				}
			}
		}while( menu != null );
		

	}

}
