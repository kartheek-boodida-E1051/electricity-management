import java.util.Iterator;
import java.util.List;

public class FloorController {
  private List<MainCorridorElectricSystem> mainCorridorElectricSystem;
  private List<SubCorridorElectricSystem> subCorridorsElectricSystem;
  private long powerConsumed;

  public void addMainCorridorsElectricSystem(List<MainCorridorElectricSystem> mainCorridorElectricSystem) {
    this.mainCorridorElectricSystem = mainCorridorElectricSystem;
  }

  public void addSubCorridorsElectricSystem(List<SubCorridorElectricSystem> subCorridorsElectricSystem) {
    this.subCorridorsElectricSystem = subCorridorsElectricSystem;
  }

  /* Should id be used or electricSystem ? */
  public void turnLightOn(int lightId, CorridorElectricSystem corridorElectricSystem) {
    corridorElectricSystem.turnLightOn(lightId, this.powerConsumed);
  }

  /* Should be idempotent across threads?
     Composite Cache present here.
  */
  public long powerConsumption() {
    // Cache invalidation becomes the problem.
    return this.powerConsumed;

    long powerConsumed = 0;
    for(Iterator inCorridor : this.mainCorridorElectricSystem.iterator()) {
      powerConsumed += mainCorridor.powerConsumption();
    }

    for(Iterator subCorridor : this.subCorridorsElectricSystem.iterator()) {
      powerConsumed += subCorridor.powerConsumption();
    }
    this.powerConsumed = powerConsumed;
    return powerConsumed;
  }
}
