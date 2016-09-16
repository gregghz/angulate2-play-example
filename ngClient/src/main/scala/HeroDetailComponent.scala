package com.lucidchart

import angulate2._
import angulate2.router._
import org.scalajs.dom
import scala.annotation.{ Annotation, StaticAnnotation }
import scala.scalajs.js
import scala.scalajs.js.JSConverters._
import scala.scalajs.js.annotation.JSName
import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue

@Component(
  selector = "my-hero-detail",
  templateUrl = "assets/hero-detail.component.html",
  styleUrls = js.Array("assets/hero-detail.component.css")
)
class HeroDetailComponent(
  heroService: HeroService,
  route: ActivatedRoute
) extends OnInit with OnDestroy {
  @Input()
  var hero: js.UndefOr[Hero] = js.undefined
  var sub: js.UndefOr[js.Dynamic] = js.undefined

  def goBack(): Unit = {
    dom.window.history.back()
  }

  def ngOnInit(): Unit = {
    sub = route.params.subscribe { (params: js.Dynamic) =>
      val id = params.selectDynamic("id").asInstanceOf[String].toInt
      heroService.getHero(id).map { hero =>
        hero.map(this.hero = _)
      }
    }
  }

  def ngOnDestroy(): Unit = {
    sub.map(_.unsubscribe())
  }
}
