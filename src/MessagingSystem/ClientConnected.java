package MessagingSystem;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnected {
    private Socket clients;
    private DataInputStream input;
    public ClientConnected(Socket clients){
        this.clients= clients;
        try {
            this.input = new DataInputStream(this.clients.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessages(){
        String message="";
        while(!message.equals("over")){
            try {
                message = input.readUTF();
            } catch (Exception e) {
                // TODO: handle exception
            }
            System.out.println(message);
        }
    }
}
