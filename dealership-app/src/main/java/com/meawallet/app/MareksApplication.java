package com.meawallet.app;


import com.meawallet.mareks.ui.UserMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MareksApplication {

	public static void main(String[] args) {
		var applicationContext = new AnnotationConfigApplicationContext("com.meawallet.mareks", "org.springframework.data");
		var userMenu = applicationContext.getBean(UserMenu.class);
		userMenu.startMenu();
	}

}
