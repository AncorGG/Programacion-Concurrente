/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacionconcurrente;

/**
 *
 * @author Ancor
 */
public class Car implements Runnable{
    
    public float speed;
    public int distanceTravelled;
    
    public Car(float speed){
        this.speed = speed;
        this.distanceTravelled = 0;
    }
    
    public float Move(){
        distanceTravelled += speed;
        return distanceTravelled;
    }
    
     @Override
    public void run() {
        Move();
    }
    
}
