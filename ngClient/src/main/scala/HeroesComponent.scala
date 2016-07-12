package com.lucidchart

import angulate2._
import angulate2.router._
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scalajs.js

@Component(
  selector = "my-heroes",
  templateUrl = "assets/heroes.component.html",
  styleUrls = js.Array("assets/heroes.component.css")
)
class HeroesComponent(
  router: Router,
  heroService: HeroService
) extends OnInit {
  var heroes = js.Array[Hero]()
  var selectedHero: js.UndefOr[Hero] = js.undefined

  def ngOnInit(): Unit = {
    heroService.getHeroes().map { hs =>
      heroes = hs
    }
  }

  def onSelect(hero: Hero): Unit = {
    selectedHero = hero
  }

  def gotoDetail(): Unit = {
    selectedHero.map { sh =>
      router.navigate(js.Array[js.Any]("detail", sh.id))
    }
  }
}
