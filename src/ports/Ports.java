package ports;
import java.util.*;
import main.*;
import containers.*;

public class Ports {
	public int id;
	public Container c1;
	public String name;
	Scanner in =  new Scanner(System.in);
	ArrayList<Integer> hist = new ArrayList<Integer>();
	ArrayList<Integer> visitport = new ArrayList<>();
	public Ports (int id , String name) {
		this.id = id;
		this.name =name;
	}

	public void hist(int shipid, int portex) {
		hist.add(shipid);
		visitport.add(portex);
	}
	public void disp() {
		System.out.println(hist);
		System.out.println(visitport);
	}

	public void unload() {
		System.out.println("Press Y To unload some weight,N to not unload anything");
		String userinp=in.next();
		if(userinp.charAt(0)=='Y' || userinp.charAt(0) == 'y') {
			int sizeofCont=0;
			System.out.println("Unloading........");
			System.out.println("Enter size to be unloaded");
			sizeofCont=in.nextInt();
			int minu = c1.getTotalWeight();
			minu = minu-sizeofCont;
			c1.setTotalWeight(minu);
			System.out.println(minu);
		}
		if(userinp.charAt(0)=='N'|| userinp.charAt(0) == 'y') {
			System.out.println("no is selected");
		}
	}
	
	
	public void load(int capacity) {
		System.out.println("Press Y To load some weight,N to not unload anything");
		String userinp=in.next();
		if(userinp.charAt(0)=='Y'|| userinp.charAt(0) == 'y') {
			int sizeofCont=0;
			System.out.println("Loading Containers....");
			System.out.println("Enter size to be loaded");
			sizeofCont=in.nextInt();
			int minu = c1.getTotalWeight();
			if((minu+sizeofCont)>capacity) {
				System.out.println("The capacity cannot be added");
			}
			minu = minu+sizeofCont;
			c1.setTotalWeight(minu);
			System.out.println(minu);
		}
		if(userinp.charAt(0)=='N'|| userinp.charAt(0) == 'n') {
			System.out.println("no is selected");
		}
	}
}
