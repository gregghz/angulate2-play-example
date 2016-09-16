package com.lucidchart

import angulate2._
import angulate2.http._
import rxjs.core.Observable
import scala.concurrent.Future
import scala.scalajs.js
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

@Injectable()
class HeroService(http: Http) {
  val heroesUrl = "app/heroes"

  def getHeroes(): Future[js.Array[Hero]] = {
    //http.get(heroesUrl).toFuture.map(response => response.json())
    Future.successful(Heroes.all)
  }

  def getHero(id: Int): Future[Option[Hero]] = {
    getHeroes().map { heroes =>
      heroes.find(_.id == id)
    }
  }
}

object Heroes {
  val all: js.Array[Hero] = js.Array(
    Hero(11, "Mr. Nice"),
    Hero(12, "Narco"),
    Hero(13, "Bombasto"),
    Hero(14, "Celeritas"),
    Hero(15, "Magneta"),
    Hero(16, "RubberMan"),
    Hero(17, "Dynama"),
    Hero(18, "Dr IQ"),
    Hero(19, "Magma"),
    Hero(20, "Tornado")
  )
}
