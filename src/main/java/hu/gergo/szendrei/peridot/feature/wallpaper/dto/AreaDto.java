package hu.gergo.szendrei.peridot.feature.wallpaper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class AreaDto {
    private long surface;
    private long extra;
    private long total; 

    public void addRoomAreas(RoomDto room) {
        this.surface += room.getSurfaceArea();
        this.extra += room.getExtraArea();
        this.total += room.getTotalArea();
    }
}
