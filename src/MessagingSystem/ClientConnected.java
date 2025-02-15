package MessagingSystem;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnected implements Runnable {
    private Socket clients;
    private DataInputStream input;
    private int clientId;
    public ClientConnected(Socket clients, int clientId){
        this.clients= clients;
        this.clientId= clientId;
        try {
            this.input = new DataInputStream( new BufferedInputStream(this.clients.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            close();
        }
    }

    @Override
    public void run() {
        readMessages();
        
    }

    public void close(){
        try {
            if(clients!=null) clients.close();
            if(input!= null) input.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readMessages(){
        String message="";
       try {
         while(!message.equals("over")){
            message = input.readUTF();
            System.out.printf("message from client %d: %s", clientId,message);
            System.out.println();
        }
       } catch (IOException e) {
            System.out.println(e.getMessage());
       } finally {
            close();
       }
    }
}
