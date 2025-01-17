/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programacionconcurrente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ancor
 */
public class ProgramacionConcurrente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        /* EJERCICIO 1
        Realiza una aplicación de consola que cuente hasta un número determinado
        (mostrando la secuencia por pantalla) utilizando dos hilos, 
        de forma que cada uno de ellos cuente un rango de números
         */
 /*
        Tarea tarea = new Tarea(1,5);
        Tarea tarea2 = new Tarea(6,10);

        
        Thread hilo1 = new Thread(tarea);
        Thread hilo2 = new Thread(tarea2);

        hilo1.start();
        hilo1.join();     
        
        hilo2.start();
        hilo2.join();
        
        System.out.println("Fin de hilo principal");
         */
 /* EJERCICIO 2
        Realiza una aplicación de consola que cuente hasta un número determinado
        (mostrando la secuencia por pantalla) utilizando un número determinado de hilos.
        La secuencia de números se repartirá a partes iguales entre todos los hilos
        de forma que a cada uno se le asigne un rango
         */
 /*
        Coordinator cord = new Coordinator(3, 1, 11);
        
        cord.StartCounting();
         
         */
 /* EJERCICIO 3
        Realiza una aplicación que simule una carrera de coches (de hasta 4 coches). 
        Para cada coche se podrá configurar su velocidad y en la aplicación podremos configurar la distancia del circuito. 
        Una vez lanzada la carrera se irá mostrando por pantalla (mediante barras de progreso, 
        por ejemplo) el desarrollo de la misma (el avance de cada coche en el tiempo). 
        Al final de la carrera se anunciará el coche ganador y los demás se detendrán mostrando cuánta distancia han recorrido
         */
 /*
        Car car1 = new Car(5);
        Car car2 = new Car(8);
        Car car3 = new Car(6);
        Car car4 = new Car(4);
        Car car5 = new Car(7);

        Race race = new Race(200, new Car[]{car1, car2, car3, car4, car5});

        race.startRace();
         */
 
 /* EJERCICIO 4
        Realiza una aplicación de texto que lance dos hilos de forma que
        el segundo se ejecute mientras dure la ejecución del primero
         */
 /*
        Alive a1 = new Alive();

        Thread hilo1 = new Thread(a1);

        Checker c1 = new Checker(hilo1);

        Thread hilo2 = new Thread(c1);
        
        hilo1.start();
        hilo2.start();
         */
 /* EJERCICIO 5
        Realiza una aplicación que ejecute 4 hilos de forma que se ejecuten
        de forma ordenada uno detrás de otro esperando cada uno a que termine
        el anterior para ejecutarse
         */
 
        Tarea tarea = new Tarea(1, 5);
        Thread[] threads = new Thread[4];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(tarea);
        }

        for (int i = 0; i < threads.length; i++) {
            System.out.println("Thread Started: " + i);
            threads[i].start();
            threads[i].join();
        }
         
    }

}
