package pl.sda.SwissArmyKnife;

import org.reflections.Reflections;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
//        Initializing the App

        SwissArmyKnifeWindow swissArmyKnifeWindow = new SwissArmyKnifeWindow();
        swissArmyKnifeWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        Adding all functions with annotation @Menu, making it easier to develop an app furthermore

        Reflections reflection = new Reflections("pl.sda");
        Set<Class<?>> typesAnnotatedWith = reflection.getTypesAnnotatedWith(Menu.class);
        for (Class<?> aClass : typesAnnotatedWith) {
            swissArmyKnifeWindow.addFunction((IFunction) aClass.newInstance());
        }

//        Adding all the functions if there weren't any annotations

//        swissArmyKnifeWindow.addFunction(new CopyFileFunction());
//        swissArmyKnifeWindow.addFunction(new CreateTextFileFunction());
//        swissArmyKnifeWindow.addFunction(new DeleteFileFunction());
//        swissArmyKnifeWindow.addFunction(new QuitFunction());

//        Making menu window visible
        swissArmyKnifeWindow.setVisible(true);
    }
}
