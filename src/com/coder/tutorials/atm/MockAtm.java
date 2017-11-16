/*
 * This is a simple atm working logic application
 *This class will combine main parts
 */
package com.coder.tutorials.atm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Coder ACJHP
 */
public class MockAtm {

    private AtmAccout accountBean;
    private NumberGenerator idGenerator;
    private Transactions transactions;
    private final List<AtmAccout> accountList;

    public MockAtm() {
        
        idGenerator = new NumberGenerator();
        //prepare account list with mock accounts
        accountList = new ArrayList<>();
        accountList.add(new AtmAccout(idGenerator.generateId(),"Onur", "12345", 15500.0));
        accountList.add(new AtmAccout(idGenerator.generateId(),"Coder", "12345", 87500.0));
        accountList.add(new AtmAccout(idGenerator.generateId(),"Hakan", "12345", 500700.0));
    }

    public int showMenu() {

        final Scanner accountNameInput = new Scanner(System.in);
        int userChoise;

        //repeat the asking about menu while choosing right choise or exit
        System.out.println("\nMENU : \n------------------------------");
        System.out.println("1- Show total balance\n2- Add deposite to account"
                + "\n3- Withdraw money from account\n4- Show account detail\n0- Exit");
        System.out.print("Choose your operation by writing number of section : ");
        userChoise = accountNameInput.nextInt();
        System.out.println("");
        accountNameInput.close();
        return userChoise;
    }

    public boolean showLogin() {

        System.out.println("Welcome to Coder ATM\n------------------------------");
        String username, password;

        System.out.print("Please enter your Account name : ");
        final Scanner scanner = new Scanner(System.in);
        username = scanner.next();

        System.out.print("Please enter your Account password : ");
        password = scanner.next();
        scanner.close();

        //iterate the mock list to find the account owner if it's avalible
        for (int i = 0; i < accountList.size(); i++) {
            AtmAccout findAccout = accountList.get(i);
            if (findAccout.getUsername().equalsIgnoreCase(username)
                    && findAccout.getPassword().equals(password)) {
                //inject found account to transaction class
                accountBean = findAccout;
                return true;
            }

        }
        System.err.println("Cannot find your Account!");
        return false;
    }

    public void prepareApp() {

        boolean status = showLogin();

        if (status) {

            do {

                int choosen = showMenu();
                transactions = new Transactions(accountBean);
                switch (choosen) {
                    case 1:
                        transactions.getTotalBalance();
                        break;
                    case 2:
                        transactions.addDeposite();
                        break;
                    case 3:
                        transactions.withDraw();
                        break;
                    case 4:
                        transactions.showAccountDetail();
                        break;    
                    case 0:
                        System.out.println("Thank you for choosing Coder ATM");
                        System.exit(0);
                }
                //repeat showing menu while the user select 0.
            } while (true);

        }
    }
}
