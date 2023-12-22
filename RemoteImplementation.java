package com.uern.rpcdistribuidos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteImplementation extends UnicastRemoteObject implements RemoteInterface {
    private static final long serialVersionUID = 1L;

    public RemoteImplementation() throws RemoteException {
        super();
    }

    @Override
    public String buscar(String nome) throws RemoteException {
    	String nomeMaiusculo = nome.toUpperCase();
    	
    	if (nomeMaiusculo.equals("KARINE")) {
    		return " é (94) 99126-4724";
    	} else if (nomeMaiusculo.equals("LUIZIANE")) {
    		return " é (84) 99956-2117";
    	} else if (nomeMaiusculo.equals("GLAUCIA")) {
    		return " é (11) 98752-6634";
    	} else {
    		return " não está cadastrado!";
    	}
    }
}
