package com.opencore.dsfinvk.cli;

import com.opencore.dsfinvk.cli.commands.TableCommand;
import com.opencore.dsfinvk.cli.commands.ValidationCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(subcommands = {TableCommand.class, ValidationCommand.class})
public class DsfinvkTool {

  public static void main(String[] args) {
    int exitCode = new CommandLine(new DsfinvkTool()).execute(args);
    System.exit(exitCode);
  }

}
