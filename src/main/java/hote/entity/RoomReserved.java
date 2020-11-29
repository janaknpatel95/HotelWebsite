package hote.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity(name = "Roomreserved")
@Table(name = "room_reserved") // case sensitive!
public class RoomReserved {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    int id;

    double price;


    @ManyToOne
    @JoinColumn(name = "room_id",
            foreignKey = @ForeignKey(name = "room_reserved_room")
    )
    Room room;

    @ManyToOne
    @JoinColumn(name = "reservation_id",
            foreignKey = @ForeignKey(name = "room_reserved_reservation")
    )
    Reservation reservation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "RoomReserved{" +
                "id=" + id +
                ", price=" + price +
                ", room=" + room +
                ", reservation=" + reservation +
                '}';
    }
}
