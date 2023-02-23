package com.meawallet.mareks.ui;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@AllArgsConstructor
public class UserMenu {

    private final UserInput userInput;
    private final List<MenuAction> actions;


}
