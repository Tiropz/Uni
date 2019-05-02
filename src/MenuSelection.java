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
import com.google.gson.Gson;


public class MenuSelection extends JDialog {
    private MenuInfo Info = new MenuInfo();
    private JLabel nomLabel, sexeLabel, cheveuxLabel, cercleLabel, icon;
    private JComboBox sex, study, cercle;
    private JTextField name;
    int lvl;
    int intel;
    int social;
    int money;
    double energy;
    double hunger;
    double bladder;
    double hygene;

    public MenuSelection(JFrame parent, String title, boolean modal){
        super(parent, title, modal);
        this.setSize(550, 270);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }

    public MenuInfo showInfo(){
        this.setVisible(true);
        return this.Info;

    }

    private void initComponent(){
        //Icône
        icon = new JLabel(new ImageIcon("Image/sol_2.jpg"));
        JPanel panIcon = new JPanel();
        panIcon.setPreferredSize(new Dimension(70,70));
        panIcon.setBackground(Color.white);
        panIcon.setLayout(new BorderLayout());
        panIcon.add(icon);

        //Le nom
        JPanel panNom = new JPanel();
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(220, 60));
        name = new JTextField();
        name.setPreferredSize(new Dimension(100, 25));
        panNom.setBorder(BorderFactory.createTitledBorder("Nom du personnage"));
        nomLabel = new JLabel("Saisir un nom :");
        panNom.add(nomLabel);
        panNom.add(name);

        //Le sexe
        JPanel panSexe = new JPanel();
        panSexe.setBackground(Color.white);
        panSexe.setPreferredSize(new Dimension(220, 60));
        panSexe.setBorder(BorderFactory.createTitledBorder("Sexe du personnage"));
        sex = new JComboBox();
        sex.addItem("Masculin");
        sex.addItem("Féminin");
        sexeLabel = new JLabel("Sexe : ");
        panSexe.add(sexeLabel);
        panSexe.add(sex);


        //La taille
        JPanel panCercle = new JPanel();
        panCercle.setBackground(Color.white);
        panCercle.setPreferredSize(new Dimension(220, 60));
        panCercle.setBorder(BorderFactory.createTitledBorder("Choisissez un cercle"));
        cercle = new JComboBox();
        cercle.addItem("CM");
        cercle.addItem("CP");
        cercle.addItem("C$");
        cercle.addItem("CPsy");
        cercle.addItem("CD");
        cercleLabel = new JLabel("Cercle");
        panCercle.add(cercleLabel);
        panCercle.add(cercle);

        //La couleur des cheveux
        JPanel panStudy = new JPanel();
        panStudy.setBackground(Color.white);
        panStudy.setPreferredSize(new Dimension(220, 60));
        panStudy.setBorder(BorderFactory.createTitledBorder("Quelles études voulez-vous entreprendre ?"));
        study = new JComboBox();
        study.addItem("Médecine");
        study.addItem("Polytechnique");
        study.addItem("Solvay");
        study.addItem("Psychologie");
        study.addItem("Droit");
        cheveuxLabel = new JLabel("Etudes");
        panStudy.add(cheveuxLabel);
        panStudy.add(study);

        JPanel content = new JPanel();
        content.setBackground(Color.white);
        content.add(panIcon);
        content.add(panNom);
        content.add(panSexe);
        content.add(panCercle);
        content.add(panStudy);


        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                switch ((String)study.getSelectedItem()){
                    case "Polytechnique":
                        energy = 100;
                        hunger = 100;
                        bladder = 100;
                        hygene = 80;
                        intel = 70;
                        social = 50;
                        money = 50;
                        break;
                    case "Médecine":
                        energy = 100;
                        hunger = 100;
                        bladder = 100;
                        hygene = 120;
                        intel = 50;
                        social = 30;
                        money = 50;
                        break;
                    case "Solvay":
                        energy = 100;
                        hunger = 100;
                        bladder = 100;
                        hygene = 100;
                        intel = 30;
                        social = 50;
                        money = 100;
                        break;
                    case "Psychologie":
                        energy = 100;
                        hunger = 100;
                        bladder = 100;
                        hygene = 100;
                        intel = 30;
                        social = 70;
                        money = 50;
                        break;
                    case "Droit":
                        energy = 100;
                        hunger = 100;
                        bladder = 100;
                        hygene = 100;
                        intel = 50;
                        social = 30;
                        money = 100;
                        break;
                }
                  Info = new MenuInfo(name.getText(), (String)sex.getSelectedItem(), (String)study.getSelectedItem() ,(String)cercle.getSelectedItem());
                Player mainChar = new Player(15,10, name.getText(), (String)sex.getSelectedItem(), (String)study.getSelectedItem() ,(String)cercle.getSelectedItem(),"Kot", energy, hunger, bladder, hygene,5, 0, 10, 15, 1, intel, social,money, 43200);
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


        });


        control.add(okBouton);


        this.getContentPane().add(panIcon, BorderLayout.WEST);
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }
}