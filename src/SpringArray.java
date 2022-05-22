package src;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import src.Spring;

public class SpringArray {
    /* Checks if a string is empty ("") or null. */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }
 
    /* Counts how many times the substring appears in the larger string. */
    // Return the indexes of the springs appearing the in the string.
    public static List<Integer> countMatches(String text, String str)
    {
        if (isEmpty(text) || isEmpty(str)) {
            return null;
        }
        
        List<Integer> springIndexes = new ArrayList<>();
 
        int index = 0;
        while (true)
        {
            index = text.indexOf(str, index);
            if (index != -1)
            {
                springIndexes.add(index);
                index += str.length();
            }
            else {
                break;
            }
        }
        
        return springIndexes;
    }

	private Spring inSeries(String expr, Spring[] springs) {
		System.out.println("In series: " + expr);
		if(expr.length() == springs.length * 2) {
			Spring spring = springs[0];
			for(int i=1; i<springs.length; i++) {
				spring = spring.inSeries(springs[i]);
			}
			
			System.out.println("Stifness: " + spring.getStiffness());
			return spring;
		}
		
		return null;
	}
	
	private Spring inParallel(String expr, Spring[] springs) {
		System.out.println("In parallel: " + expr);
		if(expr.length() == springs.length * 2) {
			Spring spring = springs[0];
			for(int i=1; i<springs.length; i++) {
				spring = spring.inParallel(springs[i]);
			}
			
			System.out.println("Stifness: " + spring.getStiffness());
			return spring;
		}
		
		return null;
	}
	
	public Spring equivalentSpring(String springExpr) {
		// Method returns an array of indexes of all springs.
		List<Integer> springIndexes = SpringArray.countMatches(springExpr, "[]");
		
		// Check the case of one spring.
		if(springIndexes.size() == 1) {
			return new Spring();
		}
		
		// Create an array of springs with default stiffness.
		Spring[] springs = new Spring[springIndexes.size()];
		Arrays.fill(springs, new Spring());
		
		for(int i=0; i<springs.length; i++) {
			System.out.println(springs[i]);
		}
		
		Spring spring;
		int size = springExpr.length();
		
		// Case for parallel connection.
		if(springExpr.charAt(0) == '[') {
			spring = this.inParallel(springExpr.substring(1, size - 1), springs);
			return spring;
		}
		
		// Case for series connection.
		if(springExpr.charAt(0) == '{') {
			spring = this.inSeries(springExpr.substring(1, size - 1), springs);
			return spring;
		}
		
		return null;
	}
	
	public Spring equivalentSpring(String springExpr, Spring[] springs) {
		List<Integer> springIndexes = SpringArray.countMatches(springExpr, "[]");
		
		if(springIndexes.size() == 1) {
			return new Spring();
		}
		
		return null;
	}
	
    public static void main(String[] args) {
        SpringArray spring = new SpringArray();
        spring.equivalentSpring("[[][][]]");
    }
}