public class DriverBankAccountTest{
  public static void main(String[]args){
      BankAccount b1 = new BankAccount(1000001, "abc123");
      BankAccount b2 = new BankAccount(1000231, "abcasdg23");

      System.out.println("Account b1:");
      b1.deposit(3000.0);
      b2.deposit(1234.0);
      System.out.println(b1);
      System.out.println("Account b2:");
      System.out.println(b2);
      System.out.println();


      double cashAmount = 300.0;
      System.out.println("EXPECT OUTPUT LIKE OTHER");
      while(cashAmount < 3000){
        System.out.println("Attempt to move $"+cashAmount+" from the b1 to b2 account:");
        if(b1.transferTo(b2, cashAmount, "abc123") ){
          System.out.println(b1);
          System.out.println(b2);
          System.out.println();
        }else{
          System.out.println("Transfer Failed");
        }

        cashAmount *= 2;
      }

      System.out.println("EXPECT FAILURE");
      b1 = new BankAccount(1000001, "abc123");
      b2 = new BankAccount(1000231, "abcasdg23");
      b1.deposit(3000.0);
      b2.deposit(1234.0);
      cashAmount = 300.0;
      while(cashAmount < 3000){
        System.out.println("Attempt to move $"+cashAmount+" from the b1 to b2 account:");
        if(b1.transferTo(b2, cashAmount, "abc12w") ){
          System.out.println(b1);
          System.out.println(b2);
          System.out.println();
        }else{
          System.out.println("Transfer Failed");
          System.out.println(b1);
          System.out.println(b2);
          System.out.println();
        }

        cashAmount *= 2;
      }
    }

}
