package module

import com.tzavellas.sse.guice.ScalaModule

import services.APIService
import services.RestService
import services.impl.APIServiceImpl
import services.impl.RestServiceImpl

class ProductionModule extends ScalaModule {

  def configure() {
    bind[RestService].to[RestServiceImpl]
    bind[APIService].to[APIServiceImpl]
  }
}