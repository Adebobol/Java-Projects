package MessagingSystem;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

class ClientSystem{
    private Socket socket = null;
    String  Ip = "127.0.0.1";
    int Port = 4000;
    private DataOutputStream output = null;
    private BufferedReader msg = null;

    public void LinkCLient(){
       try {
            socket = new Socket(Ip,Port);
            output = new DataOutputStream(socket.getOutputStream());
            msg = new BufferedReader(new InputStreamReader(System.in));
            while(true){
                String text = msg.readLine();
                output.writeUTF(text);
            }
       } catch (IOException e) {
       }
    }

    public static void main(String[] args) {
        ClientSystem clientSystem = new ClientSystem();
        clientSystem.LinkCLient();
    }
}