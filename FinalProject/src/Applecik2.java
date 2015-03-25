import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.String;
import java.lang.Comparable;
import java.lang.*;

class Listwa {
	int a = 0;
	Panel p1;
	Label napis_c;
	Button bt2, bt3;
	Container kontener;
	TextField Ta1, Ta2;
	TextField La;
	Frame Okno1_c;
	StringBuffer str1, str2, str3, str4_c;
	String[] tablica_c;

	Listwa(int wersja, StringBuffer str4, Label napis, Frame Okno1,
			String tablica[]) {
		// corobic = new
		// Label("                                                Enter     Score   ");
		napis_c = napis;
		tablica_c = tablica;
		str1 = new StringBuffer(128);
		str2 = new StringBuffer(128);
		str3 = new StringBuffer(128);
		str4_c = str4;
		Okno1_c = Okno1;
		p1 = new Panel();
		kontener = new Container();
		kontener.setLayout(new BorderLayout());
		bt2 = new Button("Check");
		bt2.setBackground(Color.PINK);
		bt2.setForeground(Color.white);
		bt3 = new Button("Clear");
		bt3.setBackground(Color.BLUE);
		bt3.setForeground(Color.white);
		Ta1 = new TextField(1);
		Ta2 = new TextField(1);
		La = new TextField(20);

		// Okno1_c.add(corobic);
		p1.setLayout(new GridLayout(1, 5));
		p1.add(napis_c);
		p1.add(bt2);
		p1.add(bt3);
		p1.add(Ta1);
		p1.add(Ta2);
		// p1.add(La);
		kontener.add(p1);
		Okno1_c.add(kontener);
		Okno1_c.add(La);
		obsluga btaction = new obsluga(wersja, a, bt2, bt3, Okno1_c, str1,
				str2, str3, str4_c, Ta1, Ta2, La, tablica_c);
		bt2.addActionListener(btaction);
		bt3.addActionListener(btaction);
	}
}

public class Applecik2 extends Applet { // ** deklaracje zmiennych
	Panel p1;// tworze glowne okno z wyborem i tekstem
	Choice gramatyka;
	String Wybor;
	Button Help;

	public void init() {

		Panel p1 = new Panel(new FlowLayout());// tutaj glowne zarzdzanie label
												// i wybor gramatyki
		Wybor = new String(" Choose the grammar you want to solve ");
		gramatyka = new Choice();// wybor
		Help = new Button("Help");

		gramatyka.addItem("Grammar1");
		gramatyka.addItem("Grammar2");
		gramatyka.addItem("Grammar3");

		p1.add(new Label(Wybor, Label.CENTER));// dodanie tekstu Wybierz
												// Gramatyke...

		p1.add(gramatyka);
		p1.add(Help);
		add(p1);

		p1.validate();

	}// obsluga zdarzen w zaleznosci od tego co wybierzemy z choice

	public boolean action(Event ev, Object o) {
		if (ev.target instanceof Button) {
			if (o == "Help") {
				Frame Okno = new Frame("Help");
				Okno.setLayout(new FlowLayout());
				Button zakoncz;
				zakoncz = new Button("End");
				Font napisglowny = new Font("Symbol", Font.BOLD, 12);
				Font okreslenie = new Font("TimesRoman", Font.ITALIC, 12);
				Label napisglownylabel, okreslenielabel, okreslenielabel1, okreslenielabel2, okreslenielabel3, okreslenielabel4;
				napisglownylabel = new Label("Instruction:");
				napisglownylabel.setFont(napisglowny);
				okreslenielabel = new Label(
						"the answer is assessed (ERROR or CORRECT),");
				okreslenielabel1 = new Label(
						"we keep entering it until we get the word end");
				okreslenielabel2 = new Label("We marked an empty set as -zp.");
				okreslenielabel3 = new Label(
						"We marked an empty symbol as- sp.");
				okreslenielabel4 = new Label(
						"Author: Lukasz Kowalski (c) 2004        ");
				okreslenielabel.setFont(okreslenie);
				okreslenielabel1.setFont(okreslenie);
				okreslenielabel2.setFont(okreslenie);
				okreslenielabel3.setFont(okreslenie);
				okreslenielabel4.setFont(okreslenie);
				Okno.add(napisglownylabel);
				Okno.add(okreslenielabel);
				Okno.add(okreslenielabel1);
				Okno.add(okreslenielabel2);
				Okno.add(okreslenielabel3);
				Okno.add(okreslenielabel4);
				Okno.add(zakoncz);
				dodatki akcja = new dodatki(null, zakoncz, null, null, Okno,
						null, null, null, null);
				zakoncz.addActionListener(akcja);

				Okno.setSize(500, 200);
				Okno.setVisible(true);
			}

		}
		if (ev.target instanceof Choice)// akcja podjeta na wybor gramatyka1
		{
			int wersja = 1;

			if (o == "Grammar1") {
				Wyglad koval = new Wyglad(wersja);
			}
			if (o == "Grammar2") {
				int wersja1 = 4;
				Wyglad nowy = new Wyglad(wersja1);
			}
			if (o == "Grammar3") {
				int wersja2 = 7;
				Wyglad koval3 = new Wyglad(wersja2);
			}

		}

		return true;
	}
}

// ta klasa umozliwia likwidacje spacji,odlicza poprawne odpowiedzi jesli juz
// jest rowna liczba co rozmiar tablicy
// to powoduje ze klawisze sa disable
// ponowne wpisanie tego samego powoduje ze nie ma mozliwosc podwojenia licznika
// bo sa wpisywane w miesjse tablicy jakis specyficzny string

class obsluga implements ActionListener {

	Button wypisz_c, czysc_c, next_c, next_c1, wersja1;
	Frame Okno1_c;
	StringBuffer str1_c;
	StringBuffer str2_c;
	StringBuffer str3_c;
	StringBuffer str4;
	StringBuffer str5;
	StringBuffer str6;
	TextField Ta1_c, Ta2_c;
	TextField La_c;
	String tablica2[];

	String odp, odp1, odp2, odp3, odp4, odp5, odp6, odp7;
	int a_c;
	int wersja_c, sprawdz;

	obsluga(int wersja, int a, Button wypisz, Button czysc, Frame Okno1,
			StringBuffer str1, StringBuffer str2, StringBuffer str3,
			StringBuffer str4_c, TextField Ta1, TextField Ta2, TextField La,
			String tablica[]) {
		czysc_c = czysc;
		// zakoncz_c=zakoncz;
		wersja_c = wersja;
		Okno1_c = Okno1;
		str1_c = str1;
		str2_c = str2;
		str3_c = str3;
		str4 = str4_c;
		wypisz_c = wypisz;
		tablica2 = tablica;
		Ta1_c = Ta1;
		Ta2_c = Ta2;
		La_c = La;
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
		wersja1 = new Button("Next");// potrezbne do ostatniego okno
		sprawdz = 6;
		a_c = a;

	}

