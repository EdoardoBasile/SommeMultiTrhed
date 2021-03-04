/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

/**
 *
 * @author basile.edoardo
 */
public class ThreadSomma implements Runnable {
    int somma;
    boolean b;
    public ThreadSomma(int somma) {
        this.somma=somma;
        b=true;
    }
    
    @Override
    public void run() {
        while(b){
            ServerMultiThread.m= ServerMultiThread.m+somma;
            b=false;
        }
    }
    
}
