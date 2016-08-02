package api

import reactivemongo.api.{DB, MongoConnection, MongoDriver}

trait ReactiveMongoApi {
  def driver: MongoDriver
  def connection: MongoConnection
  def db: DB
}
