import java.util.List;
import java.util.Scanner;


public class Account {
    //variabales 
    private int accNumber;
    private String fName;
    private String lName;
    private double balance;
    //constractures
    public Account(){}
    public Account(int accNum, String fnm, String lnm, double blnc){
        this.accNumber = accNum;
        this.fName = fnm;
        this.lName = lnm;
        this.balance = blnc;
    }
    //==============    get / set : first-name / last-name /balance
    public void setFirstName(String fname){
        this.fName = fname;
    }
    public String getFirstName(){
        return this.fName;
    }
    public void setLastName(String lname){
        this.lName = lname;
    }
    public String getLastName(){
        return this.lName;
    }
    public void setBalance(double blc){
        if(blc > 0){
            this.balance = blc;
        }
    }
    public double getBalance(){
        return this.balance;
    }
    
    //============     getting and setting  account number with verification

    public int getAccountNumber(){
        return this.accNumber;
    }
    
    ///==============      1/    adding new account  //seting the account number
    public static void addAccount(int acc,List<Account> list){

        Scanner input = new Scanner(System.in);
        Account aAccount = new Account();
        if(acc <= 10099 && acc >= 10000){   //veritication of account number
            boolean found = false;
            for(Account item : list){
                if(item.accNumber == acc){
                    found = true;
                    System.out.println("\n !!! THE ENTERED ACCOUNT NUMBER IS NOT VALID !!!\n\n");
                    break;
                }
            }
            if(found == false){     //:: if account number get verified, set other information
                aAccount.accNumber = acc;
                System.out.print("Enter first name : ");
                aAccount.setFirstName(input.next());
                System.out.print("Enter last name : ");
                aAccount.setLastName(input.next());
                double balc;
                do{
                    System.out.print("Enter balance amount : $ ");
                    balc = input.nextDouble();
                }while(balc<0);
                aAccount.setBalance(balc);
                list.add(aAccount);
                System.out.println("\n * THE INFORMATION SUCCESSFULLY ADDED *\n\n");
            }
            else{
            System.out.println("\n !!! THE ENTERED ACCOUNT NUMBER IS NOT VALID !!!\n\n");
            }
        }
        else{
            System.out.println("\n !!! NOT VALID ACCOUNT NUMBER, PLEASE TRY AGAIN !!! \n\n");
        }
    }
    
    //--------------------------     deposit | Withdraw // set ----------
    public void setDeposit(double deposit){
        if(deposit > 0)
            this.balance += deposit;
        else{
            System.out.println(" !!! THE AMOUNT IS NOT VALID !!!\n\n");
        }
    }
    public void setWithdraw(double withdraw){
        if(withdraw > 0)
            this.balance -= withdraw;
        else{
            System.out.println(" !!! THE AMOUNT IS NOT VALID !!!\n\n");
        }
    }
    
    //===============    3/    display and finding an account by account number
    public static void findAccount(List<Account> lis,int accNum){
        boolean find  = false;
        Account acc = null;
        for(Account item : lis){
            if(item.accNumber == accNum){
                find = true;
                acc = item;
            }
        }
        if(find){
            System.out.println(" The account number << " + acc.getAccountNumber() + 
                    " >>\n First Name : " + acc.getFirstName() + 
                    "\n Last Name : " + acc.getLastName() + 
                    "\n Balance : $ " + acc.getBalance());
        }
        else{
                System.out.println(" !!! THE ACCOUNT NUMBER DOES NOT EXIST !!!\n\n");
        }
    }
    //===================   2/  Removing an account number
    public static void removeAccount(List<Account> lis,int accNum){
        
        boolean find  = false;
        Account acc = null;
        int index = -1;
        for(Account item : lis){
            if(item.accNumber == accNum){
                find = true;
                acc = item;
            }
        }
        if(find){
            lis.remove(acc);
            System.out.println("\n ** THE ACCOUNT NUMBER SUCCESSFULLY REMOVED  **\n\n");
        }
        else{
                System.out.println(" !!! THE ACCOUNT NUMBER DOES NOT EXIST !!!\n\n");
        }
    }
    
    //===================   4/  Deposit to an account number
    
    public static void depositAccount(List<Account> lis, int accNum, double money){
        
        boolean find  = false;
        Account acc = null;
        for(Account item : lis){
            if(item.accNumber == accNum){
                find = true;
                acc = item;
            }
        }
        if(find){
            acc.setDeposit(money);
            System.out.println(" ** THE WITHDRAW AMOUNT SUCCESSFULLY APPLIED **\n\n");
        }
        else{
                System.out.println(" !!! THE ACCOUNT NUMBER DOES NOT EXIST !!!\n\n");
        }
    }
    
    //===================   5/  Withdraw from an account number
    
    public static void withdrawAccount(List<Account> lis, int accNum, double money){
        
        boolean find  = false;
        Account acc = null;
        for(Account item : lis){
            if(item.accNumber == accNum){
                find = true;
                acc = item;
            }
        }
        if(find){
            acc.setWithdraw(money);
            System.out.println("\n ** THE WITHDRAW AMOUNT SUCCESSFULLY APPLIED  **\n\n");
        }
        else{
                System.out.println(" !!! THE ACCOUNT NUMBER DOES NOT EXIST !!!\n\n");
        }
    }
    
