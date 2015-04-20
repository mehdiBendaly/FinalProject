

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Grammar1 extends JFrame {
	// Wyglad2 = Grammar1

	private static final long serialVersionUID = 1L;
	Label label;
	JRadioButton radioButtonProdS, radioButtonProdA, radioButtonProdB, radioButonProdC;
	Button buttonCheck, buttonExit;
	Frame window;
	String labele[];
	Label prod;
	Font front;
	Panel pannel1, pannel2, pannel3;
	Container container1, container2, container3;

	Grammar1() {

		pannel1 = new Panel();
		pannel2 = new Panel();
		pannel3 = new Panel();
		container1 = new Container();
		container2 = new Container();
		container3 = new Container();
		container1.setLayout(new GridLayout(1, 1));
		container2.setLayout(new GridLayout(1, 1));
		container3.setLayout(new GridLayout(1, 6));
		String labele[] = { "      S::=-A|-a ", "  A::=B|A*B      ",
				"B::=C|B+C|b", "  C::=c|d            " };
		label = new Label(
				"Find productions that need to be revised so that they fulfill grammatical rules 1 and 2. ");
		window = new Frame("Window");
		buttonExit = new Button("Exit");
		buttonCheck = new Button("Check");
		radioButtonProdS = new JRadioButton("Production S");
		radioButtonProdA = new JRadioButton("Production A");
		radioButtonProdB = new JRadioButton("Production B");
		radioButonProdC = new JRadioButton("Production C");
		front = new Font("Dialog", Font.BOLD, 12);
		window.setFont(front);
		window.setLayout(new FlowLayout());
		pannel1.add(label);
		container1.add(pannel1);
		window.add(container1);
		for (int k = 0; k < labele.length; k++) {
			prod = new Label(labele[k]);
			pannel2.add(prod);
			container2.add(pannel2);
			window.add(container2);
		}
		buttonExit.setForeground(Color.white);
		buttonCheck.setForeground(Color.white);
		pannel3.add(radioButtonProdS);
		pannel3.add(radioButtonProdA);
		pannel3.add(radioButtonProdB);
		pannel3.add(radioButonProdC);
		pannel3.add(buttonCheck);
		pannel3.add(buttonExit);
		container3.add(pannel3);
		window.add(container3, BorderLayout.SOUTH);
		window.setSize(550, 200);
		window.setVisible(true);
		GUIGrammar1 radio = new GUIGrammar1(null, buttonExit, null, buttonCheck,
				window, radioButtonProdS, radioButtonProdA, radioButtonProdB, radioButonProdC);
		;
		buttonCheck.addActionListener(radio);
		buttonExit.addActionListener(radio);
	}
}
