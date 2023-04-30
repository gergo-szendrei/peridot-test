package hu.gergo.szendrei.peridot.feature.wallpaper.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.gergo.szendrei.peridot.feature.wallpaper.dto.AreaDto;
import hu.gergo.szendrei.peridot.feature.wallpaper.dto.RoomDto;
import hu.gergo.szendrei.peridot.feature.wallpaper.service.data.WallpaperDataService;

@Service
public class WallpaperServiceImpl implements WallpaperService {
    @Autowired
    private WallpaperDataService wallpaperDataService;

    @Override
    public AreaDto getRequiredAmount() {
        List<RoomDto> rooms = this.getRooms();
        AreaDto requiredAmount = new AreaDto();
        for (RoomDto room : rooms) {
            requiredAmount.addRoomAreas(room);
        }
        return requiredAmount;
    }

    @Override
    public List<RoomDto> getCubicShapeRooms() {
        List<RoomDto> rooms = this.getRooms();
        return rooms.stream()
                .filter(room -> room.isCubicShape())
                .sorted((room1, room2) -> ((Long) room2.getTotalArea()).compareTo(room1.getTotalArea()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomDto> getDuplicateRooms() {
        List<RoomDto> rooms = this.getRooms();
        return rooms.stream()
                .filter(room -> Collections.frequency(rooms, room) > 1)
                .collect(Collectors.toList());
    }

    private List<RoomDto> getRooms() {
        return this.wallpaperDataService.getRooms();
    }
}
