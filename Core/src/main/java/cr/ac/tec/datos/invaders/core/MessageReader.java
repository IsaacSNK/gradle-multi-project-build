package cr.ac.tec.datos.invaders.core;

import java.io.IOException;
import java.io.InputStreamReader;

public class MessageReader {
    public static String readMessage(InputStreamReader reader, int bufferSize) throws IOException {
        StringBuilder messageBuilder = new StringBuilder();
        char[] buffer = new char[bufferSize];
        while (reader.read(buffer, 0, bufferSize) != -1) {
            messageBuilder.append(buffer);
        }
        return messageBuilder.toString();
    }
}

