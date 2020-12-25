package author;

public class Author {
    final String name, bio;
    final int age;

    public Author(String name, int age, String bio) {
        this.name = name;
        this.age = age;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getAge() {
        return age;
    }
}
