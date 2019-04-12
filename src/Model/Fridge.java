package Model;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Fridge extends Block implements Activable {

    private static JLabel lblClock = new JLabel("");
    private String time;
    public Fridge(int x, int y) {

        super(x, y, 4);
    }

    @Override
    public boolean isObstacle() {
        return true;
    }

    @Override
    public Player activate(Player mainChar){

        JOptionPane jop = new JOptionPane();
        int option = jop.showConfirmDialog(null, "Voulez-vous manger ?\n Il vous reste : " + mainChar.nbreFood + " snacks", "Confirmez", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            if (mainChar.hunger < 100 && mainChar.bladder < 10 && mainChar.nbreFood > 0) {

                System.out.println("fini1");
                final JOptionPane optionPane = new JOptionPane(lblClock, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
                System.out.println("fini2");
               // Thread t = new SampleThread(lblClock, optionPane);
              //  t.start();

                final JDialog dialog = new JDialog();
                dialog.setTitle("Message");
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setContentPane(optionPane);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                dialog.pack();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=10;i>0;i--){

                            try {
                                if(i==0){

                                }
                                time = (Integer.toString(i));
                                System.out.println("te");
                                lblClock.setText(time);
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        mainChar.hunger += 1;
                        mainChar.bladder += 0.5;
                        mainChar.nbreFood -= 1;
                        dialog.dispose();
                    }

                }).start();

                dialog.setVisible(true);

              //  t.join();
                System.out.println("afterclock");
                dialog.dispose();
              //  jop.showMessageDialog(null, lblClock, "Attention !", JOptionPane.DEFAULT_OPTION);

            } else if (mainChar.hunger > 100) {
                jop.showMessageDialog(null, "Vous avez déjà trop mangé", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            } else if (mainChar.bladder == 10) {
                jop.showMessageDialog(null, "Vous devez aller aux toilettes", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            } else if (mainChar.nbreFood == 0) {
                jop.showMessageDialog(null, "Vous n'avez plus de nourriture", "Attention !", JOptionPane.INFORMATION_MESSAGE);
            }


        }
        return mainChar;
    }

}
