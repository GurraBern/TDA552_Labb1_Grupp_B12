import java.util.stream.Stream;

public enum DirectionEnum {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(2);

    private String direction;

    public String getDirection() {
        return direction;
    }

    DirectionEnum(int directionNum) {
    }
}
