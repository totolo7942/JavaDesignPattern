package creational_design_pattern;

import lombok.Builder;
import lombok.EqualsAndHashCode;

public class LombokBuilderPatterMain {

    public static void main(String[] args) {
        EmployeeLombok employeeLombok = EmployeeLombok.builder().build();
    }

}

@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
class EmployeeLombok {

    @EqualsAndHashCode.Include
    private final String name;
    private final String email;
    private final int age;
}
