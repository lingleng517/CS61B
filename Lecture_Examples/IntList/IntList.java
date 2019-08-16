public class IntList{
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	public int size() {
		if (rest == null) {
			return 1;
		}
		return rest.size() + 1;
	}

	public int iterativeSize() {
		int size = 1;
		IntList next = rest;
		while(next != null) {
			size++;
			next = next.rest;
		}
		return size;
	}

	public int iterativeGet(int i) {
		IntList p = this;
		while (i != 1) {
			p = p.rest;
			i--;
		}
		return p.first;
	}

	public int get(int i) {
		if (i = 0) {
			return first;
		}
		return rest.get(i - 1);
	}
 
	public static void main(String[] args) {
		IntList L = new IntList(5, null);

		L = new IntList(10, L);

		L = new IntList(15, L);

		System.out.println("The size of this IntList is: " + L.size());
		System.out.println("The size of this IntList is: " + L.iterativeSize());

		System.out.println("First int: " + L.get(1));
		System.out.println("Second int: " + L.get(2));
		System.out.println("Third int: " + L.get(3));
	}
}