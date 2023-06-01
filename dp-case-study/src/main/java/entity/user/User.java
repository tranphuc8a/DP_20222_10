package entity.user;

public class User {
<<<<<<< HEAD
    // Functional cohesion
=======
    /*
    Đối tượng của lớp User là duy nhất trong chương trình nên:
        + Chuyển thành singleton
        + Bỏ phương thức cloneInformation() đi
     */

>>>>>>> 6a2dc9d22c9faa089d86dd247f32b9dde3ee87cd
    private int id;
    private String name;
    private String email;
    private String address;
    private String phone;

    private static User instance;

    public static User getInstance() {
        if (instance == null) {
            instance = new User(0, "", "", "", "");
        }
        return instance;
    }
    public User setUserInfo(int id, String name, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        return this;
    }
    private User(int id, String name, String email, String address, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

//    public User cloneInformation() {
//        return new User(this.id, this.name, this.email, this.address, this.phone);
//    }
    
    // override toString method
    @Override
    public String toString() {
        return "{" +
            "  username='" + name + "'" +
            ", email='" + email + "'" +
            ", address='" + address + "'" +
            ", phone='" + phone + "'" +
            "}";
    }

    // getter and setter
    public String getName() {
        return this.name;
    }

    public void setusername(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
