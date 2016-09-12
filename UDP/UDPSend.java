package Week37.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by Lucas on 12-09-2016.
 */
public class UDPSend {

    public static void main(String[] args) {
        //1.  bestem to porte en at sende fra(sendPort) og en at sende til(recievePort)
        int sendPort = 7777; // skal tage over 1024 fordi alle porte fra 0-1024 er reserverede
        int receivePort = 7778;

        try {
        // 2. find en ip addresse (her bare localhost)
            InetAddress ip = InetAddress.getByName("localhost"); // get by name laver en ip ud fra en string "localhost" giver din egen pc
        // 3. lav et socket ved at bruge port og ip (hvorfra vi skal sende pakken)
            DatagramSocket dsocket = new DatagramSocket(sendPort, ip);

        // 4. begynd at lave det du skal sende
            Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("MSG to send: ");
            String msg = scanner.nextLine();
            String dataString = msg; // den string du vil sende
            byte[] data = dataString.getBytes();           // lav den om til bytes

        // 5. lav det til en packet

            DatagramPacket packet = new DatagramPacket(data, data.length, ip, receivePort); // pak den og fortael hvilken port og ip den skal sende til
        // 6. og send den
            dsocket.send(packet);
        // extra lukker programmet naar "exit" bliver skrevet
            if(msg.toLowerCase().equals("exit")){
                System.out.println("chat ended");
                System.exit(123);
            }
            System.out.println("data send");
        }


        }catch (Exception e){
            System.out.println(e);
        }


    }
}
