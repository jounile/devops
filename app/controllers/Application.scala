package controllers

import play.api._
import play.api.mvc._
import utils.Config
import services.common.TextService

object Application extends Controller with Config with TextService {

  def index = Action {
    Ok(views.html.index(conf("blog.user.name"), getText(), conf("year")))
  }

  def test = Action {
    Ok(views.html.ajax(conf("blog.user.name")))
  }
}
