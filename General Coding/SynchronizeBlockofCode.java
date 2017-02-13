
public class SynchronizeBlockofCode extends Thread {
	private StringBuffer buffer ;
	
	@Override
	public void run() {
		//synchronized (buffer) {
			for(int i=1;i<=100;i++){
				System.out.println(getBuffer());
			}
			System.out.println();
				char temp = buffer.charAt(0);
				++temp;
				buffer.setCharAt(0, temp);
			
	//	}
	}
	
	public SynchronizeBlockofCode(StringBuffer buffer){
		this.buffer = buffer;
	}

	public StringBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(StringBuffer buffer) {
		this.buffer = buffer;
	}
	
	public static void main(String args[]){
		StringBuffer sbufferA = new StringBuffer("A");
		
		
		SynchronizeBlockofCode sbc1 = new SynchronizeBlockofCode(sbufferA);
		SynchronizeBlockofCode sbc2 = new SynchronizeBlockofCode(sbufferA);
		SynchronizeBlockofCode sbc3 = new SynchronizeBlockofCode(sbufferA);
		
		sbc1.start();
		sbc2.start();
		sbc3.start();
		
	}
	
	

}
