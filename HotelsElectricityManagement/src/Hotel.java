import java.util.ArrayList;
import java.util.List;

public class Hotel {
  private List<Floor> floors = new ArrayList<Floor>();

  // TODO make it final.
  public static int maxFloorElectricUsage;

  private int noOfFloors, mainCorridorsPerFloor, subCorridorsPerFloor;

  public Hotel(int noOfFloors, int mainCorridorsPerFloor, int subCorridorsPerFloor, int maxFloorElectricUsage) {
    this.noOfFloors = noOfFloors;
    this.mainCorridorsPerFloor = mainCorridorsPerFloor;
    this.subCorridorsPerFloor = subCorridorsPerFloor;
    this.setHotelStaticVariables(maxFloorElectricUsage);
    this.buildFloors();
  }

  private void buildFloors() {
    for (int i = 0; i < this.noOfFloors; i++) {
      this.floors.add(Floor.new(this.mainCorridorsPerFloor, this.subCorridorsPerFloor));
    }
    return;
  }

  private static void setHotelStaticVariables(int maxFloorElectricUsage) {
    Hotel.maxFloorElectricUsage = maxFloorElectricUsage;
  }
}
