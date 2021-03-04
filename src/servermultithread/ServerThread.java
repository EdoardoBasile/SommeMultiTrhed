/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pogliani.mattia
 */
public class ServerThread implements Runnable {

    private Socket clientSocket;

    public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        System.out.println("Serverino  partito: "
                + clientSocket.getInetAddress());
        try {

            PrintWriter out
                    = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            String richiesta = "";
            while (!richiesta.equals("exit")) {
                System.out.println("serverino in ascolto...");
                richiesta = in.readLine();
                System.out.println("caratteri: " + richiesta);
                int i= Integer.parseInt(richiesta);
                Thread[] t=new Thread[i]; 
                for(int f=0;f<i;f++){
                    ThreadSomma s=new ThreadSomma(f);
                    t[f]=new Thread(s);
                }
                for(int f=0;f<i;f++){
                    t[f].start();
                    t[f].stop();
                }
            }
            clientSocket.close();

            System.out.println("chiusura connessione effettuata");

        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
