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
import services.common.RegularExpressionService

class RegularExpressionServiceTest extends Specification with Config with RegularExpressionService {
    @Test def escapeSpecialCharsWhenNoSpecialChars() {
      running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
      val user = conf("blog.user.name")
      val returnValue = escapeSpecialChars(user)
      Assert.assertNotNull(returnValue)
      Assert.assertEquals(user, returnValue)
    }
    }

    @Test def escapeSpecialCharsWhenNoBlogUserNameIsFound() {
        running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
          val user = conf("blog.user.name2")
          val returnValue = escapeSpecialChars(user)
          Assert.assertNotNull(returnValue)
          Assert.assertEquals("key missing", returnValue)
    }
    }

    @Test def escapeSpecialCharsWhenThereIsSpecialChars() {
        running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
          val user = "test user"
          val user2 = user + "<<<&&%%€#"
          val returnValue = escapeSpecialChars(user2)
          Assert.assertNotNull(returnValue)
          Assert.assertEquals(user, returnValue)
    }
    }

}
