public class Tester {

  public static void main(String[] args) {
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

}
