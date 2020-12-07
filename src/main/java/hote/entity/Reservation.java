package hote.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


/**
 * The type Reservation.
 */
@Entity(name = "Reservation")
@Table(name = "reservation") // case sensitive!
@Getter
@Setter
@NoArgsConstructor
public class Reservation {


    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    int id;


    @ManyToOne
    @JoinColumn(name = "guest_id",
            foreignKey = @ForeignKey(name = "reservation_guest"))

    private User user;


    /**
     * The Start date.
     */

    LocalDate start_date;

    /**
     * The End date.
     */

    LocalDate end_date;

    /**
     * The Total price.
     */
    Double total_price;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RoomReserved> roomReserveds = new HashSet<>();



    /**
     * Instantiates a new Reservation.
     *
     * @param start_date  the start date
     * @param end_date    the end date
     * @param total_price the total price
     * @param user        the user
     */
    public Reservation(LocalDate start_date, LocalDate end_date, Double total_price, User user ) {
        this.user = user;
        this.end_date = end_date;
        this.start_date = start_date;
        this.total_price = total_price;
    }

//    /**
//     * Gets id.
//     *
//     * @return the id
//     */
//    public int getId() {
//        return id;
//    }
//
//    /**
//     * Sets id.
//     *
//     * @param id the id
//     */
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    /**
//     * Gets user.
//     *
//     * @return the user
//     */
//    public User getUser() {
//        return user;
//    }
//
//    /**
//     * Sets user.
//     *
//     * @param user the user
//     */
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    /**
//     * Gets start date.
//     *
//     * @return the start date
//     */
//    public LocalDate getStart_date() {
//        return start_date;
//    }
//
//    /**
//     * Sets start date.
//     *
//     * @param start_date the start date
//     */
//    public void setStart_date(LocalDate start_date) {
//        this.start_date = start_date;
//    }
//
//    /**
//     * Gets end date.
//     *
//     * @return the end date
//     */
//    public LocalDate getEnd_date() {
//        return end_date;
//    }
//
//    /**
//     * Sets end date.
//     *
//     * @param end_date the end date
//     */
//    public void setEnd_date(LocalDate end_date) {
//        this.end_date = end_date;
//    }
//
//    /**
//     * Gets total price.
//     *
//     * @return the total price
//     */
//    public Double getTotal_price() {
//        return total_price;
//    }
//
//    /**
//     * Sets total price.
//     *
//     * @param total_price the total price
//     */
//    public void setTotal_price(Double total_price) {
//        this.total_price = total_price;
//    }
//
//


    @Override
    public String toString() {
        return "Reservatio{" +
                "id=" + id +
                ", user=" + user +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", total_price=" + total_price +
                '}';
    }
}
