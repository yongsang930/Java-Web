// [계산기 예제]

import java.awt.*;
import java.awt.event.*; // event처리를 위한 인터페이스들을 사용하기 위해
import javax.swing.*;

public class CalculatorEx1 extends Frame implements ActionListener,
            WindowListener {
      JTextField resultField = null;

      Button numPad[] = null;

      Button westMx[] = null;

      Button northCx[] = null;

      MenuBar menuBar;

      Menu editMenu, viewMenu, helpMenu;

      MenuItem copyItem, pasteItem;

      CheckboxMenuItem engItem, genItem;

      MenuItem helpItem, aboutItem;

      char op;

      double memory;

      boolean decimalPoint = false;

      boolean operand = false; // 첫번째 연산자가 기억되었는지 여부를 지정한다.

      boolean inputMode = true;

      public static void main(String[] args) {
    	  CalculatorEx1 f = new CalculatorEx1();

            f.setVisible(true);
      }

      public CalculatorEx1() {
            setTitle("Calculator");

            // 메뉴만들기
            menuBar = new MenuBar();
            setMenuBar(menuBar);

            editMenu = new Menu("편집");
            menuBar.add(editMenu);
            copyItem = new MenuItem("복사하기", new MenuShortcut('C'));
            pasteItem = new MenuItem("붙여넣기", new MenuShortcut('V'));
            editMenu.add(copyItem);
            editMenu.add(pasteItem);

            viewMenu = new Menu("보기");
            menuBar.add(viewMenu);
            engItem = new CheckboxMenuItem("공학용");
            genItem = new CheckboxMenuItem("일반용");
            viewMenu.add(engItem);
            viewMenu.add(genItem);

            helpMenu = new Menu("도움말");
            menuBar.setHelpMenu(helpMenu);
            helpItem = new MenuItem("도움말 항목");
            aboutItem = new MenuItem("계산기 정보");
            helpMenu.add(helpItem);
            helpMenu.addSeparator();
            helpMenu.add(aboutItem);

            // 버튼 만들기
            String padStr[] = { "7", "8", "9", "/", "sqrt", "4", "5", "6", "*",
                        "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=" };
            String northStr[] = { " ", " Backspace ", " CE ", " C " };
            String westStr[] = { " MC ", " MR ", " MS ", " M+ " };

            resultField = new JTextField("0");
            resultField.setHorizontalAlignment(SwingConstants.RIGHT);
            resultField.setEditable(false); // 계산기 창에 값을 직접 입력하지 못하게 한다.
            resultField.setBackground(Color.white);

            Panel padPanel = new Panel();
            padPanel.setLayout(new GridLayout(4, 5, 4, 4));
            padPanel.setBackground(Color.lightGray);

            // 숫자버튼
            numPad = new Button[padStr.length];
            for (int i = 0; i < padStr.length; i++) {
                  numPad[i] = new Button(padStr[i]);
                  numPad[i].setForeground(Color.blue);
                  numPad[i].addActionListener(this);
                  padPanel.add(numPad[i]);
            }

            Panel northPanel = new Panel();
            northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 4, 4));
            northPanel.setBackground(Color.lightGray);

            // BSpace, CE, C 기능 버튼
            northCx = new Button[northStr.length];

            for (int i = 0; i < northStr.length; i++) {
                  northCx[i] = new Button(northStr[i]);
                  northCx[i].setForeground(Color.magenta);
                  northCx[i].addActionListener(this);
                  northPanel.add(northCx[i]);
            }

            Panel westPanel = new Panel();

            westPanel.setLayout(new GridLayout(4, 5, 4, 4));
            westPanel.setBackground(Color.lightGray);

            // 왼쪽의 MC, MR, MS, M+ 버튼
            westMx = new Button[westStr.length];
            for (int i = 0; i < westStr.length; i++) {
                  westMx[i] = new Button(westStr[i]);
                  westMx[i].setForeground(Color.red);
                  westMx[i].addActionListener(this);

                  westPanel.add(westMx[i]);
            }

            Panel p = new Panel();
            p.setLayout(new BorderLayout(4, 4));
            p.setBackground(Color.lightGray);

            p.add("North", northPanel);
            p.add("West", westPanel);
            p.add("Center", padPanel);

            add("North", resultField);
            add("Center", p);

            setLocation(100, 100);
            pack();
            setResizable(false);

            addWindowListener(this); // WindowListener등록
      } // end of MyCalculater()

      public void setText(String s) {
            resultField.setText(s);
      }

      public void putText(String s) {
            if (!inputMode) {
                  setText(s);
                  inputMode = true;
                  return;
            }

            String text = resultField.getText();

            if (text != null && text.length() < 25) {

                  if (text.equals("0")) {
                        setText(s.equals(".") ? "0" + s : s);
                  } else {
                        setText(text + s);
                  }
            }
      }

      public void clearText() {
            setText("0");
            inputMode = true;
            decimalPoint = false;
      }

      public void delText() {
            String text = resultField.getText();

            if (text != null) {
                  if (text.length() > 1) {
                        setText(text.substring(0, text.length() - 1));
                  } else {
                        setText("0");
                  }
                  // if (text != null)
                  // setText( (text.length() >1) ? text.substring(0, text.length()-1)
                  // : "0");
            }
      } // end of delText()

      // event처리부분
      public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            String ac = e.getActionCommand();
            System.out.println(e.getActionCommand());

            if (ac.equals("0")) {
                  double value = Double.parseDouble(resultField.getText());
                  if (value != 0.0 || decimalPoint)
                        putText("0");
            } else {
                  try {
                        int i = Integer.parseInt(ac);
                        if (ac.equals(i + ""))
                              putText(i + "");
                  } catch (Exception ex) {
                  }
            }
            /*
            * if(ac.equals("1")) putText("1"); if(ac.equals("2")) putText("2");
            * if(ac.equals("3")) putText("3"); if(ac.equals("4")) putText("4");
            * if(ac.equals("5")) putText("5"); if(ac.equals("6")) putText("6");
            * if(ac.equals("7")) putText("7"); if(ac.equals("8")) putText("8");
            * if(ac.equals("9")) putText("9");
            */
            if (source == northCx[3])
                  clearText(); // C버튼을 누르면...
            if (source == northCx[1])
                  delText(); // Backspace버튼을 누르면...
            if (ac.equals("."))
                  if (!decimalPoint) {
                        putText((inputMode) ? "." : "0.");
                        decimalPoint = true;
                  }
            if (source == numPad[3]) {
                  op = '/';
                  memory = Double.parseDouble(resultField.getText());
                  inputMode = false;
            }
            if (source == numPad[8]) {
                  op = '*';
                  memory = Double.parseDouble(resultField.getText());
                  inputMode = false;
            }
            if (source == numPad[13]) {
                  op = '-';
                  memory = Double.parseDouble(resultField.getText());
                  inputMode = false;
            }
            if (source == numPad[18]) {
                  op = '+';
                  memory = Double.parseDouble(resultField.getText());
                  inputMode = false;
            }
            if (source == numPad[19]) { // "="를 눌렀을때

                  double operand2 = Double.parseDouble(resultField.getText());
                  double result;
                  switch (op) {
                  case '/':
                        result = memory / operand2;
                        break;
                  case '*':
                        result = memory * operand2;
                        break;
                  case '-':
                        result = memory - operand2;
                        break;
                  case '+':
                        result = memory + operand2;
                        break;
                  default:
                        result = operand2;
                  }

                  setText(result + "");
                  decimalPoint = false;
                  inputMode = false;
            }
      }

      public void windowOpened(WindowEvent e) {
      }

      public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            e.getWindow().dispose();
            System.exit(0);
      }

      public void windowClosed(WindowEvent e) {
      }

      public void windowIconified(WindowEvent e) {
      }

      public void windowDeiconified(WindowEvent e) {
      }

      public void windowActivated(WindowEvent e) {
      }

      public void windowDeactivated(WindowEvent e) {
      }

}// end of class