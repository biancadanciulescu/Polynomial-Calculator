package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Polinom {

    private Map<Integer, Float> monom = new HashMap<Integer, Float>();

    public Polinom() {

    }

    public Polinom(Map<Integer, Float> monom) {

        this.monom = monom;
    }

    public Map<Integer, Float> getMonom() {

        return monom;
    }

    public void setMonom(Map<Integer, Float> polinom) {

        this.monom = polinom;
    }
    public void afisare(){
        System.out.println(monom);

    }

}
