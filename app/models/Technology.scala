package models

import anorm.SqlParser._
import anorm._
import play.api.Play.current
import play.api.db.DB
import play.api.libs.json.{JsArray, Json}

case class Technology(title: String, link: String, body: String)

object Technology {

  DB.withConnection { implicit c =>
    val result: Boolean = SQL("Select 1").execute()
  }

  val technology = {
    get[String]("title") ~
      get[String]("link") ~
        get[String]("body") map {
      case title ~link ~ body => Technology(title, link, body)
    }
  }

  def all(): List[Technology] = DB.withConnection { implicit c =>
    SQL("select * from technologies").as(technology *)
  }

}