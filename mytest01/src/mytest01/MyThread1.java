package mytest01;

public class MyThread1 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();
	} 
}

class Outputer {
	public void outputer(String name) {
		int len = name.length();
		for (int i = 0; i < len; i++) {
			System.out.println(name.charAt(i));
		}
	}
}
