package MessagingSystem;

import java.net.ServerSocket;

public class Server {
    private ServerSocket ssocket = null;

    public void LinkServer(int port, int backlog){
        try {
            ssocket = new ServerSocket();
            System.out.println("server initialized.");
            System.out.println("waiting for incoming clients.");
            ssocket.accept();

        } catch (Exception e) {
            
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.LinkServer(4000,1);
    }
   
}
