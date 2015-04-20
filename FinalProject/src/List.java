

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

class List {
	int a = 0;
	Panel pannel;
	Label label;
	Button buttonCheck, buttonClear;
	Container container;
	TextField textField1, textField2;
	TextField textField3;
	Frame window;
	StringBuffer stringBuffer1, stringBuffer2, stringBuffer3, stringBuffer4;
	String[] string;

	List(int version, StringBuffer stringBuffer_l, Label label_l, Frame window_l,
			String string_l[]) {

		label = label_l;
		string = string_l;
		stringBuffer1 = new StringBuffer(128);
		stringBuffer2 = new StringBuffer(128);
		stringBuffer3 = new StringBuffer(128);
		stringBuffer4 = stringBuffer_l;
		window = window_l;
		pannel = new Panel();
		container = new Container();
		container.setLayout(new BorderLayout());
		buttonCheck = new Button("Check");
		buttonCheck.setForeground(Color.blue);
		buttonClear = new Button("Clear");
		buttonClear.setForeground(Color.blue);
		textField1 = new TextField(1);
		textField2 = new TextField(1);
		textField3 = new TextField(20);

		pannel.setLayout(new GridLayout(1, 5));
		pannel.add(label);
		pannel.add(buttonCheck);
		pannel.add(buttonClear);
		pannel.add(textField1);
		pannel.add(textField2);
		container.add(pannel);
		window.add(container);
		window.add(textField3);
		
		Service btaction = new Service(version, a, buttonCheck, buttonClear, window, stringBuffer1,
				stringBuffer2, stringBuffer3, stringBuffer4, textField1, textField2, textField3, string);
		buttonCheck.addActionListener(btaction);
		buttonClear.addActionListener(btaction);
	}
}

