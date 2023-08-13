package com.aliasifkhan.core.utils;

import java.util.Scanner;

public class CommandProcesser implements Disposable {

    private static final CommandProcesser INSTANCE = new CommandProcesser();
    private final Scanner scanner;

    private CommandProcesser(){
        scanner = new Scanner(System.in);
    }

    public static CommandProcesser getCommandProcesser(){
        return INSTANCE;
    }

    public String[] readCommand(){

        String inputLine = scanner.nextLine();
        return inputLine.split("\\s+");
    }

    @Override
    public void dispose() {
        scanner.close();
    }
}
