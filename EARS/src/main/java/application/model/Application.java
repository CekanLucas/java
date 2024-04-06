package application.model;

import javafx.beans.property.SimpleStringProperty;

public class Application {
  private final SimpleStringProperty name;
  private final SimpleStringProperty applicationText;

  public Application(String name, String applicationText) {
      this.name = new SimpleStringProperty(name);
      this.applicationText = new SimpleStringProperty(applicationText);
  }

  public String getName() {
      return name.get();
  }

  public void setName(String name) {
      this.name.set(name);
  }

  public String getApplicationText() {
      return applicationText.get();
  }

  public void setApplicationText(String applicationText) {
      this.applicationText.set(applicationText);
  }
}
