/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.iLogic;

import dataLayer.Packet;
import interfaces.iData.Idata;
import java.util.ArrayList;
import java.util.HashMap;
import logicLayer.Offer;
import logicLayer.Order;
import logicLayer.User;


/**
 *
 * @author mehgn
 */
public interface Ilogic{
    public void injectData(Idata data);
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
