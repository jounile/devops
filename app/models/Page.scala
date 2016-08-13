package models

import anorm.SqlParser._
import anorm._
import play.api.Play.current
import play.api.db.DB
import play.api.libs.json.{JsArray, Json}

case class Page(title: String, link: String, body: String)

object Page {

  DB.withConnection { implicit c =>
    val result: Boolean = SQL("Select 1").execute()
  }

  val page = {
    get[String]("title") ~
      get[String]("link") ~
      get[String]("body") map {
      case title ~link ~ body => Page(title, link, body)
    }
  }

  def all(): List[Page] = DB.withConnection { implicit c =>
    SQL("select * from pages").as(page *)
  }

}