import Model.Player;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


class MenuSelection extends JDialog {
    private MenuInfo Info = new MenuInfo();
    private JComboBox<String> sex;
    private JComboBox<String> study;
    private JComboBox<String> cercle;
    private JTextField name;
    private int intel;
    private int social;
    private int money;
    private double energy;
    private double hunger;
    private double bladder;
    private double hygiene;

    MenuSelection(JFrame parent, String title, boolean modal){
        super(parent, title, modal);
        this.setSize(550, 270);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }

    MenuInfo showInfo(){
        this.setVisible(true);
        return this.Info;

    }

    private void initComponent(){
        //Icône
        JLabel icon = new JLabel(new ImageIcon("Image/sol_2.jpg"));
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
        JLabel nomLabel = new JLabel("Saisir un nom :");
        panNom.add(nomLabel);
        panNom.add(name);

        //Le sexe
        JPanel panSexe = new JPanel();
        panSexe.setBackground(Color.white);
        panSexe.setPreferredSize(new Dimension(220, 60));
        panSexe.setBorder(BorderFactory.createTitledBorder("Sexe du personnage"));
        sex = new JComboBox<>();
        sex.addItem("Masculin");
        sex.addItem("Féminin");
        JLabel sexeLabel = new JLabel("Sexe : ");
        panSexe.add(sexeLabel);
        panSexe.add(sex);


        //La taille
        JPanel panCercle = new JPanel();
        panCercle.setBackground(Color.white);
        panCercle.setPreferredSize(new Dimension(220, 60));
        panCercle.setBorder(BorderFactory.createTitledBorder("Choisissez un cercle"));
        cercle = new JComboBox<>();
        cercle.addItem("CM");
        cercle.addItem("CP");
        cercle.addItem("C$");
        cercle.addItem("CPsy");
        cercle.addItem("CD");
        JLabel cercleLabel = new JLabel("Cercle");
        panCercle.add(cercleLabel);
        panCercle.add(cercle);

        //La couleur des cheveux
        JPanel panStudy = new JPanel();
        panStudy.setBackground(Color.white);
        panStudy.setPreferredSize(new Dimension(220, 60));
        panStudy.setBorder(BorderFactory.createTitledBorder("Quelles études voulez-vous entreprendre ?"));
        study = new JComboBox<>();
        study.addItem("Médecine");
        study.addItem("Polytechnique");
        study.addItem("Solvay");
        study.addItem("Psychologie");
        study.addItem("Droit");
        JLabel cheveuxLabel = new JLabel("Etudes");
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

        okBouton.addActionListener(arg0 -> {
            switch ((String) Objects.requireNonNull(study.getSelectedItem())){
                case "Polytechnique":
                    energy = 100;
                    hunger = 100;
                    bladder = 100;
                    hygiene = 80;
                    intel = 70;
                    social = 50;
                    money = 50;
                    break;
                case "Médecine":
                    energy = 100;
                    hunger = 100;
                    bladder = 100;
                    hygiene = 120;
                    intel = 50;
                    social = 30;
                    money = 50;
                    break;
                case "Solvay":
                    energy = 100;
                    hunger = 100;
                    bladder = 100;
                    hygiene = 100;
                    intel = 30;
                    social = 50;
                    money = 100;
                    break;
                case "Psychologie":
                    energy = 100;
                    hunger = 100;
                    bladder = 100;
                    hygiene = 100;
                    intel = 30;
                    social = 70;
                    money = 50;
                    break;
                case "Droit":
                    energy = 100;
                    hunger = 100;
                    bladder = 100;
                    hygiene = 100;
                    intel = 50;
                    social = 30;
                    money = 100;
                    break;
            }
              Info = new MenuInfo(name.getText(), (String)sex.getSelectedItem(), (String)study.getSelectedItem() ,(String)cercle.getSelectedItem());
            Player mainChar = new Player(15,10, name.getText(), (String)sex.getSelectedItem(), (String)study.getSelectedItem() ,(String)cercle.getSelectedItem(),"Kot", energy, hunger, bladder, hygiene,0,10, 0, 10, 15, 1, intel, social,money, 43200, 0, false, false);
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
        });


        control.add(okBouton);


        this.getContentPane().add(panIcon, BorderLayout.WEST);
        this.getContentPane().add(content, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }
}