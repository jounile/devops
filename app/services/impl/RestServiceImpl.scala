package services.impl

import services.RestService
import play.api.libs.ws.WS
import scala.concurrent.Future
import play.api.Play.current
import scala.concurrent.ExecutionContext.Implicits.global

class RestServiceImpl extends RestService {

  def connect(name: String): scala.concurrent.Future[String] = {
    WS.url(name).get.map(f => f.body)
  }
}
