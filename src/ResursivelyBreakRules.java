import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class ResursivelyBreakRules {
	public static void main(String[] args) {
//		String expression = "affiliateId='12345' AND priority='0' OR TODAY='SUNDAY' AND HI='HELLO'";
		
		String expression = "1=1";
		
		expression = expression.toLowerCase().replaceAll(" and | or ", "=");
		
		Map<String, Object> rules = new HashMap<>();
		
		expression = expression.toLowerCase().replaceAll(" and " , "=").replaceAll(" or ", "=");
		
		String [] tokens = expression.split("=");
		
		if(tokens.length % 2 == 0) {
			int i = 0;
			for (; i < tokens.length; i++) {
					rules.put(tokens[i].replaceAll("'","").trim(), tokens[++i].replaceAll("'","").trim());
			}
		} else {
			throw new RuntimeException("Problem...");
		}
		System.err.println(rules);
		

	}
//	long equalsOcc = countOccurrences(expression, '=');
	/**
	 * String expression = "affiliateId='12345' AND priority='0' OR TODAY='SUNDAY'";
	 * 
	 * Map<String, Object> rules = new HashMap<>(); long equalsOcc = countOccurrences(expression, '=');
	 * while(rules.keySet().size() != equalsOcc) { if(expression.contains(" AND ")) { String [] ands =
	 * expression.split(" AND "); for (String and : ands) { String [] equals = and.split("=");
	 * rules.put(equals[0].replaceAll("'", "").trim(), equals[1].replaceAll("'", "").trim()); } if(expression.contains("
	 * OR ")) { String [] ors = expression.split(" OR "); for (String or : ors) { String [] equals = or.split("=");
	 * rules.put(equals[0].replaceAll("'", "").trim(), equals[1].replaceAll("'j", "").trim()); } }
	 * 
	 * } System.err.println(rules); }
	 * 
	 * String tokens [] = SPLIT(expression, ""); breakRules(rules, tokens, equalsOcc, expression);
	 * @param str
	 * @param ch
	 * @return
	 */
	private static long countOccurrences(String str, char ch) {
		return str.chars()
			.filter(c -> c == ch)
			.count();
	}

	private static void breakRules(Map<String, Object> rules, String[] tokens,
		long equalsOcc, String expression) {
		if (rules.keySet()
			.size() == equalsOcc)
			return;

		tokens = SPLIT(expression, "and");
	}

	private static String[] SPLIT(String expression, String splitBy) {
		return expression.split(splitBy);
	}
}
