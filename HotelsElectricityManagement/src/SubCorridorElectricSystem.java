public class SubCorridorElectricSystem extends Corridor {

  private addLights(int count) {
    for (int i = 0; i < count; i++) {
      lights.add(new Light(this.controller, this.corridorElectricSystem, ElectricComponent.State.OFF));
    }
  }

  /* State change actions.
   TODO.
  */
  public void turnLightOn(int lightId, long totalFloorPowerConsumption) {
    this.lights.get(lightId).turnOn();
    this.allocationStrategyForAcs.turnOff(totalFloorPowerConsumption);

    /* TODO Change. */
    public void turnLightOff(int lightId, long totaltFloorPowerConsumption){
      this.lights.get(lightId).turnOff();
      this.allocationStrategyForAcs.turnOn(totaltFloorPowerConsumption);
    }

  /* Check if this could replace the above two.
  // public void toggleLightAndAc(int ) {
     }
  */
  }
}