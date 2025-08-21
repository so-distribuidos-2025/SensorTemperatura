package com.mycompany.SensorTemperatura;
import java.lang.Math;

public class HiloSensado extends Thread {
    private boolean on;
    private float temperatura;

    public HiloSensado() {
        this.on = true;
        this.temperatura = 0;
    }

    public float getTemperatura() {
        return temperatura;
    }

    private float generarTemperatura() {
        return (float) (Math.random() * 125 - 40); // TODO buscar mejor forma de simular esto
    }

    public void encender() {
        on = true;
    }

    public void apagar() {
        on = false;
    }

    public void run() {
        while (on) {
            temperatura = generarTemperatura();
            System.out.println("Temperatura actual: " + temperatura + " °C");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}