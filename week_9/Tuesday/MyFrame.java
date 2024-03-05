import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// step 1. we need to define our custom action listener class
class MyButtonListener implements ActionListener {
    int count = 0;

    // (in this case) every time a button gets clicked, this actionPerformed method
    // will be called
    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        System.out.println("button gets clicked " + count + " times! Time: " + e.getWhen());
        Object obj = e.getSource();

        // obj.getText();
        // sometimes a listener may listen to various types of component
        // before we do something
        // we have to first tell what is the type of the component
        // mkae use of `instanceof` keyword to achieve that

        // `instanceof` keywork will check if the object type (not ref type) is a
        // JButton or a subclass of JButton
        if (obj instanceof JButton) {
            JButton button = (JButton) obj;
            System.out.println("The text part of this buttion is " + button.getText());
            button.setText("This button has been clicked by " + count + " times");
        }

    }
}

public class MyFrame {

    public static void main(String[] strings) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JButton button = new JButton();
        button.setText("click me");
        // step 2. need to create an instance of our custom listener and make it listen
        // to this button
        MyButtonListener listener = new MyButtonListener();
        button.addActionListener(listener);

        frame.add(button);

        frame.setVisible(true);
        JOptionPane.showMessageDialog(null,
                "A message",
                "Warning type",
                JOptionPane.ERROR_MESSAGE);
    }
}