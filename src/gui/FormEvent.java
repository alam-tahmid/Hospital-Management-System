package gui;
import java.util.EventObject;


public class FormEvent extends EventObject {

	private int id;////it has to be generated and add to table
	private String name;////Doctor's name
	private String firstName;
    private String lastName;
    private String occupation;
    private String spec;
    private String age;
    private String address;
    private String phone;
    private String email;
    private String gender;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source,int id, String firstName, String lastName, String occupation, String age, String address, String phone, String email,String gender) {
        
    	super(source);

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = occupation;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }
    /////////////////////////////////////
    /////////////////////////////////////
    //////// Doctor's information////////
    /////////////////////////////////////
    /////////////////////////////////////
    public FormEvent(Object source,int id, String name, String spec, String age, String address, String phone, String email,String gender) {
       
    	super(source);

        this.id = id;
        this.firstName = name;
        this.spec = spec;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }
    

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
