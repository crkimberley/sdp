public class Driver {
    public static void main(String[] args) {
        Storage<BankAccount> aStorage = new Storage<>();
        Storage<String> sStorage = new Storage<>();

        // Class baCls = BankAccount.class;
        // (6) replace Class baCls with Class<BankAccount> baCls
        Class<BankAccount> baCls = BankAccount.class;
        // Compiles successfully again - no errors...as objects defined correctly

        try {
            // (3) Object myAccount =  baCls.newInstance();
            // Error: ...java: incompatible types: java.lang.Object cannot be converted to BankAccount

            // (4) replace Object with BankAccount
            // BankAccount myAccount =  baCls.newInstance();
            // Error: ...java: incompatible types: java.lang.Object cannot be converted to BankAccount

            // (5) add an explicit dynamic cast (ie. performed by Java runtime environment (JVM))
            // although after Step(6) above - this is now redundant
            BankAccount myAccount = (BankAccount) baCls.newInstance();
            aStorage.setValue(myAccount);

            // Deposit
            myAccount.deposit(15);

            // (7) following code added
            System.out.println(aStorage.getValue().showBalance());
            if(aStorage.getClass() == sStorage.getClass()) {
                System.out.println("EQUAL");
            } else {
                System.out.println("NOT EQUAL");
            }
            // run-time output...
            // 115.0
            // EQUAL
            //
            // 115 is the new balance (100 + 15)
            // EQUAL as both Storage<> - Type Erasure strips parameters
        }

        catch ( InstantiationException e ) {
        // ...
        }
        catch ( IllegalAccessException e ) {
        // ...
        }
    }
}