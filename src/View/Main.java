package View;

import Controller.AeroportoSemaforo;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaforo= new Semaphore(2);


        for (int i=1; i<=12; i++){
            Thread decolagem= new AeroportoSemaforo(semaforo);
            decolagem.start();
        }
    }
}
