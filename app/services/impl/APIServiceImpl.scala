package services.impl

import java.io.{BufferedWriter, File, FileWriter}

import play.api.libs.json.Json.toJsFieldJsValueWrapper
import play.api.libs.json.{JsArray, JsObject, JsValue, Json}
import services.APIService
import services.common.RegularExpressionService
import utils.Config

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
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

  def addComments(comment: JsObject): scala.concurrent.Future[String] = {
    val filename = conf("comments.json")

    val existingJson = parseJsonFromFile(filename)
    val newArray = Json.arr(comment).as[JsArray]
    val merged = newArray.++(existingJson)

    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(merged.toString())
    bw.close()
    val fileContents = Source.fromFile(filename).getLines.mkString
    Future(fileContents)
  }

  private def parseJsonFromFile(filename: String): JsArray = {
    val json = Source.fromFile(filename).getLines.mkString
    val parsedJson: JsValue = Json.parse(json)
    val parsed = parsedJson.as[JsArray]
    parsed
  }

}