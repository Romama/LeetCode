package basics;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int rules = in.nextInt();
		int test = in.nextInt();
		
		in.nextLine();
		
		//获得规则
		String[] ruleStr = new String[rules];
		//输入ip
		String[] ips = new String[test];
		if(in.hasNext()){
			
			for(int i = 0; i< rules;i++){
				ruleStr[i] = in.nextLine();
			}
			for(int i = 0; i< test;i++){
				ips[i] = in.nextLine();
			}
			
		}
		
		
		String[] ipStr = new String[4];
		String[] testIP = new String[4];
		
		int mask = 0;
		String flag = "";
		int indexFlag = 0;
		int indexMask = 0;
		String ruleIp = "";
		for(int i = 0; i< test;i++){
			int j = 0;
			for(j = 0; j< rules;j++){
				String str = ruleStr[j];
				indexFlag = str.indexOf(' ');
				flag = str.substring(0,indexFlag);
				
				indexMask = str.indexOf('/');
				
				if(indexMask != -1){ //有子网掩码
					ruleIp = str.substring(indexFlag + 1,indexMask);
					 mask = Integer.parseInt(str.substring(indexMask + 1,str.length()));
					 ipStr = ruleIp.split("[.]");
					 testIP = ips[i].split("[.]");
					 int ipStrn = 0;
					 int testIpn = 0;
					 if(mask <= 8){
						 ipStrn = Integer.parseInt(ipStr[0]) >> (8 - mask);
					     testIpn = Integer.parseInt(testIP[0]) >> (8 - mask);
		                 if(ipStrn == testIpn){
		                	 if(flag.equals("allow"))
								System.out.println("YES");
							 else {
								System.out.println("NO");
							 }
		                	 break;
		                 } else {
							continue;
						 }
					 } else if(mask > 8 && mask <= 16){
						 if(ipStr[0].equals(testIP[0])){
							 ipStrn = Integer.parseInt(ipStr[1]) >> (16 - mask);
						     testIpn = Integer.parseInt(testIP[1]) >> (16 - mask);
						     if(ipStrn == testIpn){
			                	 if(flag.equals("allow"))
									System.out.println("YES");
								 else {
									System.out.println("NO");
								 }
			                	 break;
			                 } else {
								continue;
							 }
						 } else {
							continue;
						}
					 }  else if(mask > 16 && mask <= 24){
						 if(!ipStr[0].equals(testIP[0]) || !ipStr[1].endsWith(testIP[1])){
							 continue;
						 } else {
							 ipStrn = Integer.parseInt(ipStr[2]) >> (24 - mask);
						     testIpn = Integer.parseInt(testIP[2]) >> (24 - mask);
						     if(ipStrn == testIpn){
			                	 if(flag.equals("allow"))
									System.out.println("YES");
								 else {
									System.out.println("NO");
								 }
			                	 break;
			                 } else {
								continue;
							 }
						 }
					 } else if(mask > 24 && mask <= 32){
						 if(!ipStr[0].equals(testIP[0]) || !ipStr[1].endsWith(testIP[1]) ||  !ipStr[2].endsWith(testIP[2])){
							 continue;
						 } else {
							 ipStrn = Integer.parseInt(ipStr[3]) >> (32 - mask);
						     testIpn = Integer.parseInt(testIP[3]) >> (32 - mask);
						     if(ipStrn == testIpn){
			                	 if(flag.equals("allow"))
									System.out.println("YES");
								 else {
									System.out.println("NO");
								 }
			                	 break;
			                 } else {
								continue;
							 }
						 }
					 } else {//异常情况
						
					 }
					  
				} else { //没有子网掩码
					if(ruleIp.equals(ips[i]) ){
						if(flag.equals("allow"))
						    System.out.println("YES");
						else {
							System.out.println("NO");
						}
						 break;
					} else {
						continue;
					}
				}
			}
			
			if(j == rules)
				System.out.println("YES");
		}
	}
}
