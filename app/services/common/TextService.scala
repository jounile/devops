package services.common

import models.Text
import utils.Config

trait TextService extends Config {

  def getText(): Text = {

    val title = conf("title")

    val firstHeader = conf("first.header")
    val firstText = conf("first.text")
    val secondHeader = conf("second.header")
    val secondText = conf("second.text")
    val thirdHeader = conf("third.header")
    val thirdText = conf("third.text")
    val fourthHeader = conf("fourth.header")
    val fourthText = conf("fourth.text")

    val twitterLink = conf("twitter.link")
    val websiteLink = conf("website.link")
    val linkedinLink = conf("linkedin.link")

    val firstCaruselText = conf("first.carusel.text")
    val secondCaruselText = conf("second.carusel.text")
    val thirdCaruselText = conf("third.carusel.text")
    val fourthCaruselText = conf("fourth.carusel.text")
    val fifthCaruselText = conf("fifth.carusel.text")

    val text = new Text(title, firstHeader, firstText, secondHeader, secondText, thirdHeader, thirdText, fourthHeader, fourthText,
      twitterLink, websiteLink, linkedinLink, firstCaruselText,
      secondCaruselText, thirdCaruselText, fourthCaruselText, fifthCaruselText)
    text
  }
}
