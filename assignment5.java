class BankAccount
{
	int AccountNumber;
	float balance;
	String OwnerName;
	BankAccount(int Acn, float bl,String name)
	{
		AccountNumber = Acn;
		balance = bl;
		OwnerName = name;
	}
	float balancef()
	{
		return balance;
	}
	void add(float amount)
	{
		balance += amount;
	}
	void subtract(float amount)
	{
		if(balance-amount < 0)
			System.out.println("Balance not suffiecient...");
		else
			balance -= amount;
	}
}
class AccountManager
{
	BankAccount []accounts;
	int accounts_count = 0;
	AccountManager(int NumberOfAccounts)
	{
		accounts = new BankAccount[NumberOfAccounts+1];
	}
	private static void replace(AccountManager AcM,int index1,int index2)
	{
		BankAccount temp = AcM.accounts[index1];
		AcM.accounts[index1] = AcM.accounts[index2];
		AcM.accounts[index2] = temp;
	}
	void create(int acno, float bal, String name)
	{
		if(accounts_count == accounts.length)
		{
			System.out.println("Bank array is full...");
			System.out.println("No more accounts can be added...");
		}
		else
		{
			accounts[accounts_count] = new BankAccount(acno,bal,name);
			accounts_count++;
		}
	}
	 void add(BankAccount ac)
        {
                if(accounts_count == accounts.length)
                {
                        System.out.println("Bank array is full...");
                        System.out.println("No more accounts can be added...");
                }
                else
                {
                        accounts[accounts_count] = ac;
                        accounts_count++;
                }
        }
	void remove(int acno)
	{
		for(int i=0; i<accounts_count;i++)
		{
			if(accounts[i].AccountNumber == acno)
			{
				if(i != accounts_count)
					replace(this,i,accounts_count-1);
				accounts[accounts_count] = null;
				accounts_count--;
			}
		}
	}
	void ShowAccounts()
	{
		for(int i=0; i<accounts_count ; i++)
		{
			if(accounts[i] != null)
			{
				System.out.println("Acount No. "+accounts[i].AccountNumber);
				System.out.println("Balance : "+ accounts[i].balance);
				System.out.println("Owner Name : " + accounts[i].OwnerName);
				System.out.println();
				System.out.println();
			}
		}
	}
}
class AccountDemo1
{
	public static void main(String []args)
	{
		AccountManager m1 = new AccountManager(5);
		BankAccount ac1 = new BankAccount(1023,50000,"Koushik Mahanta");
		BankAccount ac2 = new BankAccount(1024,70000,"Sumit Bagchi");
		BankAccount ac3 = new BankAccount(1025,60000,"Sayan Modak");
		BankAccount ac4 = new BankAccount(1026,100000,"Arnab Basu");
		BankAccount ac5 = new BankAccount(1027,110000,"Sayantak Basak");

		m1.add(ac1);
		m1.add(ac2);
		m1.add(ac3);
		m1.add(ac4);
		m1.add(ac5);
		
		m1.ShowAccounts();
		
	}
}					
