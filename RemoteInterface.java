package com.uern.rpcdistribuidos;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    String buscar(String nome) throws RemoteException;
}
