public class Tester {

  public static void main(String[] args) {
    idTester();
    balanceTester();
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
    int[] depositAmounts = {0, 121321321, -21432, -2, 1};
    boolean[] depositTestResults = {true, true, false, false, true};
    BankAccount[] bankAccounts = new BankAccount[5];

    for (int index = 0; index < bankAccounts.length; index++) {
      BankAccount account = new BankAccount(1, "");
      bankAccounts[index] = account;
    }

    System.out.println("deposit() TEST");
    for (int index = 0; index < depositAmounts.length; index++) {
      if (bankAccounts[index].deposit(depositAmounts[index]) == depositTestResults[index]) {
        System.out.println("deposit function succeeded.");
      } else {
        errorHorn();
        System.out.println("deposit function failed");
      }
    }

    System.out.println("getBalance() TEST");
    int[] expectedBal = {0, 121321321, 0, 0, 1};
    for (int index = 0; index < expectedBal.length; index++) {
      if (bankAccounts[index].getBalance() == expectedBal[index]) {
        System.out.println("getBalance + deposit function succeeded.");
      } else {
        errorHorn();
        System.out.println("Depoist or getBalance function failed");
      }
    }

  }

}
