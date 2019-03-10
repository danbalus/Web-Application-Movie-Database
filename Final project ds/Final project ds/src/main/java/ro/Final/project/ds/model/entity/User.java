package ro.Final.project.ds.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;
import javax.persistence.ElementCollection;


@Entity
@Table(name = "user")
public class User {

    //todo:map<integer, intetger> CARE ARE IN EA ID UL UNIC AL FILMULUI SI RATINGUL DAT DE EL
    @Id
    @Column(name = "id")
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;//nickname

    @Column(name = "password")
    private String password;

    @Column(name = "name"/*, unique = true*/)
    private String name;


    @Column(name = "typeAccount")
    private int typeAccount;    // 0--> regular user  1--> VIP user


    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "ratings")
    //private Map<Long, Integer> ratings;// = new HashMap<Integer,Integer>();
    private Map<String, Integer> ratings;

    public User(String name, String password, int typeAccount, Long id, String email, int age) {
        this.name = name;
        this.password = password;
        this.typeAccount = typeAccount;
        this.id = id;
        this.email = email;
        this.age = age;
    }

    public User( String email,String password) {
        this.password = password;
        this.email = email;
    }

//    public User(String name, String password, int typeAccount, Long id, String email, int age, Map<Long, Integer> ratings) {
//        this.name = name;
//        this.password = password;
//        this.typeAccount = typeAccount;
//        this.id = id;
//        this.email = email;
//        this.age = age;
//        this.ratings = ratings;
//    }
public User(String name, String password, int typeAccount, Long id, String email, int age, Map<String, Integer> ratings) {
    this.name = name;
    this.password = password;
    this.typeAccount = typeAccount;
    this.id = id;
    this.email = email;
    this.age = age;
    this.ratings = ratings;
}

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(int typeAccount) {
        this.typeAccount = typeAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Map<Long, Integer> getRatings() {
//        return ratings;
//    }
    public Map<String, Integer> getRatings() {
        return ratings;
    }
//    public void setRatings(Map<Long, Integer> ratings) {
//        this.ratings = ratings;
//    }
    public void setRatings(Map<String, Integer> ratings) {
        this.ratings = ratings;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
//    public List<String> getRatingsAsString() {
//        List<String> list = new ArrayList<>();
//        if (!ratings.isEmpty()) {
//            System.out.println("ratings are not empty");
//            for (Map.Entry<Integer, Integer> pair : ratings.entrySet()) {
//                list.add(("id: " + Integer.toString(pair.getKey()) + " " + ("rate: " + Integer.toString(pair.getValue()))) + "\n");
//            }
//        }
//
//        return list;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (typeAccount != user.typeAccount) return false;
        if (age != user.age) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return ratings != null ? ratings.equals(user.ratings) : user.ratings == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + typeAccount;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (ratings != null ? ratings.hashCode() : 0);
        return result;
    }

    public String toString() {
        return ("|name|: " + name +
                "    |typeAccount|: " + "\t" + typeAccount +
                "    |email|: " + "\t" + email +
                "    |age|: " + "\t" + age +
                "    |id|: " + "\t" + id
                 + "    |ratings|: " + "\t" + Arrays.toString(ratings.entrySet().toArray()));



    }
}