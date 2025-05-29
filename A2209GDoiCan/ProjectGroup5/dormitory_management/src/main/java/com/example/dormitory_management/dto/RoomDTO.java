package com.example.dormitory_management.dto;
import com.example.dormitory.entity.Room;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {
    private Long roomId;
    private String roomNumber;
    private int capacity;
    private int currentOccupancy;
    private String gender;
    private String status;
}