	public void actionPerformed(ActionEvent evt) {
		// akcja wykonywana na przycisk czysc
		if (evt.getSource().equals(czysc_c)) {
			// czyszczenie textfieldow
			// czyszczenie stringbufferow

			Ta1_c.setText(" ");
			Ta2_c.setText(" ");
			str1_c.delete(0, 127);
			str2_c.delete(0, 127);
			wypisz_c.enable(true);

		}
		// dla 1 okno
		if (wersja_c == 1 || wersja_c == 3 || wersja_c == 4 || wersja_c == 6
				|| wersja_c == 7 || wersja_c == 9) {

			if (evt.getSource().equals(wypisz_c)) {
				// pobieranie z textFiled tekstu i dodanie go do str1_c
				// StringBuffer
				str1_c.append(Ta1_c.getText());
				// przelecenie przez po wszytkich znakach
				for (int j = 0; j < str1_c.length(); j++) {
					// jesli napotka spacje to ja likwiduje i dodaje do
					// StringBuffera str2_c
					// zrzuca to do stringa odp
					if (str1_c.charAt(j) != ' ') {
						str2_c.append(str1_c.charAt(j));
						odp = str2_c.toString();
						wypisz_c.disable();
					}

				} // wypisanie wpisu w textfiled ale juz po likwidacji sapcji
				System.out.println(str2_c);
				for (int t = 0; t < tablica2.length; t++)// przeszukiwanie
															// tablicy
				{
					if (odp != "koval")// jesli rozne to wpisz do 2 pola nic
					{
						Ta2_c.setText("Error");

					}

					if (odp.equals(tablica2[t]))// jesli jest lelemnet taki w
												// tablicy
					{
						a_c++;
						if (a_c == 1 && a_c == tablica2.length) {
							// Ta2_c.setText("OK");
							System.out.println(tablica2.length);
							System.out.println(a_c);
							Ta2_c.setText("End");
							str3_c.append(odp);
							odp = str3_c.toString();// zapisuje nam odpowiedzi
													// poprawne
							La_c.setText("{" + " " + odp + " " + "}");
							wypisz_c.disable();// wylacza klawisze
							czysc_c.disable();
							wypisz_c.setBackground(Color.LIGHT_GRAY);
							czysc_c.setBackground(Color.LIGHT_GRAY);
							str4.append("~");// dodaje falke zeby oznaczyc ze
												// juz jest jeden koniec
							odp2 = str4.toString();
							System.out.println(odp2);
						}
						System.out.println(a_c);// wypisuje ile wynosi a_c
						System.out.println(tablica2.length);// wymiar tablicy
						tablica2[t] = "koval";
						// tutaj wypisuje odp+, co daje nam podpowiedz ze
						// jeszcze nie wszytsko
						if (a_c != tablica2.length) {
							str3_c.append(odp + ",");// dodaje do dpowiedzi
														// wpisanej ,
							odp6 = str3_c.toString();// do odp6 zrzucamy to co
														// jest w stringbufferze
							System.out.println("odp6_1=" + odp6);
							// wpisuje dobrze i dodaje nam ,

							Ta2_c.setText("Correct");
							La_c.setText("{" + odp6 + "}");
							System.out.println("Dopisal odp+,");

						}
						// str3_c.append(odp5+"|");
						// odp6=str3_c.toString();
						// System.out.println("Odp6="+odp6);
						if (a_c == tablica2.length && a_c != 1)// gdy odpowiedzi
																// sie juz sa
																// wszytkie to
						{
							System.out.println("Wszedl Tutaj poraz" + a_c);
							Ta2_c.setText("End");// ustwia tekst over w okienku
							wypisz_c.disable();// wylacza klawisze
							czysc_c.disable();
							wypisz_c.setBackground(Color.LIGHT_GRAY);
							czysc_c.setBackground(Color.LIGHT_GRAY);
							// tutaj tak jak wyzej zrzucenie str3 do odp potem
							// do str6 zapamietanie dobrych
							// odp i do odp6 wynik w postci stringa tytlko tutaj
							// jest roznica bo jesli juz sa wszytkie to oststnia
							// odp6 jest bez ,

							str3_c.append(odp);
							odp6 = str3_c.toString();
							System.out.println("odp6_2=" + odp6);
							str6.append(odp6);

							La_c.setText("{" + odp6 + "}");

							str4.append("~");
							odp2 = str4.toString();

							// odp=Ta2_c.getText();
							// System.out.println(odp);

							if (wersja_c == 1 || wersja_c == 4) {
								for (int i = 0; i < str4.length(); i++) {
									if (odp2.equals("~~~~~~~~")) {
									}
								}
							}
							if (wersja_c == 3 || wersja_c == 9) {
								for (int i = 0; i < str4.length(); i++) {
									if (odp2.equals("~~~~~~~~~~~~~~")) {

									}
								}
							}
							if (wersja_c == 6 || wersja_c == 7) {
								for (int i = 0; i < str4.length(); i++) {
									if (odp2.equals("~~~~~~~~~~~~")) {

									}
								}
							}
							System.out.println("odp2=" + str4);
						}
						break;
					}

					if (odp != "koval") {
						Ta2_c.setText("Error");
					}

				}
				if (wersja_c == 1) {
					if (odp2.equals("~~~~~~~~")) {
						next_c.setBackground(Color.green);
						Okno1_c.setLayout(new BorderLayout());
						Okno1_c.add(next_c, BorderLayout.SOUTH);
						Okno1_c.setVisible(true);
						dodatki next1 = new dodatki(null, null, next_c, null,
								Okno1_c, null, null, null, null);
						next_c.addActionListener(next1);

					}
				}

				if (wersja_c == 4) {
					if (odp2.equals("~~~~~~~~")) {
						next_c.setBackground(Color.green);
						Okno1_c.setLayout(new BorderLayout());
						Okno1_c.add(next_c, BorderLayout.SOUTH);
						Okno1_c.setVisible(true);
						dodatki2 next1 = new dodatki2(null, null, next_c, null,
								Okno1_c, null, null, null, null);
						next_c.addActionListener(next1);

					}
				}
				if (wersja_c == 7) {
					if (odp2.equals("~~~~~~~~~~~~")) {
						next_c.setBackground(Color.green);
						Okno1_c.setLayout(new BorderLayout());
						Okno1_c.add(next_c, BorderLayout.SOUTH);
						Okno1_c.setVisible(true);
						dodatki3 next1 = new dodatki3(null, null, next_c, null,
								Okno1_c, null, null, null, null, null, null);
						next_c.addActionListener(next1);

					}
				}

				if (wersja_c == 3) {
					if (odp2.equals("~~~~~~~~~~~~~~")) {
						next_c1.setBackground(Color.green);
						Okno1_c.setLayout(new BorderLayout());
						Okno1_c.add(next_c1, BorderLayout.SOUTH);
						Okno1_c.setVisible(true);
						dodatki next1 = new dodatki(null, next_c1, null, null,
								Okno1_c, null, null, null, null);
						;
						next_c1.addActionListener(next1);

					}
				}
				if (wersja_c == 9) {
					if (odp2.equals("~~~~~~~~~~~~~~")) {
						next_c1.setBackground(Color.green);
						Okno1_c.setLayout(new BorderLayout());
						Okno1_c.add(next_c1, BorderLayout.SOUTH);
						Okno1_c.setVisible(true);
						dodatki3 next1 = new dodatki3(null, next_c1, null,
								null, Okno1_c, null, null, null, null, null,
								null);
						next_c1.addActionListener(next1);

					}
				}
				if (wersja_c == 6) {
					if (odp2.equals("~~~~~~~~~~~~")) {
						next_c1.setBackground(Color.green);
						Okno1_c.setLayout(new BorderLayout());
						Okno1_c.add(next_c1, BorderLayout.SOUTH);
						Okno1_c.setVisible(true);
						dodatki next1 = new dodatki(null, next_c1, null, null,
								Okno1_c, null, null, null, null);
						;
						next_c1.addActionListener(next1);

					}
				}

			}

		}

		if (wersja_c == 2 || wersja_c == 5 || wersja_c == 8) {
			if (evt.getSource().equals(wypisz_c)) {
				str1_c.append(Ta1_c.getText());
				for (int j = 0; j < str1_c.length(); j++) {
					if (str1_c.charAt(j) != ' ') {
						str2_c.append(str1_c.charAt(j));
						wypisz_c.disable();
					}

				}
				str2_c.append("|");
				odp3 = str2_c.toString();
				System.out.println("odp3=" + odp3);

				for (int k = 0; k < str2_c.length(); k++) {
					str5.append(str2_c.charAt(k));
					odp5 = str5.toString();

					if (str2_c.charAt(k) == '|') {
						odp4 = str5.toString();
						System.out.println("odp4=" + odp4);
						odp5 = odp4.replace('|', ' ');
						System.out.println("odp5=" + odp5);
						for (int t = 0; t < tablica2.length; t++) {

							if (odp5 != "koval") {
								Ta2_c.setText("Error");

							}

							if (odp5.equals(tablica2[t])) {
								a_c++;
								if (a_c == 1 && a_c == tablica2.length) {
									// Ta2_c.setText("OK");
									System.out.println(tablica2.length);
									System.out.println(a_c);
									Ta2_c.setText("End");
									str3_c.append(odp5);
									odp1 = str3_c.toString();// zapisuje nam
																// odpowiedzi
																// poprawne
									La_c.setText(odp1);
									wypisz_c.disable();// wylacza klawisze
									czysc_c.disable();
									wypisz_c.setBackground(Color.LIGHT_GRAY);
									czysc_c.setBackground(Color.LIGHT_GRAY);
									str4.append("~");
									odp2 = str4.toString();
									System.out.println(odp2);

								}
								System.out.println(a_c);// wypisuje ile wynosi
														// a_c
								System.out.println(tablica2.length);// wymiar
																	// tablicy
								tablica2[t] = "koval";// wpisuje koval zeby
														// wykasowac tamten
														// rekord
								if (a_c != tablica2.length) {
									str3_c.append(odp5 + "|");// dodaje do
																// dpowiedzi
																// wpisanej |
									odp6 = str3_c.toString();// do odp6 zrzucamy
																// to co jest w
																// stringbufferze
									System.out.println("odp6_1=" + odp6);
									str6.append(odp6);// nowy string buffer
														// czysty zapisujemy mu
														// odpowiedz ze
														// strinbuffera str3
									// jest to po to bo str3 za kazdym
									// nacisnieciem czysc jest czyszczony wiec
									// zapamietujemy wszystkie dobre odp
									// w stringbuferze str6 i zrzucamy go do
									// odp7 i wypisujemy z | jesli jeszcze
									// niekompletna jest odp
									odp7 = str6.toString();

									// System.out.println("Odp6="+odp6);
									Ta2_c.setText("Correct");
									La_c.setText(odp7);
									System.out.println("Dopisal odp5+|");
									System.out.println("odp7_1=" + odp7);
								}

								if (a_c == tablica2.length && a_c != 1)// gdy
																		// odpowiedzi
																		// sie
																		// juz
																		// sa
																		// wszytkie
																		// to
								{
									System.out.println("Wszedl Tutaj poraz"
											+ a_c);
									Ta2_c.setText("End");// ustwia tekst over w
															// okienku
									wypisz_c.disable();// wylacza klawisze
									czysc_c.disable();
									wypisz_c.setBackground(Color.LIGHT_GRAY);
									czysc_c.setBackground(Color.LIGHT_GRAY);
									// tutaj tak jak wyzej zrzucenie str3 do
									// odp6 potem do str6 zapamietanie dobrych
									// odp i do odp7 wynik w postci stringa
									// tytlko tutaj jest roznica bo jesli juz sa
									// wszytkie to oststnia odp6 jest bez |

									str3_c.append(odp5);
									odp6 = str3_c.toString();
									System.out.println("odp6_2=" + odp6);
									str6.append(odp6);

									System.out.println("odp7_2=" + odp7);
									La_c.setText(odp6);

									str4.append("~");
									odp2 = str4.toString();
									if (wersja_c == 2) {
										for (int i = 0; i < str4.length(); i++) {

											if (odp2.equals("~~~~~~")) {

											}
										}

									}
									if (wersja_c == 5) {
										for (int i = 0; i < str4.length(); i++) {

											if (odp2.equals("~~~~")) {

											}
										}

									}
									if (wersja_c == 8) {
										for (int i = 0; i < str4.length(); i++) {

											if (odp2.equals("~~")) {

											}
										}

									}

									System.out.println("odp2=" + str4);
								}
								break;
							}

							if (odp5 != "koval") {
								Ta2_c.setText("Error");
							}

						}
						if (wersja_c == 2) {
							if (odp2.equals("~~~~~~")) {
								wersja1.setBackground(Color.green);
								Okno1_c.setLayout(new BorderLayout());
								Okno1_c.add(wersja1, BorderLayout.SOUTH);
								Okno1_c.setVisible(true);
								dodatki next11 = new dodatki(wersja1, null,
										null, null, Okno1_c, null, null, null,
										null);
								wersja1.addActionListener(next11);

							}
						}
						if (wersja_c == 5) {
							if (odp2.equals("~~~~")) {
								wersja1.setBackground(Color.green);
								Okno1_c.setLayout(new BorderLayout());
								Okno1_c.add(wersja1, BorderLayout.SOUTH);
								Okno1_c.setVisible(true);
								dodatki2 next11 = new dodatki2(wersja1, null,
										null, null, Okno1_c, null, null, null,
										null);
								wersja1.addActionListener(next11);

							}
						}
						if (wersja_c == 8) {
							if (odp2.equals("~~")) {
								wersja1.setBackground(Color.green);
								Okno1_c.setLayout(new BorderLayout());
								Okno1_c.add(wersja1, BorderLayout.SOUTH);
								Okno1_c.setVisible(true);
								dodatki3 next11 = new dodatki3(wersja1, null,
										null, null, Okno1_c, null, null, null,
										null, null, null);
								wersja1.addActionListener(next11);

							}
						}
						str5.delete(0, 127);

					}

				}
			}
		}

	}
}

