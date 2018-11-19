package dataLayer;

public class Packet implements java.io.Serializable {

    private int id;
    private Object object;

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
}
