package models

import play.api.libs.json.Json

case class Technology(title: String, body: String)

object JsonFormats{
  implicit val technologyFormat = Json.format[Technology]
}
