package dataLayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientController {
    private static ObjectOutputStream objectOutputStream;
    private static ObjectInputStream objectInputStream;
    private static Socket socket;

    public ClientController(){
        if(socket == null){
            try {
                connectToServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//tek-studsrv0c.stud-srv.sdu.dk
    private void connectToServer() throws IOException {
        socket = new Socket("127.0.0.1", 1337);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        Packet p = null;
        try {
            p = (Packet)objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (p.getId() == 0){
            System.out.println(p.getObject());
        } else{
            System.out.println("Unknown package received?");
        }
    }

    public void sendPackage(Packet packet) {
        try {
            objectOutputStream.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Packet receivePackage(){
        try {
            return (Packet)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
