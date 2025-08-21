package com.mycompany.SensorTemperatura;

public class SensorTemperatura {

    public static void main(String[] args) {

        HiloSensado sensor = new HiloSensado();
        sensor.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sensor.apagar();
    }
}