package org.doInJava.SimplePrograms;

public class CountNumberOfObjects implements Cloneable{
	
	public static int counterForObject = 0;
	
	{
		counterForObject ++;
	}
	
	public static Integer getNumberOfInstances() {
		return counterForObject;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		CountNumberOfObjects obj1 = new CountNumberOfObjects();
		CountNumberOfObjects obj2 = new CountNumberOfObjects();
		CountNumberOfObjects obj3 = new CountNumberOfObjects();
		CountNumberOfObjects obj4 = new CountNumberOfObjects();
		CountNumberOfObjects obj5 = new CountNumberOfObjects();
		CountNumberOfObjects obj = obj5;
		CountNumberOfObjects obj6 = (CountNumberOfObjects) obj5.clone();
		
		System.out.println("Hashcodes are : "+obj.hashCode()+ " :: "+obj5.hashCode());
		
		System.out.println("Hashcodes are : "+obj6.hashCode()+ " :: "+obj5.hashCode());
		
		System.out.println("Number of objects created is : "
				+ ""+CountNumberOfObjects.getNumberOfInstances());
	}

}
