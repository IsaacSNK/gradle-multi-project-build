package cr.ac.tec.datos.invaders.client.communications;

import java.io.*;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import cr.ac.tec.datos.invaders.core.MessageReader;
import cr.ac.tec.datos.invaders.core.messages.Message;

public class Sender {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void sendData(int port, String host, Message message) throws IOException {
        try (
                var outgoing = new Socket(host, port);
                var writer = new OutputStreamWriter(outgoing.getOutputStream());
                var reader = new InputStreamReader(outgoing.getInputStream())
        ) {
            writer.write(mapper.writeValueAsString(message));
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
