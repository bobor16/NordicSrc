package dataLayer;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.*;

import logicLayer.Offer;
import logicLayer.User;
import logicLayer.Order;

public class ClientController {

    private static ObjectOutputStream objectOutputStream;
    private static ObjectInputStream objectInputStream;
    private static Socket socket;
    private static Thread send;

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
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(() -> {
            try {
                objectOutputStream.writeObject(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        try {
            future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("Connection timed out");
        }
    }

    public Packet receivePackage() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Packet p = new Packet();
        Future future = executor.submit(() -> {
            try {
                Packet temp = (Packet)objectInputStream.readObject();
                p.setId(temp.getId());
                p.setObject(temp.getObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        try {
            future.get(10, TimeUnit.SECONDS);
            return p;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("Connection timed out");
        }
        return new Packet(1, "timeout");
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

    public ArrayList<String> getCostumerList(String message) {
        Packet p = new Packet(33, message);
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 33) {
            return (ArrayList<String>) p.getObject();
        }
        return null;
    }

    public Order getOrder(String id) {
        Packet p = new Packet(34, id);
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 34) {
            return (Order) p.getObject();
        }
        return null;
    }

    public void createOrder(Order order) {
        Packet p = new Packet(36, order);
        sendPackage(p);
    }

    public void deleteOrder(String id) {
        Packet p = new Packet(37, id);
        sendPackage(p);
    }

    public void updateOrder(Order order) {
        Packet p = new Packet(38, order);
        sendPackage(p);
    }

    public ArrayList<String> getOfferList(String message) {
        Packet p = new Packet(39, message);
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 39) {
             System.out.println(p.getObject() +"AFTER ID CHECK");
            return (ArrayList<String>) p.getObject();
        }
        return null;
    }

    public void createOffer(Offer offer) {
        Packet p = new Packet(40, offer);
        sendPackage(p);
    }

    public void deleteOffer(int id) {
        Packet p = new Packet(41, id);
        sendPackage(p);
    }

    public void acceptOffer(String message) {
        Packet p = new Packet(42, message);
        sendPackage(p);
    }

    public void getOrderIDFromOfferID(int offerID) {
        Packet p = new Packet(43, offerID);
        sendPackage(p);
    }

    public Offer getOffer(String id) {
        Packet p = new Packet(44, id);
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 44) {
            return (Offer) p.getObject();
        }
        return null;
    }
    public ArrayList<String> getManufacturerList() {
        Packet p = new Packet(45, null);
        sendPackage(p);
        p = receivePackage();
        if (p.getId() == 45) {
            return (ArrayList<String>) p.getObject();
        }
        return null;
    }
    
      public void updateOffer(Offer offer) {
        Packet p = new Packet(46, offer);
        sendPackage(p);
    }

}