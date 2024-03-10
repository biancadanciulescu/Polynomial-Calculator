
import Model.Operations;
import Model.Polinom;
import View.AcLis;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class OpTest {


    @ParameterizedTest
    @MethodSource("InputAdunare")

    void testAdditions(Polinom p1, Polinom p2, Polinom rez){
        assertEquals(AcLis.toString(Operations.addOperation(p1, p2)), AcLis.toString(rez));
    }

    private static List<Arguments> InputAdunare(){

        String p11 = new String("3x^2+2x+1");
        String p21 = new String("4x^2-x");
        String rez1 = new String("1+x+7x^2");
        Polinom poli11 = AcLis.fromString(p11);
        Polinom poli21 = AcLis.fromString(p21);
        Polinom rezultat1= AcLis.fromString(rez1);

        String p12 = new String("6x-8");
        String p22 = new String("4x^4-x");
        String rez2 = new String("4x^4+5x-8");
        Polinom poli12 = AcLis.fromString(p12);
        Polinom poli22 = AcLis.fromString(p22);
        Polinom rezultat2 = AcLis.fromString(rez2);

        String p13 = new String("6x");
        String p23 = new String("7x");
        String rez3 = new String("13x");
        Polinom pp13 = AcLis.fromString(p13);
        Polinom pp23 = AcLis.fromString(p23);
        Polinom rezz3 = AcLis.fromString(rez3);


        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(poli11, poli21, rezultat1));
        arguments.add(Arguments.of(poli12, poli22, rezultat2));
        arguments.add(Arguments.of(pp13, pp23, rezz3));
        return arguments;
    }


    @ParameterizedTest
    @MethodSource("InputScadere")

    void testSubstract(Polinom p1, Polinom p2, Polinom rez){
        assertEquals(AcLis.toString(Operations.subOperation(p1, p2)), AcLis.toString(rez));
    }

    private static List<Arguments> InputScadere(){

        String p11 = new String("3x^2+2x+1");
        String p21 = new String("4x^2-x");
        String rez1 = new String("1+3x-x^2");
        Polinom poli11 = AcLis.fromString(p11);
        Polinom poli21 = AcLis.fromString(p21);
        Polinom rezultat1= AcLis.fromString(rez1);

        String p12 = new String("6x-8");
        String p22 = new String("4x^4-x");
        String rez2 = new String("-8+7x-4x^4");
        Polinom poli12 = AcLis.fromString(p12);
        Polinom poli22 = AcLis.fromString(p22);
        Polinom rezultat2 = AcLis.fromString(rez2);


        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(poli11, poli21, rezultat1));
        arguments.add(Arguments.of(poli12, poli22, rezultat2));

        return arguments;
    }


    @ParameterizedTest
    @MethodSource("InputInmultire")

    void testMultiplication(Polinom p1, Polinom p2, Polinom rez){
        assertEquals(AcLis.toString(Operations.multiOperation(p1, p2)), AcLis.toString(rez));
    }

    private static List<Arguments> InputInmultire(){

        String p11 = new String("3x^2+2x+1");
        String p21 = new String("4x^2-x");
        String rez1 = new String("12x^4+5x^3+2x^2-x");
        Polinom poli11 = AcLis.fromString(p11);
        Polinom poli21 = AcLis.fromString(p21);
        Polinom rezultat1= AcLis.fromString(rez1);

        String p12 = new String("6x-8");
        String p22 = new String("2x");
        String rez2 = new String("12x^2-16x");
        Polinom poli12 = AcLis.fromString(p12);
        Polinom poli22 = AcLis.fromString(p22);
        Polinom rezultat2 = AcLis.fromString(rez2);


        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(poli11, poli21, rezultat1));
        arguments.add(Arguments.of(poli12, poli22, rezultat2));

        return arguments;
    }


    @ParameterizedTest
    @MethodSource("InputImpartire")

    void testDivision(Polinom p1, Polinom p2, Polinom[] rez){
        Polinom[] vecPoli = Operations.devideOperation(p1, p2);

        assertEquals(AcLis.toString(Operations.returnPoli(vecPoli, 0)), AcLis.toString(rez[1]));
        assertEquals(AcLis.toString(Operations.returnPoli(vecPoli, 1)), AcLis.toString(rez[0]));

    }

    private static List<Arguments> InputImpartire(){

        String p1 = new String("6x^2-4x-2");
        String p2 = new String("2x-2");
        String rez1= new String("3x+1");
        String rest1 = new String("0");

        Polinom poli11 = AcLis.fromString(p1);
        Polinom poli21 = AcLis.fromString(p2);
        Polinom rezultat1= AcLis.fromString(rez1);
        Polinom restt1 = AcLis.fromString(rest1);

        Polinom[] vecPoli = {rezultat1, restt1};

        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(poli11, poli21, vecPoli));


        return arguments;
    }

    @ParameterizedTest
    @MethodSource("InputDerivare")

    void testDerivate(Polinom p1, Polinom rez){
        assertEquals(AcLis.toString(Operations.derivOperation(p1)), AcLis.toString(rez));
    }

    private static List<Arguments> InputDerivare(){

        String p11 = new String("3x^2+2x+1");
        String rez1 = new String("6x+2");
        Polinom poli11 = AcLis.fromString(p11);
        Polinom rezultat1= AcLis.fromString(rez1);

        String p12 = new String("6x-8");
        String rez2 = new String("6");
        Polinom poli12 = AcLis.fromString(p12);
        Polinom rezultat2 = AcLis.fromString(rez2);


        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(poli11, rezultat1));
        arguments.add(Arguments.of(poli12, rezultat2));

        return arguments;
    }

    @ParameterizedTest
    @MethodSource("InputIntegrare")

    void testIntegrate(Polinom p1, Polinom rez){
        assertEquals(AcLis.toString(Operations.integOperation(p1)), AcLis.toString(rez));
    }

    private static List<Arguments> InputIntegrare(){

        String p11 = new String("3x^2+2x+1");
        String rez1 = new String("+x^3+x^2+x");
        Polinom poli11 = AcLis.fromString(p11);
        Polinom rezultat1= AcLis.fromString(rez1);

        String p12 = new String("6x-8");
        String rez2 = new String("3x^2-8x");
        Polinom poli12 = AcLis.fromString(p12);
        Polinom rezultat2 = AcLis.fromString(rez2);

        String p13 = new String("7x^4+3x^2+9");
        String rez3 = new String("1.4x^5+x^3+9x");
        Polinom poli13 = AcLis.fromString(p13);
        Polinom rezultat3 = AcLis.fromString(rez3);


        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(poli11, rezultat1));
        arguments.add(Arguments.of(poli12, rezultat2));
        arguments.add(Arguments.of(poli13, rezultat3));

        return arguments;
    }
}
