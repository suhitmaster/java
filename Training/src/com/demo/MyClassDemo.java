package com.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask; 

class SinX implements Callable{
	int x;
	public SinX(int x) {
		this.x = x;
	} 
	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("T1 executing");
		return new String(x+"");
	}
	
}

class CosX implements Callable{
	int x;
	public CosX(int x) {
		this.x = x;
	} 

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("T2 executing");
		return new String(x+"");
	}
	
}
class TanX implements Callable{
	int x;
	public TanX(int x) {
		this.x = x;
	} 

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("T3 executing");
		return new String(x+"");
	}
	
}
public class MyClassDemo {
	
	public static void main(String[]cp) throws NumberFormatException, InterruptedException, ExecutionException {
		FutureTask fut1 = new FutureTask(new SinX(5));
		FutureTask fut2 = new FutureTask(new CosX(5));
		FutureTask fut3 = new FutureTask(new TanX(5));
		
		Thread t1 = new Thread(fut1);
		Thread t2 = new Thread(fut2);
		Thread t3 = new Thread(fut3);
		
		t1.start();
		t2.start();
		t3.start();
		
/*		t1.join();
		t2.join();
		t3.join();
*/		
		Integer x = Integer.parseInt(fut1.get()+"");
		Integer y = Integer.parseInt(fut2.get()+"");
		Integer z = Integer.parseInt(fut3.get()+"");
		System.out.println(x + y + z);
	}
}
