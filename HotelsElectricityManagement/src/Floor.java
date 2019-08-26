import java.util.ArrayList;
import java.util.List;

/* Floor consists corridor + subCorridor
   TODO - Functionality of moving lights.
*/
public class Floor {
  private final FloorController floorController;

  public Floor(int mainCorridorsCount, int subCorridorsCount) {
    this.floorController = FloorElectricSystemBuilder.new()
            .buildMainCorridorsElectricSystem(mainCorridorsCount)
            .buildSubCorridorsElectricSystem(subCorridorsCount)
            .build();
  }
}
