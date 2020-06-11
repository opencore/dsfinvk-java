package com.opencore.dsfinvk.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * This is needed because Jackson does not deserialize "0" and "1" if they are strings, only if they are Json numbers.
 */
public class NumericBooleanDeserializer extends JsonDeserializer<Boolean> {

  @Override
  public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    JsonToken currentToken = p.getCurrentToken();
    if (currentToken == JsonToken.VALUE_STRING) {
      String text = p.getText();
      if (text == null || text.isBlank()) {
        return null;
      }
      switch (text.trim()) {
        case "0":
          return false;
        case "1":
          return true;
        default:
          ctxt.handleWeirdStringValue(Boolean.class, text.trim(), "Only '0' and '1' are allowed");
          return false;
      }
    }
    if (currentToken == JsonToken.VALUE_NULL) {
      return false;
    }

    return (Boolean) ctxt.handleUnexpectedToken(Boolean.class, p);

  }
}
