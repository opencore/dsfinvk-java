module com.opencore.dsfinvk {

  requires java.validation;
  requires com.fasterxml.jackson.annotation;
  requires com.fasterxml.jackson.databind;
  requires java.xml;
  requires java.desktop;

  requires com.opencore.gobd;
  requires commons.csv;

  opens com.opencore.dsfinvk.models.stammdaten to org.hibernate.validator;
  opens com.opencore.dsfinvk.models.einzelaufzeichnung to org.hibernate.validator;
  opens com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf to org.hibernate.validator;
  opens com.opencore.dsfinvk.models.einzelaufzeichnung.bonpos to org.hibernate.validator;
  opens com.opencore.dsfinvk.models.kassenabschluss to org.hibernate.validator;
  opens com.opencore.dsfinvk.models to org.hibernate.validator;
  opens com.opencore.dsfinvk.util to org.hibernate.validator;
}
