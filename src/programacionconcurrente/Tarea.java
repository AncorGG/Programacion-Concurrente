/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionconcurrente;

/**
 *
 * @author Ancor
 */
public class Tarea implements Runnable {

    private int start, end;
    
    public Tarea(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        System.out.println("Rango de " + start + " a " + end);
        for (int i = start; i <= end; i++) {
            System.out.println("Cuenta " + i);
        }

    }
}
