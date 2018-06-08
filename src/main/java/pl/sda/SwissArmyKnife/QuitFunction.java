package pl.sda.SwissArmyKnife;

import javax.swing.*;
import java.awt.*;
@Menu (position = 4)
public class QuitFunction extends JFrame implements IFunction {
    private JButton quitButton = new JButton("Quit.");

    public QuitFunction() throws HeadlessException {
        super("Quit!");
        setSize(200, 70);
        setLocation(750,350);

        add(quitButton);
        quitButton.addActionListener(e -> System.exit(0));
    }

    @Override
    public void launch() {setVisible(true);}

    @Override
    public String toString() {
        return "Quit";
    }
}
