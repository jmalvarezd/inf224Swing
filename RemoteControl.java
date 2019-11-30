public class RemoteControl {
	
	//Serveur par defaut
	static final String DEFAULT_HOST = "localhost";
	static final int DEFAULT_PORT = 3332;
	
	//La fonction main:
	//Initialiser une instance de 'Client' et l'utiliser
	//pour construire une instance de MyFrame
	public static void main(String[] args) {
		Client client = null;
		try {
			client = new Client(DEFAULT_HOST,DEFAULT_PORT);
		}
		catch(Exception e){
			System.err.println("Client: Couldn't connect to "+DEFAULT_HOST+":"+DEFAULT_PORT);
			System.exit(1);
	    }
		System.out.println("Client connected to "+DEFAULT_HOST+":"+DEFAULT_PORT);
		MyFrame myFrame = new MyFrame(client);
		
	}
}
