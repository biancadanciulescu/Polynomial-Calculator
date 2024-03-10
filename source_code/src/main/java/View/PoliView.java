package View;
import Model.PoliModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PoliView extends JFrame {

    private JTextField polinom1 = new JTextField(10);
    private JTextField polinom2 = new JTextField(10);

    private JTextField rez = new JTextField(15);
    private JTextField rest = new JTextField(15);

    private JButton b_add = new JButton("Add");
    private JButton b_sub = new JButton("Substract");
    private JButton b_multi = new JButton("Multiplicate");
    private JButton b_dev = new JButton("Devide");
    private JButton b_integ = new JButton("Integrate");
    private JButton b_deriv = new JButton("Derive");
    private JButton reset = new JButton("Reset");

    private PoliModel m_model;

    public PoliView(PoliModel model){

        m_model = model;
        m_model.setValue(PoliModel.INITIAL_VALUE);

        rez.setText(m_model.getValue());
        rez.setEditable(false);

        rest.setText(m_model.getValue());
        rest.setEditable(false);


        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("Calculator polynomial");
        p1.add(l1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("First Polynomial");
        p2.add(l2);
        p2.add(Box.createRigidArea(new Dimension(10,10)));
        p2.add(polinom1);
        p2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        p2.setLayout(new FlowLayout());


        JPanel p3 = new JPanel();
        JLabel l3 = new JLabel("Second Polynomial");
        p3.add(l3);
        p3.add(polinom2);
        p3.setAlignmentX(Component.RIGHT_ALIGNMENT);
        p3.setLayout(new FlowLayout());


        JPanel poli_grup = new JPanel();
        poli_grup.setAlignmentX(Component.RIGHT_ALIGNMENT);
        poli_grup.setLayout((new BoxLayout(poli_grup, BoxLayout.Y_AXIS)));
        poli_grup.add(Box.createRigidArea(new Dimension(100,10)));
        poli_grup.add(p2);
        poli_grup.add(p3);


        JPanel p4 = new JPanel();
        p4.setLayout((new BoxLayout(p4, BoxLayout.Y_AXIS)));
        p4.setAlignmentX(Component.CENTER_ALIGNMENT);

        b_add.setAlignmentX(Component.CENTER_ALIGNMENT);
        b_sub.setAlignmentX(Component.CENTER_ALIGNMENT);
        b_multi.setAlignmentX(Component.CENTER_ALIGNMENT);

        p4.add(b_add);
        p4.add(Box.createRigidArea(new Dimension(0,10)));
        p4.add(b_sub);
        p4.add(Box.createRigidArea(new Dimension(0,10)));
        p4.add(b_multi);


        JPanel p5 = new JPanel();
        p5.setAlignmentX(Component.CENTER_ALIGNMENT);
        p5.setLayout((new BoxLayout(p5, BoxLayout.Y_AXIS)));

        b_dev.setAlignmentX(Component.CENTER_ALIGNMENT);
        b_integ.setAlignmentX(Component.CENTER_ALIGNMENT);
        b_deriv.setAlignmentX(Component.CENTER_ALIGNMENT);

        p5.add(b_dev);
        p5.add(Box.createRigidArea(new Dimension(0,10)));
        p5.add(b_integ);
        p5.add(Box.createRigidArea(new Dimension(0,10)));
        p5.add(b_deriv);


        JPanel butoane = new JPanel();
        butoane.setAlignmentX(Component.RIGHT_ALIGNMENT);
        butoane.setLayout(new FlowLayout());
        butoane.add(Box.createRigidArea(new Dimension(50,50)));
        butoane.add(p4);
        butoane.add(p5);


        JPanel p6 = new JPanel();
        p6.setAlignmentX(Component.RIGHT_ALIGNMENT);
        p6.setLayout(new FlowLayout());
        JLabel l4 = new JLabel("Result");

        p6.add(reset);
        p6.add(Box.createRigidArea(new Dimension(10,10)));
        p6.add(l4);
        p6.add(Box.createRigidArea(new Dimension(10,10)));
        p6.add(rez);

        JPanel p7 = new JPanel();
        p7.setAlignmentX(Component.RIGHT_ALIGNMENT);
        JLabel l7 = new JLabel("Reminder");
        p7.add(l7);
        p7.add(rest);
        p7.setBounds(100, 100, 100, 100);

        JPanel p = new JPanel();
        p.setBackground(Color.pink);
        p1.setBackground(Color.pink);
        p2.setBackground(Color.pink);
        p3.setBackground(Color.pink);
        p4.setBackground(Color.pink);
        p5.setBackground(Color.pink);
        p6.setBackground(Color.pink);
        p7.setBackground(Color.pink);
        poli_grup.setBackground(Color.pink);
        butoane.setBackground(Color.pink);
        p.add(p1);
        p.add(poli_grup);
        p.add(butoane);
        p.add(p6);
        p.add(p7);

        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        this.setLocation(500, 150);
        this.setSize(450, 450);
        this.setContentPane(p);
        this.setTitle("Polynomial Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void reset(){
        rez.setText(PoliModel.INITIAL_VALUE);
        rest.setText(PoliModel.INITIAL_VALUE);
    }

    public String getPolinom1(){
        return polinom1.getText();
    }

    public String getPolinom2(){
        return polinom2.getText();
    }

    public void setRez(String newRez){
        rez.setText(newRez);
    }
    public void setRest(String newRest){
        rest.setText(newRest);
    }


    public void addAddListener(ActionListener a){
       b_add.addActionListener(a);
   }
    public void addSubListener(ActionListener a){
        b_sub.addActionListener(a);
    }
    public void addMultiListener(ActionListener a){
        b_multi.addActionListener(a);
    }
    public void addDevListener(ActionListener a){
        b_dev.addActionListener(a);
    }
    public void addIntegListener(ActionListener a){
        b_integ.addActionListener(a);
    }
    public void addDerivListener(ActionListener a){ b_deriv.addActionListener(a);}
    public void addResetListener(ActionListener a){ reset.addActionListener(a);}


}
