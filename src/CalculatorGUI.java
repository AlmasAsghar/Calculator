
import java.awt.*;
import javax.swing.*;
               

public class CalculatorGUI {
    JFrame fr;
    JPanel  pn,pn2;
    JTextField tf1,tf2;
    JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,
            btnMc,btnMr,btnMp,btnMm,btnMs,btnA,btnSub,btnD,btnMul,
            btnE,btnPt,btnN,btnSq,btnP,btnR,btnS,btnC,btnCE,btnBs;
    btnHandler hnd;
    
    public CalculatorGUI()
    {
        initGUI();
    }
    public void initGUI()
    {
        fr=new JFrame("Calculator");
        pn=new JPanel(new GridLayout(7,4,4,6));
        pn.setBorder(BorderFactory.createLineBorder(Color.gray, 10));
        pn2 = new JPanel(new GridLayout(2,0));
        pn2.setPreferredSize(new Dimension(60, 60));
        tf1=new JTextField(45);
        tf2=new JTextField(40);
        //tf2.setColumns(9);
        
        fr.add(pn2,"North");
        tf1.setHorizontalAlignment(JTextField.RIGHT);
        tf2.setHorizontalAlignment(JTextField.RIGHT);
        pn2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5));
        tf1.setEditable(false);
        tf2.setEditable(false);
        pn2.add(tf1);
        pn2.add(tf2);
        
        fr.add(pn);
        
        hnd=new btnHandler(this);
        
        btnMc=new JButton("Mc");
        btnMr=new JButton ("Mr");
        btnMp=new JButton("Mp");
        btnMm=new JButton("Mm");
        btnMs=new JButton("Ms");
        
        btnA=new JButton("+");
        btnSub=new JButton("-");
        btnD=new JButton("/");
        btnMul=new JButton("*");
        
        btnSq=new JButton("sqrt");
        btnP=new JButton("%");
        btnR=new JButton("R");
        btnS=new JButton("x^2");
        
        btnC=new JButton("C");
        btnCE=new JButton("CE");
        btnBs=new JButton("<--");
        btnE=new JButton("=");
        btnPt=new JButton(".");
        btnN=new JButton("~");
        
        btn0=new JButton("0");
        btn1=new JButton("1");
        btn2=new JButton("2");
        btn3=new JButton("3");
        btn4=new JButton("4");
        btn5=new JButton("5");
        btn6=new JButton("6");
        btn7=new JButton("7");
        btn8=new JButton("8");
        btn9=new JButton("9");
        
        pn.add(btnMc);
        pn.add(btnMr);
        pn.add(btnMp);
        pn.add(btnMm);
        pn.add(btnMs);
        
        pn.add(btnP);
        pn.add(btnSq);
        pn.add(btnS);
        pn.add(btnR);
        
        
        pn.add(btnBs);
        pn.add(btnC);
        pn.add(btnS);
        pn.add(btnD);
         
        pn.add(btn7);
        pn.add(btn8);
        pn.add(btn9);
        pn.add(btnMul);
         
        pn.add(btn4);
        pn.add(btn5);
        pn.add(btn6);
        pn.add(btnA);
        
        pn.add(btn1);
        pn.add(btn2);
        pn.add(btn3);
        pn.add(btnSub);
       
        pn.add(btnPt);
        pn.add(btn0);
        pn.add(btnE);
        pn.add(btnN);
        
        btn0.addActionListener(hnd);
        btn1.addActionListener(hnd);
        btn2.addActionListener(hnd);
        btn3.addActionListener(hnd);
        btn4.addActionListener(hnd);
        btn5.addActionListener(hnd);
        btn6.addActionListener(hnd);
        btn7.addActionListener(hnd);
        btn8.addActionListener(hnd);
        btn9.addActionListener(hnd);
        btnMc.addActionListener(hnd);
        btnMr.addActionListener(hnd);
        btnMp.addActionListener(hnd);
        btnMm.addActionListener(hnd);
        btnMs.addActionListener(hnd);
        btnA.addActionListener(hnd);
        btnSub.addActionListener(hnd);
        btnD.addActionListener(hnd);
        btnMul.addActionListener(hnd);
        btnE.addActionListener(hnd);
        btnPt.addActionListener(hnd);
        btnN.addActionListener(hnd);
        btnSq.addActionListener(hnd);
        btnP.addActionListener(hnd);
        btnR.addActionListener(hnd);
        btnS.addActionListener(hnd);
        btnC.addActionListener(hnd);
        btnCE.addActionListener(hnd);
        btnBs.addActionListener(hnd);
        tf1.addActionListener(hnd);
        tf2.addActionListener(hnd);
        
        fr.setSize(400,400);
        fr.setLocation(200,200);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
