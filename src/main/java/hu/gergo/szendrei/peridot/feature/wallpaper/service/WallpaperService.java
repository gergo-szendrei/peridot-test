package hu.gergo.szendrei.peridot.feature.wallpaper.service;

import java.util.List;

import hu.gergo.szendrei.peridot.feature.wallpaper.dto.AreaDto;
import hu.gergo.szendrei.peridot.feature.wallpaper.dto.RoomDto;

public interface WallpaperService {
    public AreaDto getRequiredAmount();
    public List<RoomDto> getCubicShapeRooms();
    public List<RoomDto> getDuplicateRooms();
}