// ta klasa sluzy nam do wpisania odpowiedzi sztyno w tablice napisy.. i labele
// rozne napis..
// akcja na zakoncz
// Wypisanie gramatyki w textArea
class Wyglad {

	Frame Okno1;
	Panel pan1, pan2, pan3;
	Label napis1, napis2, napis3, napis4, napis5, napis6, napis7, napis8,
			napis9, napis10, napis11, napis12, napis13, napis14;

	String napisy1[], napisy2[], napisy3[], napisy4[], napisy5[], napisy6[],
			napisy7[], napisy8[];
	Button bt1, bt4;
	TextArea Dane;
	StringBuffer str4;
	Label polecenie, corobic, puste;
	Font czcionka;
	Container kont1, kont2, kont3;

	Wyglad(int wersja) {

		if (wersja == 1) {
			pan1 = new Panel();
			pan2 = new Panel();
			pan3 = new Panel();
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

			napis1 = new Label("First(S)");
			napis2 = new Label("First(A)");
			napis3 = new Label("First(B)");
			napis4 = new Label("First(C)");
			napis5 = new Label("Follow(S)");
			napis6 = new Label("Follow(A)");
			napis7 = new Label("Follow(B)");
			napis8 = new Label("Follow(C)");
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			str4 = new StringBuffer(128);
			bt1 = new Button("End");
			bt1.setBackground(Color.red);
			bt1.setForeground(Color.white);
			bt4 = new Button("Next");
			bt4.setBackground(Color.green);
			bt4.setForeground(Color.white);
			String napisy1[] = { "-" };
			String napisy2[] = { "c", "d", "b" };
			String napisy3[] = { "c", "d", "b" };
			String napisy4[] = { "c", "d" };
			String napisy5[] = { "zp" };
			String napisy6[] = { "*" };
			String napisy7[] = { "*", "+" };
			String napisy8[] = { "*", "+" };
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			Dane = new TextArea("Given grammar\n" + "S::=-A|-a\n"
					+ "A::=B|A*B\n" + "B::=C|B+C|b\n" + "C::=c|d\n", 10, 15);
			Okno1.setFont(czcionka);
			Okno1.setLayout(new FlowLayout());
			Okno1.setBackground(Color.GRAY);
			pan1.add(polecenie);
			pan2.add(Dane);
			pan2.add(bt1);
			pan3.add(puste);
			pan3.add(corobic);
			kont1.add(pan1);
			kont2.add(pan2);
			kont3.add(pan3, BorderLayout.SOUTH);
			Okno1.add(kont1);
			Okno1.add(kont2);
			Okno1.add(kont3);

			dodatki over = new dodatki(null, bt1, null, null, Okno1, null,
					null, null, null);
			bt1.addActionListener(over);
			Listwa wywolanie1 = new Listwa(wersja, str4, napis1, Okno1, napisy1);
			Listwa wywolanie2 = new Listwa(wersja, str4, napis2, Okno1, napisy2);
			Listwa wywolanie3 = new Listwa(wersja, str4, napis3, Okno1, napisy3);
			Listwa wywolanie4 = new Listwa(wersja, str4, napis4, Okno1, napisy4);
			Listwa wywolanie5 = new Listwa(wersja, str4, napis5, Okno1, napisy5);
			Listwa wywolanie6 = new Listwa(wersja, str4, napis6, Okno1, napisy6);
			Listwa wywolanie7 = new Listwa(wersja, str4, napis7, Okno1, napisy7);
			Listwa wywolanie8 = new Listwa(wersja, str4, napis8, Okno1, napisy8);
			Okno1.setSize(575, 600);
			Okno1.setVisible(true);
		}
		if (wersja == 2) {
			pan1 = new Panel();
			pan2 = new Panel();
			pan3 = new Panel();
			kont1 = new Container();
			kont1.setLayout(new GridLayout(1, 1));
			kont2 = new Container();
			kont2.setLayout(new GridLayout(1, 2));
			kont3 = new Container();
			kont3.setLayout(new GridLayout(1, 2));
			polecenie = new Label(
					"Find productions that need to be revised so that they fulfill grammatical rules 1 and 2.");
			corobic = new Label("Enter Comments                     Answer");
			puste = new Label(
					"                                                  ");
			czcionka = new Font("Dialog", Font.BOLD, 12);
			napis1 = new Label("S ::= ");
			napis2 = new Label("S'::= ");
			napis3 = new Label("A ::= ");
			napis4 = new Label("A'::= ");
			napis5 = new Label("B ::= ");
			napis6 = new Label("B'::= ");
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			str4 = new StringBuffer(128);
			bt1 = new Button("End");
			bt1.setBackground(Color.red);
			bt1.setForeground(Color.white);
			bt4 = new Button("Next");// pamietaj przy tych tablicach gdzie sa
										// wzory o SPACJACH!!!!
			bt4.setBackground(Color.green);

			String napisy1[] = { "-S' " };
			String napisy2[] = { "A ", "a " };
			String napisy3[] = { "BA' " };
			String napisy4[] = { "*BA' ", "sp " };
			String napisy5[] = { "CB' ", "bB' " };
			String napisy6[] = { "+CB' ", "sp ", };
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			Dane = new TextArea("Given grammar\n" + "S::=-A|-a\n"
					+ "A::=B|A*B\n" + "B::=C|B+C|b\n" + "C::=c|d\n", 10, 15);
			Okno1.setFont(czcionka);
			Okno1.setLayout(new FlowLayout());
			Okno1.setBackground(Color.GRAY);
			pan1.add(polecenie);
			pan2.add(Dane);
			pan2.add(bt1);
			pan3.add(puste);
			pan3.add(corobic);
			kont1.add(pan1);
			kont2.add(pan2);
			kont3.add(pan3, BorderLayout.SOUTH);
			Okno1.add(kont1);
			Okno1.add(kont2);
			Okno1.add(kont3);
			dodatki over = new dodatki(null, bt1, null, null, Okno1, null,
					null, null, null);
			bt1.addActionListener(over);
			Listwa wywolanie1 = new Listwa(wersja, str4, napis1, Okno1, napisy1);
			Listwa wywolanie2 = new Listwa(wersja, str4, napis2, Okno1, napisy2);
			Listwa wywolanie3 = new Listwa(wersja, str4, napis3, Okno1, napisy3);
			Listwa wywolanie4 = new Listwa(wersja, str4, napis4, Okno1, napisy4);
			Listwa wywolanie5 = new Listwa(wersja, str4, napis5, Okno1, napisy5);
			Listwa wywolanie6 = new Listwa(wersja, str4, napis6, Okno1, napisy6);
			Okno1.setSize(550, 500);
			Okno1.setVisible(true);
		}
		if (wersja == 3) {
			pan1 = new Panel();
			pan2 = new Panel();
			pan3 = new Panel();
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
			napis1 = new Label("First(S)");
			napis2 = new Label("First(S')");
			napis3 = new Label("First(A)");
			napis4 = new Label("First(A')");
			napis5 = new Label("First(B)");
			napis6 = new Label("First(B')");
			napis7 = new Label("First(C)");
			napis8 = new Label("Follow(S)");
			napis9 = new Label("Follow(S')");
			napis10 = new Label("Follow(A)");
			napis11 = new Label("Follow(A')");
			napis12 = new Label("Follow(B)");
			napis13 = new Label("Follow(B')");
			napis14 = new Label("Follow(C)");
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			str4 = new StringBuffer(128);
			bt1 = new Button("End");
			bt1.setBackground(Color.red);
			bt1.setForeground(Color.white);
			bt4 = new Button("Next");
			bt4.setBackground(Color.green);
			bt4.setForeground(Color.white);
			String napisy1[] = { "-" };
			String napisy2[] = { "c", "d", "b", "a" };
			String napisy3[] = { "c", "d", "b" };
			String napisy4[] = { "*", "sp" };
			String napisy5[] = { "c", "d", "b" };
			String napisy6[] = { "+", "sp" };
			String napisy7[] = { "c", "d" };
			String napisy8[] = { "zp" };
			String napisy9[] = { "zp" };
			String napisy10[] = { "zp" };
			String napisy11[] = { "zp" };
			String napisy12[] = { "*" };
			String napisy13[] = { "*" };
			String napisy14[] = { "+" };

			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			Dane = new TextArea("Revised grammar\n" + "S::=-S'\n"
					+ "S'::=A|a\n" + "A::=BA'\n" + "A'::=*BA'|sp\n"
					+ "B::=CB'|bB'\n" + "B'::=+CB'|sp\n" + "C::=c|d\n", 10, 15);
			Okno1.setFont(czcionka);
			Okno1.setLayout(new FlowLayout());
			Okno1.setBackground(Color.GRAY);
			pan1.add(polecenie);
			pan2.add(Dane);
			pan2.add(bt1);
			pan3.add(puste);
			pan3.add(corobic);
			kont1.add(pan1);
			kont2.add(pan2);
			kont3.add(pan3, BorderLayout.SOUTH);
			Okno1.add(kont1);
			Okno1.add(kont2);
			Okno1.add(kont3);
			dodatki over = new dodatki(null, bt1, null, null, Okno1, null,
					null, null, null);
			bt1.addActionListener(over);
			Listwa wywolanie1 = new Listwa(wersja, str4, napis1, Okno1, napisy1);
			Listwa wywolanie2 = new Listwa(wersja, str4, napis2, Okno1, napisy2);
			Listwa wywolanie3 = new Listwa(wersja, str4, napis3, Okno1, napisy3);
			Listwa wywolanie4 = new Listwa(wersja, str4, napis4, Okno1, napisy4);
			Listwa wywolanie5 = new Listwa(wersja, str4, napis5, Okno1, napisy5);
			Listwa wywolanie6 = new Listwa(wersja, str4, napis6, Okno1, napisy6);
			Listwa wywolanie7 = new Listwa(wersja, str4, napis7, Okno1, napisy7);
			Listwa wywolanie8 = new Listwa(wersja, str4, napis8, Okno1, napisy8);
			Listwa wywolanie9 = new Listwa(wersja, str4, napis9, Okno1, napisy9);
			Listwa wywolanie10 = new Listwa(wersja, str4, napis10, Okno1,
					napisy10);
			Listwa wywolanie11 = new Listwa(wersja, str4, napis11, Okno1,
					napisy11);
			Listwa wywolanie12 = new Listwa(wersja, str4, napis12, Okno1,
					napisy12);
			Listwa wywolanie13 = new Listwa(wersja, str4, napis13, Okno1,
					napisy13);
			Listwa wywolanie14 = new Listwa(wersja, str4, napis14, Okno1,
					napisy14);
			Okno1.setSize(575, 700);
			Okno1.setVisible(true);
		}
		if (wersja == 4) {
			pan1 = new Panel();
			pan2 = new Panel();
			pan3 = new Panel();
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

			napis1 = new Label("First(S)");
			napis2 = new Label("First(A)");
			napis3 = new Label("First(B)");
			napis4 = new Label("First(C)");
			napis5 = new Label("Follow(S)");
			napis6 = new Label("Follow(A)");
			napis7 = new Label("Follow(B)");
			napis8 = new Label("Follow(C)");
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			str4 = new StringBuffer(128);
			bt1 = new Button("End");
			bt1.setBackground(Color.red);
			bt1.setForeground(Color.white);
			bt4 = new Button("Next");
			bt4.setBackground(Color.green);
			bt4.setForeground(Color.white);
			String napisy1[] = { "(" };
			String napisy2[] = { "x" };
			String napisy3[] = { "y", "z", "-" };
			String napisy4[] = { "y", "z", "-" };
			String napisy5[] = { "zp" };
			String napisy6[] = { ")" };
			String napisy7[] = { ")", "+", "*" };
			String napisy8[] = { ")", "*", "+" };
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			Dane = new TextArea("Given grammar \n" + "S::=(A)\n"
					+ "A::=x|x+B\n" + "B::=C|B*C|B+C\n" + "C::=y|z|-C\n", 10,
					15);
			Okno1.setFont(czcionka);
			Okno1.setLayout(new FlowLayout());
			Okno1.setBackground(Color.GRAY);
			pan1.add(polecenie);
			pan2.add(Dane);
			pan2.add(bt1);
			pan3.add(puste);
			pan3.add(corobic);
			kont1.add(pan1);
			kont2.add(pan2);
			kont3.add(pan3, BorderLayout.SOUTH);
			Okno1.add(kont1);
			Okno1.add(kont2);
			Okno1.add(kont3);

			dodatki over = new dodatki(null, bt1, null, null, Okno1, null,
					null, null, null);
			bt1.addActionListener(over);
			Listwa wywolanie1 = new Listwa(wersja, str4, napis1, Okno1, napisy1);
			Listwa wywolanie2 = new Listwa(wersja, str4, napis2, Okno1, napisy2);
			Listwa wywolanie3 = new Listwa(wersja, str4, napis3, Okno1, napisy3);
			Listwa wywolanie4 = new Listwa(wersja, str4, napis4, Okno1, napisy4);
			Listwa wywolanie5 = new Listwa(wersja, str4, napis5, Okno1, napisy5);
			Listwa wywolanie6 = new Listwa(wersja, str4, napis6, Okno1, napisy6);
			Listwa wywolanie7 = new Listwa(wersja, str4, napis7, Okno1, napisy7);
			Listwa wywolanie8 = new Listwa(wersja, str4, napis8, Okno1, napisy8);
			Okno1.setSize(575, 600);
			Okno1.setVisible(true);
		}
		if (wersja == 5) {
			pan1 = new Panel();
			pan2 = new Panel();
			pan3 = new Panel();
			kont1 = new Container();
			kont1.setLayout(new GridLayout(1, 1));
			kont2 = new Container();
			kont2.setLayout(new GridLayout(1, 2));
			kont3 = new Container();
			kont3.setLayout(new GridLayout(1, 2));
			polecenie = new Label(
					"Find productions that need to be revised so that they fulfill grammatical rules 1 and 2. ");
			corobic = new Label("Enter Comments Answer");
			puste = new Label(
					"                                                  ");
			czcionka = new Font("Dialog", Font.BOLD, 12);
			napis1 = new Label("A ::= ");
			napis2 = new Label("A'::= ");
			napis3 = new Label("B ::= ");
			napis4 = new Label("B'::= ");

			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			str4 = new StringBuffer(128);
			bt1 = new Button("End");
			bt1.setBackground(Color.red);
			bt1.setForeground(Color.white);
			bt4 = new Button("Next");// pamietaj przy tych tablicach gdzie sa
										// wzory o SPACJACH!!!!
			bt4.setBackground(Color.green);

			String napisy1[] = { "xA' " };
			String napisy2[] = { "sp ", "+B " };
			String napisy3[] = { "CB' " };
			String napisy4[] = { "*CB' ", "+CB' ", "sp " };

			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			Dane = new TextArea("Given grammar\n" + "S::=(A)\n" + "A::=x|x+B\n"
					+ "B::=C|B*C|B+C\n" + "C::=y|z|-C\n", 10, 15);
			Okno1.setFont(czcionka);
			Okno1.setLayout(new FlowLayout());
			Okno1.setBackground(Color.GRAY);
			pan1.add(polecenie);
			pan2.add(Dane);
			pan2.add(bt1);
			pan3.add(puste);
			pan3.add(corobic);
			kont1.add(pan1);
			kont2.add(pan2);
			kont3.add(pan3, BorderLayout.SOUTH);
			Okno1.add(kont1);
			Okno1.add(kont2);
			Okno1.add(kont3);
			dodatki over = new dodatki(null, bt1, null, null, Okno1, null,
					null, null, null);
			bt1.addActionListener(over);
			Listwa wywolanie1 = new Listwa(wersja, str4, napis1, Okno1, napisy1);
			Listwa wywolanie2 = new Listwa(wersja, str4, napis2, Okno1, napisy2);
			Listwa wywolanie3 = new Listwa(wersja, str4, napis3, Okno1, napisy3);
			Listwa wywolanie4 = new Listwa(wersja, str4, napis4, Okno1, napisy4);

			Okno1.setSize(600, 500);
			Okno1.setVisible(true);
		}
		if (wersja == 6) {
			pan1 = new Panel();
			pan2 = new Panel();
			pan3 = new Panel();
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
			napis1 = new Label("First(S)");
			napis2 = new Label("First(A)");
			napis3 = new Label("First(A')");
			napis4 = new Label("First(B)");
			napis5 = new Label("First(B')");
			napis6 = new Label("First(C)");
			napis7 = new Label("Follow(S)");
			napis8 = new Label("Follow(A)");
			napis9 = new Label("follow(A')");
			napis10 = new Label("Follow(B)");
			napis11 = new Label("Follow(B')");
			napis12 = new Label("Follow(C)");

			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			str4 = new StringBuffer(128);
			bt1 = new Button("End");
			bt1.setBackground(Color.red);
			bt1.setForeground(Color.white);
			bt4 = new Button("Next");
			bt4.setBackground(Color.green);
			bt4.setForeground(Color.white);
			String napisy1[] = { "(" };
			String napisy2[] = { "x" };
			String napisy3[] = { "+", "sp" };
			String napisy4[] = { "-", "z", "y" };
			String napisy5[] = { "+", "*", "sp" };
			String napisy6[] = { "y", "z", "-" };
			String napisy7[] = { "zp" };
			String napisy8[] = { ")" };
			String napisy9[] = { ")" };
			String napisy10[] = { ")" };
			String napisy11[] = { ")" };
			String napisy12[] = { "*", "+" };

			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			Dane = new TextArea("Given grammar\n" + "S::=(A)\n" + "A::=xA'\n"
					+ "A'::=sp|+B\n" + "B::=CB'\n" + "B'::=*CB'|+CB'|sp\n"
					+ "C::=y|z|-C\n", 10, 15);
			Okno1.setFont(czcionka);
			Okno1.setLayout(new FlowLayout());
			Okno1.setBackground(Color.GRAY);
			pan1.add(polecenie);
			pan2.add(Dane);
			pan2.add(bt1);
			pan3.add(puste);
			pan3.add(corobic);
			kont1.add(pan1);
			kont2.add(pan2);
			kont3.add(pan3, BorderLayout.SOUTH);
			Okno1.add(kont1);
			Okno1.add(kont2);
			Okno1.add(kont3);
			dodatki over = new dodatki(null, bt1, null, null, Okno1, null,
					null, null, null);
			bt1.addActionListener(over);
			Listwa wywolanie1 = new Listwa(wersja, str4, napis1, Okno1, napisy1);
			Listwa wywolanie2 = new Listwa(wersja, str4, napis2, Okno1, napisy2);
			Listwa wywolanie3 = new Listwa(wersja, str4, napis3, Okno1, napisy3);
			Listwa wywolanie4 = new Listwa(wersja, str4, napis4, Okno1, napisy4);
			Listwa wywolanie5 = new Listwa(wersja, str4, napis5, Okno1, napisy5);
			Listwa wywolanie6 = new Listwa(wersja, str4, napis6, Okno1, napisy6);
			Listwa wywolanie7 = new Listwa(wersja, str4, napis7, Okno1, napisy7);
			Listwa wywolanie8 = new Listwa(wersja, str4, napis8, Okno1, napisy8);
			Listwa wywolanie9 = new Listwa(wersja, str4, napis9, Okno1, napisy9);
			Listwa wywolanie10 = new Listwa(wersja, str4, napis10, Okno1,
					napisy10);
			Listwa wywolanie11 = new Listwa(wersja, str4, napis11, Okno1,
					napisy11);
			Listwa wywolanie12 = new Listwa(wersja, str4, napis12, Okno1,
					napisy12);

			Okno1.setSize(575, 700);
			Okno1.setVisible(true);
		}
		if (wersja == 7) {
			pan1 = new Panel();
			pan2 = new Panel();
			pan3 = new Panel();
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

			napis1 = new Label("First(S)");
			napis2 = new Label("First(A)");
			napis3 = new Label("First(B)");
			napis4 = new Label("First(C)");
			napis5 = new Label("First(D)");
			napis6 = new Label("First(E)");
			napis7 = new Label("Follow(S)");
			napis8 = new Label("Follow(A)");
			napis9 = new Label("Follow(B)");
			napis10 = new Label("Follow(C)");
			napis11 = new Label("Follow(D)");
			napis12 = new Label("Follow(E)");
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			str4 = new StringBuffer(128);
			bt1 = new Button("End");
			bt1.setBackground(Color.red);
			bt1.setForeground(Color.white);
			bt4 = new Button("Next");
			bt4.setBackground(Color.green);
			bt4.setForeground(Color.white);
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
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			Dane = new TextArea("Given grammer\n" + "S::=A\n"
					+ "A::=B|while A do D\n" + "B::=C|B*C\n"
					+ "C::=y|z|-C|(B)\n" + "D::=E|begin E end\n"
					+ "E::={C:=B;}\n", 10, 15);
			Okno1.setFont(czcionka);
			Okno1.setLayout(new FlowLayout());
			Okno1.setBackground(Color.GRAY);
			pan1.add(polecenie);
			pan2.add(Dane);
			pan2.add(bt1);
			pan3.add(puste);
			pan3.add(corobic);
			kont1.add(pan1);
			kont2.add(pan2);
			kont3.add(pan3, BorderLayout.SOUTH);
			Okno1.add(kont1);
			Okno1.add(kont2);
			Okno1.add(kont3);

			dodatki over = new dodatki(null, bt1, null, null, Okno1, null,
					null, null, null);
			bt1.addActionListener(over);
			Listwa wywolanie1 = new Listwa(wersja, str4, napis1, Okno1, napisy1);
			Listwa wywolanie2 = new Listwa(wersja, str4, napis2, Okno1, napisy2);
			Listwa wywolanie3 = new Listwa(wersja, str4, napis3, Okno1, napisy3);
			Listwa wywolanie4 = new Listwa(wersja, str4, napis4, Okno1, napisy4);
			Listwa wywolanie5 = new Listwa(wersja, str4, napis5, Okno1, napisy5);
			Listwa wywolanie6 = new Listwa(wersja, str4, napis6, Okno1, napisy6);
			Listwa wywolanie7 = new Listwa(wersja, str4, napis7, Okno1, napisy7);
			Listwa wywolanie8 = new Listwa(wersja, str4, napis8, Okno1, napisy8);
			Listwa wywolanie9 = new Listwa(wersja, str4, napis9, Okno1, napisy9);
			Listwa wywolanie10 = new Listwa(wersja, str4, napis10, Okno1,
					napisy10);
			Listwa wywolanie11 = new Listwa(wersja, str4, napis11, Okno1,
					napisy11);
			Listwa wywolanie12 = new Listwa(wersja, str4, napis12, Okno1,
					napisy12);
			Okno1.setSize(575, 700);
			Okno1.setVisible(true);
		}
		if (wersja == 8) {
			pan1 = new Panel();
			pan2 = new Panel();
			pan3 = new Panel();
			kont1 = new Container();
			kont1.setLayout(new GridLayout(1, 1));
			kont2 = new Container();
			kont2.setLayout(new GridLayout(1, 2));
			kont3 = new Container();
			kont3.setLayout(new GridLayout(1, 2));
			polecenie = new Label(
					"Find productions that need to be revised so that they fulfill grammatical rules 1 and 2. ");
			corobic = new Label("Enter Comments Answer");
			puste = new Label(
					"                                                  ");
			czcionka = new Font("Dialog", Font.BOLD, 12);

			napis1 = new Label("B ::= ");
			napis2 = new Label("B'::= ");

			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			str4 = new StringBuffer(128);
			bt1 = new Button("End");
			bt1.setBackground(Color.red);
			bt1.setForeground(Color.white);
			bt4 = new Button("Next");// pamietaj przy tych tablicach gdzie sa
										// wzory o SPACJACH!!!!
			bt4.setBackground(Color.green);

			String napisy1[] = { "CB' " };
			String napisy2[] = { "*CB' ", "sp " };

			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			Dane = new TextArea("Given grammar\n" + "S::=A\n"
					+ "A::=B|while A do D\n" + "B::=C|B*C\n"
					+ "C::=y|z|-C|(B)\n" + "D::=E|begin E end\n"
					+ "E::={C:=B;}\n", 10, 15);
			Okno1.setFont(czcionka);
			Okno1.setLayout(new FlowLayout());
			Okno1.setBackground(Color.GRAY);
			pan1.add(polecenie);
			pan2.add(Dane);
			pan2.add(bt1);
			pan3.add(puste);
			pan3.add(corobic);
			kont1.add(pan1);
			kont2.add(pan2);
			kont3.add(pan3, BorderLayout.SOUTH);
			Okno1.add(kont1);
			Okno1.add(kont2);
			Okno1.add(kont3);
			dodatki over = new dodatki(null, bt1, null, null, Okno1, null,
					null, null, null);
			bt1.addActionListener(over);
			Listwa wywolanie1 = new Listwa(wersja, str4, napis1, Okno1, napisy1);
			Listwa wywolanie2 = new Listwa(wersja, str4, napis2, Okno1, napisy2);

			Okno1.setSize(550, 500);
			Okno1.setVisible(true);
		}
		if (wersja == 9) {
			pan1 = new Panel();
			pan2 = new Panel();
			pan3 = new Panel();
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

			napis1 = new Label("First(S)");
			napis2 = new Label("First(A)");
			napis3 = new Label("First(B)");
			napis4 = new Label("First(B')");
			napis5 = new Label("First(C)");
			napis6 = new Label("First(D)");
			napis7 = new Label("First(E)");
			napis8 = new Label("Follow(S)");
			napis9 = new Label("Follow(A)");
			napis10 = new Label("Follow(B)");
			napis11 = new Label("Follow(B')");
			napis12 = new Label("Follow(C)");
			napis13 = new Label("Follow(D)");
			napis14 = new Label("Follow(E)");
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			str4 = new StringBuffer(128);
			bt1 = new Button("End");
			bt1.setBackground(Color.red);
			bt1.setForeground(Color.white);
			bt4 = new Button("Next");
			bt4.setBackground(Color.green);
			bt4.setForeground(Color.white);
			String napisy1[] = { "-", "x", "y", "(", "while" };
			String napisy2[] = { "-", "x", "y", "(", "while" };
			String napisy3[] = { "-", "x", "y", "(" };
			String napisy4[] = { "*", "sp" };
			String napisy5[] = { "-", "x", "y", "(" };
			String napisy6[] = { "sp", "x", "y", "(", "-", "begin" };
			String napisy7[] = { "sp", "x", "y", "(", "-" };
			String napisy8[] = { "zp" };
			String napisy9[] = { "zp", "do" };
			String napisy10[] = { "do", ")", ";" };
			String napisy11[] = { "do", ")", ";" };
			String napisy12[] = { "*" };
			String napisy13[] = { "do" };
			String napisy14[] = { "do", "end" };
			Okno1 = new Frame("Lukasz Kowalski   (c) 2004");
			Dane = new TextArea("Given grammar\n" + "S::=A\n"
					+ "A::=B|while A do D\n" + "B::=CB'\n" + "B'::=*CB'|sp\n"
					+ "C::=y|z|-C|(B)\n" + "D::=E|begin E end\n"
					+ "E::={C:=B;}\n", 10, 15);
			Okno1.setFont(czcionka);
			Okno1.setLayout(new FlowLayout());
			Okno1.setBackground(Color.GRAY);
			pan1.add(polecenie);
			pan2.add(Dane);
			pan2.add(bt1);
			pan3.add(puste);
			pan3.add(corobic);
			kont1.add(pan1);
			kont2.add(pan2);
			kont3.add(pan3, BorderLayout.SOUTH);
			Okno1.add(kont1);
			Okno1.add(kont2);
			Okno1.add(kont3);

			dodatki over = new dodatki(null, bt1, null, null, Okno1, null,
					null, null, null);
			bt1.addActionListener(over);
			Listwa wywolanie1 = new Listwa(wersja, str4, napis1, Okno1, napisy1);
			Listwa wywolanie2 = new Listwa(wersja, str4, napis2, Okno1, napisy2);
			Listwa wywolanie3 = new Listwa(wersja, str4, napis3, Okno1, napisy3);
			Listwa wywolanie4 = new Listwa(wersja, str4, napis4, Okno1, napisy4);
			Listwa wywolanie5 = new Listwa(wersja, str4, napis5, Okno1, napisy5);
			Listwa wywolanie6 = new Listwa(wersja, str4, napis6, Okno1, napisy6);
			Listwa wywolanie7 = new Listwa(wersja, str4, napis7, Okno1, napisy7);
			Listwa wywolanie8 = new Listwa(wersja, str4, napis8, Okno1, napisy8);
			Listwa wywolanie9 = new Listwa(wersja, str4, napis9, Okno1, napisy9);
			Listwa wywolanie10 = new Listwa(wersja, str4, napis10, Okno1,
					napisy10);
			Listwa wywolanie11 = new Listwa(wersja, str4, napis11, Okno1,
					napisy11);
			Listwa wywolanie12 = new Listwa(wersja, str4, napis12, Okno1,
					napisy12);
			Listwa wywolanie13 = new Listwa(wersja, str4, napis13, Okno1,
					napisy13);
			Listwa wywolanie14 = new Listwa(wersja, str4, napis14, Okno1,
					napisy14);
			Okno1.setSize(575, 870);
			Okno1.setVisible(true);
		}

	}

}// obsluga klawisz zakoncz, zamyka okno

