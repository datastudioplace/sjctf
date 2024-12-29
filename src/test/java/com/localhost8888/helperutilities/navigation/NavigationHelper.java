package com.localhost8888.helperutilities.navigation;

import com.localhost8888.helperutilities.logger.LoggerHelper;
import com.localhost8888.interfaces.IwebComponent;
import com.localhost8888.webdriverutilities.WebDrv;
import java.net.URL;
import org.apache.log4j.Logger;

public class NavigationHelper implements IwebComponent {

  private final Logger log = LoggerHelper.getLogger(NavigationHelper.class);

  public NavigationHelper() {
    log.debug("NavigationHelper : " + WebDrv.getInstance().getWebDriver().hashCode());
  }

  public void navigateTo(String url) {
    log.info(url);
    WebDrv.getInstance().getWebDriver().get(url);
  }

  public void navigateTo(URL url) {
    log.info(url.getPath());
    WebDrv.getInstance().getWebDriver().get(url.getPath());
  }

  public String getTitle() {
    String title = WebDrv.getInstance().getWebDriver().getTitle();
    log.info(title);
    return WebDrv.getInstance().getWebDriver().getTitle();
  }

  public String getCurrentUrl() {
    String url = WebDrv.getInstance().getWebDriver().getCurrentUrl();
    log.info(url);
    return WebDrv.getInstance().getWebDriver().getCurrentUrl();
  }
}
