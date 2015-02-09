package com.adthena.utility;

import java.util.HashMap;

public class InputHelper {
	
	/*
	 * return 0 error
	 * return 1 product with qty
	 * return 2 product only
	 * */
	public static int validate(String data)
	{
		char[] dataToParse=data.toCharArray();
		for(int i=0;i<dataToParse.length;i++)
		{
			char testChar=dataToParse[i];
			if((testChar>='a'&&testChar<='z')||(testChar>='A'&&testChar<='Z')||(testChar==' ')||(testChar==',')||((testChar>='0')&&(testChar<='9'))) //only those accept 
			{
				
			}
			else {
				return 0;// error
			}
		}
		if(data.indexOf(" ")>=1&&(data.indexOf(",")!=-1))
		{
			for (String oneData:data.split(" ")) {
				int k=oneData.indexOf(",");
				if(oneData.split(",").length==2)
				{
					//
				}
				else {
					return 0;
				}
			}
			return 1; //product with qty
		}
		if((data.indexOf(" "))>=1&&(data.indexOf(",")==-1))
		{
			
			return 2; //product only
		}
		return 0;
	}
	public static String[] splitInputBySpace(String data)
	{
		return data.split(" ");
	}
	public static HashMap<String, Integer> splitInputProductAndQtyByGommaAndSpace(String dataWithQuanilty)
	{
		HashMap<String, Integer> input=new HashMap<String, Integer>();
		String[] keyValueSet=dataWithQuanilty.split(" ");
		for (String keyValue : keyValueSet) {
			String[] productNameAndQty=keyValue.split(",");
			if(keyValue.indexOf(",")==-1)
			{
				input.put(productNameAndQty[0], 0);
			}
			else {
				input.put(productNameAndQty[0], Integer.parseInt(productNameAndQty[1]));
			}
			
		}
		return input;
	}

}
