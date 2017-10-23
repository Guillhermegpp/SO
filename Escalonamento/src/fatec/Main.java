package fatec;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 0, j, i;
		int burst[] = new int[20], /* burst */
				tEsp[] = new int[20], /* Tempo de espera */
				tResp[] = new int[20], /* Tempo de resposta */
				mEsp = 0, /* Media de espera */
				mResp = 0;/* Media de resposta */

		StringBuilder sb = new StringBuilder();
		String entrada = JOptionPane.showInputDialog("Numero de processos (maximo 20): ");
		n = Integer.parseInt(entrada);

		System.out.println("Numero de Burst de cada processo: ");
		for (int l = 0; l < n; l++) {
			entrada = JOptionPane.showInputDialog("P[" + l + "]:");
			burst[l] = Integer.parseInt(entrada);

		}
		tEsp[0] = 0;
		// Calcular o tempo de espera
		for (i = 1; i < n; i++) {
			tEsp[i] = 0;
			for (j = 0; j < i; j++)
				tEsp[i] += burst[j];
		}
		for (i = 0; i < n; i++) {
			tResp[i] = burst[i] + tEsp[i];
			mEsp += tEsp[i];
			mResp += tResp[i];
			sb.append("Processo[" + (i + 1) + "]  \tBurst: " + burst[i] + "    \t\tTE: " + tEsp[i] + "     \t\tME: "
					+ tResp[i] + "\n");

		}
		mEsp /= i;
		mResp /= i;
		sb.append("\n\nTempo medio de espera: " + mEsp);
		sb.append("\nTempo medio de entrega: " + mResp);
		JOptionPane.showMessageDialog(null, sb);

		scan.close();
	}

}
