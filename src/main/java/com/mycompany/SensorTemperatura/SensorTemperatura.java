package com.mycompany.SensorTemperatura;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SensorTemperatura {

    public static void main(String[] args) {
        InetAddress ipServidor = null;
        PrintWriter pw;
        try {
            ipServidor = InetAddress.getByName("localhost");
            Socket cliente = new Socket(ipServidor, 20000);
            System.out.println(cliente);
            pw = new PrintWriter(cliente.getOutputStream(), true); //El segundo parametro activa el autoflush para escribir en el buffer
            pw.println("temperatura");
            HiloSensado sensor = new HiloSensado(cliente, pw);
            sensor.start();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}