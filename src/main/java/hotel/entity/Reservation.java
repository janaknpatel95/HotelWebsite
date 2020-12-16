package hotel.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.time.LocalDate;


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

//    many to one with user class
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

    /**
     * Instantiates a new Reservation.
     *
     * @param start_date  the start date
     * @param end_date    the end date
     * @param total_price the total price
     */
    public Reservation(LocalDate start_date, LocalDate end_date, double total_price) {

        this.end_date = end_date;
        this.start_date = start_date;
        this.total_price = total_price;
    }


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
