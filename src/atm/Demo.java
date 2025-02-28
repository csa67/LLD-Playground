package atm;

public class Demo {
    public static void main(String[] args) {
        BankingService bankingService = new BankingService();
        Dispenser dispenser = new Dispenser(100000);
        ATM atm = new ATM(bankingService, dispenser);

        bankingService.createAccount("12345",1000);
        bankingService.createAccount("5678",200.0);

        Card card = new Card("678922","1234");
        bankingService.addCardToAccount(card, "12345");

        double balance = atm.checkBalance("12345");
        System.out.println(balance);

//        Card duplicateCard = new Card("678922","1235");
//        atm.withdraw(500.0,duplicateCard);
       // Incorrect pin - Caught Error

//        Card duplicateCard2 = new Card("6789212","1234");
//        atm.withdraw(500.0,duplicateCard2);
        //Incorrect Card

        //correct card
        atm.withdraw(500.0,card);

        balance = atm.checkBalance("12345");
        System.out.println(balance);

        atm.withdraw(600, card);

    }
}
