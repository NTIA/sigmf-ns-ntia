package gov.doc.ntia.sigmf.ext.global.algorithm;

import com.fasterxml.jackson.annotation.JsonProperty;import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gov.doc.ntia.sigmf.serialization.DataProductsSerializer;
import java.util.ArrayList;

@JsonSerialize(using = DataProductsSerializer.class)
public class DataProducts {

  private String reference;

  @JsonProperty(value = "digital_filter")
  protected String digitalFilter;

  private ArrayList<DataProduct> dataProducts;

  public void add(DataProduct dataProduct){
    if(dataProducts == null){
      dataProducts = new ArrayList<>();
    }
    dataProducts.add(dataProduct);
  }

  public void remove(DataProduct dataProduct){
    if(dataProducts != null){
      dataProducts.remove(dataProduct);
    }
  }

  public ArrayList<DataProduct> getDataProducts(){
    return dataProducts;
  }

  public void setReference(String reference){
    this.reference = reference;
  }

  public String getReference(){
    return reference;
  }

  public String getDigitalFilter() {
    return digitalFilter;
  }

  public void setDigitalFilter(String digitalFilter) {
    this.digitalFilter = digitalFilter;
  }
}
