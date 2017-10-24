package SO;

import javax.swing.JOptionPane;

public class FCFS{
	
	public void calcular() {
		Escalona fcfs = new Escalona();
		StringBuilder sb = new StringBuilder();
		int i,j;
		fcfs.entrada();
		
		fcfs.tEsp[0] = 0;
		//Calcular o tempo de espera
		
		for(i=1;i<fcfs.n;i++){
			fcfs.tEsp[i]=0;
	        for(j=0;j<i;j++)
	        	fcfs.tEsp[i]+=fcfs.burst[j];
	    }
		//sb.append("P \t\t  Burst  \t\t\t  TE  \t\t\t ME\n");
		//Calcular a media de espera
		for(i=0;i<fcfs.n;i++)
	    {
			fcfs.tResp[i]=fcfs.burst[i]+fcfs.tEsp[i];
			fcfs.mEsp+=fcfs.tEsp[i];
			fcfs.mResp+=fcfs.tResp[i];
	        sb.append("P"+ (i+1) +"  \tBurst: " + fcfs.burst[i] + "    \t\tTE: " + fcfs.tEsp[i] + 
	        		"     \t\tME: "+fcfs.tResp[i]+"\n");
	        
	    }
		fcfs.mEsp/=i;
		fcfs.mResp/=i;
	    sb.append("\n\nTempo medio de espera: "+fcfs.mEsp);
	    sb.append("\nTempo medio de entrega: "+fcfs.mResp);
	    JOptionPane. showMessageDialog(null,sb);
	}
}
