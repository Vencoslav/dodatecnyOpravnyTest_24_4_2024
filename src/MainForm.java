import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainForm extends JFrame {
    private JPanel panelMain;
    private JTextField txtRidic;
    private JTextField txtBezin;
    private JRadioButton rbDalnice;
    private JRadioButton rbMesto;
    private JRadioButton rbMimoMesto;
    private JTextField txtDatum;
    private JTextField txtUjeteKilometry;
    private JButton btUloz;
    private List<JizdaVozidla> seznam = new ArrayList<>();
    private File selectedFile;

    public MainForm(){
        setContentPane(panelMain);
        setTitle("Opravný test");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initMenu();

        btUloz.addActionListener(e->{nacitSoubor();});

    }
    public void initMenu(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu nastroje = new JMenu("Nástroje");
        menuBar.add(nastroje);

        JMenuItem zobraz = new JMenuItem("Zobraz průměrnou spotřebu");
        nastroje.add(zobraz);
        zobraz.addActionListener(e->{ziskejPrumer();});


    }

    public void nacitSoubor(){
        JFileChooser fc = new JFileChooser(".");
        int result = fc.showOpenDialog(this);
        if(result ==  JFileChooser.APPROVE_OPTION){
            selectedFile = fc.getSelectedFile();
            pridejDoSouboru(selectedFile);
        }
    }

    public void pridejDoSouboru(File selectedFile){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(selectedFile))){
            String ridic = txtRidic.getText();
            Double spotrebaBenzinu = Double.parseDouble(txtBezin.getText());
            LocalDate datum = LocalDate.parse(txtDatum.getText());
            Integer ujeteKilometry = Integer.parseInt(txtUjeteKilometry.getText());
            bw.write(datum+";"+spotrebaBenzinu+";"+ridic+";"+ujeteKilometry+";");
        } catch (IOException e) {
            throw new RuntimeException("Soubor:" +selectedFile+ "nebyl nalezen. " +e.getLocalizedMessage());
        }

    }

    public void ziskejPrumer(){
        int prumerSpotreby = 0;
        for(JizdaVozidla vozidla : seznam){
            prumerSpotreby += vozidla.getSpotrebaBenzinu()/seznam.size();
        }
        JOptionPane.showMessageDialog(this,"Průměrná spotřeba benzínu" + prumerSpotreby);
    }

}
