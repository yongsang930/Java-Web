import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculratorEx2 {
   private Frame f;
   private Panel p;
   private TextField tf;
   private Button[] btnNum;
   private Button btnPlus, btnMinus, btnMul, btnDiv, btnRes;
   private int num1;
   private boolean isPlus, isMinus, isMul, isDiv;

   public CalculratorEx2() {
      f = new Frame("계산기");
      tf = new TextField();
      tf.setText("0");
      p = new Panel();

      btnNum = new Button[10];
      for (int i = 0; i < btnNum.length; i++) {
         btnNum[i] = new Button(String.valueOf(i));
      }
      btnPlus = new Button("+");
      btnMinus = new Button("-");
      btnMul = new Button("X");
      btnDiv = new Button("/");
      btnRes = new Button("=");
      num1 = 0;
      isPlus = false;
      isMinus = false;
      isMul = false;
      isDiv = false;
   }

   public void startFrame() {
      f.add(tf, BorderLayout.NORTH);
      f.add(p, BorderLayout.CENTER);
      p.setBackground(Color.pink);
      p.setLayout(new GridLayout(4, 0));
      for (int i = 0; i < btnNum.length; i++) {
         p.add(btnNum[i]);
      }

      for (int i = 0; i < btnNum.length; i++) {
         btnNum[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (tf.getText().equals("0")) {
                  tf.setText(e.getActionCommand());
               } else {
                  String s = tf.getText();
                  s = s + e.getActionCommand();
                  tf.setText(s);
               }
            }
         });
      }
      
      btnPlus.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            num1 = Integer.parseInt(tf.getText());
            isPlus = true;
            tf.setText("0");
         }
      });
      
      btnMinus.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            num1 = Integer.parseInt(tf.getText());
            isMinus = true;
            tf.setText("0");
         }
      });
      
      btnMul.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            num1 = Integer.parseInt(tf.getText());
            isMul = true;
            tf.setText("0");
         }
      });
      
      btnDiv.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            num1 = Integer.parseInt(tf.getText());
            isDiv = true;
            tf.setText("0");
         }
      });
      
      btnRes.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if(isPlus == true) {
               int res = num1 + Integer.parseInt(tf.getText());
               tf.setText(String.valueOf(res));
            }else if(isMinus == true) {
               int res = num1 - Integer.parseInt(tf.getText());
               tf.setText(String.valueOf(res));
            }else if(isMul == true) {
               int res = num1 * Integer.parseInt(tf.getText());
               tf.setText(String.valueOf(res));
            }else if(isDiv == true) {
               int res = num1 / Integer.parseInt(tf.getText());
               tf.setText(String.valueOf(res));
            }
            
            isPlus = false;
            isMinus = false;
            isMul = false;
            isDiv = false;
         }
      });

      p.add(btnPlus);
      p.add(btnMinus);
      p.add(btnMul);
      p.add(btnDiv);
      p.add(btnRes);

      f.setSize(400, 400);
      f.setVisible(true);
   }

   public static void main(String[] args) {
      CalculratorEx2 c = new CalculratorEx2();
      c.startFrame();
   }
}