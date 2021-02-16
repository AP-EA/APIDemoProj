
package com.test.bin;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "EntityIdentifierCode",
    "IdentificationCodeQualifier",
    "IdentificationCode"
})
public class Name_ {

    @JsonProperty("EntityIdentifierCode")
    private String entityIdentifierCode;
    @JsonProperty("IdentificationCodeQualifier")
    private String identificationCodeQualifier;
    @JsonProperty("IdentificationCode")
    private String identificationCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("EntityIdentifierCode")
    public String getEntityIdentifierCode() {
        return entityIdentifierCode;
    }

    @JsonProperty("EntityIdentifierCode")
    public void setEntityIdentifierCode(String entityIdentifierCode) {
        this.entityIdentifierCode = entityIdentifierCode;
    }

    @JsonProperty("IdentificationCodeQualifier")
    public String getIdentificationCodeQualifier() {
        return identificationCodeQualifier;
    }

    @JsonProperty("IdentificationCodeQualifier")
    public void setIdentificationCodeQualifier(String identificationCodeQualifier) {
        this.identificationCodeQualifier = identificationCodeQualifier;
    }

    @JsonProperty("IdentificationCode")
    public String getIdentificationCode() {
        return identificationCode;
    }

    @JsonProperty("IdentificationCode")
    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
