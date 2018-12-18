/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

/**
 *
 * @author mehgn
 */
import dataLayer.Packet;
import interfaces.iLogic.Ilogic;
import interfaces.iData.Idata;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author mehgn
 */
public class LogicFacade implements interfaces.iLogic.Ilogic {

    private static Idata data;
    private static Ilogic logic;

    private PasswordValidation passwordChecker = new PasswordValidation();

    @Override
    public void injectData(Idata data) {
        this.data = data;
    }

    public LogicFacade() {
    }

    public static Ilogic getInstance() {
        return logic;
    }
 @Override
    public String login(String UP) {
        return data.login(UP);
    }

    @Override
    public String register(HashMap registerForm) {
       return data.register(registerForm);
    }

    @Override
    public ArrayList<String> getEmails() {
        return data.getEmails();
    }

    @Override
    public void deleteUser(String email) {
        data.deleteUser(email);
    }

    @Override
    public String getPassword(String email) {
       return data.getPassword(email);
    }

    @Override
    public ArrayList<Order> getOrderListPending() {
        return data.getOrderListPending();
    }

    @Override
    public User getUser(String email) {
        return data.getUser(email);
    }

    @Override
    public ArrayList<String> getLog() {
        return data.getLog();
    }

    @Override
    public void updateUser(HashMap<String, String> form) {
        data.updateUser(form);
    }

    @Override
    public ArrayList<String> getCostumerList(String message) {
       return data.getCostumerList(message);
    }

    @Override
    public Order getOrder(String id) {
       return data.getOrder(id);
    }

    @Override
    public void createOrder(Order order) {
        data.createOrder(order);
    }

    @Override
    public void deleteOrder(String id) {
        data.deleteOrder(id);
    }

    @Override
    public void updateOrder(Order order) {
        data.updateOrder(order);
    }

    @Override
    public ArrayList<String> getOfferList(String message) {
       return data.getOfferList(message);
    }

    @Override
    public void createOffer(Offer offer) {
        data.createOffer(offer);
    }

    @Override
    public void deleteOffer(int id) {
        data.deleteOffer(id);
    }

    @Override
    public void acceptOffer(String message) {
        data.acceptOffer(message);
    }

    @Override
    public void getOrderIDFromOfferID(int offerID) {
        data.getOrderIDFromOfferID(offerID);
    }

    @Override
    public Offer getOffer(String id) {
        return data.getOffer(id);
    }

    @Override
    public ArrayList<String> getManufacturerList() {
        return data.getManufacturerList();
    }

    @Override
    public void updateOffer(Offer offer) {
        data.updateOffer(offer);
    }


    @Override
    public void sendPackage(Packet packet) {
        data.sendPackage(packet);
    }

    @Override
    public Packet receivePackage() {
        return data.receivePackage();
    }

    @Override
    public String getUser() {
        return data.getUser();
    }
     
     
}

