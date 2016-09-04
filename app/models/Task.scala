package models

import anorm.SqlParser._
import anorm._
import play.api.Play.current
import play.api.db.DB

case class Task(id: Long, label: String, title: String, link: String, cover: String)

object Task {

  DB.withConnection { implicit c =>
    val result: Boolean = SQL("Select 1").execute()
  }

  val task = {
    get[Long]("id") ~
      get[String]("label")~
      get[String]("title")~
      get[String]("link")~
      get[String]("cover") map {
      case id~label~title~link~cover => Task(id, label, title, link, cover)
    }
  }

  def all(): List[Task] = DB.withConnection { implicit c =>
    SQL("select * from task").as(task *)
  }

  def create(label: String,title: String,link: String,cover: String) {
    DB.withConnection { implicit c =>
      SQL("insert into task (label, title, link, cover) values ({label}, {title}, {link}, {cover})").on(
        'label -> label,
        'title -> title,
        'link -> link,
        'cover -> cover
      ).executeUpdate()
    }
  }

  def delete(id: Long) {
    DB.withConnection { implicit c =>
      SQL("delete from task where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }


}
