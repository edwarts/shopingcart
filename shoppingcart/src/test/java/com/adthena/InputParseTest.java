package com.adthena;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.adthena.utility.InputHelper;


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
		String[] result=InputHelper.splitInputBySpace(data);
		assertArrayEquals(expecteds, result);
	}
	
	@Test
	public void splitInputProductAndQtyByGommaAndSpace()
	{
		HashMap<String, Integer> input=new HashMap<String, Integer>();
		String[] keyValueSet=dataWithQuanilty.split(" ");
		assertArrayEquals(keyValueSet,new String[]{"Apple,1","milk,2","soup,3"});
		input=InputHelper.splitInputProductAndQtyByGommaAndSpace(dataWithQuanilty);

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
		assertEquals(0, InputHelper.validate("Apple,1,1 milk,2 soup,3"));
		assertEquals(0, InputHelper.validate("Apple,1,1*# milk,2 soup,3"));
		assertEquals(0, InputHelper.validate("Apple,1,1*# milk,2 soup,3"));
		assertEquals(1, InputHelper.validate("Apple,1 milk,2 soup,3"));
		assertEquals(2, InputHelper.validate("Apple milk soup"));
		
	}
	
	

}
