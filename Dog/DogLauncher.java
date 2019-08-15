public class DogLauncher {
	public static void main(String[] args) {
		Dog[] dogs = new Dog[3];
		dogs[0] = new Dog(5);
		dogs[1] = new Dog(25);
		dogs[2] = new Dog(40);
		int i = 0;
		while (i < dogs.length) {
			dogs[i].makeNoise();
			i++;
		}
		Dog larger = Dog.maxDog(dogs[0], dogs[1]);
		larger.makeNoise();
		
		System.out.println(Dog.binomen);
	}
}