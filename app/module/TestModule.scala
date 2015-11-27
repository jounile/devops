package module

import com.tzavellas.sse.guice.ScalaModule

import services.APIService
import services.RestService
import services.mock.MockAPIService
import services.mock.MockRestService

class TestModule extends ScalaModule {

  def configure() {
    bind[RestService].to[MockRestService]
    bind[APIService].to[MockAPIService]
  }
}