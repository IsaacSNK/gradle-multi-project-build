package cr.ac.tec.datos.invaders.client;

import cr.ac.tec.datos.invaders.client.communications.Sender;
import cr.ac.tec.datos.invaders.core.messages.Message;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Message message = new Message();
        message.setOperation(1);

        for (var i = 0; i < 10; i++) {
            Sender.sendData(9000, "127.0.0.1", message);
        }
    }
}
