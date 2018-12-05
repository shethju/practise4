package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaInterface int1 = () -> System.out.println("hey");
		int1.apply();
		LInterface2 int2 = (param1, param2) -> {
			return param1 + param2;
		};
		System.out.println(int2.apply("abc", 1));
		List<Integer> number = Arrays.asList(2,3,4,5);
		List<Integer> number2 = number.stream().
											filter(x-> x > 2).
											map(x->x*x).
											collect(Collectors.toList());
		number.forEach(System.out::println);
		number2.forEach(System.out::println);
	}
	
}
