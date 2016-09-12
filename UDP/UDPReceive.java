package Week37.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Lucas on 12-09-2016.
 */
public class UDPReceive {
// modtage data
    public static void main(String[] args) {
        try {

        // 1. samme port og ip som HVEM!!??!?!
            int recivePort = 7778;
            InetAddress reciveIp = InetAddress.getByName("localhost");

            DatagramSocket receiveSocket = new DatagramSocket(recivePort, reciveIp);

        // 2. lav et recivearray eller hvad du nu skal modtage
            byte[] reciveDataArray = new byte[1024]; //

            // side note: loop for at programmet kan staa aabent og modtage sendte modtagelser. lav et while loop
            while (true) {

        // 3. lav pakken
                DatagramPacket packet = new DatagramPacket(reciveDataArray, reciveDataArray.length); // skal bare modtage packet saa behoever ikke ip og port

        // 4. modtag pakken
                receiveSocket.receive(packet); // paken er nu modtaget

        // 5. oversaet pakken til noget forstaaeligt
                String msg = new String(reciveDataArray);

            // extra lukker programmet naar "exit" bliver modtaget
                if(msg.toLowerCase().substring(0,4).equals("exit")){
                    System.out.println("chat has ended");
                    System.exit(124);
                }
                System.out.println(msg);

            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
