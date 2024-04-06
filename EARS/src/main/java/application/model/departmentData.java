package application.model;

public class departmentData {
    
    private int departmentID;
    private String departmentName;
    
    public departmentData(int departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }
    
     public int getDepartmentID() {
        return departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }
    
}
