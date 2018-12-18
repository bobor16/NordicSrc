package interfaces.iData;

import dataLayer.Packet;
import interfaces.iLogic.Ilogic;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import logicLayer.Offer;
import logicLayer.User;
import logicLayer.Order;

/**
 *
 * @author mehgn
 */
public interface Idata{
    public void injectLogic(Ilogic logic);
    public String login(String UP);

    public String register(HashMap registerForm);


    public ArrayList<String> getEmails();

    public void deleteUser(String email);


    public String getPassword(String email);


    public ArrayList<Order> getOrderListPending();

    public User getUser(String email);


    public ArrayList<String> getLog();


    public void updateUser(HashMap<String, String> form);


    public ArrayList<String> getCostumerList(String message);

    public Order getOrder(String id);


    public void createOrder(Order order);


    public void deleteOrder(String id);

    public void updateOrder(Order order);


    public ArrayList<String> getOfferList(String message);


    public void createOffer(Offer offer);


    public void deleteOffer(int id);

    public void acceptOffer(String message);


    public void getOrderIDFromOfferID(int offerID);


    public Offer getOffer(String id);

    public ArrayList<String> getManufacturerList();

    
    public void updateOffer(Offer offer);
      
    public void sendPackage(Packet packet);


    public Packet receivePackage();
      
}