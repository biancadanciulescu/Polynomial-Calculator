package org.example;

import Controller.PoliController;
import Model.Operations;
import Model.PoliModel;
import Model.Polinom;
import View.PoliView;
import java.util.HashMap;
import java.util.Map;
import View.AcLis;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {
    public static void main(String[] args) {

        PoliModel polimodel = new PoliModel();
        PoliView poliView = new PoliView(polimodel);
        PoliController poliController = new PoliController(polimodel, poliView);
        poliView.setVisible(true);

    }
}
