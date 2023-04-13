package Source;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class CalculadoraGrafica implements ActionListener {

    private Calculator c; //Objeto de la clase Calculadora
    private JTextField tfexp, tfx, tfy, tfz, tfres;  //Campos de texto para las expresiones y
    //los valores de las variables

    public CalculadoraGrafica() {
        //En el constructor se crean las componentes gráficas
        JFrame f = new JFrame(); //Objeto JFrame que contendrá todas las componentes gráficas
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Calculadora");
        f.setMinimumSize(new Dimension(300, 620));
        f.setLocation(50, 50);
        f.getContentPane().setLayout(new GridLayout(3, 1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(null); //El JFrame estará dividido en tres paneles
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);

        JLabel l1 = new JLabel("EXPRESIÓN"); //Etiqueta
        l1.setBounds(5, 0, 290, 30);
        l1.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
        l1.setForeground(Color.magenta);
        panel1.add(l1);

        tfexp = new JTextField();  //Campo de texto para introducir la expresión
        tfexp.setBounds(5, 30, 270, 30);
        panel1.add(tfexp);
        JPanel panel11 = new JPanel();
        panel11.setLayout(new GridLayout(3, 6));
        JButton b;
        String[] buttons = {"x", "y", "z", "1", "2", "3", "+", "*", "-", "4", "5", "6", "(", ")", "0", "7", "8", "9"};
        for (int i = 0; i < buttons.length; i++) {
            b = new JButton(buttons[i]);
            b.addActionListener(this);
            panel11.add(b); //Botones para introducir la expresión
        }
        panel11.setBounds(15, 70, 250, 120);
        panel1.add(panel11);
        f.getContentPane().add(panel1);

        JLabel l2 = new JLabel("VALORES DE VARIABLES"); //Etiqueta
        l2.setBounds(5, 51, 290, 30);
        l2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));//setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        l2.setForeground(Color.red);
        panel2.add(l2);


        JPanel panel21 = new JPanel();
        panel21.setLayout(new GridLayout(3, 2));
        panel21.setBounds(40, 90, 130, 90);
        panel21.add(new JLabel("x  ", JLabel.CENTER));
        tfx = new JTextField();
        panel21.add(tfx);
        panel21.add(new JLabel("y  ", JLabel.CENTER));
        tfy = new JTextField();
        panel21.add(tfy);
        panel21.add(new JLabel("z  ", JLabel.CENTER));
        tfz = new JTextField();
        panel21.add(tfz);
        panel2.add(panel21);
        f.getContentPane().add(panel2);

        JLabel l3 = new JLabel("RESULTADOS"); //Etiqueta
        l3.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));//l3.setFont(new Font(Font.SANS_SERIF, Font.BOLD,14));
        l3.setBounds(5, 51, 290, 30);
        l3.setForeground(Color.blue);
        panel3.add(l3);

        //Botones para realizar las operaciones sobre la expresión
        b = new JButton("Sustituir");
        b.addActionListener(this);
        b.setBounds(5, 90, 87, 30);
        panel3.add(b);
        b = new JButton("Calcular");
        b.addActionListener(this);
        b.setBounds(97, 90, 87, 30);
        panel3.add(b);
        b = new JButton("Borrar");
        b.addActionListener(this);
        b.setBounds(189, 90, 87, 30);
        panel3.add(b);
        tfres = new JTextField();
        tfres.setBounds(5, 130, 270, 30);
        panel3.add(tfres);
        f.getContentPane().add(panel3);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ev) {
        String aux = ((JButton) ev.getSource()).getText();

        if (aux.equals("Sustituir")) {
            this.sustituir();
        } else {
            if (aux.equals("Calcular")) {
                this.calcular();
            } else {
                if (aux.equals("Borrar")) {
                    this.reset();
                } else {
                    String aux2 = tfexp.getText();
                    tfexp.setText(aux2 + aux);
                }
            }
        }
    }

    private void calcular() {
        String s = tfexp.getText();
        Expression exp = parser(s);
        Valoration val = new Valoration();
        if(!tfx.getText().isEmpty() ){
            val.addAssignation("x", Integer.parseInt(tfx.getText()));
        }
        if(!tfy.getText().isEmpty()){
            val.addAssignation("y", Integer.parseInt(tfy.getText()));
        }
        if(!tfz.getText().isEmpty()){
            val.addAssignation("z", Integer.parseInt(tfz.getText()));
        }
        c = new Calculator(exp, val);
        int res = c.calculate();
        tfres.setText(Integer.toString(res));
    }

    private void sustituir() {
        String s = tfexp.getText();
        Expression exp = parser(s);
        Valoration val = new Valoration();
        if(!tfx.getText().isEmpty()){
            val.addAssignation("x", Integer.parseInt(tfx.getText()));
        }
        if(!tfy.getText().isEmpty()){
            val.addAssignation("y", Integer.parseInt(tfy.getText()));
        }
        if(!tfz.getText().isEmpty()){
            val.addAssignation("z", Integer.parseInt(tfz.getText()));
        }
        c = new Calculator(exp, val);

        tfres.setText(this.c.substitute().toString());
    }

    private void reset() {
        this.tfx.setText("");
        this.tfy.setText("");
        this.tfz.setText("");
        this.tfexp.setText("");
        this.tfres.setText("");
    }

    private static String getExp1(String s) {
        int i = 1, na = 1, nc = 0;

        while (na != nc) {
            if (s.charAt(i) == '(') {
                na++;
            } else {
                if (s.charAt(i) == ')') {
                    nc++;
                }
            }
            i++;
        }
        return s.substring(0, i);
    }

    private static Expression parser(String s) {
        int l = s.length();
        if (s.charAt(0) == '(') {
            String s1 = getExp1(s);
            int l1 = s1.length();
            if (s1.length() == l) {
                return parser(s.substring(1, l - 1));
            }
            char op = s.charAt(l1);
            String s2 = s.substring(l1 + 1, l);
            if (op == '+') return new Add(parser(s1), parser(s2));
            else if (op == '-') return new Subtract(parser(s1), parser(s2));
            else return new Product(parser(s1), parser(s2));
        } else {
            if (s.charAt(0) == '-') {
                if (s.charAt(1) == '(') {
                    s = s.substring(2, l - 1);
                    return new Opposite(parser(s));
                } else {
                    s = s.substring(1, l);
                    return new Opposite(parser(s));
                }
            } else {
                int i1 = s.indexOf("+");
                int i2 = s.indexOf("*");
                int i3 = s.indexOf("-");
                if ((i1 == -1) && (i2 == -1) && (i3 == -1)) {
                    if (s.equals("x") || s.equals("y") || s.equals("z")) {
                        return new Variable(s);
                    } else {
                        return new Constant(Integer.parseInt(s));
                    }
                } else {
                    if (i1 == -1) i1 = l;
                    if (i2 == -1) i2 = l;
                    if (i3 == -1) i3 = l;

                    if ((i1 < i2) && (i1 < i3)) {

                        String s1 = s.substring(0, i1);
                        String s2 = s.substring(i1 + 1, l);
                        return new Add(parser(s1), parser(s2));

                    } else if ((i2 < i1) && (i2 < i3)) {
                        String s1 = s.substring(0, i2);
                        String s2 = s.substring(i2 + 1, l);
                        return new Product(parser(s1), parser(s2));

                    } else {
                        String s1 = s.substring(0, i3);
                        String s2 = s.substring(i3 + 1, l);
                        return new Subtract(parser(s1), parser(s2));

                    }
                }
            }
        }
    }
}
