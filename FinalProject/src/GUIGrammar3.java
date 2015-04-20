

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JRadioButton;



class GUIGrammar3 extends JFrame implements ActionListener {
	JRadioButton pS_c, pA_c, pB_c, pC_c, pD_c, pE_c;
	Button zakoncz_c;
	Button wersja1_c;
	Button next_c;
	Button sprawdz_c;
	Button dalej_c;
	Button czysc_c;
	Frame Okno1_c, Okno2_c;
	String napis[];
	TextField t1, t2;
	Label zle;

	String odp;

	GUIGrammar3(Button wersja1, Button zakoncz, Button next, Button sprawdz,
			Frame Okno1, JRadioButton pS, JRadioButton pA, JRadioButton pB,
			JRadioButton pC, JRadioButton pD, JRadioButton pE) {
		pS_c = pS;
		pA_c = pA;
		pB_c = pB;
		pC_c = pC;
		pD_c = pD;
		pE_c = pE;
		Okno1_c = Okno1;
		zakoncz_c = zakoncz;
		next_c = next;
		sprawdz_c = sprawdz;
		wersja1_c = wersja1;
		t1 = new TextField(1);
		t2 = new TextField(1);
		odp = new String();
		zle = new Label("TRY AGAIN!!!");
		czysc_c = new Button("Clear");
		dalej_c = new Button("         Next        ");
		Okno2_c = new Frame("Okno2");
	}

	public void actionPerformed(ActionEvent ev1) {// obsluga zakoncz
		if (ev1.getSource().equals(zakoncz_c)) {
			Okno1_c.hide();
		}
		if (ev1.getSource().equals(next_c)) {// uruchomianie 2 okna - to z
												// wyborem produkcji
			Okno1_c.hide();
			Grammar3 nowy = new Grammar3();
		}
		if (ev1.getSource().equals(sprawdz_c)) {
			Okno1_c.remove(zle);
			if (pS_c.isSelected() == false && pA_c.isSelected() == false
					&& pB_c.isSelected() == true && pC_c.isSelected() == false
					&& pD_c.isSelected() == false && pE_c.isSelected() == false) {

				dalej_c.setBackground(Color.green);
				Okno1_c.add(dalej_c, BorderLayout.AFTER_LAST_LINE);
				Okno1_c.setVisible(true);
				dalej_c.addActionListener(this);
				System.out.println("Correct");
				Okno1_c.remove(zle);
				sprawdz_c.disable();
				sprawdz_c.setBackground(Color.LIGHT_GRAY);

			} else {
				Okno1_c.add(zle);
				Okno1_c.setVisible(true);
			}
		}
		if (ev1.getSource().equals(dalej_c))// przycisk dalej sie pojawia gdzy
											// wszytko jest OKI i wtedy
											// uruchamia
		// okno z poprawa geramatyki
		{
			int wersja = 8;
			Okno1_c.hide();
			Window nowy = new Window(wersja);
		}
		if (ev1.getSource().equals(wersja1_c))// to oblsuga przycisku dalej z 3
												// okna-poprawa gramatyki
		// do okno koncowego czyli okno gdzie wyznaczamy pier,nast gramatyki
		// popraw.
		{

			int wersja = 9;
			Okno1_c.hide();
			Window nowy3 = new Window(wersja);
		}

	}
}
