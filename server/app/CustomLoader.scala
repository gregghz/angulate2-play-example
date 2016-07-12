package com.lucidchart

import _root_.controllers.Assets
import com.lucidchart.controllers._
import com.softwaremill.macwire._
import play.api._
import play.api.routing.Router
import router.Routes

class CustomLoader extends ApplicationLoader {
  def load(context: ApplicationLoader.Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment)
    }

    (new BuiltInComponentsFromContext(context) with CustomComponents).application
  }
}

trait CustomComponents extends BuiltInComponents with CustomModule {
  lazy val assets: Assets = wire[Assets]
  lazy val prefix: String = "/"
  lazy val router: Router = wire[Routes]
}

trait CustomModule { self: BuiltInComponents =>
  lazy val root: Root = wire[Root]
}