

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class GUIGrammar1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JRadioButton pS_c, pA_c, pB_c, pC_c;
	Button buttonEnd;
	Button buttonVersion;
	Button buttonNext1;
	Button buttonNext2;
	Button buttonCheck;
	Button buttonClear;
	Frame window1, window2;
	String napis[];
	TextField textField1, textField2;
	Label label;

	String string;

	GUIGrammar1(Button buttonVersion_g, Button buttonEnd_g, Button buttonNext1_g, Button buttonCheck_g,
			Frame window1_g, JRadioButton pS, JRadioButton pA, JRadioButton pB,
			JRadioButton pC) {
		pS_c = pS;
		pA_c = pA;
		pB_c = pB;
		pC_c = pC;
		window1 = window1_g;
		buttonEnd = buttonEnd_g;
		buttonNext1 = buttonNext1_g;
		buttonCheck = buttonCheck_g;
		buttonVersion = buttonVersion_g;
		textField1 = new TextField(1);
		textField2 = new TextField(1);
		string = new String();
		label = new Label("TRY AGAIN!!!");
		buttonClear = new Button("Clear");
		buttonNext2 = new Button("         Next        ");
		window2 = new Frame("Okno2");
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ev1) {// obsluga zakoncz
		if (ev1.getSource().equals(buttonEnd)) {
			window1.hide();
		}
		if (ev1.getSource().equals(buttonNext1)) {// uruchomianie 2 okna - to z  wyborem produkcji
			window1.hide();
			Grammar1 grammar1 = new Grammar1();
		}
		if (ev1.getSource().equals(buttonCheck)) {
			window1.remove(label);
			if (pS_c.isSelected() == true && pA_c.isSelected() == true
					&& pB_c.isSelected() == true && pC_c.isSelected() == false) {

				//dalej_c.setBackground(Color.green);
				window1.add(buttonNext2, BorderLayout.AFTER_LAST_LINE);
				window1.setVisible(true);
				buttonNext2.addActionListener(this);
				System.out.println("Correct");
				window1.remove(label);
				buttonCheck.disable();
				//sprawdz_c.setBackground(Color.LIGHT_GRAY);

			} else {
				window1.add(label);
				window1.setVisible(true);
			}
		}
		if (ev1.getSource().equals(buttonNext2))// przycisk dalej sie pojawia gdzy
											// wszytko jest OKI i wtedy
											// uruchamia
		// okno z poprawa geramatyki
		{
			int version = 2;
			window1.hide();
			Window window = new Window(version);
		}
		if (ev1.getSource().equals(buttonVersion))// to oblsuga przycisku dalej z 3
												// okna-poprawa gramatyki
		// do okno koncowego czyli okno gdzie wyznaczamy pier,nast gramatyki
		// popraw.
		{

			int version = 3;
			window1.hide();
			Window window = new Window(version);
		}

	}
}