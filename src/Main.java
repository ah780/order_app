import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    static MenuItem[] menu = {
            new MenuItem("توست شنيتسل", 8),
            new MenuItem("توست فاهيتا", 10),
            new MenuItem("توست نقانق", 4),
            new MenuItem("توست نقانق مع جبنة", 5),
            new MenuItem("توست بيتزا", 7)
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("قائمة الطعام");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel title = new JLabel("اختر الأصناف:");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();
        for (MenuItem item : menu) {
            JCheckBox checkBox = new JCheckBox(item.name + " - " + item.price + " شيكل");
            checkBoxes.add(checkBox);
            panel.add(checkBox);
        }

        JButton orderButton = new JButton("إنهاء الطلب");
        orderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(orderButton);

        orderButton.addActionListener(e -> {
            StringBuilder bill = new StringBuilder("***** الفاتورة *****\n");
            double total = 0;
            for (int i = 0; i < checkBoxes.size(); i++) {
                if (checkBoxes.get(i).isSelected()) {
                    bill.append(menu[i].name).append(": ").append(menu[i].price).append(" شيكل\n");
                    total += menu[i].price;
                }
            }
            bill.append("--------------------\n");
            bill.append("المجموع: ").append(String.format("%.2f", total)).append(" شيكل");

            JOptionPane.showMessageDialog(frame, bill.toString(), "الفاتورة", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}