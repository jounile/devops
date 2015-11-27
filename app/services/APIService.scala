package services

trait APIService {
  def getAPIDescription(): scala.concurrent.Future[String]
}