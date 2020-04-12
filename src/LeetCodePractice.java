import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.omg.CosNaming.IstringHelper;

// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }
public class LeetCodePractice {

	public static void main(String[] args) {

		LeetCodePractice leetCodePractice = new LeetCodePractice();
		
		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		head = leetCodePractice.reverseBetween(head, 1, 2);
		
		int[] nums1 = {2, 7, 11, 15};
		int[] nums2 = {1, 2, 3, 5, 6, 7, 11, 15};
		double median = leetCodePractice.findMedianSortedArrays(nums1, nums2);

		String palindrome = leetCodePractice.longestPalindrome("ababd");

		String bin1 = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		String bin2 = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		String strSum = leetCodePractice.addBinary(bin1, bin2);

//		int[] nums = {2, 7, 11, 15};
//		twoSum(nums, 9);

//		int iLen = lengthOfLongestSubstring("au");
//		System.out.println(iLen);
//		int numRows = 5;
//		
//		List<List<Integer>> pascleTraingle = generate(numRows) ;
//		System.out.println(numRows);
//		System.out.println(pascleTraingle);
//		
//		List<Integer> pascleRowIndex = getRow(numRows);
//		System.out.println(pascleRowIndex);

	}


	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascleTraingle = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> pascleRow = new ArrayList<Integer>();
			if (i == 0) {
				pascleRow.add(1);
			}
			if (i > 0) {
				// pascleRow.add(1);
				for (int j = 0; j <= i; j++) {
					if (j == 0) {
						pascleRow.add(1);
					} else if (j > 0 && j < i) {
						pascleRow.add(pascleTraingle.get(i - 1).get(j) + pascleTraingle.get(i - 1).get(j - 1));
					} else if (j == i) {
						pascleRow.add(1);
					}
				}
			}
			pascleTraingle.add(pascleRow);
		}
		return pascleTraingle;
	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> pascleRowIndex = new ArrayList<Integer>();
		for (int i = 0; i < rowIndex; i++) {
			List<Integer> pascleRow = new ArrayList<Integer>();
			if (i == 0) {
				pascleRow.add(1);
			}
			if (i > 0) {
				// pascleRow.add(1);
				for (int j = 0; j <= i; j++) {
					if (j == 0) {
						pascleRow.add(1);
					} else if (j > 0 && j < i) {
						pascleRow.add(pascleRowIndex.get(j) + pascleRowIndex.get(j - 1));
					} else if (j == i) {
						pascleRow.add(1);
					}
				}
			}
			pascleRowIndex.clear();
			pascleRowIndex.addAll(pascleRow);
		}
		return pascleRowIndex;
	}

	public static int lengthOfLongestSubstring(String strInput) {
		int iStart = 0, iEnd = 0, iLen = 0;
		int[] indexArr = new int[256];
		// char strInput[51];
		// cin >> strInput;
		if (strInput.length() > 0) {
			iLen = 1;
			int iCharVal = strInput.charAt(0);
			indexArr[iCharVal] = 1;
			iStart = 1;
		}

		// for(int jTemp = 1; strInput[jTemp-1]!='\0'; jTemp++){
		for (int jTemp = 1; jTemp < strInput.length(); jTemp++) {
			int iCharVal = strInput.charAt(jTemp);

			if (indexArr[iCharVal] > 0 && (iStart < indexArr[iCharVal] + 1)) {
				iStart = indexArr[iCharVal] + 1;
			}
			indexArr[iCharVal] = jTemp + 1;
			iEnd = jTemp + 1;
			if (iLen < (iEnd - iStart + 1)) {
				iLen = iEnd - iStart + 1;
			}
			// cout <<iStart <<" "<<iEnd<<"."<< iLen<<"... " ;

		}
		// cout<<iLen<<endl;
		return iLen;
	}

	public String addBinary(String a, String b) {
		String binSum = new String();
		int iNuma = 0;
		int iNumb = 0, iSum = 0;
		for (int i = 0; i < a.length(); i++) {
			iNuma = iNuma << 1 | a.charAt(i) - '0';
		}
		for (int i = 0; i < b.length(); i++) {
			iNumb = iNumb << 1 | b.charAt(i) - '0';
		}
		iSum = iNuma + iNumb;
		for (int i = 0; iSum > 0; i++) {
			int iBin = 0;
			iBin = iSum & 1;
			iSum = iSum >> 1;
			binSum = iBin + binSum;
		}

		return binSum;
	}

	public boolean containsDuplicate(int[] nums) {
		boolean containsDuplicate = false;
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				containsDuplicate = true;
		}
		return containsDuplicate;
	}

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev= head;
            head = next;
        }
        return prev;
    }

	public static int[] twoSum(int[] nums, int target) {
		int[] retValue = new int[2];
		for (int i = 0; i < nums.length; i++) {
			retValue[0] = i + 1;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					retValue[1] = j + 1;
					j = nums.length;
					i = nums.length;
				}
			}
		}
		return retValue;
	}

	public String longestPalindrome(String s) {
		String palindrome = new String();
		int iStart = 0, iEnd = 0, iPlindromeStart = 0, iLen = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; i - j >= 0 && i + j + 1 < s.length(); j++) {
				if(s.charAt(i-j) == s.charAt(i+j+1)){
					iStart = i-j;
					iEnd = i+j+1;
				} else {
					break;
				}
				if(iLen < (iEnd - iStart + 1)) {
					iPlindromeStart = iStart;
					iLen = iEnd - iStart;
				}
			}
			for (int j = 1; i - j >= 0 && i + j + 1 < s.length(); j++) {
				if(s.charAt(i-j) == s.charAt(i+j)){
					iStart = i-j;
					iEnd = i+j;
				} else {
					break;
				}
				if(iLen < (iEnd - iStart)) {
					iPlindromeStart = iStart;
					iLen = iEnd - iStart;
				}
			}
		}
		palindrome = s.substring(iPlindromeStart, iPlindromeStart+iLen);
		return palindrome;
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double retValue = 0;
		int iLen1 = nums1.length;
		int iLen2 = nums2.length;
		double median1 = 0, median2 = 0; 
		if(iLen1 % 2 == 0) {
			median1 = (nums1[iLen1/2-1] + nums1[iLen1/2])/2;
		} else {
			median1 = nums1[iLen1/2];
		}
		
		if(iLen2 % 2 == 0) {
			median2 = (nums2[iLen2/2-1] + nums2[iLen2/2])/2;
		} else {
			median2 = nums2[iLen2/2];
		}
		
		
		return retValue;
	}

    public boolean isPalindrome(ListNode head) {
        boolean isPalindrome = false;
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(fastNode != null && fastNode.next != null) {
        	fastNode = fastNode.next.next;
        	slowNode = slowNode.next;
        	
        }
        
        return isPalindrome;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        
        ListNode mNode = head;
    	ListNode mPrevNode = null;
    	ListNode nNode = head;
    	ListNode nNextNode = head;
    	int i = 1;
    	for(; i < m; i++) {
    		mPrevNode = mNode;
	    	mNode = mNode.next;
	    	nNode = mNode;
	    	nNextNode = mNode;
    	}
    	mNode = null;
    	for(; i <= n ; i++) {
            ListNode next = null;
            if(nNextNode.next!= null)
                next = nNextNode.next;
            nNextNode.next = mNode;
            mNode = nNextNode;
            nNextNode = next;
    	}

    	if(mPrevNode != null)
    		mPrevNode.next = mNode;
    	else 
    		head = mNode;
    	nNode.next = nNextNode;
    	
    	return head;
        
    }
    
}
