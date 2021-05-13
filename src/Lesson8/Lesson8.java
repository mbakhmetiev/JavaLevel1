package Lesson8;

import javax.swing.*;
import java.awt.*;

public class Lesson8 {

    	static class CounterApp extends JFrame {
    		private int value;
			private int step;
		public CounterApp(int initialValue) {
			setBounds(300, 300, 300, 180);
			setTitle("* * * COUNTER * * *");
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			Font font = new Font("Arial", Font.BOLD, 32);
			Font font1 = new Font("Arial", Font.BOLD, 20);

			JPanel panel = new JPanel();
			panel.setMaximumSize(new Dimension(200, 200));
			panel.setLayout(new FlowLayout());
			add(panel, BorderLayout.SOUTH);

			JPanel panel1 = new JPanel();
			panel.setMaximumSize(new Dimension(200, 200));
			panel.setLayout(new FlowLayout());
			add(panel1, BorderLayout.NORTH);

			JLabel counterValueView = new JLabel();
			counterValueView.setFont(font);
			counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
			add(counterValueView, BorderLayout.CENTER);

			value = initialValue;
			step = 1;
			counterValueView.setText(value + " | " + step );

			JButton decrementButton = new JButton("<");
			decrementButton.setFont(font);
			add(decrementButton, BorderLayout.WEST);

			decrementButton.addActionListener(actionEvent -> {
				value -= step;
				counterValueView.setText(value + " | " + step );
			});

			JButton incrementButton = new JButton(">");
			incrementButton.setFont(font);
			add(incrementButton, BorderLayout.EAST);

			incrementButton.addActionListener(actionEvent -> {
				value += step;
				counterValueView.setText(value + " | " + step );
			});

			JButton resetButton = new JButton("Reset");
			resetButton.setFont(font1);
			resetButton.setPreferredSize(new Dimension(150, 30));
			panel.add(resetButton);

			resetButton.addActionListener(actionEvent -> {
				value = 0;
				step = 1;
				counterValueView.setText(value + " | " + step );
			});

			JLabel stepPrompt = new JLabel();
			stepPrompt.setFont(font1);
			stepPrompt.setText("Enter step:");
			panel1.add(stepPrompt);

			JTextField field = new JTextField();
			field.setPreferredSize(new Dimension(60, 30));
			panel1.add(field);

			field.addActionListener(actionEvent -> {
			    String input = field.getText();
			    boolean isInt = false;
			    for (int i = 0; i < input.length() ; i++) {
			    	isInt |= Character.isDigit(input.charAt(i));
				}
			    if (isInt) step = Integer.parseInt(input);
				counterValueView.setText(value + " | " + step );
				field.setText(null);
			});

			setVisible(true);
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CounterApp(0);
			}
		});
	}
}
