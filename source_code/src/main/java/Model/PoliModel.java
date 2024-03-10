package Model;

import View.AcLis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PoliModel {

    public static final String INITIAL_VALUE = "0";
    public String rez; //valoarea curenta totala
    public String rest; //valoarea restului(impartire)

    public PoliModel(){
        reset();

    }

    public void reset(){
        rez = new String("INITIAL_VALUE");
        rest = new String("INITIAL_VALUE");

    }

    public void addOp(Polinom p1, Polinom p2){
        Polinom p = Operations.addOperation(p1, p2);
        String total = AcLis.toString(p);

        rez = total;
    }

    public void subOp(Polinom p1, Polinom p2){
        Polinom p = Operations.subOperation(p1, p2);
        String total = AcLis.toString(p);

        rez = total;
    }

    public void multiOp(Polinom p1, Polinom p2){
        Polinom p = Operations.multiOperation(p1, p2);
        String total = AcLis.toString(p);

        rez = total;
    }

    public void integOp(Polinom p1){
        Polinom p = Operations.integOperation(p1);
        String total = AcLis.toString(p);

        rez = total;
    }

    public void derivOp(Polinom p1){
        Polinom p = Operations.derivOperation(p1);
        String total = AcLis.toString(p);

        rez = total;
    }

    public String devOp(Polinom p1, Polinom p2){
        Polinom[] vecPolinoame = Operations.devideOperation(p1, p2);

        String total = AcLis.toString(vecPolinoame[1]);
        return total;
    }

    public String dev2Op(Polinom p1, Polinom p2){
        Polinom[] vecPolinoame = Operations.devideOperation(p1, p2);

        String rst = AcLis.toString(vecPolinoame[0]);
        return rst;
    }

    public void setValue(String value) {
        rez = new String(value);
    }

    public String getValue(){
        return rez.toString();
    }

}



