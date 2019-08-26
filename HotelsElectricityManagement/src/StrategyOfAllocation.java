import java.util.*;

/* Check if properly Encapsulated
 Using LRU here.
*/
/* Problems -
   - Need Proper Encapsulation for state.
   - Strategy is being used only at multiple AC level on a particular corridor only.
   Considering MaxPowerMinimise can be attained within this.
   Checking if can be moved to Floor Level and even to Light. 
   - TODO - If we handle for each light turn, there will turn on and off of multiple AC which will be bad.
   Hence need to look for a batching solution.
*/
public class StrategyOfAllocation {
  Queue<ElectricalComponent> onState = new LinkedList<ElectricalComponent>();
  Queue<ElectricalComponent> offState = new LinkedList<ElectricalComponent>();

  HashMap<Integer, ElectricalComponent> indexForOnState = new HashMap<Integer, ElectricalComponent>();
  HashMap<Integer, ElectricalComponent> indexForOffState = new HashMap<Integer, ElectricalComponent>();

  public StrategyOfAllocation(List<ElectricalComponent> electricComponents) {
    this.build(electricComponents);
  }

  private void build(List<ElectricalComponent> electricComponents) {
    for(Iterator electricComponent: electricComponents.iterator()) {
      if (electricComponent.isOn) {
        this.onState.add(electricComponent);
        this.indexForOnState.add(electricComponent.id, electricComponent);
      } else {
        this.offState.add(electricComponent);
        this.indexForOnState.add(electricComponent.id, electricComponent);
      }
    }
    return;
  }

  /* Add Proper Status.
  // Changing the cache at the Floor Level.
  */
  public void turnOff(long totalFloorPowerConsumption) {
    while(totalFloorPowerConsumption < Hotel.maxFloorElectricUsage) {
      this.onState.remove(electricComponent);
      this.indexForOnState.remove(electricComponent); /* TODO remove ElectricComponent */
      this.offState.add(electricComponent);
      this.indexForOnState.add(electricComponent.id, electricComponent);
      totalFloorPowerConsumption -= electricComponent.powerConsumed();
    }
  }

  public turnOn(long int totalFloorPowerConsumption) {
    while(totalFloorPowerConsumption < Hotel.maxFloorElectricUsage) {
      this.onState.remove(electricComponent);
      this.indexForOnState.remove(electricComponent); // TODO remove ElectricComponent
      this.offState.add(electricComponent);
      this.indexForOnState.add(electricComponent.id, electricComponent);
      totalFloorPowerConsumption += electricComponent.powerConsumed();
    }
  }
}