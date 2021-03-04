/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
sviluppare un applicativo client server che generi tanti thread quanti dichiarati dall'utente attraverso un thread a
lui dedicato. Ogni thread sommera ad una variabile globale contenuta nel server il proprio valore inrementale assegnatogli dal server
da uno ad n dove n è il numero del thread. Il server killera ogni processo dopo che avra svolto l'operzione. Quando tutti i processi 
saranno killati il server stampera a consol il risultato.
 */
package servermultithread;

import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pogliani.mattia
 */
public class ServerMultiThread {
    public static int m=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            ServerSocket server
                    = new ServerSocket(5500);
            System.out.println("Server è attivo e in ascolto");

            while (true) {
                Socket client = server.accept();
                System.out.println("connessione ricevuta, ora se la smazza il thread");
                Thread Serverino
                        = new Thread(new ServerThread(client));
                Serverino.start();

            }

        } catch (IOException ex) {
            Logger.getLogger(ServerMultiThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
