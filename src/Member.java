import javax.management.loading.PrivateClassLoader;



public class Member {
    
    private int age, phoneNumber,timeIn,timeOut;
    private String childFirstName, childLastName,P1FirstName,
                    P2FirstName,P1LastName,P2LastName;
    
    
    
    public Member(){
        this.age=0;
        this.phoneNumber=0;
        this.timeIn = 0;
        this.timeOut = 0;
        
        this.childFirstName ="";
        this.childLastName ="";
        this.P1FirstName= "";
        this.P2FirstName = "";
        this.P1LastName ="";
        this.P2LastName = "";
    }
    
    public Member(int age, int phoneNumber, int timeIn, int timeout
            ,String childFirstName, String childLastName, String p1F, String p1L
            ,String p2F, String p2L){
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.timeIn = timeIn;
        this.timeOut = timeout;
        this.childFirstName = childFirstName;
        this.childLastName =childLastName;
        this.P1FirstName = p1F;
        this.P1LastName = p1L;
        this.P2FirstName = p2F;
        this.P2LastName = p2L;
        
        
    }
    public int getAge() {
        return age;
    }
    public String getChildFirstName() {
        return childFirstName;
    }
    public String getChildLastName() {
        return childLastName;
    }
    public String getP1FirstName() {
        return P1FirstName;
    }
    public String getP1LastName() {
        return P1LastName;
    }
    public String getP2FirstName() {
        return P2FirstName;
    }
    public String getP2LastName() {
        return P2LastName;
    }
    
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public int getTimeIn() {
        return timeIn;
    }
    public int getTimeOut() {
        return timeOut;
    }
    
    
    public void setAge(int age) {
        this.age = age;
    }
    public void setChildFirstName(String childFirstName) {
        this.childFirstName = childFirstName;
    }
    public void setChildLastName(String childLastName) {
        this.childLastName = childLastName;
    }
    public void setP1FirstName(String p1FirstName) {
        P1FirstName = p1FirstName;
    }
    public void setP1LastName(String p1LastName) {
        P1LastName = p1LastName;
    }
    public void setP2FirstName(String p2FirstName) {
        P2FirstName = p2FirstName;
    }
    public void setP2LastName(String p2LastName) {
        P2LastName = p2LastName;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }
    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

}
