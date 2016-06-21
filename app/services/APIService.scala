package services

trait APIService {
  def getAPIDescription(): scala.concurrent.Future[String]

  def getComments(): scala.concurrent.Future[String]
}