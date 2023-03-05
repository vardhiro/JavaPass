import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

class Passc{

	public static boolean passIsThere(String inp) {
        boolean flag = false;
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("dict.txt"));
			String line = reader.readLine();

			while (line != null) {
				if (line.trim().equals(inp)) 
                    flag = true;
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        return flag;
	}
    public static void main(String[] args) {
        // Created Frame
        JFrame f = new JFrame("JPass: Your Password Checker for safety");
        f.setSize(600,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        // The Panel 
        JPanel pan = new JPanel();
        f.add(BorderLayout.NORTH, pan);

        // The Label
        Font fn = new Font("Calibri", 0, 20);
        JLabel label = new JLabel("The Password: ");
        label.setFont(fn);
        pan.add(BorderLayout.NORTH,label);

        // The Text Box
        JTextField pass = new JTextField();
        pass.setColumns(11);
        pass.setFont(fn);
        pan.add(pass);
        
        // The button 
        JButton button = new JButton("Check it!");
        pan.add(button);

        // Confirmation label 
        JLabel conf = new JLabel("Click Check to start checking");
        conf.setFont(fn);
        f.add(BorderLayout.CENTER,conf);

        button.addActionListener(e ->
        {
            boolean isUsed = passIsThere(pass.getText());
            if (isUsed)
                conf.setText("The password is in the dictionary and is thus prone to hacking");
            else
                conf.setText("Yohoo! You may use the password! it is safe!");
        });
    }
}