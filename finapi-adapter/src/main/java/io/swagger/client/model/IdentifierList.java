/*
 * finAPI RESTful Services
 * finAPI RESTful Services
 *
 * OpenAPI spec version: v1.46.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Set of identifiers (in ascending order)
 */
@ApiModel(description = "Set of identifiers (in ascending order)")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-05-14T19:12:52.919Z")
public class IdentifierList {
  @SerializedName("identifiers")
  private List<Long> identifiers = null;

  public IdentifierList identifiers(List<Long> identifiers) {
    this.identifiers = identifiers;
    return this;
  }

  public IdentifierList addIdentifiersItem(Long identifiersItem) {
    if (this.identifiers == null) {
      this.identifiers = new ArrayList<Long>();
    }
    this.identifiers.add(identifiersItem);
    return this;
  }

   /**
   * Set of identifiers (in ascending order)
   * @return identifiers
  **/
  @ApiModelProperty(value = "Set of identifiers (in ascending order)")
  public List<Long> getIdentifiers() {
    return identifiers;
  }

  public void setIdentifiers(List<Long> identifiers) {
    this.identifiers = identifiers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdentifierList identifierList = (IdentifierList) o;
    return Objects.equals(this.identifiers, identifierList.identifiers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifiers);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdentifierList {\n");
    
    sb.append("    identifiers: ").append(toIndentedString(identifiers)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

