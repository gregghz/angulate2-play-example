package com.lucidchart

import angulate2._
import angulate2.http._
import angulate2.router._
import org.scalajs.dom
import scala.scalajs.js
import scala.scalajs.js.annotation._

@Component(
  selector = "my-app",
  styleUrls = js.Array("assets/app.component.css"),
  template = """
<h1>{{title}}</h1>
    <nav>
        <a [routerLink]="['/dashboard']" routerLinkActive="active">Dashboard</a>
        <a [routerLink]="['/heroes']" routerLinkActive="active">Heroes</a>
    </nav>
<router-outlet></router-outlet>
""",
  directives = js.Array(ROUTER_DIRECTIVES),
  providers = @@[HeroService]
)
class AppComponent {
  val title = "Tour of Heroes"
}
