package utils

import play.api.Play
import play.api.Play.current

trait Config {

  lazy val config = Play.configuration

  def conf(key: String) = {
    config.getString(key).getOrElse("key missing")
  }
}