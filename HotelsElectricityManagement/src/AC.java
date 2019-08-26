public class AC extends ElectricalComponent {

  CONSUMPTION_PER_UNIT = 10;

  /* Constructor is Different - Doubtful. */
  public AC(FloorController controller, CorridorElectricSystem corridorElectricSystem) {
    this.controller = controller;
    this.corridorElectricSystem = corridorElectricSystem;
    this.isOn = State.ON;
  }
}
