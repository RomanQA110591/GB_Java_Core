package ru.GB.Lesson8;

import java.sql.SQLException;

public class AppMain {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        UserInterface userInterface = new UserInterface();
        try {
            userInterface.runApplication();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}

