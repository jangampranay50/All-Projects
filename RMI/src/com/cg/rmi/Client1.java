package com.cg.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class Client1
{
public static void main(String args[]) throws RemoteException
{
Client1 c=new Client1();
c.connectRemote();
}
private void connectRemote() throws RemoteException
{
try{
Scanner sc=new Scanner(System.in);
Registry reg=LocateRegistry.getRegistry("localhost",9999);
Adder1 ad=(Adder1)reg.lookup("h1 server1");
System.out.println("Enter two numbers:");
int a=sc.nextInt();
int b=sc.nextInt();
System.out.println("Addition is: "+ad.add(a,b));
}
catch(NotBoundException|RemoteException e)
{
System.out.println("Exception :"+e);
}
}
}