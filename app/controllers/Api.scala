package controllers

import play.api.Play._
import models._
import models.JsonFormats._
import play.api._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import models.Technology
import play.api.db
import play.api.libs.json.{JsArray, JsObject, Json}
import play.api.mvc.{Action, Controller}
import play.api.i18n.MessagesApi
import play.api.Play.current
import play.modules.reactivemongo._
import play.modules.reactivemongo.json._
import reactivemongo.api.Cursor
import reactivemongo.core.actors.Exceptions.PrimaryUnavailableException
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.Future

object Api extends Controller {

  lazy val reactiveMongoApi = current.injector.instanceOf[ReactiveMongoApi]

  def api = Action { implicit request =>
    Ok(views.html.api("API 1.0"))
  }

  def collection: Future[JSONCollection] = reactiveMongoApi.database.map(_.collection[JSONCollection]("technologies"))

  /*
    def findAll = Action {
      Ok(views.html.api("FindAll"))
    }
  */

    def findAll = Action.async{ implicit request =>

      collection.map(i => Ok("Got result: " + i))

      /*
      // let's do our query
      val cursor: Cursor[Technology] = collection.find(Json.obj()).cursor[Technology]

      // gather all the Technology in a list
      val futureTechnologyList :Future[List[Technology]] = cursor.collect[List]()

      // transform the list into a JsArray
      val futureTechnologyJsonArray :Future[JsArray] = futureTechnologyList.map { Technology =>
        Json.arr(Technology)
      }

      // everything's ok! Let's reply with the array
      futureTechnologyJsonArray.map { Technology =>
        Ok(Technology)
      }
      */
    }

}
