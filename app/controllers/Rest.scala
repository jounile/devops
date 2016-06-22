package controllers

import play.api.libs.json.{JsObject, JsValue, Json}

import scala.concurrent.ExecutionContext.Implicits.global

import injector.ServiceInjector
import play.api.mvc.Action
import play.api.mvc.Controller

object Rest extends Controller with ServiceInjector {

  lazy val restService = getRestService
  lazy val apiService = getAPIService

  def test = Action.async { implicit request =>
    restService.connect("http://www.hel.fi/palvelukarttaws/rest/v2/organization/") map (future =>
      Ok(future))
  }

  def api = Action.async { implicit request =>
    apiService.getAPIDescription() map (future =>
      Ok(future))
  }

  def comments = Action.async { implicit request =>
    apiService.getComments() map (future =>
      Ok(future))
  }

  def addComment = Action.async { implicit request =>
    println(request.body.asFormUrlEncoded)

    val bodyValues = request.body.asFormUrlEncoded
    val value = if (bodyValues.isDefined) {
      val json: Option[JsObject] = bodyValues.map(f => {
        val author = f.seq.get("author").get.head
        val text = f.seq.get("text").get.head
        val id = f.seq.get("id").get.head
        Json.obj(
          "id" -> id,
          "author" -> author,
          "text" -> text)
      })
      json
    } else {
      Some(Json.obj())
    }
    apiService.addComments(value.getOrElse(Json.obj())) map (future =>
      Ok(future))
  }
}