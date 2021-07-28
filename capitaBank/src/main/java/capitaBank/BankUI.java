package capitaBank;

import java.util.Scanner;

public class BankUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		showMenu();

	}
	
	public static void showMenu() {
		char option='\0';
	
        Scanner scanner = new Scanner(System.in);
        AccountController ac = new AccountController(new AccountDAO());
        
        Customer c1 = new Customer("Bob","Alan");
        Account a1 = ac.insertAccount(new NewAccount(c1));
        
        Customer c2 = new Customer("Alex","John");
		Account a2 = ac.insertAccount(new NewAccount(c2));
		
        System.out.println("Welcome " + c1.getFirstName());
        System.out.println("Your ID is " + c1.getCustomerId());
        System.out.println("\n");
        System.out.println("A. Check Blanace");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Transfer");
        System.out.println("E. Delete Account");
        System.out.println("F. Exit");
            
            do {
                System.out.println("==============================================================================================================================================================================================");
                System.out.println("Enter an option");
                System.out.println("==============================================================================================================================================================================================");
                
                option = scanner.next().charAt(0);
                System.out.println("\n");

                switch(option){
                
                case 'A':
                System.out.println("-------------------------------------------------------------");
                System.out.println("Balance = "+a1.getFunds());
                System.out.println("-------------------------------------------------------------");
                System.out.println("\n");
                break;

                case 'B':
                System.out.println("-------------------------------------------------------------");
                System.out.println("Enter an amount to deposit:");
                System.out.println("-------------------------------------------------------------");
                int amount = scanner.nextInt();
                a1.deposit(amount);
                System.out.println("\n");
                break;

                case 'C':
                System.out.println("-------------------------------------------------------------");
                System.out.println("Enter an amount to withdraw");
                System.out.println("-------------------------------------------------------------");
                int amount2 = scanner.nextInt();
                a1.withdraw(amount2);
                System.out.println("\n");
                break;

                case 'D':
                System.out.println("-------------------------------------------------------------");
                System.out.println("Please enter the account id you wish to transfer to");
                String accountId = scanner.next();
                AccountDAO d = new AccountDAO();
    
                Account result = d.getAccount(Integer.parseInt(accountId));
                System.out.println("Enter amount you wish to transfer");
                int transferAmount = scanner.nextInt();
                
                a1.transfer(result,transferAmount);
                System.out.println("-------------------------------------------------------------");
                System.out.println("\n");
                break;

                case 'E':
                	System.out.println("-------------------------------------------------------------");
                	System.out.println("Do you wish to delete your account?");
                	String deleteAccount = scanner.next();
                	if(deleteAccount.equals("yes")) {
                		AccountDAO d2 = new AccountDAO();
                    	d2.deleteAccount(a1.getAccountId());
                	} else if(deleteAccount.equals("no")){
                		break;
                	}
                	
                break;
                
                case 'F':
                    System.out.println("**************************************************************");
                    break;
                    
                default:
                System.out.println("Invalid Option. Please enter again");
                break;
                }
            }while(option != 'F');
                System.out.println("Thank you for using our services");
        }
	}


