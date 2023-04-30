package hu.gergo.szendrei.peridot.feature.wallpaper.service.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.gergo.szendrei.peridot.feature.wallpaper.dto.RoomDto;
import hu.gergo.szendrei.peridot.shared.service.DataUtilService;

@Component
public class WallpaperDataServiceImpl implements WallpaperDataService {
    @Autowired
    private DataUtilService dataUtilService;

    @Override
    public List<RoomDto> getRooms() {
        List<String> dimensions = this.getDimensions();
        return this.getRooms(dimensions);
    }

    private List<RoomDto> getRooms(List<String> dimensions) {
        List<RoomDto> rooms = new ArrayList<>();
        for (String dimension : dimensions) {
            String[] dimValues = dimension.split("x");
            rooms.add(new RoomDto(dimValues));
        }
        return rooms;
    }

    private List<String> getDimensions() {
        String input = this.dataUtilService.getResource("/data/sample-input.txt");
        String[] dimensions = input.split("\n");
        return Arrays.asList(dimensions);
    }
}
