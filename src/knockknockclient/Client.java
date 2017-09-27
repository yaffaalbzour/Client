package knockknockclient;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException 
    {
        try (
            Socket kkSocket = new Socket("localhost", 1234);
            PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(kkSocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String meaningFromServer;
            String wordFromUser;

            while ((meaningFromServer = in.readLine()) != null) {
                System.out.print(meaningFromServer);
                if (meaningFromServer.equals("Bye."))
                    break;
                
                wordFromUser = stdIn.readLine();
                if (wordFromUser != null) {
                    //System.out.println("Means: " + wordFromUser);
                   out.println('\n'+wordFromUser);
                }
            }
        }
    }
}