package cs.vsu.ru.kapustin;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Utils {
    public static void writeAnswerToFile(String fileName, String queue) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileName);

        out.print(queue);
        out.close();
    }
}
