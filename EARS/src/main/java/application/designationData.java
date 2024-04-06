package application;

public class designationData {
    
    private int designationID;
    private String designationName;
    
    public designationData(int designationID, String designationName) {
        this.designationID = designationID;
        this.designationName = designationName;
    }
    
     public int getDesignationID() {
        return designationID;
    }

    public String getDesignationName() {
        return designationName;
    }
    
}
