# angulate2-play-example

This is a simple play application that (currently) uses a fork of angulate2 to bootstrap and run a simple angular2/scala.js application.

## To run

Currently to run this example there are four main steps:

1. Locally publish my fork of angulate2 (pending [PR26](https://github.com/jokade/angulate2/pull/26) and [PR27](https://github.com/jokade/angulate2/pull/27))
2. Build a patched version of Angular 2.0.0-rc.4 (This should only be necessary until Angular's RC5 release)
3. Clone the example project and copy built angular sources into the webroot
4. Build js deps and run the example project

``` bash
# 1.
git clone https://github.com/gregghz/angulate2.git /path/to/workdir/
cd /path/to/workdir/angulate2
sbt publishLocal

# 2.
git clone https://github.com/gregghz/angular.git /path/to/workdir/
cd /path/to/workdir/angular
git checkout 2.0.0-rc.4-angulate2-fixes
# follow the guide [here](https://github.com/gregghz/angular/blob/2.0.0-rc.4-angulate2-fixes/DEVELOPER.md) to build Angular2
./build.sh

# 3.
git clone https://github.com/gregghz/angulate2-play-example.git /path/to/workdir/
cp -r /path/to/workdir/angular/dist/packages-dist /path/to/workdir/angulate2-play-example/server/public/

# 4.
cd /path/to/workdir/angulate2-play-example/server/public/deps
npm install
cd /path/to/workdir/angulate2-play-example
sbt server/run
```
