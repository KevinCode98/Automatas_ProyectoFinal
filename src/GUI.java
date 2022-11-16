import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GUI extends JFrame {

    JPanel north, west, south, east, center;
    Button fileLoader;
    JFileChooser fileChooser;
    JLabel path;
    File file;
    String fileContetText;
    FileNameExtensionFilter filter;

    JTextArea fileContent;
    public static JTextArea textArea;
    JScrollPane scroll;

    public GUI() {
        super("Analizador sintactico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        fileChooser = new JFileChooser();
        fileLoader = new Button("Select file");
        filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);
        path = new JLabel("File path: none selected yet");
        textArea = new JTextArea();
        fileContent = new JTextArea();
        fileContent.setEditable(false);
        scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        fileLoader.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fileChooser.showOpenDialog(null);

                if (actionEvent.getActionCommand().equals("Select file") && fileChooser.getSelectedFile().getAbsolutePath().endsWith(".txt")) {
                    path.setText("File path: " + fileChooser.getSelectedFile().getAbsolutePath());
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                    try {
                        fileContetText = Files.readString(Paths.get(fileChooser.getSelectedFile().getAbsolutePath()));
                        fileContent.setText(fileContetText);
                        Automata.cadena = fileContetText;
                        new ControlAutomata();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un archivo de texto imbecil.");
                }

            }
        }));


        //set NORTH layout
        north = new JPanel(new GridLayout(1, 1, 0, 0));
        JPanel northCanvas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        northCanvas.add(fileLoader);
        northCanvas.add(path);
        north.add(northCanvas);
        add(north, BorderLayout.NORTH);


//      Set SOUTH layout configuration
        south = new JPanel();
        add(south, BorderLayout.SOUTH);

//      Set WEST layout configuration
        west = new JPanel();
        add(west, BorderLayout.WEST);

//      Set EAST layout configuration
        east = new JPanel();
        add(east, BorderLayout.EAST);

//      Set CENTER layout configuration
        center = new JPanel(new GridLayout(2, 1, 100, 20));
        center.add(fileContent);
        center.add(scroll);
        add(center, BorderLayout.CENTER);
    }
}

