package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'isBalanced' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String isBalanced(String s) {
		Stack<String> stack = new Stack<String>();
		String[] split = s.split("");
		
		for (int i = 0; i < split.length; i++) {
			if (isOpenBracket(split[i])) {
				stack.add(split[i]);
			} else {
				if (isCorrectClose(stack.peek(), split[i])) {
					stack.pop();
				} 
			}
		}
		
		if (stack.isEmpty())
			return "YES";
		else
			return "NO";
	}
	
	private static boolean isOpenBracket(String open) {
		return open.equals("{") || open.equals("[") || open.equals("(");
	}
	
	private static boolean isCorrectClose(String open, String close) {
		String openClose = open + close;
		return openClose.equals("{}") || openClose.equals("[]") || openClose.equals("()");
	}
	
//	public static String isBalanced(String s) {
//		List<String> openBrackets = new ArrayList<String>();
//		String[] split = s.split("");
//		for (int i = 0; i < split.length; i++) {
//			if (split[i].equals("{") || split[i].equals("[") || split[i].equals("(")) {
//				openBrackets.add(split[i]);
//			} else {
//				String closeBracket = split[i];
//				if (openBrackets.get(openBrackets.size() - 1).concat(closeBracket).equals("()")
//						|| openBrackets.get(openBrackets.size() - 1).concat(closeBracket).equals("[]")
//						|| openBrackets.get(openBrackets.size() - 1).concat(closeBracket).equals("{}")) {
//					openBrackets.remove(openBrackets.size() - 1);
//				}
//			}
//		}
//		
//		if (openBrackets.isEmpty())
//			return "YES";
//		else
//			return "NO";
//	}

}

public class SolutionBalancedBrackets {
	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//		IntStream.range(0, t).forEach(tItr -> {
//			try {
//				String s = bufferedReader.readLine();
//
//				String result = Result.isBalanced(s);
//
//				bufferedWriter.write(result);
//				bufferedWriter.newLine();
//			} catch (IOException ex) {
//				throw new RuntimeException(ex);
//			}
//		});
//
//		bufferedReader.close();
//		bufferedWriter.close();
		System.out.println(Result.isBalanced("{[()]}"));
		System.out.println(Result.isBalanced("{[(])}"));
		System.out.println(Result.isBalanced("{{[[(())]]}}"));
	}
}
