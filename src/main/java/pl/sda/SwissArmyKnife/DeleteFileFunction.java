package pl.sda.SwissArmyKnife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
@Menu (position = 3)
public class DeleteFileFunction extends JFrame implements IFunction {
    private JTextField fileToDelete = new JTextField( 20);
    private JButton deleteButton = new JButton("DELETE");

    public DeleteFileFunction() throws HeadlessException {
        super("Delete File");
        initView();
        deleteButton.addActionListener(this::deleteFile);
    }

    private void deleteFile(ActionEvent actionEvent) {
        try {
            Files.delete(Paths.get(fileToDelete.getText()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        setLayout(new FlowLayout());
        setSize(600, 100);
        setLocation(750,350);
        add(fileToDelete);
        add(deleteButton);
    }

    @Override
    public void launch() { setVisible(true);}

    @Override
    public String toString() {
        return "Delete File";
    }
}
