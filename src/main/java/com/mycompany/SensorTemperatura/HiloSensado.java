package com.mycompany.SensorTemperatura;

import java.io.PrintWriter;
import java.lang.Math;
import java.net.Socket;

public class HiloSensado extends Thread {
    private boolean on;
    private double temperatura;
    private Socket cnxServidor;
    PrintWriter pw;

    public HiloSensado(Socket s, PrintWriter pw) {
        this.on = true;
        this.temperatura = 40;
        this.cnxServidor = s;
        this.pw = pw;
    }

    public double getTemperatura() {
        return temperatura;
    }

    private void generarTemperatura() {
        double cambio = (double) (Math.random() * 20 - 10);
        temperatura += cambio;
        if (temperatura > 125) {
            temperatura = 125;
        }
        if (temperatura < -40) {
            temperatura = -40;
        }
        Math.random();
    }

    public void encender() {
        on = true;
    }

    public void apagar() {
        on = false;
    }

    public void run() {
        while (on) {
            generarTemperatura();
            pw.println(this.temperatura);
            System.out.println(temperatura);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}