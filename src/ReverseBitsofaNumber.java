
public class ReverseBitsofaNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int reverseBits(int num) 
	{ 
		int count = num * 8 - 1; 
		int reverse_num = num; 
		
		num >>= 1; 
		while(num > 0) 
		{ 
		reverse_num <<= 1;	 
		reverse_num |= num & 1; 
		num >>= 1; 
		count--; 
		} 
		reverse_num <<= count; 
		return reverse_num; 
	} 
}
