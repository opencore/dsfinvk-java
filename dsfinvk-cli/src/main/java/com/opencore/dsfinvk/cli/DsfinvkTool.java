package com.opencore.dsfinvk.cli;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import com.opencore.dsfinvk.parser.DsfinvkParser;
import com.opencore.gdpdu.data.ParsingException;
import picocli.CommandLine;
import picocli.CommandLine.Option;

public class DsfinvkTool implements Callable<Integer> {

  @Option(names = "-f", description = "Path to the index.xml file", required = true)
  private File indexXml;

  public static void main(String[] args) {
    int exitCode = new CommandLine(new DsfinvkTool()).execute(args);
    System.exit(exitCode);
  }

  @Override
  public Integer call() throws Exception {
    try {
      DsfinvkParser.parseAndValidate(indexXml);
    } catch (IOException | ParsingException e) {
      e.printStackTrace();
      return 1;
    }
    return 0;
  }
}
