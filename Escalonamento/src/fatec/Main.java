package fatec;


import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String menu;
		
		do{
			Escalonador process = new Escalonador();
			menu = JOptionPane.showInputDialog(
					"1 - FSFC\n2 - SJF\n3 - SRTF\n"
					+ "4 - Round RobinR\n5 - Multinível");
			
			if( menu != null ){
				switch( menu ){
				case "1" : process.FCFS();/*FCFS*/
					break;
				case "2" : process.SJF();/*SJF*/
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
