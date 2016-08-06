package controllers

import play.api.mvc._
import play.api.libs.json.{JsArray, Json}
import services.common.TextService
import utils.Config
import play.api.data._
import play.api.data.Forms._
import models.{Task, Technology}
import anorm._
import anorm.SqlParser._

object Application extends Controller with Config with TextService {

  def index = Action {
    Ok(views.html.index(getText(), conf("year"), conf("siili")))
  }

  def form = Action {
    Ok(views.html.form("my message"))
  }

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

  def technologies = Action {
    Ok(views.html.technologies(Technology.all()))
  }



}
