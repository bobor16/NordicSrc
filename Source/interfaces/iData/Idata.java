package interfaces.iData;

import interfaces.all.ICase;
import interfaces.iLogic.Ilogic;
import interfaces.all.iAuthenticate;
import java.util.ArrayList;
import logicLayer.User;
import logicLayer.Order;

/**
 *
 * @author mehgn
 */
public interface Idata extends iAuthenticate, ICase{
    public void injectLogic(Ilogic logic);
    public ArrayList<User> displayUsers();
 public void deleteUser(String email);
 public ArrayList<Order> getOrderListPending();
    }
