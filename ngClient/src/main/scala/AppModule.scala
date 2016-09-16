package com.lucidchart

import angulate2._
import scala.scalajs.js

@NgModule(
  imports = js.Array(
    BrowserModule,
    FormsModule,
    HttpModule,
    Routes.routing
  ),
  declarations = @@[
    AppComponent,
    HeroDetailComponent,
    HeroesComponent,
    DashboardComponent
  ],
  providers = @@[HeroService],
  bootstrap = @@[AppComponent]
)
class AppModule {

}