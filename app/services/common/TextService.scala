package services.common

import models.Text
import utils.Config

trait TextService extends Config {

  def getText(): Text = {

    val title = conf("title")

    val firstTitle = conf("first.title")
    val firstBody = conf("first.body")
    val secondTitle = conf("second.title")
    val secondBody = conf("second.body")
    val thirdTitle = conf("third.title")
    val thirdBody = conf("third.body")
    val fourthTitle = conf("fourth.title")
    val fourthBody = conf("fourth.body")

    val twitterLink = conf("twitter.link")
    val websiteLink = conf("website.link")
    val linkedinLink = conf("linkedin.link")

    val firstCaruselText = conf("first.carusel.text")
    val secondCaruselText = conf("second.carusel.text")
    val thirdCaruselText = conf("third.carusel.text")
    val fourthCaruselText = conf("fourth.carusel.text")
    val fifthCaruselText = conf("fifth.carusel.text")

    val year = conf("year")
    val siili = conf("siili")

    val text = new Text(title, firstTitle, firstBody, secondTitle, secondBody, thirdTitle, thirdBody, fourthTitle, fourthBody,
      twitterLink, websiteLink, linkedinLink, firstCaruselText,
      secondCaruselText, thirdCaruselText, fourthCaruselText, fifthCaruselText, year, siili)
    text
  }
}
