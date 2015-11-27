package services.common

trait RegularExpressionService {

  def escapeSpecialChars(text: String): String = {
    text.replaceAll("[^+ÄäÖöÅåA-Za-z0-9\\s]", new String())
  }
}
