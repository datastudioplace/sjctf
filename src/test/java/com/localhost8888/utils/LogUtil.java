package com.localhost8888.utils;

import java.io.BufferedWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

  // File format for the log name
  ZonedDateTime date = ZonedDateTime.now();
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
  String fileNameFormat = date.format(formatter);

  private BufferedWriter bufferedWriter = null;

  // Write message within the log
  public void Write(String message) {
    try {
      formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH_MM_SS");
      String dateFormat = date.format(formatter);
      bufferedWriter.write("[" + dateFormat + "]: " + message);
      bufferedWriter.newLine();
      bufferedWriter.flush();
    } catch (Exception e) {

    }
  }
}
