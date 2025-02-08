package SocketPro;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSide {
    private Socket socket = null;
    private BufferedReader input = null;
    // private DataInputStream input = null;
    private DataOutputStream out =  null;


    public ClientSide(String address, int port){
        try {
            socket = new Socket(address, port);
            System.out.println("connected");
            // input = new DataInputStream(System.in);
            input = new BufferedReader(new InputStreamReader(System.in));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        String line = "";
        while(!line.equals("over")){
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        try {
            input.close();
            out.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ClientSide client = new ClientSide("127.0.0.1", 7000);
    }

}