    //===================   6/  Sorting The account
    public static void sortingAccounts(List<Account> lis, int num){
        Account[] all = new Account[lis.size()];
        lis.toArray(all);
        switch (num) {
            case 1:     //  by balance desendent
                for(int pass = 1; pass < all.length ; pass++ ){
                    boolean testControl = false;
                    for(int index= 0 ; index<all.length-1 ; index++){
                        if(all[index].balance < all[index+1].balance){
                            Account temp = all[index];
                            all[index] = all[index+1];
                            all[index+1] = temp;
                            testControl = true;
                        }
                    }
                    if(testControl == false){
                        break;
                    }
                }   /////===== show
                System.out.println("\n\t  The descendent list of accounts by Balance: \n\t"
                        + "+++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.printf("     Balance :|: %10s :|: %7s :|: %10s\n",  "Account Number", "First Name" , "Last Name");
                for (int i =0 ; i < all.length ; i++)
                {
                    System.out.printf("%d %9s $  %10s  %18s  %13s\n" ,i+1, all[i].balance , all[i].accNumber ,all[i].fName , all[i].lName);
                }
                System.out.println("\n\t++++++++++++++++++++++++++++++++++++++++++++++\n\n");
                break;
            case 2:     //  by balance ascendent
                for(int pass = 1; pass < all.length ; pass++ ){
                    boolean testControl = false;
                    for(int index = 0 ; index<all.length-1; index++){
                        if(all[index].balance > all[index+1].balance){
                            Account temporary = all[index];
                            all[index] = all[index+1];
                            all[index+1] = temporary;
                             testControl = true;
                        }
                    }
                    if(testControl == false){
                        break;
                    }
                }   /////===== show
                System.out.println("\n\t  The ascendent list of accounts by Balance: \n\t"
                        + "++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.printf("     Balance :|: %10s :|: %7s :|: %10s\n",  "Account Number", "First Name" , "Last Name");
                for (int i =0 ; i < all.length ; i++)
                {
                    System.out.printf("%d %9s $  %10s  %18s  %13s\n" ,i+1, all[i].balance , all[i].accNumber ,all[i].fName , all[i].lName);
                }
                System.out.println("\n\t++++++++++++++++++++++++++++++++++++++++++++++\n\n");
                break;  
                //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
            case 3:    //  by account number descendent
                for(int pass = 1; pass < all.length ; pass++ ){
                    boolean testControl = false;
                    for(int index = 0 ; index<all.length-1; index++){
                        if(all[index].accNumber < all[index+1].accNumber){
                            Account temporary = all[index];
                            all[index] = all[index+1];
                            all[index+1] = temporary;
                            testControl = true;
                        }
                    }
                    if(testControl == false){
                        break;
                    }
                }   /////===== show
                System.out.println("\n\t  The descendent list of accounts by Account Number: \n\t"
                        + "++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.printf("  Account No# :|: %10s :|: %7s :|: %10s\n", "First Name" , "Last Name" , "Balance");
                for (int i =0 ; i < all.length ; i++)
                {
                    System.out.printf("%d %9s   %12s  %13s  %14s \n" ,i+1, all[i].accNumber ,all[i].fName , all[i].lName , all[i].balance);
                }
                System.out.println("\n\t++++++++++++++++++++++++++++++++++++++++++++++\n\n");
                break;
                //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
            case 4:    //  by account number ascendent
                for(int pass = 1; pass < all.length ; pass++ ){
                    boolean testControl = false;
                    for(int index = 0 ; index<all.length-1; index++){
                        if(all[index].accNumber > all[index+1].accNumber){
                            Account temporary = all[index];
                            all[index] = all[index+1];
                            all[index+1] = temporary;
                            testControl = true;
                        }
                    }
                    if(testControl == false){
                        break;
                    }
                }   /////===== show
                System.out.println("\n\t  The ascendent list of accounts by Account Number: \n\t"
                        + "++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.printf("  Account No# :|: %10s :|: %7s :|: %10s\n", "First Name" , "Last Name" , "Balance");
                for (int i =0 ; i < all.length ; i++)
                {
                    System.out.printf("%d %9s   %12s  %13s  %14s \n" ,i+1, all[i].accNumber ,all[i].fName , all[i].lName , all[i].balance);
                }
                System.out.println("\n\t++++++++++++++++++++++++++++++++++++++++++++++\n\n");
        }
    } 
    
    //=============  7/  avrage balance value
    public static double avgBalance(List<Account> lis){
        double avg;// = 0;
        double sum = 0;
        for(Account item : lis){
            sum += item.balance;
        }
        avg = sum/lis.size();
        return avg;
    }
    //=============  8/  total balance value
    public static double totalBalance(List<Account> lis){
        double total = 0;
        for(Account item : lis){
            total += item.balance;
        }
        return total;
    }
}
//++++++++++++++++  :: :::  End of the class Account  ::: ::
