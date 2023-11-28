package main;
import java.security.ProtectionDomain;
import java.awt.desktop.AboutHandler;
import java.io.*;
import java.lang.System.Logger;
import java.util.*;

import javax.print.attribute.standard.Media;

import containers.*;
import ports.*;
import ships.*;


public class Main {
	public static void main(String[] args) throws IOException {
		Random rand = new Random();
		// TODO Auto-generated method stub	
		int shipid = rand.nextInt(100);
		Scanner in = new Scanner(System.in);
		List<Ports> port = new ArrayList<Ports>();
        List<Container> contlist = new ArrayList<Container>();
        List<String> customer = new ArrayList<String>();
        String portdesto=null;
        String portsrc=null;
        String cust_name = null;
        String cust_address=null;
        String cust_identity=null;
        int access=0;
        
//*****************************Admin Creation*************************************
        System.out.println("************************************************LOGIN SCREEN**************************************************");
        System.out.println("Login as User or Admin");
        System.out.println("1. User"+"\n"+"2. Admin");
        
        int user = in.nextInt();

			
        switch (user) {
		case 1:
			
		
       
			

//*****************************Customer Creation*********************************
        System.out.println("***************************************Port Management************************************************************************************************************");
        System.out.println("Enter Name,Address and Customer Identity");
        cust_name = in.next();
        cust_address = in.next();
        cust_identity = in.next();
        System.out.println("***************************************User  "+ cust_name+"*************************************************************************************************");
        customer.add(cust_name);
        try {
        	File file = new File("C:\\Users\\KAILASHA\\Downloads\\Port-Management-main\\Port-Management-main\\src\\main\\example_input.txt") ;
        	FileWriter fr = new FileWriter(file,true) ;
        	BufferedWriter br = new BufferedWriter(fr);
        	br.write("************************************************LOG*******************************************************************************\n");
        	br.write("Customer Name: "+ cust_name+ "\n");
        	br.write("Customer Address: "+ cust_address+ "\n");
        	br.write("Customer Identity: "+ cust_identity+ "\n");
        	br.close();
        	
        }
        catch (IOException e) {
			// TODO: handle exception
        	System.out.println("error occured");
        	e.printStackTrace();
		}
        
// **************************** Port Creation **********************************
        String[] ports = {"Chennai","Kochi","Mumbai","Dubai"};
        int [] portnum = {1,2,3,4};
        for(int i=0;i<4;i++) {
            Ports n = new Ports(portnum[i],ports[i]);
            port.add(n);
        }
        System.out.println("The following is the Port names and its Ids");
        for(int i=0;i<4;i++) {
            System.out.println(port.get(i).id);
            System.out.println(port.get(i).name);
//            port.get(i).disp();
        }
		System.out.println("Enter no. of containers");
        
// ************************* Weight of Containers *******************************        
		int n;
		List<String> contOut = new ArrayList<String>();
		n=in.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the weight of the container");
            int p = in.nextInt();
            if(p<300) {
                System.out.println("Enter the container ID ");
                int ContID = in.nextInt();
                Container cont;
                cont = new BasicContainer(ContID,p);
                contlist.add(cont);
                contOut.add("Basic");
            }
            else {

                System.out.println("Enter the container ID ");
                int ContID = in.nextInt();
                System.out.println("Enter  R or r for Refrigerated heavy container");
                System.out.println("Enter L or l for Liquidated heavy container");
                System.out.println("Enter D or d for default heavy container");
                char a = in.next().charAt(0);
                if(a=='R' || a=='r') {
                    Container cont;
                    cont = new RefrigeratedContainer(ContID,p);
                    contlist.add(cont);
                    System.out.println(cont.totalWeight);
                    contOut.add("HeavyReferegerated");
                    
                }
                else if (a=='L' || a=='l') {
					Container cont;
					cont = new LiquidContainer(ContID, p);
					contlist.add(cont);
					System.out.println(cont.totalWeight);
					contOut.add("HeavyLiquid");
				}
                else if (a=='D' || a=='d') {
					Container cont;
					cont = new HeavyContainer(ContID, p);
					contlist.add(cont);
					System.out.println(cont.totalWeight);
					contOut.add("Heavy");
                }
        }
            }
//**********************************Port Destination and Choice of Port****************

        int flag=0;
        String portnameuser;
        int delay = 0,arrive = 0;
        ArrayList<String> portname = new ArrayList<String>();
        ArrayList<Integer> orderli = new ArrayList<Integer>();
        System.out.println("Enter Destination");
        portdesto = in.next();
        System.out.println("Enter Source");
        portsrc = in.next();
        System.out.println("**********************************INVOICE******************************************************************");
        System.out.println("Customer Name: "+ cust_name);
        System.out.println("Customer Address: "+ cust_address);
        System.out.println("Destination: "+ portdesto);
        System.out.println("Source: "+ portsrc);
        System.out.println("Ship ID: "+ shipid);
        
        System.out.println("================Port Visit================================================");
        int order=0;
        while(flag==0) {
            System.out.println("Enter the corresponding port name to visit");
            System.out.println("Enter 0 to close");
            portnameuser = in.next();   
            if(portnameuser.charAt(0) == '0') {
                flag=1;
            }
            int portex=Integer.MIN_VALUE;
            for(int i=0;i<4;i++) {
                if(portnameuser.equals(port.get(i).name)) {
                    portex=i;
                    order++;
                    portname.add(portnameuser);
                    orderli.add(order);
                    System.out.println("Current Port is: "+ portnameuser);
                    
                }   
            }

             if(portex == Integer.MIN_VALUE) {
                System.out.println(" ");
                continue;
            }
             port.get(portex).hist(shipid,order);
             port.get(portex).unload();
             port.get(portex).load(2000);
             System.out.println(portex);
             for(int i=0;i<portname.size();i++) {
            	 if(portname.contains(portdesto)) {
            		 
            		 System.out.println(cust_name+" Your Shipment has Arrived");delay=0; break;
            	 }
            	 else {
            		 System.out.println(cust_name+" Your Shipment has been Delayed"); delay ++;break;
            	 }
             }

        }

        for(int i=0;i<4;i++) {
        	port.get(i).disp();
        }
        int a = Container.totalWeight;
        System.out.println(a);
        
  
        try {
        	File file = new File("C:\\Users\\KAILASHA\\Downloads\\Port-Management-main\\Port-Management-main\\src\\main\\log.txt") ;
        	FileWriter fr = new FileWriter(file,true) ;
        	BufferedWriter br = new BufferedWriter(fr);
        	br.write("************************************************LOG*******************************************************************************\n");
        	br.write("Customer Name: "+ cust_name+ "\n");
        	br.write("Ship id: "+ shipid+"\n");
        	br.write("Destination: "+portdesto+"\n");
        	br.write("Source: "+ portsrc+"\n");
        	br.write("FinalWeight: "+ a+ "\n");
        	br.write("Ports Visited: " +portname +"\n");
        	br.write("Order Visited: " +orderli+ "\n");
        		br.write("Containers loaded: " + contOut+"\n" );
        		if(delay>0) {
        			br.write("Customer's Shipment is Delayed "+"\n");
        			br.write("Current Port: "+ portname.get(portname.size()-1)+"\n");
        		}
        		else {
        			br.write("Customer's Shipment has Arrived at destination: "+ portname.get(portname.size()-1)+"\n");
        		}
      		//Mywrite.wait("Current ship location: " + )
        	br.close();
        	
        }
        catch (IOException e) {
			
        	System.out.println("error occured");
        	e.printStackTrace();
		}

        break;
        
        
        case 2:
        	access=0;
        	System.out.println("***********************************************ADMIN******************************************************************************");
        	System.out.println("================================ Which Do u wish to access? ===================");
        	System.out.println("1. User Details\n"+"2.Log");
        	int adminAccess = in.nextInt();
        	if(adminAccess==1) {
        		File file = new File("C:\\Users\\KAILASHA\\Downloads\\Port-Management-main\\Port-Management-main\\src\\main\\user.txt");
    			BufferedReader br = new BufferedReader(new FileReader(file));
    			String st;
    	        while ((st = br.readLine()) != null)
    	            System.out.println(st);
        		 
        	}
        	else {
			File file = new File("C:\\Users\\KAILASHA\\Downloads\\Port-Management-main\\Port-Management-main\\src\\main\\log.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
	        while ((st = br.readLine()) != null)
	            System.out.println(st);

			break;
        }
        }
	
        
        
	}
        
	}


