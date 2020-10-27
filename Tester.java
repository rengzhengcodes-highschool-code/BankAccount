public class Tester {

  public static void main(String[] args) {
    idTester();
    balanceTester();
    toStringTester();
  }

  public static void errorHorn() {
    System.out.println("ERROR!\nERROR\nERROR");
  }

  public static void idEqualityTester(BankAccount bankAccount, int ID) {
    if (ID != bankAccount.getAccountID()) {
      errorHorn();
      System.out.println("Constructor failed at assigning bank ID or getAccountID method failed: " + ID +
      "\n Returned: " + bankAccount.getAccountID());
    } else {
      System.out.println("ID assignment and retrieval works.");
    }
  }

  public static void idTester() {
    int[] bankIDs = {10234, 032432, 0, -423432, 204321, 232, 2, -2321, -2};
    System.out.println("POSITIVE ID RANDOMIZED TEST");
    for (int i = 0; i < 10; i++) {
      int bankID = (int)(Math.random() * 100000000);
      BankAccount account = new BankAccount(bankID, "Strudles");
      idEqualityTester(account, bankID);
    }

    System.out.println("NEGATIVE ID RANDOMIZED TEST");
    for (int i = 0; i < 10; i++) {                                              //ID TEST FOR NEG NUMBERS AS THEY ARE VALID ID INPUTS.
      int bankID = (int)(Math.random() * -100000000);
      BankAccount account = new BankAccount(bankID, "Strudles");
      idEqualityTester(account, bankID);
    }

    System.out.println("STATIC ID TEST");
    for (int index = 0; index < bankIDs.length; index++) {
      BankAccount account = new BankAccount(bankIDs[index], "");
      idEqualityTester(account, bankIDs[index]);
    }
  }

  public static void balanceTester() {
    double[] depositAmounts = {0, 121321321, -21432, -2, 1, Math.PI};
    boolean[] depositTestResults = {true, true, false, false, true, true};
    BankAccount[] bankAccounts = new BankAccount[6];

    for (int index = 0; index < bankAccounts.length; index++) {                 //initiaties bankAccounts
      BankAccount account = new BankAccount(1, "");
      bankAccounts[index] = account;
    }

    System.out.println("deposit() TEST");
    for (int index = 0; index < bankAccounts.length; index++) {
      if (bankAccounts[index].deposit(depositAmounts[index]) == depositTestResults[index]) {
        System.out.println("deposit function succeeded.");
      } else {
        errorHorn();
        System.out.println("deposit function failed at index: " + index);
      }
    }

    System.out.println("getBalance() TEST");
    double[] depositedAmounts = {0, 121321321, 0, 0, 1, Math.PI};
    for (int index = 0; index < bankAccounts.length; index++) {
      if (bankAccounts[index].getBalance() == depositedAmounts[index]) {
        System.out.println("getBalance + deposit function succeeded.");
      } else {
        errorHorn();
        System.out.println("Deposit or getBalance function failed at index: " + index);
      }
    }

    System.out.println("withdraw() TEST");
    double[] withdrawAmounts = {0, 10000, 2048, -100, 20042, Math.PI};
    boolean[] withdrawTestResults = {true, true, true, false, false, true};
    for (int index = 0; index < bankAccounts.length; index++) {                 //creates bank accounts with same amount of money for withdraw testing
      BankAccount account = new BankAccount(1, "");
      account.deposit(10000.);
      bankAccounts[index] = account;
    }
    for (int index = 0; index < bankAccounts.length; index++) {
      if (bankAccounts[index].withdraw(withdrawAmounts[index]) == withdrawTestResults[index]) {
        System.out.println("withdraw function succeeded.");
      } else {
        errorHorn();
        System.out.println("withdraw function failed at index: " + index);
      }
    }

    System.out.println("getBalance() TEST 2");
    double[] postWithdrawExpectedBal = {10000, 0, (10000 - 2048), 10000, 10000, (10000 - Math.PI)};
    for (int index = 0; index < bankAccounts.length; index++) {
      if (bankAccounts[index].getBalance() == postWithdrawExpectedBal[index]) {
        System.out.println("getBalance + withdraw function succeeded.");
      } else {
        errorHorn();
        System.out.println("Withdraw or getBalance function failed at index: " + index);
      }
    }
  }

  public static void toStringTester() {
    System.out.println("toString() Tester");
    int[] accountIDs = new int[10];
    for (int index = 0; index < accountIDs.length; index++) {
      accountIDs[index] = (int)(Math.random() * 100000000);
    }
    double[] accountBalances = new double[10];
    for (int index = 0; index < accountBalances.length; index++) {
      accountBalances[index] = Math.random() + Math.pow(10, Math.random() * 1000);
    }

    for (int index = 0; index < accountIDs.length; index++) {
      BankAccount account = new BankAccount(accountIDs[index], "");
      account.deposit(accountBalances[index]);
      String expectedString = accountIDs[index] + "\t" + accountBalances[index];
      if (expectedString.equals(account.toString())) {
        System.out.println("toString function succeeded.");
      } else {
        errorHorn();
        System.out.println("toString function failed.");
        System.out.println("Expected: " + accountBalances[index]);
        System.out.println("Received: " + account.toString());
      }
    }
  }

}
