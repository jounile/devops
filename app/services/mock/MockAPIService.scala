package services.mock

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import services.APIService

class MockAPIService extends APIService {

  def getAPIDescription(): scala.concurrent.Future[String] = {
    Future("api")
  }
}