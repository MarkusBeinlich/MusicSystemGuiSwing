/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beinlich.markus.musicsystem.model.net;

import de.beinlich.markus.musicsystem.model.ServerAddr;
import de.beinlich.markus.musicsystem.model.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author Markus Beinlich
 */
public class ServerPool implements Serializable {

    protected static ServerPool uniqueInstance;
    private Map<String, ServerAddr> servers;
    private String fileNameServerPool;

    private ServerPool(String clientName) {
        fileNameServerPool = clientName + ".ServerPool";
        File serverFile = new File(fileNameServerPool);
        if (!serverFile.exists()) {
            servers = new TreeMap<>();
            //Der Standard-Server muss immer eingetragen sein, damit sich die Server
            //gegenseitig finden können
            addServer("HiFi-Anlage", new ServerAddr(50001, "127.0.0.1", "HiFi-Anlage",true));
//            addServer(musicNetComponent.getMusicSystem().getName(), musicNetComponent.getMusicSystem().getServerAddr());
        } else {
            try {
                FileInputStream fis = new FileInputStream(serverFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                servers = (Map) ois.readObject();
                ois.close();
                // aktuellen Server aktiv setzen - wenn er nicht existiert wird er hinzugefügt
                // Das geht zumindest Client-seitig nicht, da das MusicSystem ja noch nicht existiert, wenn der Serverpool erzeugt wird
//                if (servers.containsKey(musicNetComponent.getMusicSystem().getName())) {
//                    servers.get(musicNetComponent.getMusicSystem().getName()).setActiv(true);
//                } else {
//                    addServer(musicNetComponent.getMusicSystem().getName(), musicNetComponent.getMusicSystem().getServerAddr());
//                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ServerPool.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ServerPool.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerPool.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public static synchronized ServerPool getInstance(String clientName) {
        if (uniqueInstance == null) {
            uniqueInstance = new ServerPool(clientName);
        }
        return uniqueInstance;
    }

    public ServerPool addServers(ServerPool serverPool) {
        //nicht in sich selbst einfügen
        if (this != serverPool) {
            servers.putAll(serverPool.getServers());
            saveServerPool();
        }
        return this;
    }
    
    public ServerAddr getFirstServer() {
        return (ServerAddr)((TreeMap)servers).firstEntry().getValue();
    }

    public void addServer(String name, ServerAddr serverAddr) {
        servers.put(name, serverAddr);
        saveServerPool();
    }

    private void saveServerPool() {
        try {
            FileOutputStream fos = new FileOutputStream(fileNameServerPool);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(getServers());
            System.out.println(System.currentTimeMillis() + "saveServerPool:" + getServers());
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ServerPool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getActiveServers() {
        List<String> activeServers = new ArrayList<>();
        servers.forEach((key, value) -> {
            if (value.isActiv()) {
                activeServers.add(key);
            }
        });
        return activeServers;
    }

    /**
     * @return the servers
     */
    public Map<String, ServerAddr> getServers() {
       return new TreeMap<>(servers);
//        return servers;
    }
    
        @Override
    public String toString() {
        return this.fileNameServerPool + " Servers: " + servers.toString() ;
    }

}
