

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
import java.awt.TextArea;

//ta klasa sluzy nam do wpisania odpowiedzi sztyno w tablice napisy.. i labele rozne napis..
//akcja na zakoncz
//Wypisanie gramatyki w textArea
public class Window {
//	Wyglad = Window

	Frame frame;
	Panel pannel1, pannel2, pannel3;
	Label labelFirstS, labelFirstA, labelFirstB, labelFirstC, LabelFollowS, labelFollowA, labelFollowB, labelFollowC,
			napis9, napis10, napis11, napis12, napis13, napis14;

	String napisy1[], napisy2[], napisy3[], napisy4[], napisy5[], napisy6[],
			napisy7[], napisy8[];
	Button buttonEnd, buttonNext;
	TextArea Dane;
	StringBuffer str4;
	Label polecenie, corobic, puste;
	Font czcionka;
	Container kont1, kont2, kont3;

	Window(int wersja) {

		if (wersja == 1) {
			pannel1 = new Panel();
			pannel2 = new Panel();
			pannel3 = new Panel();
			kont1 = new Container();
			kont1.setLayout(new GridLayout(1, 1));
			kont2 = new Container();
			kont2.setLayout(new GridLayout(1, 2));
			kont3 = new Container();
			kont3.setLayout(new GridLayout(1, 2));
			polecenie = new Label(
					"Please find first and follow symbols for the given grammar");
			corobic = new Label("Enter comments                      Answer");
			puste = new Label(
					"                                                  ");

			czcionka = new Font("Dialog", Font.BOLD, 12);

			labelFirstS = new Label("First(S)");
			labelFirstA= new Label("First(A)");
			labelFirstB = new Label("First(B)");
			labelFirstC = new Label("First(C)");
			LabelFollowS = new Label("Follow(S)");
			labelFollowA = new Label("Follow(A)");
			labelFollowB = new Label("Follow(B)");
			labelFollowC = new Label("Follow(C)");
			str4 = new StringBuffer(128);
			buttonEnd= new Button("Exit");
			buttonEnd.setForeground(Color.blue);
			buttonNext = new Button("Next");
			buttonNext.setForeground(Color.blue);
			String firstS[] = { "-" };
			String firstA[] = { "c", "d", "b" };
			String firstB[] = { "c", "d", "b" };
			String firstC[] = { "c", "d" };
			String followS[] = { "zp" };
			String followA[] = { "*" };
			String followB[] = { "*", "+" };
			String followC[] = { "*", "+" };
			frame = new Frame("Grammar 1");
			Dane = new TextArea("Given grammar\n" + "S::=-A|-a\n"
					+ "A::=B|A*B\n" + "B::=C|B+C|b\n" + "C::=c|d\n", 10, 15);
			frame.setFont(czcionka);
			frame.setLayout(new FlowLayout());
			pannel1.add(polecenie);
			pannel2.add(Dane);
			pannel2.add(buttonEnd);
			pannel3.add(puste);
			pannel3.add(corobic);
			kont1.add(pannel1);
			kont2.add(pannel2);
			kont3.add(pannel3, BorderLayout.SOUTH);
			frame.add(kont1);
			frame.add(kont2);
			frame.add(kont3);

			GUIGrammar1 over = new GUIGrammar1(null, buttonEnd, null, null, frame, null,
					null, null, null);
			buttonEnd.addActionListener(over);
			List wywolanie1 = new List(wersja, str4, labelFirstS, frame, firstS);
			List wywolanie2 = new List(wersja, str4, labelFirstA, frame, firstA);
			List wywolanie3 = new List(wersja, str4, labelFirstB, frame, firstB);
			List wywolanie4 = new List(wersja, str4, labelFirstC, frame, firstC);
			List wywolanie5 = new List(wersja, str4, LabelFollowS, frame, followS);
			List wywolanie6 = new List(wersja, str4, labelFollowA, frame, followA);
			List wywolanie7 = new List(wersja, str4, labelFollowB, frame, followB);
			List wywolanie8 = new List(wersja, str4, labelFollowC, frame, followC);
			frame.setSize(575, 600);
			frame.setVisible(true);
		}
		
		if (wersja == 4) {
			pannel1 = new Panel();
			pannel2 = new Panel();
			pannel3 = new Panel();
			kont1 = new Container();
			kont1.setLayout(new GridLayout(1, 1));
			kont2 = new Container();
			kont2.setLayout(new GridLayout(1, 2));
			kont3 = new Container();
			kont3.setLayout(new GridLayout(1, 2));
			polecenie = new Label(
					"Please find first and follow symbols for the given grammar");
			corobic = new Label("Enter Comments Answer");
			puste = new Label(
					"                                                  ");
			czcionka = new Font("Dialog", Font.BOLD, 12);

			labelFirstS = new Label("First(S)");
			labelFirstA = new Label("First(A)");
			labelFirstB = new Label("First(B)");
			labelFirstC = new Label("First(C)");
			LabelFollowS = new Label("Follow(S)");
			labelFollowA = new Label("Follow(A)");
			labelFollowB = new Label("Follow(B)");
			labelFollowC = new Label("Follow(C)");
			str4 = new StringBuffer(128);
			buttonEnd = new Button("Exit");
			
			buttonEnd.setForeground(Color.blue);
			buttonNext = new Button("Next");
			buttonNext.setForeground(Color.blue);


			String napisy1[] = { "(" };
			String napisy2[] = { "x" };
			String napisy3[] = { "y", "z", "-" };
			String napisy4[] = { "y", "z", "-" };
			String napisy5[] = { "zp" };
			String napisy6[] = { ")" };
			String napisy7[] = { ")", "+", "*" };
			String napisy8[] = { ")", "*", "+" };
			frame = new Frame("Grammar 2");
			Dane = new TextArea("Given grammar \n" + "S::=(A)\n"
					+ "A::=x|x+B\n" + "B::=C|B*C|B+C\n" + "C::=y|z|-C\n", 10,
					15);
			frame.setFont(czcionka);
			frame.setLayout(new FlowLayout());
			pannel1.add(polecenie);
			pannel2.add(Dane);
			pannel2.add(buttonEnd);
			pannel3.add(puste);
			pannel3.add(corobic);
			kont1.add(pannel1);
			kont2.add(pannel2);
			kont3.add(pannel3, BorderLayout.SOUTH);
			frame.add(kont1);
			frame.add(kont2);
			frame.add(kont3);

			GUIGrammar1 over = new GUIGrammar1(null, buttonEnd, null, null, frame, null,
					null, null, null);
			buttonEnd.addActionListener(over);
			List wywolanie1 = new List(wersja, str4, labelFirstS, frame, napisy1);
			List wywolanie2 = new List(wersja, str4, labelFirstA, frame, napisy2);
			List wywolanie3 = new List(wersja, str4, labelFirstB, frame, napisy3);
			List wywolanie4 = new List(wersja, str4, labelFirstC, frame, napisy4);
			List wywolanie5 = new List(wersja, str4, LabelFollowS, frame, napisy5);
			List wywolanie6 = new List(wersja, str4, labelFollowA, frame, napisy6);
			List wywolanie7 = new List(wersja, str4, labelFollowB, frame, napisy7);
			List wywolanie8 = new List(wersja, str4, labelFollowC, frame, napisy8);
			frame.setSize(575, 600);
			frame.setVisible(true);
		}
		
		if (wersja == 7) {
			pannel1 = new Panel();
			pannel2 = new Panel();
			pannel3 = new Panel();
			kont1 = new Container();
			kont1.setLayout(new GridLayout(1, 1));
			kont2 = new Container();
			kont2.setLayout(new GridLayout(1, 2));
			kont3 = new Container();
			kont3.setLayout(new GridLayout(1, 2));
			polecenie = new Label(
					"Please find first and follow symbols for the given grammar");
			corobic = new Label("Enter Comments Answer");
			puste = new Label(
					"                                                  ");
			czcionka = new Font("Dialog", Font.BOLD, 12);

			labelFirstS = new Label("First(S)");
			labelFirstA = new Label("First(A)");
			labelFirstB = new Label("First(B)");
			labelFirstC = new Label("First(C)");
			LabelFollowS = new Label("First(D)");
			labelFollowA = new Label("First(E)");
			labelFollowB = new Label("Follow(S)");
			labelFollowC = new Label("Follow(A)");
			napis9 = new Label("Follow(B)");
			napis10 = new Label("Follow(C)");
			napis11 = new Label("Follow(D)");
			napis12 = new Label("Follow(E)");
			str4 = new StringBuffer(128);
			buttonEnd = new Button("Exit");
			
			buttonEnd.setForeground(Color.blue);
			buttonNext = new Button("Next");
			buttonNext.setForeground(Color.blue);

			String napisy1[] = { "-", "x", "y", "(", "while", "z" };
			String napisy2[] = { "-", "x", "y", "(", "while", "z" };
			String napisy3[] = { "-", "x", "y", "(", "z" };
			String napisy4[] = { "-", "x", "y", "(", "z" };
			String napisy5[] = { "sp", "x", "y", "(", "-", "begin", "z" };
			String napisy6[] = { "sp", "x", "y", "(", "-", "z" };
			String napisy7[] = { "zp" };
			String napisy8[] = { "do" };
			String napisy9[] = { "*", "do", ")", ";" };
			String napisy10[] = { "*", "do", ")", ";", ":=" };
			String napisy11[] = { "do" };
			String napisy12[] = { "do", "end" };
			frame = new Frame("Grammar 3");
			Dane = new TextArea("Given grammer\n" + "S::=A\n"
					+ "A::=B|while A do D\n" + "B::=C|B*C\n"
					+ "C::=y|z|-C|(B)\n" + "D::=E|begin E end\n"
					+ "E::={C:=B;}\n", 10, 15);
			frame.setFont(czcionka);
			frame.setLayout(new FlowLayout());
			pannel1.add(polecenie);
			pannel2.add(Dane);
			pannel2.add(buttonEnd);
			pannel3.add(puste);
			pannel3.add(corobic);
			kont1.add(pannel1);
			kont2.add(pannel2);
			kont3.add(pannel3, BorderLayout.SOUTH);
			frame.add(kont1);
			frame.add(kont2);
			frame.add(kont3);

			GUIGrammar1 over = new GUIGrammar1(null, buttonEnd, null, null, frame, null,
					null, null, null);
			buttonEnd.addActionListener(over);
			List wywolanie1 = new List(wersja, str4, labelFirstS, frame, napisy1);
			List wywolanie2 = new List(wersja, str4, labelFirstA, frame, napisy2);
			List wywolanie3 = new List(wersja, str4, labelFirstB, frame, napisy3);
			List wywolanie4 = new List(wersja, str4, labelFirstC, frame, napisy4);
			List wywolanie5 = new List(wersja, str4, LabelFollowS, frame, napisy5);
			List wywolanie6 = new List(wersja, str4, labelFollowA, frame, napisy6);
			List wywolanie7 = new List(wersja, str4, labelFollowB, frame, napisy7);
			List wywolanie8 = new List(wersja, str4, labelFollowC, frame, napisy8);
			List wywolanie9 = new List(wersja, str4, napis9, frame, napisy9);
			List wywolanie10 = new List(wersja, str4, napis10, frame,
					napisy10);
			List wywolanie11 = new List(wersja, str4, napis11, frame,
					napisy11);
			List wywolanie12 = new List(wersja, str4, napis12, frame,
					napisy12);
			frame.setSize(575, 700);
			frame.setVisible(true);
		}
		

	}

}
