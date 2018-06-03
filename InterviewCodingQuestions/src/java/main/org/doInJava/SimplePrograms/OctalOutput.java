package org.doInJava.SimplePrograms;

public class OctalOutput {

	public static void main(String[] args) {
		Integer a = 010; // octal 10 ----> 8 in decimal
		System.out.println(a);
		Integer aa = new Integer(0100);
		System.out.println(aa);
		
		Integer b = 0x10; // hexadecimal 10 ----> 16 in decimal
		System.out.println(b);
		Integer bb = new Integer(0x100);
		System.out.println(bb);
		
	}

}
