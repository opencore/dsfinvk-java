module com.opencore.dsfinvk {

  requires com.opencore.gdpdu.data;
  requires com.opencore.gdpdu.models;
  requires com.opencore.gdpdu.index;
  requires commons.csv;

  requires java.validation;
  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.databind;
  requires java.xml;
  requires java.desktop;

  exports com.opencore.dsfinvk.models.stammdaten;
  exports com.opencore.dsfinvk.models.einzelaufzeichnung;
  exports com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf;
  exports com.opencore.dsfinvk.models.einzelaufzeichnung.bonpos;
  exports com.opencore.dsfinvk.models.kassenabschluss;
  exports com.opencore.dsfinvk.models;
  exports com.opencore.dsfinvk.util;

  opens com.opencore.dsfinvk.models;
  opens com.opencore.dsfinvk.models.einzelaufzeichnung;
  opens com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf;
  opens com.opencore.dsfinvk.models.einzelaufzeichnung.bonpos;
  opens com.opencore.dsfinvk.models.kassenabschluss;
  opens com.opencore.dsfinvk.models.stammdaten;

}
