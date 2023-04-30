package hu.gergo.szendrei.peridot.feature.wallpaper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class RoomDto {
    private long length;
    private long width;
    private long height;

    public RoomDto(String[] dimValues) {
        this.length = Long.parseLong(dimValues[0]);
        this.width = Long.parseLong(dimValues[1]);
        this.height = Long.parseLong(dimValues[2]);
    }

    @Override
    public boolean equals(Object arg0) {
        RoomDto otherRoom = (RoomDto) arg0;
        return this.length == otherRoom.getLength() && this.width == otherRoom.getWidth()
                && this.height == otherRoom.getHeight();
    }

    public long getSurfaceArea() {
        return (2 * this.length * this.width) + (2 * this.width * this.height) + (2 * this.height * this.length);
    }

    public long getExtraArea() {
        if (this.length >= this.width && this.length >= this.height) {
            return this.width * this.height;
        }
        if (this.width >= this.length && this.width >= this.height) {
            return this.length * this.height;
        }
        return this.width * this.length;
    }

    public long getTotalArea() {
        return this.getSurfaceArea() + this.getExtraArea();
    }

    public boolean isCubicShape() {
        return this.length == this.width && this.width == this.height;
    }
}
