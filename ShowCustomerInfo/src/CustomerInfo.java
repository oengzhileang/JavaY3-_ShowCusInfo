import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerInfo {
    private JFrame frame;
    private JPanel panel;
    private JLabel idLabel, lastNameLabel, firstNameLabel, phoneLabel;
    private JButton prevButton, nextButton;
    private int currentIndex;

    // Sample customer data
    private String[][] customers = {
            {"1", "Chenda", "Sovisal", "092888999"},
            {"2", "Doe", "John", "0123456789"},
            {"3", "Smith", "Jane", "0987654321"}
    };

    public CustomerInfo() {
        frame = new JFrame("Customer");
        panel = new JPanel(new GridLayout(5, 2, 5, 5));

        idLabel = new JLabel("ID: ");
        lastNameLabel = new JLabel("Last Name: ");
        firstNameLabel = new JLabel("First Name: ");
        phoneLabel = new JLabel("Phone: ");

        panel.add(idLabel);
        panel.add(new JLabel());
        panel.add(lastNameLabel);
        panel.add(new JLabel());
        panel.add(firstNameLabel);
        panel.add(new JLabel());
        panel.add(phoneLabel);
        panel.add(new JLabel());

        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex--;
                if (currentIndex < 0) {
                    currentIndex = customers.length - 1;
                }
                updateCustomerInfo();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex++;
                if (currentIndex >= customers.length) {
                    currentIndex = 0;
                }
                updateCustomerInfo();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        currentIndex = 0;
        updateCustomerInfo();

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void updateCustomerInfo() {
        idLabel.setText("ID: " + customers[currentIndex][0]);
        lastNameLabel.setText("Last Name: " + customers[currentIndex][1]);
        firstNameLabel.setText("First Name: " + customers[currentIndex][2]);
        phoneLabel.setText("Phone: " + customers[currentIndex][3]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerInfo();
            }
        });
    }
}
