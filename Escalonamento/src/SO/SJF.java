package SO;

import javax.swing.JOptionPane;

public class SJF {

	public void calcular() {
		Escalona sjf = new Escalona();
		int[] ord = new int[20];
		StringBuilder sb = new StringBuilder();
		sjf.entrada();
		int aux;
		/*// ordenar
		for (int k = 0; k < sjf.n; k++) {
			for (int j = 0; j < sjf.n; j++) {
				if (sjf.burst[j] < sjf.burst[k]) {
					aux = j;
					ord[k] = aux;
				}

				System.out.println(ord[k]);
			}
		}
		System.out.println("");*/

		sjf.tEsp[ord[0]] = 0;
		// Calcular o tempo de espera

		for (int i = 1; i < sjf.n; i++) {
			sjf.tEsp[ord[i]] = 0;
			for (int j = 0; j < i; j++)
				sjf.tEsp[ord[i]] += sjf.burst[j];
		}
		int i;
		// Calcular a media de espera
		for (i = 0; i < sjf.n; i++) {
			sjf.tResp[i] = sjf.burst[i] + sjf.tEsp[i];
			sjf.mEsp += sjf.tEsp[i];
			sjf.mResp += sjf.tResp[i];
			sb.append("Processo[" + (sjf.p[i]+1) + "]  \tBurst: " + sjf.burst[sjf.p[i]] + "    \t\tTE: " + sjf.tEsp[sjf.p[i]] + 
					"     \t\tME: "+ sjf.tResp[sjf.p[i]] + "\n");

		}
		sjf.mEsp /= i;
		sjf.mResp /= i;
		sb.append("\n\nTempo medio de espera: " + sjf.mEsp);
		sb.append("\nTempo medio de entrega: " + sjf.mResp);
		JOptionPane.showMessageDialog(null, sb);
	}
}
