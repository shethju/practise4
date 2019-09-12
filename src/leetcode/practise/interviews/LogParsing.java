package leetcode.practise.interviews;

// Google
public class LogParsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "[10:30] <  > hello there!";
		String str2 = "Wed 05/31 @ server01 <martha>	hello!hello!";
		System.out.println(getUsername(str2));
	}

	private static String getUsername(String log) {
		if (log == null) return null;
		int startIndex = -1;
		int endIndex = -1;
		for (int i=0; i < log.length(); i++) {
			if (log.charAt(i) == '<') {
				startIndex = i+1;
			} else if (log.charAt(i) == '>') {
				endIndex = i;
				break;
			}
		}
		if (endIndex != -1 && startIndex != -1 && endIndex >= startIndex) {
			System.out.println("startIndex:" + startIndex + ", endIndex:" + endIndex);
			return log.substring(startIndex, endIndex);
		}
		return null;
	}
	
	private static int getWordCount(String log) {
		if (log == null) return -1;
		int wordCount = -1;
		int startIndex = -1;
		for (int i=0; i < log.length(); i++) {
			if (log.charAt(i) == '>') {
				startIndex = i;
				break;
			}
		}
		if (startIndex > 1) {
			for (int i= startIndex+1; i < log.length(); i++) {
				
			}
		}
	}
}
