package cr.ac.tec.datos.invaders.client.communications;

import java.io.*;
import java.net.Socket;
import cr.ac.tec.datos.invaders.core.MessageReader;

public class Sender {
    public static void sendData(int port, String host, String message) throws IOException {
        try (
                var outgoing = new Socket(host, port);
                var writer = new OutputStreamWriter(outgoing.getOutputStream());
                var reader = new InputStreamReader(outgoing.getInputStream())
        ) {
            writer.write(message);
            writer.flush();
            outgoing.shutdownOutput();

            var line = MessageReader.readMessage(reader, 1024);
            if (line.startsWith("ACK")) {
                System.out.println("Server accepted the request");
            } else {
                System.out.println("Server rejected the request");
            }
        }
    }
}
