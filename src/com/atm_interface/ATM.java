package com.atm_interface;

import java.util.HashMap;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		
		Operation obj = new Operation();
		
	}

}

class Data
{
	float balance;
	
}


class Operation
{
	int transactions;
	Scanner sc =new Scanner(System.in);
	HashMap<Integer, Data>map=new HashMap<>();
	Operation()
	{
		System.out.println("*********************************************");
		System.out.println("\tWelcome to ATM Services");
		opr();
		
	}
	
	
	public void opr()
	{
		System.out.println("\n*********************************************");
		System.out.println("Enter your Pin: ");
		int pin = sc.nextInt();
		if (pin == 1234)
		{
			if(map.containsKey(pin) == true)
			{
				Data obj = map.get(pin);
				menu(obj);
				
				
			}
			else 
			{
				System.out.println("*********************************************");

				System.out.println("Press Number key to continue");
				int key = sc.nextInt();
				
				Data obj = new Data();
				map.put(key, obj);
				menu(obj);
				
			}
		}
		
	}
	
	public void menu(Data obj)
	{
		
		
		System.out.println("\nEnter Choice: ");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit Money");
		System.out.println("3. Withdraw Money");
	    System.out.println("4. Transfer Money");
		System.out.println("5. exit\n");
		
		int n = sc.nextInt();
		
		if(n==1)
		{
			check_balance(obj);
		}
		
		else if(n==2)
		{
			deposit(obj);
		}
		
		else if(n==3)
		{
			withdraw(obj);
		}
		
		else if(n==4)
		{
			transfer(obj);
		}
		
		else if(n==5)
		{
			System.out.println("Thank You");
		}
		
		else 
		{
			System.out.println("Enter Valid Choice...");
			menu(obj);
		}
	}
	
	public void check_balance(Data obj)
	{
		System.out.println("\n=========================================");
		System.out.println("\n Your Balance " + obj.balance);
		System.out.println("\n=========================================");
		menu(obj);
		
	}
	
	public void deposit(Data obj)
	{
		System.out.println("\n Enter the Amount you want to Deposit ");
		float amt = sc.nextFloat();
		
		obj.balance = obj.balance + amt;
		
		System.out.println("\n Amount deposited Successfully");
		menu(obj);
	}
	
	public void withdraw(Data obj)
	{
		System.out.println("\n Enter the Amount ");
		float amt = sc.nextFloat();
		if(obj.balance>= amt)
		{
			obj.balance=obj.balance-amt;
			System.out.println("\n Amount Withdraw Successfully");
		}
		else
		{
			System.out.println("Insufficient Balance");
		}
		
		menu(obj);
	}
	
	public void transfer(Data obj)
	{
		 System.out.print("\nEnter Receipent's Account Number ");
	        int receipent = sc.nextInt();
	        System.out.print("\nEnter the amount to transfer");
	        float amt = sc.nextFloat();
	        try 
	            {
	            if ( obj.balance >= amt ) 
	            {
	                if ( amt <= 20000 ) 
	                {
	                    
						transactions++;
	                    obj.balance -= amt;
	                    System.out.println("==============================================");
	                    System.out.println("Successfully Transfered: " + receipent);
	                    String str = amt + " Rs transfered to " + receipent + "\n";
	                    
                        
	                }
	                else 
	                {
	                    System.out.println("Limit is 20000");
	                }
	            }
	            else 
	            {
	                System.out.println("\nInsufficient Balance");
	            }
	        }
	        catch (Exception e) 
	        {
	           
	        }
	        
	        menu(obj);
	}

}