class dodatki2 extends JFrame implements ActionListener {
	JRadioButton pS_c, pA_c, pB_c, pC_c;
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

	dodatki2(Button wersja1, Button zakoncz, Button next, Button sprawdz,
			Frame Okno1, JRadioButton pS, JRadioButton pA, JRadioButton pB,
			JRadioButton pC) {
		pS_c = pS;
		pA_c = pA;
		pB_c = pB;
		pC_c = pC;

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
			Wyglad3 nowy = new Wyglad3();
		}
		if (ev1.getSource().equals(sprawdz_c)) {
			Okno1_c.remove(zle);
			if (pS_c.isSelected() == false && pA_c.isSelected() == true
					&& pB_c.isSelected() == true && pC_c.isSelected() == false) {

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
			int wersja = 5;
			Okno1_c.hide();
			Wyglad nowy = new Wyglad(wersja);
		}
		if (ev1.getSource().equals(wersja1_c))// to oblsuga przycisku dalej z 3
												// okna-poprawa gramatyki
		// do okno koncowego czyli okno gdzie wyznaczamy pier,nast gramatyki
		// popraw.
		{

			int wersja = 6;
			Okno1_c.hide();
			Wyglad nowy3 = new Wyglad(wersja);
		}

	}
}

class dodatki3 extends JFrame implements ActionListener {
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

