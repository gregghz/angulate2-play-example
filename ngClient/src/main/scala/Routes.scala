package com.lucidchart

import angulate2._
import angulate2.router._
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport
object Routes {

  @JSExport
  val routes: RouterConfig = RouterConfig(
    RDef(path = "", redirectTo = "dashboard", pathMatch = "full"),
    RDef(path = "heroes", component = @#[HeroesComponent]),
    RDef(path = "dashboard", component = @#[DashboardComponent]),
    RDef(path = "detail/:id", component = @#[HeroDetailComponent])
  )

  @JSExport
  val APP_ROUTER_PROVIDERS = js.Array(
    js.Dynamic.global.ng.router.provideRouter(routes)
  )

}
