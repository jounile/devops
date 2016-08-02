package controllers

import play.api.mvc._
import services.common.TextService
import utils.Config

object Application extends Controller with Config with TextService {

  def index = Action {
    Ok(views.html.index(getText(), conf("year"), conf("siili")))
  }

  def form = Action {
    Ok(views.html.form("my message"))
  }

}
