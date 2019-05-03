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

public class Table extends Block implements Activable {

    int nbreFoodIn;
    public Table(int x, int y) {

        super(x, y, 4);

    }

    @Override
    public boolean isObstacle() {
        return true;
    }

    @Override
    public Player activate(Player mainChar){

        mainChar.eat(10,10, mainChar);
        return mainChar;
    }

}
