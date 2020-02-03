import java.net.*;
import java.io.*;
 
//declaramos la clase udp
public class clienteudp {
    public static void main(String argv[]) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
 
       //Definimos el sockets, número de bytes del buffer, y mensaje.
        DatagramSocket socket;
        InetAddress address;
        byte[] mensaje_bytes = new byte[256];
        String mensaje="";
        mensaje_bytes=mensaje.getBytes();
 
//Paquete
 DatagramPacket paquete;
 
 String cadenaMensaje="";
 
DatagramPacket servPaquete;
 
byte[] RecogerServidor_bytes = new byte[256];
 
 try {
 socket = new DatagramSocket();
 
address=InetAddress.getByName("192.168.10.1");
 
do {
 mensaje = "";
 mensaje = in.readLine();
 mensaje_bytes = mensaje.getBytes();
 paquete = new DatagramPacket(mensaje_bytes,mensaje.length(),address,8889);
 socket.send(paquete);
 
RecogerServidor_bytes = new byte[256];
 
//Esperamos a recibir un paquete
 servPaquete = new DatagramPacket(RecogerServidor_bytes,256);
 socket.receive(servPaquete);
 
//Convertimos el mensaje recibido en un string
 cadenaMensaje = new String(RecogerServidor_bytes).trim();
 
//Imprimimos el paquete recibido
 System.out.println(cadenaMensaje);
 } while (!mensaje.startsWith("fin"));
 }
 catch (Exception e) {
 System.err.println(e.getMessage());
 System.exit(1);
 }
 }
}