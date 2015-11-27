package services

trait RestService {
  def connect(name: String): scala.concurrent.Future[String]
}