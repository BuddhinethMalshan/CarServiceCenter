import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

public class Bill {
    private JPanel Main;
    private JTextArea textArea1;
    private JButton PRINTButton;
    private JButton ADDButton;
    private JTextField textField2;
    private JTextField textField1;

    public Bill() {

        billHeder();
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textArea1.setText(textArea1.getText()+textField1.getText()+"-"+textField2.getText()+"\t\t"+"Rs"+"\n");
            }
        });
        PRINTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea1.print();
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    private void billHeder()
    {

        textArea1.setText("========================"+"\n"
                +"4 Wheel Auto Center"+"\n"
                +"Contac No-0362548791"+"\n"
                +"Adres- TeamR@gmail.com"+"\n"
                +"========================"+"\n"
                +"Cashier- Nalin"+"\n"
                +"Invoice No- 0456"+"\n"
                +"========================"+"\n"
                +"Vehicle- TOYOTA Aqua"+"\n"
                +"Customer- Kasun Amarasena"+"\n"
                +"========================"+"\n"
                +"1.Vehicle wash        "+"\n"
                +"      Body wash-               Rs.1500"+"\n"
                +"      Interior Vacuum-      Rs.1500"+"\n"
                +" "+"\n"
                +"2.Wheel Alignment        "+"\n"
                +"      Wheel Balancing-    Rs.1000"+"\n"
                +" "+"\n"
                +"2.Other       "+"\n"
                +"      Oil Filter-                    Rs.1000"+"\n"
                +" "+"\n"
                +"                                 "+"\n"
                +"        Total-                        Rs.5000"+"\n"
                +" "+"\n"
                +"========================"+"\n"
                +"       Thank you for choosing us"+"\n"
                +"            Have a nice day!!"+"\n"
                +"========================"+"\n"
                +"Develop By Team_R"+"\n");

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bill");
        frame.setContentPane(new Bill().Main);
        frame.setSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);






    }
}
