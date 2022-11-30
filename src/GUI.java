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
    public static StringBuilder logStringBuilder, tokensStringBuilder;

    public GUI() {
        super("Analizador sintactico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

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
                resetCounters();
                if (actionEvent.getActionCommand().equals("Select file") && fileChooser.getSelectedFile().getAbsolutePath().endsWith(".txt")) {
                    path.setText("File path: " + fileChooser.getSelectedFile().getAbsolutePath());
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                    try {
                        fileInnerText = Files.readString(Paths.get(fileChooser.getSelectedFile().getAbsolutePath()));
                        fileContentTextArea.setText(fileInnerText);
                        Automata.cadena = fileInnerText;

                        new ControlAutomata();

                        tokensStringBuilder.append("Palabra reservadas = " + Identificador.cantidadPalabrasReservadas + "\n");
                        tokensStringBuilder.append("Identificador = " + Identificador.cantidadIdentificador + "\n");
                        tokensStringBuilder.append("Operador relacional = " + OperadorRelacional.cantidadOperadorRelacional + "\n");
                        tokensStringBuilder.append("Operador lógico = " + OperadoLogico.cantidadOperadoLogico + "\n");
                        tokensStringBuilder.append("Operador aritmético = " + OperadorAritmetico.cantidadOperadorAritmetico + "\n");
                        tokensStringBuilder.append("Asignación = " + Asignacion.cantidadAsignacion + "\n");
                        tokensStringBuilder.append("Numero entero = " + NumeroEntero.cantidadNumeroEntero + "\n");
                        tokensStringBuilder.append("Numero decimales = " + NumeroFlotante.cantidadNumeroFlotante + "\n");
                        tokensStringBuilder.append("Comentario = " + Comentario.cantidadComentario + "\n");
                        tokensStringBuilder.append("Parentesis = " + Parentesis.cantidadParentesis + "\n");
                        tokensStringBuilder.append("Llaves = " + Llaves.cantidadLlaves + "\n");
                        tokensStringBuilder.append("Errores = " + Error.cantindadError + "\n");
                        tokensContentTextArea.setText(tokensStringBuilder.toString());
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

    private void resetCounters() {
        Identificador.cantidadPalabrasReservadas = 0;
        Identificador.cantidadIdentificador = 0;
        OperadorRelacional.cantidadOperadorRelacional = 0;
        OperadoLogico.cantidadOperadoLogico = 0;
        OperadorAritmetico.cantidadOperadorAritmetico = 0;
        Asignacion.cantidadAsignacion = 0;
        NumeroEntero.cantidadNumeroEntero = 0;
        NumeroFlotante.cantidadNumeroFlotante = 0;
        Comentario.cantidadComentario = 0;
        Parentesis.cantidadParentesis = 0;
        Llaves.cantidadLlaves = 0;
        Error.cantindadError = 0;
        tokensStringBuilder = new StringBuilder();
        logStringBuilder = new StringBuilder();
        Automata.position = 0;
    }

    public static void appendLogTextArea() {
        logTextArea.setText(logStringBuilder.toString());
    }
}

