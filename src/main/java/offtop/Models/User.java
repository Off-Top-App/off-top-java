package offtop.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "user")
public class User{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;

    public String firstName;
    public String lastName;
    public String city;
    public int age;
    public String gender;
    public String professional;
    public String email;
    public String username;
    public String password;
    public String createdAt;
    public String deletedAt;

    public User(){
        super();
    }

    public User (int Id, String firstName, String lastName, String city, int age, String gender, String professional,
     String email, String username, String password, String createdAt, String deletedAt ){
      
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.gender = gender;
        this.professional = professional;
        this.email = email;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
     }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

}