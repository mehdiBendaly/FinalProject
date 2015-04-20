

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//This class allows the elimination of spaces, deducts the correct answer if you already
//is the number that equals the size of the array
//this will disable the keys are
//re-enter the same results with no possibility of doubling the counter
//because they are entered for some special string array

public class Service implements ActionListener {

	Button logOut, clear, next_c, next_c1, wersja1;
	Frame window;
	StringBuffer stringBuffer1;
	StringBuffer stringBuffer2;
	StringBuffer stringBuffer3;
	StringBuffer stringBuffer4;
	StringBuffer str5;
	StringBuffer str6;
	TextField textField1, textField2;
	TextField textField3;
	String array[];

	String odp, odp1, odp2, odp3, odp4, odp5, odp6, odp7;
	int a_c;
	int version, sprawdz;

	Service(int version_s, int a, Button logOut_s, Button clear_s,
			Frame window_s, StringBuffer stringBuffer1_s,
			StringBuffer stringBuffer2_s, StringBuffer stringBuffer3_s,
			StringBuffer stringBuffer4_s, TextField textField1_s,
			TextField textField2_s, TextField textField3_s, String array_s[]) {
		clear = clear_s;
		version = version_s;
		window = window_s;
		stringBuffer1 = stringBuffer1_s;
		stringBuffer2 = stringBuffer2_s;
		stringBuffer3 = stringBuffer3_s;
		stringBuffer4 = stringBuffer4_s;
		logOut = logOut_s;
		array = array_s;
		textField1 = textField1_s;
		textField2 = textField2_s;
		textField3 = textField3_s;
		odp = new String();
		odp1 = new String();
		odp2 = new String();
		odp3 = new String();
		odp4 = new String();
		odp5 = new String();
		odp6 = new String();
		odp7 = new String();
		str5 = new StringBuffer(128);
		str6 = new StringBuffer(128);
		next_c = new Button("Next");
		next_c1 = new Button("Everything was executed correctly");
		wersja1 = new Button("Next");// go to next window
		sprawdz = 6;
		a_c = a;

	}

