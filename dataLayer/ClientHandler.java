package dataLayer;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket socket;
    private int clientNumber;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Packet outputPackage;
    private Packet inputPackage;
    private boolean run;

    public ClientHandler(Socket socket, int clientNumber) {
        this.socket = socket;
        this.clientNumber = clientNumber;
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.outputPackage = null;
        this.inputPackage = null;
        this.run = true;
    }

    @Override
    public void run() {
        try {
            log("Client " + clientNumber + " has connected!");
            outputPackage = new Packet(0,
                    "You successfully connected to the server. You are client: " + clientNumber + ".\n"
                    + "Type 'exit' to disconnect from the server.");
            out.writeObject(outputPackage);

            while (run) {
                inputPackage = (Packet) in.readObject();
                if (inputPackage == null) {
                    break;
                }

                switch (inputPackage.getId()) {
                    case -1:
                        run = false;
                        break;
                    default:
                        log("Received unknown packet with id " + inputPackage.getId() + " from client " + clientNumber);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                log("Couldn't disconnect client " + clientNumber);
            }
            log("Client " + clientNumber + " has disconnected from the server!");
        }
    }

    private static synchronized void log(String message) {
        try {
            File file = new File("log.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.canWrite()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
                writer.write(message + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
