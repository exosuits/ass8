package jsjs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Calculator extends JFrame {
	private String chkInput;
	private int numOne, sum, total;
	private int count = 0, inputChk = 0;
	private final String names[] = { "7", "8", "9", "-", 
									 "4", "5", "6", "+", 
									 "1", "2", "3", "*", 
									 "0", "", "=", "/" };
	private JTextField inputText;

	public Calculator() {
		JPanel Panel1 = new JPanel(new BorderLayout(5, 2));
		inputText = new JTextField("", SwingConstants.CENTER);
		inputText.setHorizontalAlignment(JTextField.RIGHT);
		Panel1.add(inputText, BorderLayout.CENTER);
		JPanel Panel2 = new JPanel(new GridLayout(5, 5));
		JButton buttons[] = new JButton[names.length];
		
		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			Panel2.add(buttons[count]);
			PadInput handler = new PadInput();
			buttons[count].addActionListener(handler);
		}
		add(Panel1, BorderLayout.NORTH);
		add(Panel2, BorderLayout.CENTER);
		setSize(210, 350);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	private class PadInput implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String eventText = event.getActionCommand();

			if (eventText.equals("+")){
				inputChk = 1;
			} 
			
			else if (eventText.equals("-")){
				inputChk = 2;
			} 
			
			else if (eventText.equals("*")){
				inputChk = 3;
			} 
			
			else if (eventText.equals("/")){
				inputChk = 4;
			}
			
			else if (eventText.equals("=")){
				inputChk = 5;
			} 
			
			else {
				if (count == 1){
					inputText.setText("");
					count = 0;
				}
				inputText.setText(inputText.getText() + event.getActionCommand()); 
			}

			try {
				if ((total != 0) && (inputChk <= 5)){
					inputText.setText(inputText.getText()); 
				} 
				else {
					if (inputChk == 1){
						numOne = Integer.parseInt(inputText.getText()); 
						total += numOne; 
						numOne = 0; 
						inputText.setText(String.valueOf(total)); 
						count = 1;
						chkInput = "+"; 
					} 
					
					else if (inputChk == 2){
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;
						inputText.setText(String.valueOf(total));
						count = 1;
						chkInput = "-";
					} 
					
					else if (inputChk == 3){
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;
						inputText.setText(String.valueOf(total));
						count = 1;
						chkInput = "*";
					} 
					
					else if (inputChk == 4){
						numOne = Integer.parseInt(inputText.getText());
						total += numOne;
						numOne = 0;
						inputText.setText(String.valueOf(total));
						System.out.println(" numBer ==> " + numOne);
						System.out.println(" total ==> " + total);
						count = 1;
						chkInput = "/";
					}
				}
			} 
			catch (Exception e){
				System.out.println(" Error ==> " + e);
			}

			if (total == 0) 
			{
				inputText.setText(inputText.getText()); 
			} else {
				if ((inputChk == 5) && chkInput.equals("+")) 
				{
					numOne = Integer.parseInt(inputText.getText()); 
					sum = numOne + total; 
					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum)); 
				} 
				else if ((inputChk == 5) && chkInput.equals("-")){
					System.out.println("bbb");
					numOne = Integer.parseInt(inputText.getText());
					sum = total - numOne;
					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum));					
				} 
				else if ((inputChk == 5) && chkInput.equals("*")){
					System.out.println("ccc");
					numOne = Integer.parseInt(inputText.getText());
					sum = numOne * total;
					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum));
				} 
				else if ((inputChk == 5) && chkInput.equals("/")){
					System.out.println("ddd");
					numOne = Integer.parseInt(inputText.getText());
					sum = total / numOne;
					count = 1;
					numOne = 0;
					total = 0;
					inputText.setText(String.valueOf(sum));
				}
			}
		}
	}	

	public static void main(String args[]) {
		Calculator start = new Calculator();

	}
}