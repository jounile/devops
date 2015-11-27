package services.common

import models.Text
import utils.Config

trait TextService extends Config {

  def getText(): Text = {
    val firstHeader = conf("first.header")
    val firstText = conf("first.text")
    val secondHeader = conf("second.header")
    val secondText = conf("second.text")
    val thirdHeader = conf("third.header")
    val thirdText = conf("third.text")

    val twitterLink = conf("twitter.link")
    val githubLink = conf("github.link")
    val linkedinLink = conf("linkedin.link")

    val firstCaruselHeader = conf("first.carusel.header")
    val firstCaruselText = conf("first.carusel.text")
    val secondCaruselHeader = conf("second.carusel.header")
    val secondCaruselText = conf("second.carusel.text")
    val thirdCaruselHeader = conf("third.carusel.header")
    val thirdCaruselText = conf("third.carusel.text")

    val oldSite= conf("old.site.url")
    val thesis = conf("master.thesis.url")

    val text = new Text(firstHeader, firstText, secondHeader, secondText, thirdHeader, thirdText,
      twitterLink, githubLink, linkedinLink, firstCaruselHeader, firstCaruselText, secondCaruselHeader,
      secondCaruselText, thirdCaruselHeader, thirdCaruselText, oldSite, thesis)
    text
  }
}
