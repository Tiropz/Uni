import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import Model.Player;
import org.json.simple.DeserializationException;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;
import com.google.gson.Gson;


public class MenuSelection extends JDialog {
    private MenuInfo Info = new MenuInfo();
    private boolean sendData;
    private JLabel nomLabel, sexeLabel, cheveuxLabel, ageLabel, tailleLabel,taille2Label, icon;
    private JRadioButton tranche1, tranche2, tranche3, tranche4;
    private JComboBox sexe, cheveux;
    private JTextField nom, taille;

    public MenuSelection(JFrame parent, String title, boolean modal){
        super(parent, title, modal);
        this.setSize(550, 270);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }

    public MenuInfo showInfo(){
        this.sendData = false;
        this.setVisible(true);
        return this.Info;
    }

    private void initComponent(){
        //Icône
        icon = new JLabel(new ImageIcon("images/icone.jpg"));
        JPanel panIcon = new JPanel();
        panIcon.setBackground(Color.white);
        panIcon.setLayout(new BorderLayout());
        panIcon.add(icon);

        //Le nom
        JPanel panNom = new JPanel();
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(220, 60));
        nom = new JTextField();
        nom.setPreferredSize(new Dimension(100, 25));
        panNom.setBorder(BorderFactory.createTitledBorder("Nom du personnage"));
        nomLabel = new JLabel("Saisir un nom :");
        panNom.add(nomLabel);
        panNom.add(nom);

        //Le sexe
        JPanel panSexe = new JPanel();
        panSexe.setBackground(Color.white);
        panSexe.setPreferredSize(new Dimension(220, 60));
        panSexe.setBorder(BorderFactory.createTitledBorder("Sexe du personnage"));
        sexe = new JComboBox();
        sexe.addItem("Masculin");
        sexe.addItem("Féminin");
        sexeLabel = new JLabel("Sexe : ");
        panSexe.add(sexeLabel);
        panSexe.add(sexe);


        //La taille
        JPanel panTaille = new JPanel();
        panTaille.setBackground(Color.white);
        panTaille.setPreferredSize(new Dimension(220, 60));
        panTaille.setBorder(BorderFactory.createTitledBorder("Taille du personnage"));
        tailleLabel = new JLabel("Taille : ");
        taille2Label = new JLabel(" cm");
        taille = new JTextField("180");
        taille.setPreferredSize(new Dimension(90, 25));
        panTaille.add(tailleLabel);
        panTaille.add(taille);
        panTaille.add(taille2Label);

        //La couleur des cheveux
        JPanel panCheveux = new JPanel();
        panCheveux.setBackground(Color.white);
        panCheveux.setPreferredSize(new Dimension(220, 60));
        panCheveux.setBorder(BorderFactory.createTitledBorder("Couleur de cheveux du personnage"));
        cheveux = new JComboBox();
        cheveux.addItem("Blond");
        cheveux.addItem("Brun");
        cheveux.addItem("Roux");
        cheveux.addItem("Blanc");
        cheveuxLabel = new JLabel("Cheveux");
        panCheveux.add(cheveuxLabel);
        panCheveux.add(cheveux);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panNom);
        content.add(panSexe);
        content.add(panTaille);
        content.add(panCheveux);

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            /*    Info = new MenuInfo(nom.getText(), (String)sexe.getSelectedItem(), (String)cheveux.getSelectedItem() ,getTaille()); */
                Player mainChar = new Player(3,4, nom.getText(), (String)sexe.getSelectedItem(), (String)cheveux.getSelectedItem() ,getTaille());
                // Create a new Gson object
                Gson gson = new Gson();

                //convert the Java object to json
                String jsonString = gson.toJson(mainChar);
                //Write JSON String to file
                FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter("mainChar.json");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileWriter.write(jsonString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setVisible(false);
            }

            public String getTaille(){
                return (taille.getText().equals("")) ? "180" : taille.getText();
            }
        });

        JButton cancelBouton = new JButton("Quitter");
        cancelBouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);

            }
        });

        control.add(okBouton);
        control.add(cancelBouton);

        this.getContentPane().add(panIcon, BorderLayout.WEST);
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }
}