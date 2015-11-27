package controllers

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
}