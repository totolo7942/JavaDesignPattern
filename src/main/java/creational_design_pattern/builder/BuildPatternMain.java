package creational_design_pattern.builder;

public class BuildPatternMain {

    public static void main(String[] args) {
        Employee employee = Employee.builder()
                .age(10)
                .build();

        System.out.println(employee.toString());
    }
}

class Employee {
    private final String name;
    private final String email;
    private final int age;

    public Employee(eBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public static eBuilder builder() { return new eBuilder();}

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public static class eBuilder {
        private String name;
        private String email;
        private int age;

        eBuilder(){}


        public eBuilder(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public eBuilder age(int age) {
            this.age = age;
            return this; //본인의 값을 다시 넘겨줘야됨
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}