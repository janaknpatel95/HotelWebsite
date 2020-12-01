package hote.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Room.
 */
@Entity(name = "Room")
@Table(name = "room")
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
    String current_price;

    /**
     * The Avalable.
     */
    String Avalable;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RoomReserved> roomReserveds = new HashSet<>();

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
     * Gets room name.
     *
     * @return the room name
     */
    public String getRoom_name() {
        return room_name;
    }

    /**
     * Sets room name.
     *
     * @param room_name the room name
     */
    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets current price.
     *
     * @return the current price
     */
    public String getCurrent_price() {
        return current_price;
    }

    /**
     * Sets current price.
     *
     * @param current_price the current price
     */
    public void setCurrent_price(String current_price) {
        this.current_price = current_price;
    }

    /**
     * Gets avalable.
     *
     * @return the avalable
     */
    public String getAvalable() {
        return Avalable;
    }

    /**
     * Sets avalable.
     *
     * @param avalable the avalable
     */
    public void setAvalable(String avalable) {
        Avalable = avalable;
    }

    /**
     * Gets room reserveds.
     *
     * @return the room reserveds
     */
    public Set<RoomReserved> getRoomReserveds() {
        return roomReserveds;
    }

    /**
     * Sets room reserveds.
     *
     * @param roomReserveds the room reserveds
     */
    public void setRoomReserveds(Set<RoomReserved> roomReserveds) {
        this.roomReserveds = roomReserveds;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", room_name='" + room_name + '\'' +
                ", description='" + description + '\'' +
                ", current_price='" + current_price + '\'' +
                ", Avalable='" + Avalable + '\'' +
                ", roomReserveds=" + roomReserveds +
                '}';
    }
}
