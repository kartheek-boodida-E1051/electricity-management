import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract public class CorridorElectricSystem {

  /* Check ParentChild Ref might not work.
   private HashMap<ElectricalComponent, List<ElectricalComponent> > typeToComponentsMap = new HashMap<ElectricalComponent, List<ElectricalComponent>>();
  */
  private List<AC> acs = new ArrayList<AC>();
  private List<Light> lights = new ArrayList<Light>();
  private FloorController controller;
  private StrategyOfAllocation allocationStrategyForAcs, allocationStrategyForLights;

  public CorridorElectricSystem(FloorController controller) {
    this.controller = controller;
    this.addAcs(1);
    this.addLights(1);
    this.allocationStrategyForAcs = new StrategyOfAllocation(this.acs);
    /* this.allocationStrategyForLights = StrategyOfAllocation.new(this.lights); */
  }

  private void addAcs(int count) {
    for (int i=0; i<count ; i++) {
      acs.add(new AC(controller, this));
    }
  }

  public long powerConsumption() {
    long powerConsumption = 0;
    for(Iterator light : List<Light> lights) {
      powerConsumption += light.powerConsumed();
    }
    for(Iterator ac : List<AC> acs) {
      powerConsumption += ac.powerConsumed();
    }
    return powerConsumption;
  }

  abstract private void addLights(int count);
  /* abstract public int powerConsumption(); */
}

/* Type inclusion to change mainCorridor to SubCorridor - TODO Viceversa. */