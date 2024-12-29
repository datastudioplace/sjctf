/**
 * @author rahul.rathore
 *     <p>07-Aug-2016
 */
package com.localhost8888.helperutilities.HyperLink;

import com.localhost8888.helperutilities.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class LinkHelper {

  private final Logger log = LoggerHelper.getLogger(LinkHelper.class);

  public String getHyperLink(WebElement element) {
    String link = element.getAttribute("hreg");
    log.info("Element : " + element + " Value : " + link);
    return link;
  }
}
