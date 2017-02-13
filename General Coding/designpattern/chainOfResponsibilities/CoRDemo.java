/**
 * 
 */
package designpattern.chainOfResponsibilities;

/**
 * @author anoop
 *
 */
abstract class DenominationCassette {
	
	public static final int THOUSAND = 1000;
	public static final int FIVE_HUNDRED = 500;
	public static final int HUNDRED = 100;
	
	public DenominationCassette nextCassette;
	
	public int balanceAmount;

	public DenominationCassette getNextCassette() {
		return nextCassette;
	}

	public void setNextCassette(DenominationCassette nextCassette) {
		this.nextCassette = nextCassette;
	}

	public void chain(int amount){
		balanceAmount = amount;
		DenominationCassette currentCassette = this;
		do{
			balanceAmount = currentCassette.drawAmount(balanceAmount);
			currentCassette = currentCassette.getNextCassette();
		}while(balanceAmount>0);
	}
	
	public abstract int drawAmount(int amount);

}

class ThousandsCassette extends DenominationCassette{
	
	public ThousandsCassette(int amount) {
		this.balanceAmount = amount;
	}
	
	@Override
	public int drawAmount(int amount) {
		System.out.print("no. of thousand notes" + amount/THOUSAND);
		return amount%THOUSAND;
	}
}

class FiveHundredCassette extends DenominationCassette{
	
	public FiveHundredCassette(int amount) {
		this.balanceAmount = amount;
	}
	
	@Override
	public int drawAmount(int amount) {
		System.out.println("\nno. of five hundred notes" + amount/FIVE_HUNDRED);
		return amount%FIVE_HUNDRED;
	}
}

class HundredCassette extends DenominationCassette{
	
	public HundredCassette(int amount) {
		this.balanceAmount = amount;
	} 
	@Override
	public int drawAmount(int amount) {
		System.out.println("\nno. of hundred notes" + amount/HUNDRED);
		return amount%HUNDRED;
	}
}

public class CoRDemo{
	
	public static DenominationCassette getChainOfResponsibilities(){
		DenominationCassette tc = new ThousandsCassette(0);
		DenominationCassette fhc = new FiveHundredCassette(0);
		DenominationCassette hc = new HundredCassette(0);
				
		tc.setNextCassette(fhc);
		fhc.setNextCassette(hc);
		
		return tc;
	}
	
	
	public static void main (String args[]){
		
		int amount = 5600;
		
		CoRDemo.getChainOfResponsibilities().chain(amount);
	}
}

