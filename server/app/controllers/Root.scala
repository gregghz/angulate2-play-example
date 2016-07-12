package com.lucidchart.controllers

import play.api._
import play.api.mvc._

class Root(
  env: Environment
) extends Controller {
  def index(path: String) = Action {
    Ok(views.html.index(env))
  }
}