package compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ComparableMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Laptop> list = new ArrayList<Laptop>();
		list.add(new Laptop("c", 1, 10));
		list.add(new Laptop("b", 2, 20));
		list.add(new Laptop("a", 3, 30));
		Collections.sort(list); // Note sort default is ascending order. Note Laptop already implements Comparable interface
		for (Laptop l : list) {
			System.out.println(l.getBrand());
		}
		Comparator<Laptop> com = new Comparator<Laptop>() {
			public int compare(Laptop l1, Laptop l2) {
				if (l1.getPrice() < l2.getPrice()) {
					return -1;
				} else if (l1.getPrice() > l2.getPrice()) {
					return 1;
				} else return 0;
			}
		}; // note semi colon. 
		Collections.sort(list, com); // Note sort default is ascending order. Note now we are using customer comparator
		//and not inbuild compararison .
		for (Laptop l : list) {
			System.out.println(l.getPrice());
		}
		Comparator<String> comString = new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		}; // note ;
		Comparator<String> comLamba = 
				(String o1, String o2) -> { return o1.compareTo(o2);}; // note ;
		comLamba.compare("hello", "world");	
		//  (o1, o2) -> { return o1.compareTo(o2);};
		Comparator<String> comLamba2 =
		    (o1, o2) -> { return o1.compareTo(o2);};
		Comparator<String> comLamba3 =
				    (o1, o2) -> o1.compareTo(o2);
	}

}
