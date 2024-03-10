package Model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Operations {

    public static Polinom addOperation(Polinom polinom1, Polinom polinom2) {

        Polinom poliRez = new Polinom();

        polinom1.getMonom().forEach((putere, coeficient)->{
            float coef2 = polinom2.getMonom().getOrDefault(putere, 0f);
            if(coeficient + coef2 != 0)
                poliRez.getMonom().put(putere, coeficient + polinom2.getMonom().getOrDefault(putere, 0f));
        });

        polinom2.getMonom().forEach((putere, coeficient)->{

            if(coeficient !=0 && (polinom1.getMonom().containsKey(putere) != polinom2.getMonom().containsKey(putere)))
                poliRez.getMonom().put(putere, coeficient);
        });

        return poliRez;

    }

    public static Polinom subOperation(Polinom polinom1, Polinom polinom2) {

        Polinom poliRez = new Polinom();

        polinom1.getMonom().forEach((putere, coeficient)->{
            poliRez.getMonom().put(putere, coeficient - polinom2.getMonom().getOrDefault(putere, 0f));
        });

        polinom2.getMonom().forEach((putere, coeficient)->{
            if(polinom1.getMonom().containsKey(putere) != polinom2.getMonom().containsKey(putere))
                poliRez.getMonom().put(putere, -coeficient);
        });

        return poliRez;

    }

    public static Polinom multiOperation(Polinom polinom1, Polinom polinom2) {

        Polinom poliRez = new Polinom();

        polinom1.getMonom().forEach((putere1, coeficient1) -> {
            polinom2.getMonom().forEach((putere2, coeficient2) -> {

                int putereRez = putere1 + putere2;
                float coeficientRez = coeficient1 * coeficient2;

                if (poliRez.getMonom().containsKey(putereRez)) {
                    float coeficientAnterior = poliRez.getMonom().get(putereRez);
                    poliRez.getMonom().put(putereRez, coeficientAnterior + coeficientRez);
                } else {
                    poliRez.getMonom().put(putereRez, coeficientRez);
                }
            });
        });

        return poliRez;
    }
    public static Polinom derivOperation(Polinom polinom){

        Polinom poliRez = new Polinom();

        polinom.getMonom().forEach((putere, coeficient)->{

            if(putere == 0){
                poliRez.getMonom().put(0, 0f);
            }
            else {

                if(coeficient != 0)
                    poliRez.getMonom().put(putere - 1, putere * coeficient);
            }

        });

        return poliRez;

    }

    public static Polinom integOperation(Polinom polinom){

        Polinom poliRez = new Polinom();

        polinom.getMonom().forEach((putere, coeficient)->{

            float x = 1;

            if(putere == 0 && coeficient != 0){
                poliRez.getMonom().put(1, coeficient);
            }
            else
                if(coeficient != 0) {
                    x=coeficient/(putere+1);
                    poliRez.getMonom().put(putere + 1, x);
                }
        });

        return poliRez;
    }
    public static Polinom[] devideOperation(Polinom polinom1, Polinom polinom2){

        Polinom[] vecPoli = new Polinom[2];
        vecPoli[0] = new Polinom();
        vecPoli[1] = new Polinom();

        Polinom deimpartitNou = polinom1;
        Polinom scazut = new Polinom();

        int gradMaxDeimp = Collections.max(polinom1.getMonom().keySet());;
        int gradMaxImp = Collections.max(polinom2.getMonom().keySet());

        while(gradMaxDeimp >= gradMaxImp){

            int dif = gradMaxDeimp - gradMaxImp;
            float coef = deimpartitNou.getMonom().getOrDefault(gradMaxDeimp , 0f) / polinom2.getMonom().getOrDefault(gradMaxImp, 0f);

            vecPoli[1].getMonom().put(dif, coef); //  il salvez in rezultat

            Polinom temp = new Polinom();
            temp.getMonom().put(dif, coef); // il salvez intr-un polinom secundar ca sa pot face inmultirea cu impartitorul

            scazut = Operations.multiOperation(polinom2, temp); // 6x^2-6x

            deimpartitNou = Operations.subOperation(deimpartitNou, scazut);

            gradMaxDeimp = Collections.max(deimpartitNou.getMonom().keySet()); //salvez cel mai mare grad actual al deimp
            while(gradMaxDeimp >=0 && (deimpartitNou.getMonom().getOrDefault(gradMaxDeimp , 0f) == 0))
                //aici actualizez cel mai mare grad si deoarece dupa scadere imi ramane polinomul de grad mare(dar cu coeficient 0)
                // tot scad gradul, dar pun conditie sa scada doar pana ajunge la gradul 0(ca sa nu am bucla infinita)
                gradMaxDeimp = gradMaxDeimp-1;


        }

        vecPoli[0] = deimpartitNou;
        return vecPoli;

    }

    public static Polinom returnPoli(Polinom[] vecPoli, int i){ //ca sa ia doar un polinom din vector, pt teste

        return vecPoli[i];

    }

}

