module com.opencore.dsfinvk.models {

  requires java.validation;
  requires com.opencore.gdpdu.models;

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