	public void actionPerformed(ActionEvent evt) {
		// on button clear click
		if (evt.getSource().equals(clear)) {
			// blank all textfields

			textField1.setText(" ");
			textField2.setText(" ");
			stringBuffer1.delete(0, 127);
			stringBuffer2.delete(0, 127);
			logOut.enable(true);

		}
		// window 1
		if (version == 1 || version == 3 || version == 4 || version == 6
				|| version == 7 || version == 9) {

			if (evt.getSource().equals(logOut)) {
				// pobieranie z textFiled tekstu i dodanie go do str1_c
				// StringBuffer
				stringBuffer1.append(textField1.getText());
				// przelecenie przez po wszytkich znakach
				for (int j = 0; j < stringBuffer1.length(); j++) {
					// jesli napotka spacje to ja likwiduje i dodaje do
					// StringBuffera str2_c
					// zrzuca to do stringa odp
					if (stringBuffer1.charAt(j) != ' ') {
						stringBuffer2.append(stringBuffer1.charAt(j));
						odp = stringBuffer2.toString();
						logOut.disable();
					}

				} // wypisanie wpisu w textfiled ale juz po likwidacji sapcji
				System.out.println(stringBuffer2);
				for (int t = 0; t < array.length; t++)// przeszukiwanie
														// tablicy
				{
					if (odp != "koval")// jesli rozne to wpisz do 2 pola nic
					{
						textField2.setText("Error");
						textField2.setForeground(Color.red);

					}

					if (odp.equals(array[t]))// jesli jest lelemnet taki w
												// tablicy
					{
						a_c++;
						if (a_c == 1 && a_c == array.length) {
							System.out.println(array.length);
							System.out.println(a_c);
							textField2.setText("End");
							stringBuffer3.append(odp);
							odp = stringBuffer3.toString();// zapisuje nam
															// odpowiedzi
							// poprawne
							textField3.setText("{" + " " + odp + " " + "}");
							logOut.disable();// wylacza klawisze
							clear.disable();
							logOut.setBackground(Color.LIGHT_GRAY);
							clear.setBackground(Color.LIGHT_GRAY);
							stringBuffer4.append("~");// dodaje falke zeby
														// oznaczyc ze
							// juz jest jeden koniec
							odp2 = stringBuffer4.toString();
							System.out.println(odp2);
						}
						System.out.println(a_c);// wypisuje ile wynosi a_c
						System.out.println(array.length);// wymiar tablicy
						array[t] = "koval";
						// tutaj wypisuje odp+, co daje nam podpowiedz ze
						// jeszcze nie wszytsko
						if (a_c != array.length) {
							stringBuffer3.append(odp + ",");// dodaje do
															// dpowiedzi
							// wpisanej ,
							odp6 = stringBuffer3.toString();// do odp6 zrzucamy
															// to co
							// jest w stringbufferze
							System.out.println("odp6_1=" + odp6);
							// wpisuje dobrze i dodaje nam ,

							textField2.setText("Correct");
							textField2.setForeground(Color.green);
							textField3.setText("{" + odp6 + "}");
							System.out.println("Dopisal odp+,");

						}
						// str3_c.append(odp5+"|");
						// odp6=str3_c.toString();
						// System.out.println("Odp6="+odp6);
						if (a_c == array.length && a_c != 1)// gdy odpowiedzi
															// sie juz sa
															// wszytkie to
						{
							System.out.println("Wszedl Tutaj poraz" + a_c);
							textField2.setText("End");// ustwia tekst over w
														// okienku
							logOut.disable();// wylacza klawisze
							clear.disable();
							logOut.setBackground(Color.LIGHT_GRAY);
							clear.setBackground(Color.LIGHT_GRAY);
							// tutaj tak jak wyzej zrzucenie str3 do odp potem
							// do str6 zapamietanie dobrych
							// odp i do odp6 wynik w postci stringa tytlko tutaj
							// jest roznica bo jesli juz sa wszytkie to oststnia
							// odp6 jest bez ,

							stringBuffer3.append(odp);
							odp6 = stringBuffer3.toString();
							System.out.println("odp6_2=" + odp6);
							str6.append(odp6);

							textField3.setText("{" + odp6 + "}");

							stringBuffer4.append("~");
							odp2 = stringBuffer4.toString();

							// odp=Ta2_c.getText();
							// System.out.println(odp);

							if (version == 1 || version == 4) {
								for (int i = 0; i < stringBuffer4.length(); i++) {
									if (odp2.equals("~~~~~~~~")) {
									}
								}
							}
							if (version == 3 || version == 9) {
								for (int i = 0; i < stringBuffer4.length(); i++) {
									if (odp2.equals("~~~~~~~~~~~~~~")) {

									}
								}
							}
							if (version == 6 || version == 7) {
								for (int i = 0; i < stringBuffer4.length(); i++) {
									if (odp2.equals("~~~~~~~~~~~~")) {

									}
								}
							}
							System.out.println("odp2=" + stringBuffer4);
						}
						break;
					}

					if (odp != "koval") {
						textField2.setText("Error");
					}

				}
				if (version == 1) {
					if (odp2.equals("~~~~~~~~")) {
						next_c.setBackground(Color.green);
						window.setLayout(new BorderLayout());
						window.add(next_c, BorderLayout.SOUTH);
						window.setVisible(true);
						GUIGrammar1 next1 = new GUIGrammar1(null, null, next_c,
								null, window, null, null, null, null);
						next_c.addActionListener(next1);

					}
				}

				if (version == 4) {
					if (odp2.equals("~~~~~~~~")) {
						next_c.setBackground(Color.green);
						window.setLayout(new BorderLayout());
						window.add(next_c, BorderLayout.SOUTH);
						window.setVisible(true);
						GUIGrammar2 next1 = new GUIGrammar2(null, null, next_c,
								null, window, null, null, null, null);
						next_c.addActionListener(next1);

					}
				}
				if (version == 7) {
					if (odp2.equals("~~~~~~~~~~~~")) {
						next_c.setBackground(Color.green);
						window.setLayout(new BorderLayout());
						window.add(next_c, BorderLayout.SOUTH);
						window.setVisible(true);
						GUIGrammar3 next1 = new GUIGrammar3(null, null, next_c,
								null, window, null, null, null, null, null,
								null);
						next_c.addActionListener(next1);

					}
				}

			}

		}

	}
}
