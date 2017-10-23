//Threads Java Produtor-Consumidor

//Produtor
class Producer implements Runnable{
	private Channel mbox;
	//Construtor
	public Producer(Channel mbox){
		this.mbox = mbox;
	}
	
	public void run(){
		//criando a variavel do tipo Date
		Date message;
		
		while (true){
			//domindo 
			SleepUtilities.nap();
			//produzir um item e inseri-lo no buffer
			message = new Date();
			
			System.out.println("Mensagem enviada: " +message);
			//Enviar a mensagem inserida
			mbox.send(message);
		}
	}
}
//Consumidor
class Consumer implements Runnable{
	private Channel mbox;
	
	//Construtor
	public Consumer(Channel mbox){
		this.mbox = mbox;
	}
	
	public void run(){
		//criando a variavel do tipo Date
		Date message;
		
		while (true){
			//domindo 
			SleepUtilities.nap();
			//receber o item enviado pelo produtor
			message = (Date)mbox.receive();
			
			if (message != null)
				//Ler a mensagem
				System.out.println("Mensagem recebida: " +message);
			
		}
	}
}

public class Factory{
	//Construtor
	public Factory(){
		//Primeiro cria o buffer de mensagem
		Channel mailBox = new MessageQueue();
		
		//Cria as threads produtor e o consumidor 
		//Cria um objeto do tipo Thread para referenciar o Produtor
		Thread producerThread = 
					new Thread(new Producer(mailBox));			
		//Cria um objeto do tipo Thread para referenciar o Consumidor
		Thread consumerThread = 
					new Thread(new Consumer(mailBox));
		//Inicia as Threads
		producerThread.start();
		consumerThread.start();
	}
	public static void main(String args[]){
		Factory server = new Factory();
	}
}