	dodatki3(Button wersja1, Button zakoncz, Button next, Button sprawdz,
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
			Wyglad4 nowy = new Wyglad4();
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
			Wyglad nowy = new Wyglad(wersja);
		}
		if (ev1.getSource().equals(wersja1_c))// to oblsuga przycisku dalej z 3
												// okna-poprawa gramatyki
		// do okno koncowego czyli okno gdzie wyznaczamy pier,nast gramatyki
		// popraw.
		{

			int wersja = 9;
			Okno1_c.hide();
			Wyglad nowy3 = new Wyglad(wersja);
		}

	}
}

class dodatki extends JFrame implements ActionListener {
	JRadioButton pS_c, pA_c, pB_c, pC_c;
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

	dodatki(Button wersja1, Button zakoncz, Button next, Button sprawdz,
			Frame Okno1, JRadioButton pS, JRadioButton pA, JRadioButton pB,
			JRadioButton pC) {
		pS_c = pS;
		pA_c = pA;
		pB_c = pB;
		pC_c = pC;
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
			Wyglad2 nowy = new Wyglad2();
		}
		if (ev1.getSource().equals(sprawdz_c)) {
			Okno1_c.remove(zle);
			if (pS_c.isSelected() == true && pA_c.isSelected() == true
					&& pB_c.isSelected() == true && pC_c.isSelected() == false) {

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
			int wersja = 2;
			Okno1_c.hide();
			Wyglad nowy = new Wyglad(wersja);
		}
		if (ev1.getSource().equals(wersja1_c))// to oblsuga przycisku dalej z 3
												// okna-poprawa gramatyki
		// do okno koncowego czyli okno gdzie wyznaczamy pier,nast gramatyki
		// popraw.
		{

			int wersja = 3;
			Okno1_c.hide();
			Wyglad nowy3 = new Wyglad(wersja);
		}

	}
}

