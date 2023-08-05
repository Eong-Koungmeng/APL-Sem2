package Exercise3;

class Zoo
{
	
	Animal animals[];
	Zoo()
	{
		animals = new Animal[2];
		animals[0] = new Dog();
		animals[1] = new Cat();
		
	}
	
	void speak()
	{
		for(int i = 0; i < animals.length;i++)
		{
			animals[i].makeSound();
		}
	}
}