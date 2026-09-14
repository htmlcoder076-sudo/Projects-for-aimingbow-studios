import javax.swing.*;
import java.awt.*;

public class main{
	public static void CheckAndCalc(){
		int num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "first number?"));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "second number?"));
		if (num1 == (num2)){
		JOptionPane.showMessageDialog(null, "Equal: True");
        }
		else{
		JOptionPane.showMessageDialog(null, "Equal: False");
		}
	}
	public static void Init(){
		JFrame frame = new JFrame("equal checker");
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.RED);

		JButton check = new JButton("Check two numbers");
		check.setBackground(Color.RED);
		check.setForeground(Color.ORANGE);
		check.addActionListener(e -> {
			CheckAndCalc();
		});

		JPanel panel = new JPanel();
		

		panel.add(check); 
		frame.add(panel);

		frame.setVisible(true);
	}
	public static void main(String[] args) {
		Init();
	}

}