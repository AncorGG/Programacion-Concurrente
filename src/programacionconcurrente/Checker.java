/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionconcurrente;

/**
 *
 * @author Ancor
 */
public class Checker implements Runnable {

    public Thread tarea;

    public Checker(Thread tarea) {
        this.tarea = tarea;
    }

    @Override
    public void run() {
        while (tarea.isAlive()) {
            System.out.println("Checking....");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        System.out.println("Checking stopped");
    }
}
