package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    private final MyJPanel myJPanel;
    private final JButton strom;
    private final JButton dom;
    private final JButton cesta;
    private final JLabel mod;

    MyFrame() {
        super();
        this.setTitle("MyFinalTryFrame");
        this.setSize(500, 850);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel mod = new JLabel("Strom");
        this.mod=mod;

        MyJPanel myJPanel = new MyJPanel(mod);
        this.myJPanel = myJPanel;
        this.add(myJPanel, BorderLayout.CENTER);

        JButton strom = new JButton("Strom");
        JButton dom = new JButton("Dom");
        JButton cesta = new JButton("Cesta");


        mod.setOpaque(true);
        mod.setBackground(myJPanel.getMyJpanelColor());

        this.strom=strom;
        this.dom=dom;
        this.cesta=cesta;

        JPanel downMenu = new JPanel();
        downMenu.setLayout(new GridLayout(1,4));
        downMenu.add(strom);
        downMenu.add(dom);
        downMenu.add(cesta);
        downMenu.add(mod);

        strom.addActionListener(this);
        dom.addActionListener(this);
        cesta.addActionListener(this);

        this.add(downMenu,BorderLayout.NORTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==strom){
            myJPanel.setWhatToPaint(1);
            mod.setText("Strom");
        }
        if(e.getSource()==dom){
            myJPanel.setWhatToPaint(2);
            mod.setText("Dom");
        }
        if(e.getSource()==cesta){
            myJPanel.setWhatToPaint(3);
            mod.setText("Cesta");
        }
        mod.setBackground(myJPanel.getMyJpanelColor());
    }
}
