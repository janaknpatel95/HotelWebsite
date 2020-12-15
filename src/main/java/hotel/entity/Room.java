package hotel.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Room.
 */
@Entity(name = "Room")
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
public class Room {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    int id;


    /**
     * The Room name.
     */
    String room_name;

    /**
     * The Description.
     */
    String description;

    /**
     * The Current price.
     */
    Double current_price;

    /**
     * The Avalable.
     */
    int Avalable;

    LocalDate date;


    public Room(String room_name, String description, Double current_price, int avalable, LocalDate date) {
        this.room_name = room_name;
        this.description = description;
        this.current_price = current_price;
        Avalable = avalable;
        this.date = date;
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", room_name='" + room_name + '\'' +
                ", description='" + description + '\'' +
                ", current_price='" + current_price + '\'' +
                ", Avalable='" + Avalable + '\'' +
                ", Date='" + date + '\'' +
                '}';
    }
}
