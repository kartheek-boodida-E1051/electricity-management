/* Interface? related to 24hrs on, only night on. */
public class Light extends ElectricalComponent {

  static final int CONSUMPTION_PER_UNIT = 5;

  /* Constructor is changing. Check */
  public Light(FloorController controller, CorridorElectricSystem corridorElectricSystem, State isOn) {
    this.controller = controller; /* Can this be moved to abstract controller? */
    this.corridorElectricSystem = corridorElectricSystem;
    this.isOn = isOn;
  }
}