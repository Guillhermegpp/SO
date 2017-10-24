package fatec;

public class Process implements Comparable<Process> {
	
	private int id,
				burst,
				tCheg;

	
	public Process(int id, int burst) {
		this.id = id;
		this.burst = burst;
	}

	public Process(int id, int burst, int tCheg) {
		this.id = id;
		this.burst = burst;
		this.tCheg = tCheg;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getBurst() {
		return burst;
	}


	public void setBurst(int burst) {
		this.burst = burst;
	}


	public int gettCheg() {
		return tCheg;
	}


	public void settCheg(int tCheg) {
		this.tCheg = tCheg;
	}

	
	@Override
	public int compareTo(Process p) {
		if ( (this.tCheg < p.gettCheg() || this.tCheg == p.gettCheg())
				&& (this.getBurst() < p.getBurst()) ) {
			return -1;
		} else if ( (this.tCheg > p.gettCheg() || (this.tCheg == p.gettCheg()) && 
				this.getBurst() > p.getBurst()) ) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
