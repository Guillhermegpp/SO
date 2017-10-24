package fatec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Escalonador {
	public StringBuilder sb = new StringBuilder();
	String entrada;
	public ArrayList<Process> lista = new ArrayList<>();
	public ArrayList<Process> listaOrd = new ArrayList<>();
	public int n = 0, j, i, tEsp[] = new int[20], /* Tempo de espera */
			mEsp = 0, /* Media de espera */
			mResp = 0;/* Media de resposta */
	Scanner scan = new Scanner(System.in);

	// Tela com quantidade de Processos
	public void entrada() {
		entrada = JOptionPane.showInputDialog("Numero de processos (maximo 20): ");
		n = Integer.parseInt(entrada);
	}

	// Quando só pede o burst
	public void SoBurst() {
		int burst;
		String op = JOptionPane.showInputDialog("Definir tamanho do burst de cada processo?(S/N)");
		if (op.toUpperCase().equals("S")) {
			for (int l = 0; l < n; l++) {
				entrada = JOptionPane.showInputDialog("P" + (l + 1) + " :");
				burst = Integer.parseInt(entrada);
				lista.add(new Process(l + 1, burst));
			}
		} else {
			Random rd = new Random();
			for (int l = 0; l < n; l++) {
				burst = rd.nextInt(11); // Aleatório de 0 a 10
				lista.add(new Process(l + 1, burst));
			}
		}
	}

	// Burst e Tempo de Chegada
	public void tChegada() {
		int burst, tcheg;
		String op = JOptionPane.showInputDialog("Definir tamanho de chegada de cada processo?(S/N)");
		if (op.toUpperCase().equals("S")) {
			for (int l = 0; l < n; l++) {
				entrada = JOptionPane.showInputDialog("Burst P" + (l + 1) + " :");
				burst = Integer.parseInt(entrada);
				entrada = JOptionPane.showInputDialog("Tempo de Chegada P" + (l + 1) + " :");
				tcheg = Integer.parseInt(entrada);
				lista.add(new Process(l + 1, burst, tcheg));
			}
		} else {
			Random rd = new Random();
			for (int l = 0; l < n; l++) {
				burst = rd.nextInt(11); // Aleatório de 0 a 10
				tcheg = rd.nextInt(11);
				lista.add(new Process(l + 1, burst, tcheg));
			}
		}
	}

	// Calcula e imprimi os resultados
	public void imprimir(ArrayList<Process> p) {
		tEsp[0] = 0;
		// Calcular o tempo de espera
		for (i = 1; i < n; i++) {
			tEsp[i] = 0;
			for (j = 0; j < i; j++)
				tEsp[i] += p.get(j).getBurst();
		}

		// Calcular a media de espera
		for (i = 0; i < n; i++) {
			int tCheg = p.get(i).getBurst() + tEsp[i];
			p.get(i).settCheg(tCheg);
			mEsp += tEsp[i];
			mResp += p.get(i).gettCheg();
			sb.append("P" + p.get(i).getId() + "    Burst: " + p.get(i).getBurst() + "    T.Espera: " + tEsp[i] + " "
					+ "    T.Chegada: " + p.get(i).gettCheg() + "\n");

		}
		mEsp /= i;
		mResp /= i;
		sb.append("\n\nTempo medio de espera: " + mEsp);
		sb.append("\nTempo medio de entrega: " + mResp);
		JOptionPane.showMessageDialog(null, sb);
		sb = new StringBuilder();
	}

	// Simulador do escalonamento FCFS
	public void FCFS() {

		int i, j;
		entrada();
		SoBurst();
		imprimir(lista);

	}

	// Simulador do escalonamento SJF
	public void SJF() {
		entrada();
		tChegada();

		ArrayList<Process> p = new ArrayList<Process>(lista);
		int sumRetorno = 0, menor = 0, pivo = 0;
		// Ordena a lista para garantir a hierarquia de chegada
		Collections.sort(p);
		listaOrd.add(p.remove(0));
		sumRetorno = listaOrd.get(0).getBurst();

		while (p.size() > 1) {
			pivo = 0;
			for (int i = 1; i < p.size(); i++) {
				if (p.get(pivo).getBurst() <= p.get(i).getBurst() && p.get(pivo).gettCheg() < sumRetorno)
					menor = pivo;
				else if (p.get(i).gettCheg() < sumRetorno) {
					pivo = i;
					menor = i;
				}
			}
			sumRetorno += p.get(menor).getBurst();
			listaOrd.add(p.remove(menor));
		}
		// add o ultimo processo a lista, na ultima posicao
		if (p.size() == 1)
			listaOrd.add(p.remove(0));
		imprimir(listaOrd);
	}

	public void SRTF() {

	}

	public void RR() {

	}

	public void MultiNivel() {

	}
}
