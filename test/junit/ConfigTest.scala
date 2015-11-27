package junit

import org.junit.Test
import utils.Config
import org.junit.Assert
import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import play.api.mvc.Controller
import play.mvc.Result._
import play.api.libs.json.Json._
import play.api.Play
import utils.Config
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

class ConfigTest extends Specification with Config {

  "Config test: correct key. should be Ok and return correct parameter" in {
    running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        val result = conf("test.application")
        result must not beNull;
        result must equalTo("not-test")
    }
  }


      "Config test 2: correct key. should be Ok and return correct parameter" in {
        running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
      //val found = conf("test.application")
      //Assert.assertNotNull(found)
      //Assert.assertEquals("not-test", found)

      val result = conf("test.application")
      result must not beNull;
      result must equalTo("not-test")
    }
    }

}
