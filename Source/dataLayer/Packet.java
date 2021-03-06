package dataLayer;

public class Packet implements java.io.Serializable {

    private int id;
    private Object object;

    //Packet class that carries objects. 
    public Packet(){

    }
    public Packet(int id, Object object) {
        this.id = id;
        this.object = object;
    }

    public int getId() {
        return this.id;
    }

    public Object getObject() {
        return this.object;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
