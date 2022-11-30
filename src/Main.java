import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {
    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Runnable ventana = new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        };

        try {
            SwingUtilities.invokeAndWait(ventana);
        } catch (InterruptedException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}