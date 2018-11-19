//package Server;
//import java.net.ServerSocket;
//
//public class Program {
//    public static void main(String[] args) throws Exception{
//        int client = 0;
//        ServerSocket listener = new ServerSocket(1337);
//
//        try {
//            while (true){
//                new ClientHandler(listener.accept(), client++).start();
//            }
//        }
//        finally {
//            listener.close();
//        }
//    }
//}
