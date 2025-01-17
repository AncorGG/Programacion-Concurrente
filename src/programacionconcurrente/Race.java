/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionconcurrente;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author Ancor
 */
public class Race {

    public int trackDistance;
    public Car[] cars;
    private AtomicBoolean raceFinished;

    public Race(int trackDistance, Car[] cars) {
        this.trackDistance = trackDistance;
        this.cars = cars;
        this.raceFinished = new AtomicBoolean(false);
    }

    public void startRace() {
        Thread[] threads = new Thread[cars.length];

        for (int i = 0; i < cars.length; i++) {
            final int carIndex = i;

            threads[i] = new Thread(() -> {
                while (!raceFinished.get() && cars[carIndex].distanceTravelled < trackDistance) {
                    cars[carIndex].Move();

                    if (cars[carIndex].distanceTravelled >= trackDistance) {
                        if (raceFinished.compareAndSet(false, true)) {
                            System.out.println("Car " + (carIndex + 1) + " wins the race!");
                        }
                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        while (!raceFinished.get()) {
            printRaceState();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted during race state update.");
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted during join.");
            }
        }

        System.out.println("Race finished!");

    }

    public void printRaceState() {
        System.out.println("-------------------------------------");
        for (int i = 0; i < cars.length; i++) {
            System.out.print("Car " + (i + 1) + ": ");
            printTrack(cars[i].distanceTravelled);
        }
        System.out.println("-------------------------------------");

    }

    public void printTrack(float distanceTravelled) {
        for (int i = 0; i < trackDistance / 10; i++) {
            if (distanceTravelled / 10 >= i) {
                System.out.print("#");
            } else {
                System.out.print("_");
            }
        }
        System.out.println("");
    }

}
