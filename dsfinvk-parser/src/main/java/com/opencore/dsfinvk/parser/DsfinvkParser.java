package com.opencore.dsfinvk.parser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import com.opencore.dsfinvk.models.einzelaufzeichnung.BonReferenzen;
import com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf.Bonkopf;
import com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf.BonkopfAbrKreis;
import com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf.BonkopfUst;
import com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf.BonkopfZahlarten;
import com.opencore.dsfinvk.models.einzelaufzeichnung.bonkopf.TseTransaktionen;
import com.opencore.dsfinvk.models.einzelaufzeichnung.bonpos.Bonpos;
import com.opencore.dsfinvk.models.einzelaufzeichnung.bonpos.BonposPreisfindung;
import com.opencore.dsfinvk.models.einzelaufzeichnung.bonpos.BonposUst;
import com.opencore.dsfinvk.models.einzelaufzeichnung.bonpos.BonposZusatzinfo;
import com.opencore.dsfinvk.models.kassenabschluss.ZGVTyp;
import com.opencore.dsfinvk.models.kassenabschluss.ZWaehrungen;
import com.opencore.dsfinvk.models.kassenabschluss.ZZahlart;
import com.opencore.dsfinvk.models.stammdaten.StammAbschluss;
import com.opencore.dsfinvk.models.stammdaten.StammAgenturen;
import com.opencore.dsfinvk.models.stammdaten.StammKassen;
import com.opencore.dsfinvk.models.stammdaten.StammOrte;
import com.opencore.dsfinvk.models.stammdaten.StammTerminals;
import com.opencore.dsfinvk.models.stammdaten.StammUst;
import com.opencore.dsfinvk.util.StrictGroup;
import com.opencore.gdpdu.data.GdpduDataParser;
import com.opencore.gdpdu.data.ParsingException;
import com.opencore.gdpdu.index.GdpduIndexParser;
import com.opencore.gdpdu.index.models.DataSet;
import com.opencore.gdpdu.index.models.Media;
import com.opencore.gdpdu.index.models.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DsfinvkParser {

  private static final Logger LOG = LoggerFactory.getLogger(DsfinvkParser.class);

  private static final Map<String, Class<?>> TABLE_MAP = new HashMap<>();
  private static final GdpduDataParser GDPDU_DATA_PARSER = new GdpduDataParser();

  public static void parseAndValidate(String indexXmlFile) throws IOException, ParsingException {
    parseAndValidate(new File(Objects.requireNonNull(indexXmlFile)));
  }

  public static void parseAndValidate(File indexXmlFile) throws IOException, ParsingException {
    Objects.requireNonNull(indexXmlFile);
    DataSet index = GdpduIndexParser.parseXmlFile(indexXmlFile, GdpduIndexParser.ParseMode.LENIENT);

    for (Media media : index.getMedia()) {
      for (Table table : media.getTables()) {
        LOG.info("Parsing table {}/{} ({})", media.getName(), table.getName(), table.getUrl());

        Class<?> clazz = TABLE_MAP.get(table.getUrl());
        if (clazz == null) {
          LOG.warn("Could not find class for [{}]", table.getUrl());
          continue;
        }

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        List<?> objects = parseTable(indexXmlFile, table.getName(), clazz);
        for (Object object : objects) {
          Set<ConstraintViolation<Object>> violations = validator.validate(object, StrictGroup.class, Default.class);
          if (violations.isEmpty()) {
            continue;
          }
          LOG.warn("Violations found for: [{}]", object);
          for (ConstraintViolation<Object> violation : violations) {
            LOG.warn("Violation ({}): {}", violation.getPropertyPath(), violation.getMessage());
          }
        }

      }
    }

  }

  private static <T> List<T> parseTable(File indexXml, String tableName, Class<T> clazz) throws ParsingException {
    return GDPDU_DATA_PARSER.parseTable(indexXml, tableName, clazz);
  }

  static {
    TABLE_MAP.put(Bonkopf.FILENAME, Bonkopf.class);
    TABLE_MAP.put(BonkopfAbrKreis.FILENAME, BonkopfAbrKreis.class);
    TABLE_MAP.put(BonkopfUst.FILENAME, BonkopfUst.class);
    TABLE_MAP.put(BonkopfZahlarten.FILENAME, BonkopfZahlarten.class);
    TABLE_MAP.put(TseTransaktionen.FILENAME, TseTransaktionen.class);

    TABLE_MAP.put(Bonpos.FILENAME, Bonpos.class);
    TABLE_MAP.put(BonposPreisfindung.FILENAME, BonposPreisfindung.class);
    TABLE_MAP.put(BonposUst.FILENAME, BonposUst.class);
    TABLE_MAP.put(BonposZusatzinfo.FILENAME, BonposZusatzinfo.class);

    TABLE_MAP.put(BonReferenzen.FILENAME, BonReferenzen.class);

    TABLE_MAP.put(ZGVTyp.FILENAME, ZGVTyp.class);
    TABLE_MAP.put(ZWaehrungen.FILENAME, ZWaehrungen.class);
    TABLE_MAP.put(ZZahlart.FILENAME, ZZahlart.class);

    TABLE_MAP.put(StammAbschluss.FILENAME, StammAbschluss.class);
    TABLE_MAP.put(StammAgenturen.FILENAME, StammAgenturen.class);
    TABLE_MAP.put(StammKassen.FILENAME, StammKassen.class);
    TABLE_MAP.put(StammOrte.FILENAME, StammOrte.class);
    TABLE_MAP.put(StammTerminals.FILENAME, StammTerminals.class);
    //TABLE_MAP.put(StammTse.F)
    TABLE_MAP.put(StammUst.FILENAME, StammUst.class);
  }

}
