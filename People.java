

interface People {

	default void show(String name, Integer age) {
		System.out.println(String.format(" %s is of age %s", name, age));
	}

}
