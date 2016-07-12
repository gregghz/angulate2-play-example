package com.lucidchart

import angulate2._
import angulate2.router._
import scala.scalajs.js
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

@Component(
  selector = "my-dashboard",
  templateUrl = "assets/dashboard.component.html",
  styleUrls = js.Array("assets/dashboard.component.css")
)
class DashboardComponent(
  router: Router,
  heroService: HeroService
) extends OnInit {
  var heroes: js.Array[Hero] = js.Array()

  def ngOnInit(): Unit = {
    heroService.getHeroes().map { hs =>
      heroes = hs.drop(1).take(4)
    }
  }

  def gotoDetail(hero: Hero): Unit = {
    router.navigate(js.Array[js.Any]("detail", hero.id))
  }
}
