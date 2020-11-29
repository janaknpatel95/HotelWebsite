package hote.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "Reservation")
@Table(name = "reservation") // case sensitive!
public class Reservation {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    int id;


    @ManyToOne
    @JoinColumn(name = "guest_id",
            foreignKey = @ForeignKey(name = "reservation_guest"))

    private User user;


    LocalDate start_date;

    LocalDate end_date;

    Double total_price;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RoomReserved> roomReserveds = new HashSet<>();

    public Reservation(){


    }

    public Reservation(LocalDate start_date, LocalDate end_date, Double total_price, User user ) {
        this.user = user;
        this.end_date = end_date;
        this.start_date = start_date;
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
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
