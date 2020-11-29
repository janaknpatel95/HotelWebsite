package hote.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Room")
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    int id;


    String room_name;

    String description;

    String current_price;

    String Avalable;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RoomReserved> roomReserveds = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(String current_price) {
        this.current_price = current_price;
    }

    public String getAvalable() {
        return Avalable;
    }

    public void setAvalable(String avalable) {
        Avalable = avalable;
    }

    public Set<RoomReserved> getRoomReserveds() {
        return roomReserveds;
    }

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
