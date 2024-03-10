package View;
import Model.Polinom;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcLis {

    public static Polinom fromString(String input) {

        Map<Integer, Float> monom = new HashMap<>();
        Pattern pattern = Pattern.compile("^([+-]?([0-9]*([.][0-9]{1,2})?))?[x]?(\\^[0-9]{1,2})?(([+-]([0-9]*([.][0-9]{1,2})?)[x](\\^[0-9]{1,2})*)|[+-]?([0-9]*([.][0-9]{1,2})?))+$");
                ////////////////////////////////semn coef cu sau fara virgula/////x///^ coef cu max 2 cifre
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String match = matcher.group();
            String[] parts = match.split("(?=[+-])");

            for (String part : parts) {

                float coef = 0;
                int putere = 0;

                if (part.matches("^([-+])?[x](\\^[0-9]+)?$")) {

                    if(part.startsWith("+"))
                        coef = 1;
                    else
                        coef = -1;

                    if(part.contains("^"))
                        putere = Integer.parseInt(part.substring(part.indexOf("^") +1));
                    else
                        putere = 1;

                } else if (part.matches("^([-+]?)([0-9]+)?([.][0-9]+)?[x](\\^([0-9]+))?$")) {
                    String[] subparts = part.split("[x]\\^?");
                    if (subparts.length == 2) {
                        if(subparts[0].isEmpty())
                            coef = 1;
                        else
                            coef = Float.parseFloat(subparts[0]);

                        putere = Integer.parseInt(subparts[1]);
                    } else {

                        if(subparts[0].isEmpty())
                            coef = 1;
                        else
                            coef = Float.parseFloat(subparts[0]);
                        putere = 1;

                    }
                } else if (part.matches("^([-+]?)([0-9]+)?([.][0-9]+)?$")) {
                    coef = Float.parseFloat(part);
                    putere = 0;
                }

                if (coef != 0) {
                    if (monom.containsKey(putere)) {
                        coef += monom.get(putere);
                    }
                    monom.put(putere, coef);
                }
            }
        }

        return new Polinom(monom);
    }

    public static String toString(Polinom polinom) {

        StringBuilder str = new StringBuilder();
        boolean prim = true;

        for (Map.Entry<Integer, Float> entry : polinom.getMonom().entrySet()) {
            int putere = entry.getKey();
            float coef = entry.getValue();

            if (coef == 0) {
                continue;
            }

            if (coef > 0 && !prim) {
                str.append("+");
            }

            if (coef == -1 && putere != 0) {
                str.append("-");
            } else if (coef != 1 || putere == 0) {
                str.append(coef);
            }

            if (putere > 0) {
                str.append("x");
                if (putere != 1) {
                    str.append("^").append(putere);
                }
            }

            prim = false;
        }

        if (str.length() == 0) {
            str.append("0");
        }

        return str.toString();
    }

    public static int validPolinom(String input, PoliView poliView){


            String reg = new String("^([+-]?([0-9]*([.][0-9]{1,2})?))?[x]?(\\^[0-9]{1,2})?(([+-]([0-9]*([.][0-9]{1,2})?)[x](\\^[0-9]{1,2})*)|[+-]?([0-9]*([.][0-9]{1,2})?))+$");
        if(input.isEmpty()){
            JOptionPane.showMessageDialog(poliView, "Bad input", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        if(!(input.matches(reg)))
        {
            JOptionPane.showMessageDialog(poliView, "Bad input", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        return 0;

    }

}

