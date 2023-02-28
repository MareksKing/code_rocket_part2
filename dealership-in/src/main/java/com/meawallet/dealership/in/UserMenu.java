package com.meawallet.dealership.in;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class UserMenu {

    private final UserInput userInput;
    private final List<MenuAction> actions;

    public void startMenu() {
        while (true) {
            System.out.println("Hello");

            try {
                for (int i = 0; i < actions.size(); i++) {
                    System.out.println(i + ". " + actions.get(i).getName());
                }

                int number = userInput.getMenuAction();

                checkUserInput(number);

                MenuAction menuAction = actions.get(number);
                menuAction.execute();
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect menu action, please try again.");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void checkUserInput(int number) {
        if (number < 0 || number >= actions.size()) {
            throw new IllegalArgumentException("Incorrect menu action.");
        }
    }


}
