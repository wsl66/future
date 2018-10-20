package mytest01;

public class TestThread {
	public static void main(String[] args) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
			}
		}).start();
		
		new Thread(){
			@Override
			public void run(){
				// 执行的代码
			}
			
		}.start();

	}
	
}
