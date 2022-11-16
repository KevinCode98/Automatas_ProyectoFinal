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

    String fileContet;

    FileNameExtensionFilter filter;

    JTextArea textArea;
    public GUI() {
        super("Animacion2D");
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
        path = new JLabel("Path: ");


        fileLoader.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fileChooser.showOpenDialog(null);

                if (actionEvent.getActionCommand().equals("Select file") && fileChooser.getSelectedFile().getAbsolutePath().endsWith(".txt")) {
                    path.setText("Path: " + fileChooser.getSelectedFile().getAbsolutePath());
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                    try {
                        fileContet = Files.readString(Paths.get(fileChooser.getSelectedFile().getAbsolutePath()));
//                        textArea.setText(fileContet);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un archivo de texto imbecil.");
                }

            }
        }));


        //set north layout
        north = new JPanel(new GridLayout(2, 1, 50, 10));
        north.add(fileLoader);
        north.add(path);
        north.add(path);
        add(north, BorderLayout.NORTH);

//        //set south layout
        south = new JPanel();
        south.setBackground(Color.blue);
//        south.setLayout(new SpringLayout());
        add(south, BorderLayout.SOUTH);
//
//        //set west layout
        west = new JPanel();
        west.setBackground(Color.green);
//        west.setLayout(new SpringLayout());
        add(west, BorderLayout.WEST);
//
//        //set east layout
        east = new JPanel();
        east.setBackground(Color.pink);
//        east.setLayout(new SpringLayout());
        add(east, BorderLayout.EAST);

        //set center layout
        center = new JPanel();
        center.setBackground(new Color(0x7272D2));
//        center.add(textArea);
//        east.setLayout(new SpringLayout());
        add(center, BorderLayout.CENTER);


    }


}

