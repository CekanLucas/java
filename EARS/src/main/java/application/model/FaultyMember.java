package application.model;

public class FaultyMember {

	private String name;
    private String department;

    public FaultyMember(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for department
    public String getDepartment() {
        return department;
    }

    // Setter for department
    public void setDepartment(String department) {
        this.department = department;
    }
    
}
