package pl.sda.SwissArmyKnife;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
@Menu(position = 2)
public class CopyFileFunction extends JFrame implements IFunction {
    private JTextField sourceFile = new JTextField(20);
    private JTextField targetFile = new JTextField(20);
    private JButton copyButton = new JButton("COPY!");

    public CopyFileFunction() throws HeadlessException {
        setLayout(new FlowLayout());
        setLocation(300, 400);
        setSize(450, 500);
        add(sourceFile);
        add(targetFile);
        add(copyButton);
        copyButton.setLocation(50, 50);
        copyButton.addActionListener(e -> copyFiles());
    }

    public void copyFiles() {
        try {
            Files.copy(Paths.get(sourceFile.getText()), Paths.get(targetFile.getText()), REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void launch() {
        setVisible(true);
    }

    @Override
    public String toString() {
        return "Copy File";
    }
}
