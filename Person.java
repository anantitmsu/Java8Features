

public class Person {

	private String name;
	private Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public int ageDifference(final Person other) {
		return age - other.age;

	}

	@Override
	public String toString() {
		return String.format("Name : %s | Age : %s", this.name, this.age);
	}

}
