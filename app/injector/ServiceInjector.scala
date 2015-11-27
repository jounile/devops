package injector

import com.google.inject.Guice
import com.google.inject.Injector

import module.ProductionModule
import module.TestModule
import play.Logger
import play.Logger
import play.Play
import services.APIService
import services.RestService
import utils.Config

trait ServiceInjector extends Config {

  lazy val injector = getInjector

  def getRestService(): RestService = {
    val restService = injector.getInstance(classOf[RestService])
    restService
  }

  def getAPIService(): APIService = {
    val apiService = injector.getInstance(classOf[APIService])
    apiService
  }

  private def getInjector(): Injector = {
    Logger.debug("" + conf("test.application"))
    if (Play.isTest || conf("test.application") == "test") {
      Logger.info("Starting application in test mode...")
      Guice.createInjector(new TestModule())
    } else {
      Logger.info("Starting application in production mode...")
      Guice.createInjector(new ProductionModule())
    }
  }

}