package Controller;

import java.util.concurrent.Semaphore;

public class AeroportoSemaforo extends Thread {

    private static int pista= (int) (Math.random()* 2)+ 1;
    private Semaphore semaforo;

    public AeroportoSemaforo(Semaphore semaforo){
        this.semaforo= semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire();
            decolagem();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            semaforo.release();
        }
    }

    private void decolagem() {
        int tempom= (int) (Math.random()* 4001)+ 3000;
        int tempot= (int) (Math.random()* 5001)+ 5000;
        int tempod= (int) (Math.random()* 3001)+ 1000;
        int tempoa= (int) (Math.random()* 5001)+ 3000;
        try {
            sleep(tempom);
            sleep(tempot);
            System.out.println("O avião #"+ getId() +" está decolando");
            sleep(tempod);
            sleep(tempoa);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (pista % 2 == 0){
            System.out.println("O avião #"+ getId() +" decolou da pista sul");
            pista++;
        }
        else {
            System.out.println("O avião #" + getId() + " decolou da pista norte");
            pista++;
        }
    }
}
