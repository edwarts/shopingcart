package com.adthena;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.sun.media.jfxmedia.control.VideoDataBuffer;

public class InputParseTest {

	public static String data="Apple milk soup";
	public static String dataWithQuanilty="Apple,1 milk,2 soup,3";
	@Test
	public void test() {
		
	}
	@Test
	public void splitInputBySpace()
	{
		String[] expecteds={"Apple","milk","soup"};
		String[] result=data.split(" ");
		assertArrayEquals(expecteds, result);
	}
	@Test
	public void splitInputProductAndQtyByGommaAndSpace()
	{
		HashMap<String, Integer> input=new HashMap<String, Integer>();
		String[] keyValueSet=dataWithQuanilty.split(" ");
		assertArrayEquals(keyValueSet,new String[]{"Apple,1","milk,2","soup,3"});
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
		assertEquals(input.get("Apple").intValue(), Integer.parseInt("1"));
		assertEquals(input.get("milk").intValue(), Integer.parseInt("2"));
		assertEquals(input.get("soup").intValue(), Integer.parseInt("3"));
		
	}
	@Test
	public void ValidateInput()
	{
		//two types of input are acceptable .
		//One is product name only
		//One is product name with qty. It is not so good to use Java to parse the pattern, scala is good at pattern matching using case class
		//because we can define case class string only and string,int and other _ 
		assertEquals(0, validate("Apple,1,1 milk,2 soup,3"));
		assertEquals(0, validate("Apple,1,1*# milk,2 soup,3"));
		assertEquals(1, validate("Apple,1 milk,2 soup,3"));
		assertEquals(2, validate("Apple milk soup"));
		
	}
	/*
	 * return 0 error
	 * return 1 product with qty
	 * return 2 product only
	 * */
	public int validate(String data)
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
	

}
