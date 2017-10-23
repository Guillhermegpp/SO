package SO;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

public class mae {

	public static void main(String[] args) {
		Random rd = new Random();
		int r = rd.nextInt(21);
		for (int i = 0; i < 10; i++) {
			r = rd.nextInt(11);
			System.out.println(r);
		}
	}

}
