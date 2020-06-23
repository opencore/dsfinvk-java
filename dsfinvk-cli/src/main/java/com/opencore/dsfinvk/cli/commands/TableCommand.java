package com.opencore.dsfinvk.cli.commands;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

import com.opencore.dsfinvk.parser.DsfinvkParser;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "table", description = "This command allows dealing with single tables")
public class TableCommand implements Callable<Integer> {

  @Option(names = "-f", description = "Path to the index.xml file", required = true)
  private File indexXml;

  @ArgGroup(exclusive = true, multiplicity = "1")
  private Target target;

  private static class Target {
    //@Option(names = "-t", required = true) String tableName; TODO: To support name we first need to map name to URL or have a separate Map but I'm not sure
    @Option(names = "-u", required = true) String url;
  }

  @Override
  public Integer call() throws Exception {
    Class<?> clazz = DsfinvkParser.getClassForFilename(target.url);

    List<?> objects = DsfinvkParser.parseTable(indexXml, target.url, clazz);
    System.out.println("Found [" + objects.size() + "] results");
    for (Object object : objects) {
      System.out.println(object);
    }
    return 0;
  }
}
