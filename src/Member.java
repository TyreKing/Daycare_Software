import javax.management.loading.PrivateClassLoader;



public class Member {
    
    private int age,timeIn,timeOut;
    private long phoneNumber;
    private String childFirstName, childLastName,P1FirstName,
                   P1LastName, address;
    
    
    
    public Member(){
        this.age=0;
        this.phoneNumber=0;
        this.timeIn = 0;
        this.timeOut = 0;
        this.address = "";
        this.childFirstName ="";
        this.childLastName ="";
        this.P1FirstName= "";
        this.P1LastName ="";
        
    }
    
    public Member(int age, int phoneNumber, int timeIn, int timeout
            ,String childFirstName, String childLastName, String p1F, String p1L
            ,String address){
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.timeIn = timeIn;
        this.timeOut = timeout;
        this.childFirstName = childFirstName;
        this.childLastName =childLastName;
        this.P1FirstName = p1F;
        this.P1LastName = p1L;
        this.address = address;
        
        
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
   
    public String getAddress() {
        return address;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public int getTimeIn() {
        return timeIn;
    }
    public int getTimeOut() {
        return timeOut;
    }
    
    public void setAddress(String address) {
        this.address = address;
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
 
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }
    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

}
