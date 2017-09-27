package client;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException 
    {
        try (
            Socket Socket = new Socket("localhost", 1234);
            PrintWriter out = new PrintWriter(Socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(Socket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String meaningFromServer;
            String wordFromUser;

            while ((meaningFromServer = in.readLine()) != null) {
                System.out.print(meaningFromServer);
                if (meaningFromServer.equals("Bye.")){
                    Socket.close();
                    break;
                }
                
                wordFromUser = stdIn.readLine();
                if (wordFromUser != null) {
                   out.println(wordFromUser);
                }
            }
            
        }
    }
}