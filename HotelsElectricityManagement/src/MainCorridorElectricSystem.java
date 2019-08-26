public class MainCorridorElectricSystem extends Corridor {

  private void addLights(int count) {
    for (int i = 0; i<count ; i++) {
      this.lights.add(new Light(this.controller, this, ElectricalComponent.State.ON));
    }
  }

  /* State change methods */
  public void turnLightOn(int lightId, long int totalFloorPowerConsumption) {
    this.lights.get(lightId).turnOn();
  }

  public void turnLightOff(int lightId) {
    this.lights.get(lightId).turnOff();
  }
}
