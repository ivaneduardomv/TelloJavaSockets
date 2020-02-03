import java.net.*;

public class UDPClient{
    //Methods
    public UDPClient(String ipAddress, int port){
        try{
            socketAddress = InetAddress.getByName(ipAddress);

            socketPort = port;

            UDPSocket = new DatagramSocket();

            receiveBuffer = new byte[256];
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public void send(String message){
        try{
            packetToSend = new DatagramPacket(message.getBytes(), message.length(), socketAddress, socketPort);
            UDPSocket.send(packetToSend);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public void receive(){
        try{
            //Esperamos a recibir un paquete
            packetToReceive = new DatagramPacket(receiveBuffer, 256);
            UDPSocket.receive(packetToReceive);
     
            //Convertimos el mensaje recibido en un string
            String message = new String(receiveBuffer).trim();
     
            //Imprimimos el paquete recibido
            System.out.println("We revieved: " + message);

            for (int i = 0; i < 256; ++i){
                receiveBuffer[i] = 0x00;
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
    //Atributes
    private DatagramSocket UDPSocket;
    private DatagramPacket packetToSend;
    private DatagramPacket packetToReceive;
    private InetAddress socketAddress;
    private int socketPort;
    private byte[] receiveBuffer;
}