package services.mock

import play.api.libs.json.Json

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import services.APIService

class MockAPIService extends APIService {

  def getAPIDescription(): scala.concurrent.Future[String] = {
    Future("api")
  }

  def getComments(): scala.concurrent.Future[String] = {

    val json = Json.arr(Json.obj(
      "id" -> 1,
      "author" -> "Jukka Edvardsson",
      "text" -> "nice home page"),
      Json.obj(
        "id" -> 2,
        "author" -> "First visitor",
        "text" -> "nice, but where is clojureScript"))

    Future(json.toString)
  }
}