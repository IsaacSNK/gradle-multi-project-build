package cr.ac.tec.datos.invaders.server.communication;

import cr.ac.tec.datos.invaders.core.MessageReader;

import java.io.*;
import java.net.ServerSocket;

public class Server {
    private static final int PORT = 9000;

    private ServerSocket socket;
    private boolean isActive = true;

    public Server() throws IOException {
        this.socket = new ServerSocket(PORT);
    }

    public void run() throws IOException {
        System.out.println("Server ready for connections");
        while (this.isActive) {
            try (
                    var inboundConnection = this.socket.accept();
                    var reader = new InputStreamReader(inboundConnection.getInputStream());
                    var writer = new OutputStreamWriter(inboundConnection.getOutputStream());
            ) {
                String data = MessageReader.readMessage(reader, 1024);
                System.out.println(data);
                if (!data.startsWith("OP")) {

                    System.out.println("Invalid data received from client: " + data);
                    writer.write("Malformed request");
                    writer.flush();
                    continue;
                }
                writer.write("ACK");
                writer.flush();
            }
        }
    }

    public void stop() {
        this.isActive = false;
    }
}
