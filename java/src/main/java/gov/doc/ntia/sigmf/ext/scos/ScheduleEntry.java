package gov.doc.ntia.sigmf.ext.scos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleEntry implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  @JsonProperty(value = "id", required = true)
  protected String id;

  @NotNull
  @JsonProperty(value = "name", required = true)
  protected String name;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @JsonProperty(value = "stop", required = false)
  protected Date stop;

  @JsonProperty(value = "interval", required = false)
  protected Integer interval;

  @JsonProperty(value = "priority", required = false)
  protected Integer priority;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
  @JsonProperty(value = "start", required = false)
  protected Date start;

  @JsonProperty List<String> roles;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getStop() {
    return stop;
  }

  public void setStop(Date stop) {
    this.stop = stop;
  }

  public Integer getInterval() {
    return interval;
  }

  public void setInterval(Integer interval) {
    this.interval = interval;
  }

  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public void addRole(String role) {
    if (this.roles == null) {
      roles = new ArrayList<>();
    }
    roles.add(role);
  }

  public void removeRole(String role) {
    if (roles != null) {
      roles.remove(role);
    }
  }

  /**
   * Parses the schedule name from the URL/ID of the ScheduleEntry.
   *
   * @return the name of the ScheduleEntry.
   */
  @JsonIgnore
  public String getScheduleNameFromUrl() {
    String scheduleName = "";
    if (id != null) {
      if (id.endsWith("/")) {
        scheduleName = id.substring(0, id.length() - 1);
      }
      int index = scheduleName.lastIndexOf("/");
      scheduleName = scheduleName.substring(index + 1);
    }
    return scheduleName;
  }
}
