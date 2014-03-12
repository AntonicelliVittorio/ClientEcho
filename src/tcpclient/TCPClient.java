package tcpclient;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author antonicelli.vittorio
 */

public class TCPClient{
    public static void main(String[] args)throws IOException{
        Socket s = null;
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader tastiera = null;

        try{
            s = new Socket("localhost",2000);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Connesso con echoserver "+ s.getInetAddress());
            System.out.println("Comandi possibili: 'fine'  'maiuscole:on'  'maiuscole:off'");
            while(true){
                try{
                    System.out.print(": ");
                    String str = tastiera.readLine();
                    if(str.equals("fine")){
                        out.println(str);
                        break;
                    }
                    out.println(str);
                    if(str.equals("maiuscole:on") == false && str.equals("maiuscole:off") == false){
                            System.out.println("> " + in.readLine());
                    }
                }catch(IOException e){}
            }
        
        }catch(IOException e){
            System.out.println("Server non raggiungibile");
        }  
    }
}