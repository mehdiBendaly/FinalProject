

import java.awt.*;
import java.applet.*;

public class AppletApp extends Applet { // ** Variable declaration

	private static final long serialVersionUID = -6578515530269515441L;

	Panel pannel;// Forming the main window and text selection
	Choice grammar; // gramatyka = grammar
	String choice; // Wybor = choice

	// Button Help;

	public void init() {
		FlowLayout f = new FlowLayout();
		Panel pannel = new Panel(f);// Main management and choice
													// grammar label
		choice = new String(" Choose the grammar you want to solve ");
		grammar = new Choice();// wybor

		grammar.addItem("Grammar1");
		grammar.addItem("Grammar2");
		grammar.addItem("Grammar3");

		pannel.add(new Label(choice, Label.CENTER));// adding text Select
													// Grammar...

		pannel.add(grammar);
		add(pannel);

		pannel.validate();

	}// Events depending on what you choose from the choice

	public boolean action(Event ev, Object o) {

		if (ev.target instanceof Choice)// Grammar 1 is selected
		{
			if (o == "Grammar1") {
				new Window(1);
			}
			if (o == "Grammar2") {
				new Window(4);
			}
			if (o == "Grammar3") {
				new Window(7);
			}

		}

		return true;
	}
}