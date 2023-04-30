package hu.gergo.szendrei.peridot.feature.wallpaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.gergo.szendrei.peridot.feature.wallpaper.dto.AreaDto;
import hu.gergo.szendrei.peridot.feature.wallpaper.dto.RoomDto;
import hu.gergo.szendrei.peridot.feature.wallpaper.service.WallpaperService;

@RestController
@RequestMapping(path = "/api/wallpaper")
public class WallpaperController {
    @Autowired
    private WallpaperService wallpaperService;

    @GetMapping(path = "/requiredAmount")
    public ResponseEntity<AreaDto> getRequiredAmount() {
        return new ResponseEntity<AreaDto>(this.wallpaperService.getRequiredAmount(), HttpStatus.OK);
    }

    @GetMapping(path = "/cubicShapeRooms")
    public ResponseEntity<List<RoomDto>> getCubicShapeRooms() {
        return new ResponseEntity<List<RoomDto>>(this.wallpaperService.getCubicShapeRooms(), HttpStatus.OK);
    }

    @GetMapping(path = "/duplicateRooms")
    public ResponseEntity<List<RoomDto>> getDuplicateRooms() {
        return new ResponseEntity<List<RoomDto>>(this.wallpaperService.getDuplicateRooms(), HttpStatus.OK);
    }
}
