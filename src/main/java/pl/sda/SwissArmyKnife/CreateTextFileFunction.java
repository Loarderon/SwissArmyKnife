package pl.sda.SwissArmyKnife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
@Menu
public class CreateTextFileFunction extends JFrame implements IFunction {
    private JTextField targetFile = new JTextField();
    private JTextArea fileContent = new JTextArea();
    private JButton saveButton = new JButton("SAVE");

    public CreateTextFileFunction() throws HeadlessException {
        super("Create Text File");
        initView();
        saveButton.addActionListener(this::saveFile);
    }

    private void saveFile(ActionEvent actionEvent) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(targetFile.getText());
            fileOutputStream.write(fileContent.getText().getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        setLayout(new BorderLayout());
        setSize(450, 300);
        setLocation(400, 700);
        add(targetFile, BorderLayout.PAGE_START);
        add(fileContent, BorderLayout.CENTER);
        add(saveButton, BorderLayout.PAGE_END);
    }

    @Override
    public void launch() {setVisible(true);}

    @Override
    public String toString() {
        return "Create Text File";
    }
}
