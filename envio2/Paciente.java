
public class Paciente {
  private byte ID;
  private int press_manha;
  private int press_tarde;
  private int press_noite;

  public void setID(byte ID) {
    this.ID = ID;
  }

  public void setpress_manha(int press_manha) {
    this.press_manha = press_manha;
  }

  public void setpress_tarde(int press_tarde) {
    this.press_tarde = press_tarde;
  }

  public void setpress_noite(int press_noite) {
    this.press_noite = press_noite;
  }

  public byte getID() {
    return this.ID;
  }

  public int getpress_manha() {
    return this.press_manha;
  }

  public int getpress_tarde() {
    return this.press_tarde;
  }

  public int getpress_noite() {
    return this.press_noite;
  }

  public String toString() {
    return this.getID() + " - " + this.getpress_manha() + " - " +
        this.getpress_tarde() + " - " + this.getpress_noite();
  }
}
