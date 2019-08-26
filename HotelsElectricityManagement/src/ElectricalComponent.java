/* Interface? related to 24hrs on, only night on. */
abstract public class ElectricalComponent {

  private final state isON;
  private CorridorElectricSystem corridorElectricSystem;
  private FloorController controller;

  protected static final int CONSUMPTION_PER_UNIT = 0;

  public enum State
  {
    OFF, ON;
  }

  public boolean isOn() {
    this.isOn == State.ON;
  }

  public int canTurnOff() {
    return this.isOn;
  }

  public int turnOff() {
    return this.isOn = State.OFF;
  }

  public int turnOn() {
    return this.isOn = State.ON;
  }

  /* Change it to state like turnOn, turnOff.
  // private void toggleState() {
  //   this.isOn = !this.isOn;
     }
  */

  public int powerConsumed() {
    return (this.isOn ? CONSUMPTION_PER_UNIT : 0);
  }

}