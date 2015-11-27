package services.mock

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import services.RestService

class MockRestService extends RestService {

  def connect(name: String): scala.concurrent.Future[String] = {
    Future("this is mock response")
  }
}