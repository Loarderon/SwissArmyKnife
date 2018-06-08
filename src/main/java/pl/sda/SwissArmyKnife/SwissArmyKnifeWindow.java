package pl.sda.SwissArmyKnife;

import javax.swing.*;
import java.awt.*;

public class SwissArmyKnifeWindow extends JFrame {
    private JList<IFunction> functionList = new JList<IFunction>();
    private DefaultListModel <IFunction> functionListModel = new DefaultListModel<IFunction>();
    private JButton useSelectedFunction = new JButton("Use selected function");

    public SwissArmyKnifeWindow() throws HeadlessException {
    functionList.setModel(functionListModel);
    setLayout(new BorderLayout());
    setSize(350, 250);
    setLocation(700, 300);
    add(functionList, BorderLayout.CENTER);
    add(useSelectedFunction, BorderLayout.PAGE_END);
    useSelectedFunction.addActionListener(e-> functionList.getSelectedValue().launch());
    }

    public void addFunction(IFunction iFunction) {
        functionListModel.addElement(iFunction);
    }
}
