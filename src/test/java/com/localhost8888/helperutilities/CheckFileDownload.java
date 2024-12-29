package com.localhost8888.helperutilities;

import java.io.File;
import org.testng.Assert;

public class CheckFileDownload {
  public static boolean isFileDownloaded(String downloadPath, String fileName) throws Exception {
    Thread.sleep(3000);

    File dir = new File(downloadPath);
    File[] dirContents = dir.listFiles();

    for (int i = 0; i < dirContents.length; i++) {
      if (dirContents[i].getName().contains(fileName)) {
        Assert.assertTrue(true, "Unable to download ...");
        return true;
      }
    }
    return false;
  }
}
