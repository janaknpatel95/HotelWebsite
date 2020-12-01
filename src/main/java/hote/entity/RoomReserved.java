package hote.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * The type Room reserved.
 */
@Entity(name = "Roomreserved")
@Table(name = "room_reserved") // case sensitive!
public class RoomReserved {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    int id;

    /**
     * The Price.
     */
    double price;


    /**
     * The Room.
     */
    @ManyToOne
    @JoinColumn(name = "room_id",
            foreignKey = @ForeignKey(name = "room_reserved_room")
    )
    Room room;

    /**
     * The Reservation.
     */
    @ManyToOne
    @JoinColumn(name = "reservation_id",
            foreignKey = @ForeignKey(name = "room_reserved_reservation")
    )
    Reservation reservation;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets room.
     *
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets room.
     *
     * @param room the room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Gets reservation.
     *
     * @return the reservation
     */
    public Reservation getReservation() {
        return reservation;
    }

    /**
     * Sets reservation.
     *
     * @param reservation the reservation
     */
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