class Wyglad2 extends JFrame {
	Label polecenie;
	JRadioButton taknie1, taknie2, taknie3, taknie4;
	Button sprawdz, zakoncz;
	Frame Okno2;
	String labele[];
	Label prod;
	Font czcionka;
	Panel pan1, pan2, pan3;
	Container kont1, kont2, kont3;

	Wyglad2() {

		pan1 = new Panel();
		pan2 = new Panel();
		pan3 = new Panel();
		kont1 = new Container();
		kont2 = new Container();
		kont3 = new Container();
		kont1.setLayout(new GridLayout(1, 1));
		kont2.setLayout(new GridLayout(1, 1));
		kont3.setLayout(new GridLayout(1, 6));
		String labele[] = { "      S::=-A|-a ", "  A::=B|A*B      ",
				"B::=C|B+C|b", "  C::=c|d            " };
		polecenie = new Label(
				"Find productions that need to be revised so that they fulfill grammatical rules 1 and 2. ");
		Okno2 = new Frame("Okno2");
		zakoncz = new Button("End");
		sprawdz = new Button("Check");
		taknie1 = new JRadioButton("Production S");
		taknie2 = new JRadioButton("Production A");
		taknie3 = new JRadioButton("Production B");
		taknie4 = new JRadioButton("Production C");
		czcionka = new Font("Dialog", Font.BOLD, 12);
		Okno2.setFont(czcionka);
		Okno2.setLayout(new FlowLayout());
		pan1.add(polecenie);
		kont1.add(pan1);
		Okno2.add(kont1);
		for (int k = 0; k < labele.length; k++) {
			prod = new Label(labele[k]);
			pan2.add(prod);
			kont2.add(pan2);
			Okno2.add(kont2);
		}
		zakoncz.setForeground(Color.white);
		zakoncz.setBackground(Color.red);
		sprawdz.setForeground(Color.white);
		sprawdz.setBackground(Color.pink);
		taknie1.setBackground(Color.GRAY);
		taknie2.setBackground(Color.GRAY);
		taknie3.setBackground(Color.GRAY);
		taknie4.setBackground(Color.GRAY);
		pan3.add(taknie1);
		pan3.add(taknie2);
		pan3.add(taknie3);
		pan3.add(taknie4);
		pan3.add(sprawdz);
		pan3.add(zakoncz);
		kont3.add(pan3);
		Okno2.add(kont3, BorderLayout.SOUTH);
		Okno2.setSize(550, 200);
		Okno2.setBackground(Color.GRAY);
		Okno2.setVisible(true);
		dodatki radio = new dodatki(null, zakoncz, null, sprawdz, Okno2,
				taknie1, taknie2, taknie3, taknie4);
		;
		sprawdz.addActionListener(radio);
		zakoncz.addActionListener(radio);
	}
}

