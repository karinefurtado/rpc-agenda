package com.uern.rpcdistribuidos;

import org.springframework.stereotype.Service;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

@Service
public class RMIService {

    private RemoteInterface remoteService;

    public String buscar(String nome) throws Exception {
        if (remoteService == null) {
            throw new IllegalStateException("Serviço pronto para uso!");
        }
        return remoteService.buscar(nome);
    }

    public void init() throws Exception {
        try {
            if (remoteService == null) {
                remoteService = new RemoteImplementation();
                Registry registry = LocateRegistry.createRegistry(1099);
                registry.rebind("RemoteService", remoteService);
            }
        } catch (Exception e) {
            remoteService = null;
            throw e;
        }
    }
    
    public void close() {
        try {
            if (remoteService != null) {
                // Unbind the remote service
                Registry registry = LocateRegistry.getRegistry();
                registry.unbind("RemoteService");

                // Unexport the remote service
                // Note: This assumes that RemoteImplementation implements UnicastRemoteObject
                // If not, you may need to use UnicastRemoteObject.exportObject to get the remote object reference
                UnicastRemoteObject.unexportObject(remoteService, true);

                remoteService = null;
            }
        } catch (Exception e) {
            // Handle exception or log error as needed
            e.printStackTrace();
        }
    }
}
