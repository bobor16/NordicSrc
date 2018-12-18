/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLayer;

/**
 *
 * @author mehgn
 */
import interfaces.iLogic.Ilogic;
import interfaces.iData.Idata;
import logicLayer.Case;

import java.util.ArrayList;
import java.util.HashMap;
import logicLayer.Offer;

import logicLayer.User;
import logicLayer.Order;

/**
 *
 * @author mehgn
 */
public class DataFacade implements Idata {

    private static Idata data;
    private static Ilogic logic;
    ClientController cc = new ClientController();

    public DataFacade() {
    }

    public static Idata getInstance() {
        return data;
    }

    @Override
    public void injectLogic(Ilogic logic) {
        this.logic = logic;
    }

    @Override
    public String login(String UP) {
        return cc.login(UP);
    }

    @Override
    public String register(HashMap registerForm) {
       return cc.register(registerForm);
    }

    @Override
    public ArrayList<String> getEmails() {
        return cc.getEmails();
    }

    @Override
    public void deleteUser(String email) {
        cc.deleteUser(email);
    }

    @Override
    public String getPassword(String email) {
       return cc.getPassword(email);
    }

    @Override
    public ArrayList<Order> getOrderListPending() {
        return cc.getOrderListPending();
    }

    @Override
    public User getUser(String email) {
        return cc.getUser(email);
    }

    @Override
    public ArrayList<String> getLog() {
        return cc.getLog();
    }

    @Override
    public void updateUser(HashMap<String, String> form) {
        cc.updateUser(form);
    }

    @Override
    public ArrayList<String> getCostumerList(String message) {
       return cc.getCostumerList(message);
    }

    @Override
    public Order getOrder(String id) {
       return cc.getOrder(id);
    }

    @Override
    public void createOrder(Order order) {
        cc.createOrder(order);
    }

    @Override
    public void deleteOrder(String id) {
        cc.deleteOrder(id);
    }

    @Override
    public void updateOrder(Order order) {
        cc.updateOrder(order);
    }

    @Override
    public ArrayList<String> getOfferList(String message) {
       return cc.getOfferList(message);
    }

    @Override
    public void createOffer(Offer offer) {
        cc.createOffer(offer);
    }

    @Override
    public void deleteOffer(int id) {
        cc.deleteOffer(id);
    }

    @Override
    public void acceptOffer(String message) {
        cc.acceptOffer(message);
    }

    @Override
    public void getOrderIDFromOfferID(int offerID) {
        cc.getOrderIDFromOfferID(offerID);
    }

    @Override
    public Offer getOffer(String id) {
        return cc.getOffer(id);
    }

    @Override
    public ArrayList<String> getManufacturerList() {
        return cc.getManufacturerList();
    }

    @Override
    public void updateOffer(Offer offer) {
        cc.updateOffer(offer);
    }

    @Override
    public void sendPackage(Packet packet) {
        cc.sendPackage(packet);
    }

    @Override
    public Packet receivePackage() {
        return cc.receivePackage();
    }
    
    @Override
    public String getUser(){
        return cc.getUser();
    }

}