class Wyglad3 extends JFrame {
	Label polecenie;
	JRadioButton taknie1, taknie2, taknie3, taknie4;
	Button sprawdz, zakoncz;
	Frame Okno2;
	String labele[];
	Label prod;
	Font czcionka;
	Panel pan1, pan2, pan3;
	Container kont1, kont2, kont3;

	Wyglad3() {
		pan1 = new Panel();
		pan2 = new Panel();
		pan3 = new Panel();
		kont1 = new Container();
		kont2 = new Container();
		kont3 = new Container();
		kont1.setLayout(new GridLayout(1, 1));
		kont2.setLayout(new GridLayout(1, 1));
		kont3.setLayout(new GridLayout(1, 6));
		String labele[] = { "      S::=(A) ", "  A::=x|x+B      ",
				"B::=C|B*C|B+C", "  C::=y|z|-C            " };
		polecenie = new Label(
				"Find productions that need to be revised so that they fulfill grammatical rules 1 and 2. ");
		Okno2 = new Frame("Okno2");
		zakoncz = new Button("End");
		sprawdz = new Button("Check");
		taknie1 = new JRadioButton("Production S");
		taknie2 = new JRadioButton("Production A");
		taknie3 = new JRadioButton("Production B");
		taknie4 = new JRadioButton("Production C");
		czcionka = new Font("Dialog", Font.BOLD, 12);
		Okno2.setFont(czcionka);
		Okno2.setLayout(new FlowLayout());
		pan1.add(polecenie);
		kont1.add(pan1);
		Okno2.add(kont1);
		for (int k = 0; k < labele.length; k++) {
			prod = new Label(labele[k]);
			pan2.add(prod);
			kont2.add(pan2);
			Okno2.add(kont2);
		}
		zakoncz.setForeground(Color.white);
		zakoncz.setBackground(Color.red);
		sprawdz.setForeground(Color.white);
		sprawdz.setBackground(Color.pink);
		taknie1.setBackground(Color.GRAY);
		taknie2.setBackground(Color.GRAY);
		taknie3.setBackground(Color.GRAY);
		taknie4.setBackground(Color.GRAY);
		pan3.add(taknie1);
		pan3.add(taknie2);
		pan3.add(taknie3);
		pan3.add(taknie4);
		pan3.add(sprawdz);
		pan3.add(zakoncz);
		kont3.add(pan3);
		Okno2.add(kont3, BorderLayout.SOUTH);
		Okno2.setSize(550, 200);
		Okno2.setBackground(Color.GRAY);
		Okno2.setVisible(true);
		dodatki2 radio = new dodatki2(null, zakoncz, null, sprawdz, Okno2,
				taknie1, taknie2, taknie3, taknie4);
		;
		sprawdz.addActionListener(radio);
		zakoncz.addActionListener(radio);
	}
}

