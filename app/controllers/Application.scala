package controllers

import play.api.mvc._
import play.api.libs.json.{JsArray, Json}
import utils.Config
import play.api.data._
import play.api.data.Forms._
import models._
import play.api.Play.current
import play.api.i18n.Messages
import play.api.i18n.Messages.Implicits._
import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.twirl.api.Html

object Application extends Controller with Config {



  def index = Action {
    Ok(views.html.index(""))
  }

  def form = Action {
    Ok(views.html.form("Welcome to Scala Play + Bootstrap + AngularJS"))
  }




  // Contact

  def contact = Action {
    Ok(views.html.contacts("", Contact.all(), contactForm))
  }

  val contactForm = Form(
    "name" -> nonEmptyText
  )

  def newContact = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.contacts("", Contact.all(), errors)),
      name => {
        Contact.create(name, "", "")
        Redirect(routes.Application.contact)
      }
    )
  }




  // Tasks

  def tasks = Action {
    Ok(views.html.tasks("", Task.all(), taskForm))
  }

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  def newTask = Action { implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.tasks("", Task.all(), errors)),
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
  }

  // Pages

  implicit val pageWrites: Writes[Page] = (
    (JsPath \ "title").write[String] and
      (JsPath \ "path").write[String] and
        (JsPath \ "body").write[String]
    )(unlift(Page.unapply))

  def getPages = Action {
    Ok(Json.toJson(Page.getPages()))
  }



  def getPage(path: String) = Action {
    Ok(views.html.page("", Page.getPage(path)))
  }

}
