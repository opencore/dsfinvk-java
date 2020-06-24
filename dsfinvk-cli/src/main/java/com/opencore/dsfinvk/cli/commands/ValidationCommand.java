package com.opencore.dsfinvk.cli.commands;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import com.opencore.dsfinvk.parser.DsfinvkParser;
import com.opencore.gdpdu.common.exceptions.ParsingException;
import picocli.CommandLine;

@CommandLine.Command(name = "validation", description = "This command can be used to validate a full DSFinV-K export")
public class ValidationCommand implements Callable<Integer> {

  @CommandLine.Option(names = "-f", description = "Path to the index.xml file", required = true)
  private File indexXml;

  @Override
  public Integer call() {
    try {
      DsfinvkParser.parseAndValidate(indexXml);
    } catch (IOException | ParsingException e) {
      e.printStackTrace();
      return 1;
    }
    return 0;
  }

}
