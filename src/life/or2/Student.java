package life.or2;

public class Student extends Person {

    private String identifier = ""; // matricola

    public Student() {
        super();
    }

    public Student(String[] data) {
        this();
        this.setFromData(data);
    }

    public Student(String name, String surname, String identifier) {
        super(name, surname);
        this.identifier = identifier;
    }

    public void setFromData(String[] data) throws IllegalArgumentException, BadIdentifierException {
        if (data.length != 3) {
            throw new IllegalArgumentException("data must have length 3!");
        }
        if (data[2].charAt(0) != 'M') {
            throw new BadIdentifierException();
        }

        this.name = data[0];
        this.surname = data[1];
        this.identifier = data[2];
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "Student{" +
                "identifier='" + identifier + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
