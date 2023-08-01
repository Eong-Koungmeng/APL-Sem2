package Exercise6;

class Customer extends Person
{
	int customerID;
	String address;
	String phoneNumber;
	
	Customer(String name, int age, char gender, int customerID, String address, String phoneNumber)
	{
		super(name, age, gender);
		this.customerID = customerID;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	void displayInfo()
	{
		System.out.println("Name: " + name + ", age: " + age + ", Gender: " + gender + ", CustomerID: " + customerID + ", Address: "+ address + ", Phone Number: " + phoneNumber);
	}
}
