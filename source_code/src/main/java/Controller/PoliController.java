package Controller;

import Model.Operations;
import Model.PoliModel;
import Model.Polinom;
import View.AcLis;
import View.PoliView;
import java.awt.event.*;
public class PoliController {

    PoliModel m_model;
    PoliView m_view;


    public PoliController(PoliModel model, PoliView view) {
        m_model = model;
        m_view = view;

        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addDevListener(new DevListener());
        view.addMultiListener(new MultiListener());
        view.addIntegListener(new IntegListener());
        view.addDerivListener(new DerivListener());
        view.addResetListener(new ResetListener());
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String polinom1 = m_view.getPolinom1();
            String polinom2 = m_view.getPolinom2();

            int err = AcLis.validPolinom(polinom1, m_view);
            int err2 = AcLis.validPolinom(polinom2, m_view);

            if (err == 0 && err2 == 0) {
                Polinom p1 = AcLis.fromString(polinom1);
                Polinom p2 = AcLis.fromString(polinom2);

                Polinom rez = Operations.addOperation(p1, p2);
                String rz = AcLis.toString(rez);

                m_model.addOp(p1, p2);
                m_view.setRez(m_model.getValue());
            }
        }
    }


    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String polinom1 = m_view.getPolinom1();
            String polinom2 = m_view.getPolinom2();

            int err = AcLis.validPolinom(polinom1, m_view);
            int err2 = AcLis.validPolinom(polinom2, m_view);

            if (err == 0 && err2 == 0) {
                Polinom p1 = AcLis.fromString(polinom1);
                Polinom p2 = AcLis.fromString(polinom2);

                m_model.subOp(p1, p2);
                m_view.setRez(m_model.getValue());
            }
        }
    }

    class MultiListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String polinom1 = m_view.getPolinom1();
            String polinom2 = m_view.getPolinom2();

            int err = AcLis.validPolinom(polinom1, m_view);
            int err2 = AcLis.validPolinom(polinom2, m_view);

            if (err == 0 && err2 == 0) {
                Polinom p1 = AcLis.fromString(polinom1);
                Polinom p2 = AcLis.fromString(polinom2);

                m_model.multiOp(p1, p2);
                m_view.setRez(m_model.getValue());
            }
        }
    }
    class DevListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String polinom1 = m_view.getPolinom1();
            String polinom2 = m_view.getPolinom2();

            int err = AcLis.validPolinom(polinom1, m_view);
            int err2 = AcLis.validPolinom(polinom2, m_view);

            if (err == 0 && err2 == 0) {
                Polinom p1 = AcLis.fromString(polinom1);
                Polinom p2 = AcLis.fromString(polinom2);

                String rezz = m_model.devOp(p1, p2);
                String restt = m_model.dev2Op(p1,p2);

                m_view.setRez(rezz);
                m_view.setRest(restt);

            }
        }
    }
    class IntegListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String polinom1 = m_view.getPolinom1();

            int err = AcLis.validPolinom(polinom1, m_view);
            if (err == 0) {
                Polinom p1 = AcLis.fromString(polinom1);

                m_model.integOp(p1);
                m_view.setRez(m_model.getValue());
            }
        }
    }

    class DerivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String polinom1 = m_view.getPolinom1();

            int err = AcLis.validPolinom(polinom1, m_view);
            if (err == 0) {
                Polinom p1 = AcLis.fromString(polinom1);

                m_model.derivOp(p1);
                m_view.setRez(m_model.getValue());
            }
        }
    }

    class ResetListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            m_model.reset();
            m_view.reset();
        }
    }

}