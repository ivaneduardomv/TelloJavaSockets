import java.io.*;

public class TelloAPI{
    public static void main(String[] args){
        String msg = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        UDPClient udpClient = new UDPClient("192.168.10.1", 8889);
        //UDPClient udpClient = new UDPClient("localhost", 6000);

        System.out.println(args.length);

        if(args.length != 0){
            if(args.length == 1){
                msg = args[0];
            }
            if(args.length == 2){
                msg = args[0] + " " + args[1];
            }

            System.out.println(msg);

            udpClient.send(msg);
            //udpClient.receive();
        }
    }
}