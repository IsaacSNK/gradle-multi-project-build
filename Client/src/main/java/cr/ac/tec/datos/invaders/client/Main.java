package cr.ac.tec.datos.invaders.client;

import cr.ac.tec.datos.invaders.client.communications.Sender;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        for (var i = 0; i < 10; i++) {
            Sender.sendData(9000, "127.0.0.1", "OP: Hola " + i);
        }
    }
}
