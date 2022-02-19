
public class OrderedKeyValue implements Comparable<String> {
	
	public String key;
	public int value;

	
	public OrderedKeyValue(String key, int value) { //constructor
		this.key = key;
		this.value = value;
	}


	@Override
	public int compareTo(String o) { //for comparing this class based on string key
		return this.key.compareTo(o); //if current class string is larger than the given string, return positive value. Ex (curent class: zzz, given: aaa)
										//if current class string is smaller than the given string, return negative value. Ex (curent class: aaa, given: zzz)
										//if current class string is equal to the given string, return 0. Ex (curent class: aaa, given: aaa)
	}

}