class Wyglad4 extends JFrame {
	Label polecenie;
	JRadioButton taknie1, taknie2, taknie3, taknie4, taknie5, taknie6;
	Button sprawdz, zakoncz;
	Frame Okno2;
	String labele[];
	Label prod;
	Font czcionka;
	Panel pan1, pan2, pan3;
	Container kont1, kont2, kont3;

	Wyglad4() {

		pan1 = new Panel();
		pan2 = new Panel();
		pan3 = new Panel();
		kont1 = new Container();
		kont2 = new Container();
		kont3 = new Container();
		kont1.setLayout(new GridLayout(1, 1));
		kont2.setLayout(new GridLayout(1, 1));
		kont3.setLayout(new GridLayout(1, 6));
		String labele[] = { "      S::=A ", "  A::=B|while A do D      ",
				"B::=C|B*C", "  C::=y|z|-C|(B)", "D::=E|begin E end",
				"E::={C:=B;}" };
		polecenie = new Label(
				"Find productions that need to be revised so that they fulfill grammatical rules 1 and 2. ");
		Okno2 = new Frame("Okno2");
		zakoncz = new Button("End");
		sprawdz = new Button("Check");
		taknie1 = new JRadioButton("Production S");
		taknie2 = new JRadioButton("Production A");
		taknie3 = new JRadioButton("Production B");
		taknie4 = new JRadioButton("Production C");
		taknie5 = new JRadioButton("Production D");
		taknie6 = new JRadioButton("Production E");
		czcionka = new Font("Dialog", Font.BOLD, 12);
		Okno2.setFont(czcionka);
		Okno2.setLayout(new FlowLayout());
		pan1.add(polecenie);
		kont1.add(pan1);
		Okno2.add(kont1);
		for (int k = 0; k < labele.length; k++) {
			prod = new Label(labele[k]);
			pan2.add(prod);
			kont2.add(pan2);
			Okno2.add(kont2);
		}
		zakoncz.setForeground(Color.white);
		zakoncz.setBackground(Color.red);
		sprawdz.setForeground(Color.white);
		sprawdz.setBackground(Color.pink);
		taknie1.setBackground(Color.GRAY);
		taknie2.setBackground(Color.GRAY);
		taknie3.setBackground(Color.GRAY);
		taknie4.setBackground(Color.GRAY);
		taknie5.setBackground(Color.GRAY);
		taknie6.setBackground(Color.GRAY);
		pan3.add(taknie1);
		pan3.add(taknie2);
		pan3.add(taknie3);
		pan3.add(taknie4);
		pan3.add(sprawdz);
		pan3.add(zakoncz);
		kont3.add(pan3);
		Okno2.add(kont3, BorderLayout.SOUTH);
		Okno2.setSize(700, 200);
		Okno2.setBackground(Color.GRAY);
		Okno2.setVisible(true);
		dodatki3 radio = new dodatki3(null, zakoncz, null, sprawdz, Okno2,
				taknie1, taknie2, taknie3, taknie4, taknie5, taknie6);
		sprawdz.addActionListener(radio);
		zakoncz.addActionListener(radio);
	}
}