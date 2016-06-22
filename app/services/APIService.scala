package services

import play.api.libs.json.JsObject

trait APIService {
  def getAPIDescription(): scala.concurrent.Future[String]

  def getComments(): scala.concurrent.Future[String]

  def addComments(comment: JsObject): scala.concurrent.Future[String]
}