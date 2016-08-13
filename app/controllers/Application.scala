package controllers

import play.api.mvc._
import play.api.libs.json.{JsArray, Json}
import services.common.TextService
import utils.Config
import play.api.data._
import play.api.data.Forms._
import models.{Task, Technology, Page}
import play.api.libs.json._
import play.api.libs.functional.syntax._

object Application extends Controller with Config with TextService {

  def index = Action {
    Ok(views.html.index(getText(), conf("year"), conf("siili")))
  }

  def form = Action {
    Ok(views.html.form("my message"))
  }


  // Tasks

  def tasks = Action {
    Ok(views.html.tasks(Task.all(), taskForm))
  }

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.tasks(Task.all(), errors)),
      label => {
        Task.create(label)
        Redirect(routes.Application.tasks)
      }
    )
  }

  def deleteTask(id: Long) = Action {
    Task.delete(id)
    Redirect(routes.Application.tasks)
  }



  // Technologies

  implicit val technologyWrites: Writes[Technology] = (
    (JsPath \ "title").write[String] and
      (JsPath \ "link").write[String] and
        (JsPath \ "body").write[String]
  )(unlift(Technology.unapply))

  def getTechnologies = Action {
    Ok(Json.toJson(Technology.all()))
//    Ok(views.html.technologies(Technology.all()))
  }

  // Pages

  implicit val pageWrites: Writes[Page] = (
    (JsPath \ "title").write[String] and
      (JsPath \ "link").write[String] and
      (JsPath \ "body").write[String]
    )(unlift(Page.unapply))

  def getPages = Action {
    Ok(Json.toJson(Page.all()))
  }

}
