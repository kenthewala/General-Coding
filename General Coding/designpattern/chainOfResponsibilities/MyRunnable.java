package designpattern.chainOfResponsibilities;

public class MyRunnable implements Runnable {
	
	private long num;
	
	public MyRunnable(long num){
		this.num = num;
	}
	
	public static void main(String s[]){
		
		for(int i=1;i<=50;i++){
			Runnable runnable = new MyRunnable(100000+i);
			Thread executor = new Thread(runnable);
			
			executor.start();
			
			
			
		}
		
		
	}

	@Override
	public void run() {
		int sum = 0;
		for(int i=1;i<=num;i++){
			sum+=i;
		}
		System.out.println(sum);
	}
	

}
