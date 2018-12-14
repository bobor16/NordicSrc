package dataLayer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import logicLayer.User;
import logicLayer.Order;

public class ClientController {

    private static ObjectOutputStream objectOutputStream;
    private static ObjectInputStream objectInputStream;
    private static Socket socket;

    public ClientController() {
        if (socket == null) {
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
            p = (Packet) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (p.getId() == 0) {
            System.out.println(p.getObject());
        } else {
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

    public Packet receivePackage() {
        try {
            return (Packet) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String login(String UP) {
        Packet p = new Packet(1, UP.toLowerCase());
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 1) {
            return (String) p.getObject();
        }
        return "-1";
    }

    public String register(HashMap registerForm) {
        Packet p = new Packet(2, registerForm);
        sendPackage(p);
        p = receivePackage();

        if (p.getId() == 2) {
            return (String) p.getObject();
        }
        return "-1";
    }

    public ArrayList<String> getEmails() {
        Packet p = new Packet(4, null);
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 4) {
            return (ArrayList<String>) p.getObject();
        }
        return null;
    }

    public void deleteUser(String email) {
        Packet p = new Packet(5, email.toLowerCase());
        sendPackage(p);
        if (p.getId() == 5) {
            System.out.println("User deleted");
        } else {
            System.out.println("Something went wrong");
        }
    }

    public String getPassword(String email) {
        String message = email;
        Packet p = new Packet(6, message);
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 6) {
            String password = (String) p.getObject();
            System.out.println(password);
            return password;
        }
        return "Wrong Package";
    }

    public ArrayList<Order> getOrderListPending() {
        Packet p = new Packet(7, null);
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 7) {
            return (ArrayList<Order>) p.getObject();
        }
        return null;
    }

    public User getUser(String email) {
        Packet p = new Packet(30, email);
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 30) {
            return (User) p.getObject();
        }
        return null;
    }

    public ArrayList<String> getLog() {
        Packet p = new Packet(31, null);
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 31) {
            return (ArrayList<String>) p.getObject();
        }
        return null;
    }

    public void updateUser(HashMap<String, String> form) {
        Packet p = new Packet(32, form);
        sendPackage(p);
    }

    
}
