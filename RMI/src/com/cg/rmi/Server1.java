package com.cg.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server1 extends UnicastRemoteObject implements Adder1
{
public Server1() throws RemoteException
{
super();
}
 public int add(int n1, int n2)  throws RemoteException
{
return(n1+n2);
}


public static void main(String args[]) throws RemoteException{
    try{
Registry reg=LocateRegistry.createRegistry(9999);
reg.rebind("hi server1", new Server1());
System.out.println("Server is ready");
        }
            catch(RemoteException e)
             {
                System.out.println("Exception :"+e);
              }
}
}