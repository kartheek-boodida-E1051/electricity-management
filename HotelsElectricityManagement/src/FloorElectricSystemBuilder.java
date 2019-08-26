import java.util.ArrayList;
import java.util.List;

public class FloorElectricSystemBuilder {
  private FloorController floorController;

  /* Should build initialize with all components off? */
  public FloorElectricSystemBuilder() {
    this.floorController = new FloorController();
  }

  public FloorElectricSystemBuilder buildMainCorridorsElectricSystem(int count) {
    List<MainCorridorElectricSystem> mainCorridorsElectricSystem = new ArrayList<MainCorridorElectricSystem>();
    for (int i = 0; i < this.mainCorridorsCount; i++) {
      mainCorridorsElectricSystem.add(new MainCorridor(this.floorController));
    }
    this.floorController.addMainCorridorsElectricSystem(mainCorridorsElectricSystem);
    return this;
  }

  public FloorElectricSystemBuilder buildSubCorridorsElectricSystem(int count) {
    List<SubCorridorsElectricSystem> subCorridorsElectricSystem = new ArrayList<SubCorridorsElectricSystem>();
    for (int i = 0; i < this.subCorridorsCount; i++) {
      subCorridorsElectricSystem.add(SubCorridorsElectricSystem.new(this.floorController));
    }
    this.floorController.addSubCorridorsElectricSystem(SubCorridorsElectricSystem);
    return this;
  }

  public FloorController build() {
    return this.floorController;
  }
}
