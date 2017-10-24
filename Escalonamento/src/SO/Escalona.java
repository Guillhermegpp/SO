package SO;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Escalona {

	/*
	 * ArrayList<Integer> p,burst,tEsp,tResp; public int n=0,j,i, Processo burst
	 * Tempo de espera Tempo de resposta mEsp=0,Media de espera mResp=0;Media de
	 * resposta Scanner scan = new Scanner(System.in);
	 */
	public int n = 0, j, i, p[] = new int[20], /* Processo */
			burst[] = new int[20], /* burst */
			tEsp[] = new int[20], /* Tempo de espera */
			tResp[] = new int[20], /* Tempo de resposta */
			mEsp = 0, /* Media de espera */
			mResp = 0;/* Media de resposta */
	Scanner scan = new Scanner(System.in);

	public void entrada() {
		String entrada = JOptionPane.showInputDialog("Numero de processos (maximo 20): ");
		n = Integer.parseInt(entrada);
		String op = JOptionPane.showInputDialog("Definir tamanho do burst de cada processo?(S/N)");
		if (op.toUpperCase().equals("S")) {
			for (int l = 0; l < n; l++) {
				entrada = JOptionPane.showInputDialog("P[" + (l + 1) + "]:");
				burst[l] = Integer.parseInt(entrada);
			}
		} else {
			Random rd = new Random();
			for (int l = 0; l < n; l++) {
				burst[l] = rd.nextInt(11);
			}
		}
		scan.close();
	}

	public void FCFS() {

		StringBuilder sb = new StringBuilder();
		int i, j;
		entrada();

		tEsp[0] = 0;
		// Calcular o tempo de espera

		for (i = 1; i < n; i++) {
			tEsp[i] = 0;
			for (j = 0; j < i; j++)
				tEsp[i] += burst[j];
		}
		// sb.append("P \t\t Burst \t\t\t TE \t\t\t ME\n");
		// Calcular a media de espera
		for (i = 0; i < n; i++) {
			tResp[i] = burst[i] + tEsp[i];
			mEsp += tEsp[i];
			mResp += tResp[i];
			sb.append("P" + (i + 1) + "  \tBurst: " + burst[i] + "    \t\tTE: " + tEsp[i] + "     \t\tME: " + tResp[i]
					+ "\n");

		}
		mEsp /= i;
		mResp /= i;
		sb.append("\n\nTempo medio de espera: " + mEsp);
		sb.append("\nTempo medio de entrega: " + mResp);
		JOptionPane.showMessageDialog(null, sb);
	}

	public void SJF() {

	}

	public void SRTF() {

	}
	
	public void RR() {

	}
	
	public void MultiNivel() {

	}
}
