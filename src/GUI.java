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

    public static JTextArea logTextArea;
    public JTextArea fileContentTextArea, tokensContentTextArea;
    private JPanel north, west, south, east, center;
    private Button fileLoader;
    private JFileChooser fileChooser;
    private JLabel path;
    private File file;
    private String fileInnerText;
    private FileNameExtensionFilter filter;
    private JScrollPane scrollableLog, scrollableFileContent, scrollableTokensContent;
    public static StringBuilder logStringBuilder;

    public GUI() {
        super("Analizador sintactico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        logStringBuilder = new StringBuilder();

        fileChooser = new JFileChooser();
        fileLoader = new Button("Select file");
        filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);
        path = new JLabel("File path: none selected yet");

        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        logTextArea.setToolTipText("Log text area");

        fileContentTextArea = new JTextArea();
        fileContentTextArea.setEditable(false);
        fileContentTextArea.setToolTipText("File inner text area");

        tokensContentTextArea = new JTextArea();
        tokensContentTextArea.setEditable(false);
        tokensContentTextArea.setToolTipText("Tokens inner text area");


        scrollableLog = new JScrollPane(logTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableFileContent = new JScrollPane(fileContentTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTokensContent = new JScrollPane(tokensContentTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        fileLoader.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fileChooser.showOpenDialog(null);

                if (actionEvent.getActionCommand().equals("Select file") && fileChooser.getSelectedFile().getAbsolutePath().endsWith(".txt")) {
                    path.setText("File path: " + fileChooser.getSelectedFile().getAbsolutePath());
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                    try {
                        fileInnerText = Files.readString(Paths.get(fileChooser.getSelectedFile().getAbsolutePath()));
                        fileContentTextArea.setText(fileInnerText);
                        Automata.cadena = fileInnerText;
                        new ControlAutomata();

                        final StringBuilder sb = new StringBuilder(tokensContentTextArea.getText());
                        sb.append("Palabra reservadas = ").append(Identificador.cantidadPalabrasReservadas + "\n");
                        sb.append("Identificador = ").append(Identificador.cantidadIdentificador + "\n");
                        sb.append("Operador relacional = ").append(OperadorRelacional.cantidadOperadorRelacional + "\n");
                        sb.append("Operador lógico = ").append(OperadoLogico.cantidadOperadoLogico + "\n");
                        sb.append("Operador aritmético = ").append(OperadorAritmetico.cantidadOperadorAritmetico + "\n");
                        sb.append("Asignación = ").append(Asignacion.cantidadAsignacion + "\n");
                        sb.append("Numero entero = ").append(NumeroEntero.cantidadNumeroEntero + "\n");
                        sb.append("Numero decimales = ").append(NumeroFlotante.cantidadNumeroFlotante + "\n");
                        sb.append("Comentario = ").append(Comentario.cantidadComentario + "\n");
                        sb.append("Parentesis = ").append(Parentesis.cantidadParentesis + "\n");
                        sb.append("Llaves = ").append(Llaves.cantidadLlaves + "\n");
                        sb.append("Errores = ").append(Error.cantindadError + "\n");

                        tokensContentTextArea.setText(sb.toString());

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
        JPanel northCanvas = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
        center = new JPanel(new GridLayout(0, 1, 100, 20));
        JPanel centerCanvas = new JPanel(new GridLayout(0, 2, 10, 10));
        centerCanvas.add(scrollableFileContent);
        centerCanvas.add(scrollableTokensContent);
        center.add(centerCanvas);
        center.add(scrollableLog);
        add(center, BorderLayout.CENTER);
    }

    public static void appendLogTextArea(){
        logTextArea.setText(logStringBuilder.toString());
    }
}

