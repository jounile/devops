package specs2

import org.specs2.mutable._
import play.api.test._
import play.api.test.Helpers._
import play.api.mvc.Controller
import play.mvc.Result
import play.api.libs.json.Json._
import play.api.Play
import utils.Config

class ConfigSpecs extends Specification with Config {

  "Config test: correct key. should be Ok and return correct parameter" in {
    running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        val result = conf("test.application")
        result must not beNull;
        result must equalTo("not-test")
    }
  }

  "Config test: key missing: should not be Ok and returning key missing text" in {
    running(FakeApplication(additionalConfiguration = inMemoryDatabase())) {
        val result = conf("test.application2")
        result must not beNull;
        result must equalTo("key missing")
    }
  }
}
