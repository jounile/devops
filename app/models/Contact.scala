package models

import anorm.SqlParser._
import anorm._
import play.api.Play.current
import play.api.db.DB

case class Contact(id: Long, name: String, email: String, message: String)

object Contact {

  DB.withConnection { implicit c =>
    val result: Boolean = SQL("Select 1").execute()
  }

  val contact = {
    get[Long]("id") ~
      get[String]("name") ~
    get[String]("email") ~
    get[String]("message") map {
      case id~name~email~message => Contact(id, name, email, message)
    }
  }

  def all(): List[Contact] = DB.withConnection { implicit c =>
    SQL("select * from contact").as(contact *)
  }

  def create(name: String, email: String, message: String) {
    DB.withConnection { implicit c =>
      SQL("insert into contact (name,email,message) values ({name},{email},{message})")
        .on('name -> name)
        .on('email -> email)
        .on('message -> message
      ).executeUpdate()
    }
  }

}