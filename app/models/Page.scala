package models

import anorm.SqlParser._
import anorm._
import play.api.Play.current
import play.api.db.DB
import play.api.libs.json.{JsArray, Json}

case class Page(title: String, path: String, body: String)

object Page {

  DB.withConnection { implicit c =>
    val result: Boolean = SQL("Select 1").execute()
  }

  val page = {
    get[String]("title") ~
      get[String]("path") ~
      get[String]("body") map {
      case title ~path ~ body => Page(title, path, body)
    }
  }

  def getPages(): List[Page] = DB.withConnection { implicit c =>
    SQL("select * from pages").as(page *)
  }

  def getPage(path: String): List[Page] = DB.withConnection { implicit c =>
    SQL("select * from pages where path = {path}")
      .on("path" -> path)
      .as(page *)
  }

}