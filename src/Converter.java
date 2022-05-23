package src;
import java.util.*;

public class Converter {

	public Spring generateSpringSystem(Integer[] values) {
		List<Spring> springs = new ArrayList<>();
		
		String springExpr = "[";
		
		for(int i=0; i < values.length; i++) {
			if(values[i] == 1) {
				springs.add(new Spring(Math.pow(2, values.length - i - 1)));
				springExpr += "[]";
			}
		}
		
		springExpr += "]";
		
		SpringArray arr = new SpringArray();
		
	    Spring[] springArray = new Spring[springs.size()];
        springs.toArray(springArray);
	      
		Spring generated_spring = arr.equivalentSpring(springExpr, springArray);
		
		return generated_spring;
	}
	
	public static Double[] getOscillation(Spring spring, int t0, int t1) {
		double dt = (t1 - t0) / 100;
		return spring.move(t1, t0, dt, 0, 1, 1);
	}
}