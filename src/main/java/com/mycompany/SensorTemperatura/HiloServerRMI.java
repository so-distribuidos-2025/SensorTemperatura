package com.mycompany.SensorTemperatura;
/*
 * Clase HiloServerRMI
 * -------------------
 * Este hilo permite iniciar un servidor RMI (Remote Method Invocation)
 * en un puerto dinámico calculado a partir de un identificador.
 *
 * Cada instancia de este hilo crea un registro RMI en el puerto correspondiente
 * y publica un objeto remoto que implementa la interfaz {@link interfaces.IServerRMI}.
 */

import com.mycompany.SensorTemperatura.interfaces.ISensorRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para mandar a hacer las cosas de HiloSensado
 */
public class HiloServerRMI extends UnicastRemoteObject implements ISensorRMI{
    private HiloSensado sensorRMI;

    public HiloServerRMI(HiloSensado sensorRMI) throws RemoteException {
        this.sensorRMI = sensorRMI;
    }


    @Override
    public void setValor(double valor) throws RemoteException {
        this.sensorRMI.setValor(valor);

    }

    @Override
    public void setAuto(boolean auto) throws RemoteException {
        this.sensorRMI.setAuto(auto);
    }
}
