/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionconcurrente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ancor
 */
public class Coordinator {

    private int numThreads, countStart, countEnd;
    private List<int[]> ranges;
    private List<Thread> threads;

    public Coordinator(int numThreads, int countStart, int countEnd) {
        this.numThreads = numThreads;
        this.countStart = countStart;
        this.countEnd = countEnd;
        this.ranges = Divide();
        this.threads = new ArrayList<>();
    }

    public List<int[]> Divide() {
        int totalNumbers = this.countEnd - this.countStart + 1;
        int rangePerThread = totalNumbers / this.numThreads;
        int remainder = totalNumbers % this.numThreads;

        List<int[]> ranges = new ArrayList<>();

        int start = this.countStart;
        for (int i = 0; i < this.numThreads; i++) {
            int end = start + rangePerThread - 1;

            if (remainder > 0) {
                end++;
                remainder--;
            }

            ranges.add(new int[]{start, end});

            start = end + 1;
        }

        return ranges;
    }

    public void StartCounting() {
        for (int[] range : ranges) {
            Tarea tarea = new Tarea(range[0], range[1]);
            Thread hilo = new Thread(tarea);
            threads.add(hilo);
        }

        for (Thread hilo : threads) {
            try {
                hilo.start();
                hilo.join();
            } catch (InterruptedException ie) {
                ie.getStackTrace();
            }
        }
    }

}
