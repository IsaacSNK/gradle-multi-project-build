package cr.ac.tec.datos.invaders.server;

import cr.ac.tec.datos.invaders.server.communication.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Server().run();
    }
}
