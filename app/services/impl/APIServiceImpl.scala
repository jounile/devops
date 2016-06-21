package services.impl

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import play.api.libs.json.Json
import play.api.libs.json.Json.toJsFieldJsValueWrapper
import services.APIService
import utils.Config
import services.common.RegularExpressionService

import scala.io.Source

class APIServiceImpl extends APIService with Config with RegularExpressionService {

  def getAPIDescription(): scala.concurrent.Future[String] = {

    val userName = escapeSpecialChars(conf("blog.user.name"))

    val json = Json.obj(
      "blog" -> userName,
      "text" -> "title text",
      "links" -> "list of links")

    Future(json.toString)
  }

  def getComments(): scala.concurrent.Future[String] = {
    val filename = conf("comments.json")
    val fileContents = Source.fromFile(filename).getLines.mkString
    Future(fileContents)
  }
}