package BitMagic;

public class BitWiseOperator {

	public static void main(String[] args) {
		Integer iNum = new Integer(10);
		System.out.println(Integer.toBinaryString(iNum));
		System.out.println(Integer.toBinaryString(-iNum));
		System.out.println(Integer.toBinaryString(~iNum));
		//iNum = -(~iNum);
		System.out.println(Integer.toBinaryString(-(~iNum)));
		System.out.println(Integer.toBinaryString(iNum >> 1));
		System.out.println(Integer.toBinaryString(iNum >>> 1));
		
		System.out.println(Integer.toBinaryString(iNum << 1));

	}

}
