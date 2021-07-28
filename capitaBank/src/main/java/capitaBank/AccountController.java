package capitaBank;

public class AccountController {
    private final AccountDAO userDao;
   
    public AccountController(AccountDAO userDao) {
    	this.userDao = userDao;
    }

    
    public Account insertAccount(NewAccount newAccount) {
    	return userDao.insertAccount(newAccount);
    }
    
    public void deleteAccount(Account account) {
    	userDao.deleteAccount(account.getAccountId());
    }
    
//    public Account createAndInsertAccount(Customer c, AccountType a) {
//    	userDao d = new userDao();
//    	
//    	if(a == accountType.CHECKING) {
//    		CheckingAccount acc = new CheckingAccount();
//    		accounts.add(acc);
//    		c.addAccount(acc);
//    		d.insertAccount(acc.getAccountId(),c.getFirstName(), c.getLastName(),0.0, "CHECKING");
//    		return acc;
//    	} else if(a == accountType.SAVINGS) {
//    		SavingAccount s = new SavingAccount();
//    		accounts.add(s);
//    		c.addAccount(s);
//    		d.insertAccount(s.getAccountId(),c.getFirstName(), c.getLastName(), 0.0, "SAVINGS");
//    		return s;
//    	}
//    	return null;
//    }
    
       

}
