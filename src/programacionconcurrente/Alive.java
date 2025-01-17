/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionconcurrente;

/**
 *
 * @author Ancor
 */
public class Alive implements Runnable{
   

    @Override
    public void run() {
       
        for (int i = 0; i < 20; i++) {
            System.out.println("Status: Alive");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        }

    }
    
}
