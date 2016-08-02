package controllers

import javax.inject.Inject

import play.api.libs.json.{JsArray, Json}
import play.api.mvc.{Action, Controller}
import play.modules.reactivemongo._


class MyController @Inject() (val reactiveMongoApi: ReactiveMongoApi)
  extends Controller with MongoController with ReactiveMongoComponents {



}
