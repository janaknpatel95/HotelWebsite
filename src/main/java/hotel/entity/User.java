package hotel.entity;


import javax.persistence.*;



import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;


/**
 * The type User.
 */
@Entity(name = "User")
@Table(name = "user") // case sensitive!
@Getter @Setter @NoArgsConstructor
public class User {


    /**
     * The First name.
     */
    @NotEmpty(message = "Please provide a First name")
    public String first_name;
    /**
     * The Last name.
     */
    @NotEmpty(message = "Please provide a Last name")
    public String last_name;
    /**
     * The User name.
     */
    public String user_name;

    /**
     * The Email.
     */
    @NotEmpty(message = "Please provide a Email")
    public String email;

    /**
     * The Phone.
     */
    @NotEmpty(message = "Please provide a Phone")
    public String phone;
    /**
     * The Address.
     */
    public String address;

    /**
     * The Details.
     */
    public String details;

    /**
     * The Password.
     */
    public String Password;


    /**
     * Gets password.
     *
     * @return the password
     */
//    public String getPassword() {
//        return Password;
//    }
//
//    /**
//     * Sets password.
//     *
//     * @param password the password
//     */
//    public void setPassword(String password) {
//        Password = password;
//    }

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
 private int id;

    /**
     * Bidirectional @OneToMany
     * The bidirectional @OneToMany association also requires a @ManyToOne association on the child side.
     * Although the Domain Model exposes two sides to navigate this association, behind the scenes,
     * the relational database has only one foreign key for this relationship.
     * Every bidirectional association must have one owning side only (the child side),
     * the other one being referred to as the inverse (or the mappedBy) side.
     * Foreign key is on the child table (Order in this example)
     * Source: http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#associations-one-to-many
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<Reservation> reservations = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    /**
     * Instantiates a new User.
     */
//    public User() {
//    }

    /**
     * Instantiates a new User.
     *
     * @param first_name the first name
     * @param last_name  the last name
     * @param user_name  the user name
     * @param email      the email
     * @param password   the password
     * @param phone      the phone
     */
    public User(String first_name, String last_name, String user_name, String email, String password, String phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.email = email;
        this.Password = password;
        this.phone = phone;
    }

    /**
     * Instantiates a new User.
     *
     * @param first_name the first name
     * @param last_name  the last name
     * @param user_name  the user name
     * @param email      the email
     * @param phone      the phone
     * @param address    the address
     * @param details    the details
     */
    public User(String first_name, String last_name, String user_name, String email, String phone, String address, String details) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.details = details;
    }

    /**
     * Instantiates a new User.
     *
     * @param first_name the first name
     * @param last_name  the last name
     * @param user_name  the user name
     * @param email      the email
     * @param phone      the phone
     */
    public User(String first_name, String last_name, String user_name, String email, String phone) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.email = email;
        this.phone = phone;
    }




    /**
     * Gets reservations.
     *
     * @return the reservations
     */
    public Set<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Sets reservations.
     *
     * @param reservations the reservations
     */
    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }


    @Override
    public String toString() {
        return "User{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", details='" + details + '\'' +
                ", id=" + id +
                '}';
    }


    /**
     * Add role.
     *
     * @param reservation the role
     */
    public void addReservasion(Reservation reservation) {
        reservations.add(reservation);
        reservation.setUser(this);
    }

    /**
     * Remove role.
     *
     * @param reservasion the role
     */
    public void removeReservasion(Reservation reservasion) {
        reservations.remove(reservasion);
        reservasion.setUser(null);
    }


    /**
     * Gets roles.
     *
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    /**
     * Add role.
     *
     * @param role the role
     */
    public void addRole(Role role) {
        roles.add(role);
        role.setUser(this);
    }

    /**
     * Remove role.
     *
     * @param role the role
     */
    public void removeRole(Role role) {
        roles.remove(role);
        role.setUser(null);
    }

}
