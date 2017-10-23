package SO;

import javax.swing.JOptionPane;

public class FCFS extends Escalona{
	
	public void calcular() {
		Escalona fsfc = new Escalona();
		StringBuilder sb = new StringBuilder();
		
		fsfc.entrada();
		
		tEsp[0] = 0;
		//Calcular o tempo de espera
		
		for(i=1;i<n;i++){
	        tEsp[i]=0;
	        for(j=0;j<i;j++)
	            tEsp[i]+=burst[j];
	    }
		//sb.append("P \t\t  Burst  \t\t\t  TE  \t\t\t ME\n");
		//Calcular a media de espera
		for(i=0;i<n;i++)
	    {
	        tResp[i]=burst[i]+tEsp[i];
	        mEsp+=tEsp[i];
	        mResp+=tResp[i];
	        sb.append("P"+ (i+1) +"  \tBurst: " + burst[i] + "    \t\tTE: " + tEsp[i] + 
	        		"     \t\tME: "+tResp[i]+"\n");
	        
	    }
		mEsp/=i;
	    mResp/=i;
	    sb.append("\n\nTempo medio de espera: "+mEsp);
	    sb.append("\nTempo medio de entrega: "+mResp);
	    JOptionPane. showMessageDialog(null,sb);
	}
}
