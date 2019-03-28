package gov.doc.ntia.sigmf;

import java.io.Serializable;

public class Extension implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String name;

    protected String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}
