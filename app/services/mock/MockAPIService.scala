package services.mock

import java.io.{FileWriter, BufferedWriter, File}

import play.api.libs.json.{JsObject, Json}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import services.APIService

import scala.io.Source

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

  def addComments(comment: JsObject): scala.concurrent.Future[String] = {
    Future("")
  }
}