package junit

import org.junit.Test
import utils.Config
import org.junit.Assert
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import play.api.mvc.Controller
import play.mvc.Result
import play.api.libs.json.Json._
import play.api.Play
import utils.Config
import services.common.TextService

class TextServiceTest extends Specification with Config with TextService {
    @Test def getTextService() {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
      val returnValue = getText()
      Assert.assertNotNull(returnValue)
      Assert.assertEquals(conf("first.header"), returnValue.firstTitle)
      Assert.assertEquals(conf("first.text"), returnValue.firstBody)
    }
  }

}
