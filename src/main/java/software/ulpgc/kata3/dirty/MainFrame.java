package software.ulpgc.kata3.dirty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import software.ulpgc.kata3.clean.control.*;
import software.ulpgc.kata3.clean.view.*;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private BarchartDisplay barchartDisplay;

    public MainFrame() throws HeadlessException {
        this.setTitle("Statistics");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(createBarchartDisplay());
        this.add(menu(), BorderLayout.NORTH);
        this.commands = new HashMap<>();
    }

    private JPanel menu() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(toggle());
        return panel;
    }

    private JButton toggle() {
        JButton button = new JButton("Toggle Chart");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Toggle Chart").execute();
            }
        });
        return button;
    }

    private JPanel createBarchartDisplay() {
        JFreeBarchartDisplay display = new JFreeBarchartDisplay();
        barchartDisplay = display;
        return display;
    }

    public void put(String key, Command command) {
        commands.put(key, command);
    }

    public BarchartDisplay barchartDisplay() {
        return barchartDisplay;
    }
}