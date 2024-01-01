package com.code;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game extends JFrame {
	JTextField guess, range1, range2, range3;
	ButtonListener buttonListener;
	ButtonListener1 buttonListener1;
	ButtonListener2 buttonListener2;
	JLabel headlabel, inputlabel, guesslabel, resultlabel, resultlabel1, value1label, label, totalguesslabel1;

	int rand, calcy;
	int count = 0;

	public Game() {
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.WHITE);
		
		headlabel = new JLabel("GUESS THE NUMBER GAME");
		headlabel.setForeground(Color.BLUE);
		headlabel.setFont(new Font("times new roman", Font.BOLD, 24));
		headlabel.setSize(330, 20);
		headlabel.setLocation(80, 10);

		value1label = new JLabel("Range");
		value1label.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		value1label.setSize(270, 20);
		value1label.setLocation(140, 40);

		range1 = new JTextField(10);
		range1.setSize(30, 20);
		range1.setLocation(200, 40);

		label = new JLabel("-");
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		label.setSize(20, 20);
		label.setLocation(250, 40);

		range2 = new JTextField(10);
		range2.setSize(30, 20);
		range2.setLocation(280, 40);

		JButton genbutton = new JButton("Generate Random Number");
		genbutton.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		genbutton.setSize(280, 30);
		genbutton.setLocation(90, 70);
		genbutton.setBackground(Color.LIGHT_GRAY);
		buttonListener = new ButtonListener();
		genbutton.addActionListener(buttonListener);

		range3 = new JTextField(10);
		range3.setSize(30, 20);
		range3.setLocation(310, 110);

		totalguesslabel1 = new JLabel("You've Number Of Guesses");
		totalguesslabel1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		totalguesslabel1.setSize(270, 20);
		totalguesslabel1.setLocation(110, 110);

		guesslabel = new JLabel("Guess the Number ?");
		guesslabel.setForeground(Color.RED);
		guesslabel.setFont(new Font("times new roman", Font.BOLD, 20));
		guesslabel.setSize(270, 20);
		guesslabel.setLocation(140, 140);

		inputlabel = new JLabel("", SwingConstants.CENTER);
		inputlabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		inputlabel.setSize(270, 20);
		inputlabel.setLocation(80, 160);

		guess = new JTextField(10);
		guess.setSize(50, 30);
		guess.setLocation(190, 190);

		resultlabel = new JLabel("Try and guess it !", SwingConstants.CENTER);
		resultlabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		resultlabel.setSize(270, 20);
		resultlabel.setLocation(80, 230);

		resultlabel1 = new JLabel("", SwingConstants.CENTER);
		resultlabel1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		resultlabel1.setSize(270, 20);
		resultlabel1.setLocation(80, 250);

		JButton guessbutton = new JButton("Guess");
		guessbutton.setSize(100, 30);
		guessbutton.setLocation(110, 280);
		guessbutton.setBackground(Color.LIGHT_GRAY);
		buttonListener1 = new ButtonListener1();
		guessbutton.addActionListener(buttonListener1);

		JButton playagainbutton = new JButton("Play Again!");
		playagainbutton.setSize(100, 30);
		playagainbutton.setLocation(240, 280);
		playagainbutton.setBackground(Color.LIGHT_GRAY);
		buttonListener2 = new ButtonListener2();
		playagainbutton.addActionListener(buttonListener2);

		c.add(headlabel);
		c.add(value1label);
		c.add(label);
		c.add(totalguesslabel1);
		c.add(resultlabel);
		c.add(resultlabel1);
		c.add(guesslabel);
		c.add(inputlabel);
		c.add(guess);
		c.add(range1);
		c.add(range2);
		c.add(range3);
		c.add(genbutton);
		c.add(guessbutton);
		c.add(playagainbutton);

		range1.setEditable(true);
		range2.setEditable(true);
		range3.setEditable(false);
		guess.setEditable(false);
		setTitle("GUESS THE NUMBER");
		setSize(500, 360);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Random r = new Random();
			int high = Integer.parseInt(range2.getText());
			int low = Integer.parseInt(range1.getText());

			if (low == high) {
				resultlabel.setText("Give Correct Inputs Of Range!");
				resultlabel.setForeground(Color.RED);
			}

			rand = r.nextInt(high - low) + low;
			calcy = (int) Math.round(Math.log(high - low + 1)) + 1;
			range3.setText(calcy + "");
			inputlabel.setText("Enter the number between " + low + " and " + high + " !!");
			guess.setEditable(true);
		}
	}

	private class ButtonListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int a = Integer.parseInt(guess.getText());
			int high = Integer.parseInt(range2.getText());
			int low = Integer.parseInt(range1.getText());

			if (low == high) {
				resultlabel.setText("Give Correct Inputs Of Range!");
				resultlabel.setForeground(Color.RED);
			} else {

				while (count < calcy) {

					if (a == rand) {
						resultlabel.setText("Congratulations!, You Won The Game");
						resultlabel.setForeground(Color.GREEN);
						resultlabel1.setText("You Took " + count + " atempts!");
						resultlabel1.setForeground(Color.GREEN);
						guess.setEditable(false);
						break;

					} else if (a < rand) {
						resultlabel.setText(a + " Is Too Low!");
						resultlabel.setForeground(Color.ORANGE);
						count++;
						break;

					} else if (a > rand) {
						resultlabel.setText(a + " Is Too High!");
						resultlabel.setForeground(Color.ORANGE);
						count++;
						break;

					} else {
						resultlabel.setText("Try Again");
						resultlabel.setForeground(Color.RED);
						count++;
					}

				}
				if (count >= calcy) {
					resultlabel.setText("Oops!, You Lost The Game!");
					resultlabel.setForeground(Color.RED);
					guess.setText(rand + "");
					resultlabel1.setText("Better Luck Next Time!");
					resultlabel1.setForeground(Color.RED);
					guess.setEditable(false);
				}
			}
		}
	}

	private class ButtonListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			guess.setText("");
			resultlabel.setText("Try and guess it !");
			resultlabel.setForeground(Color.BLACK);
			resultlabel1.setText("");
			range1.setText("");
			range2.setText("");
			range3.setText("");
			guess.setEditable(true);
//			guess.requestFocus();
			count = 0;
		}
	}

	public static void main(String[] args) {
		new Game();
	}

}
