# angulate2-play-example

This is a simple play application that (currently) uses a fork of angulate2 to bootstrap and run a simple angular2/scala.js application.

## To run

Currently to run this example there are four main steps:

1. Locally publish my fork of angulate2 (pending [PR26](https://github.com/jokade/angulate2/pull/26) and [PR27](https://github.com/jokade/angulate2/pull/27) and some changes that don't yet have a PR)
2. Clone the example project
3. run the example project

``` bash
# 1.
git clone https://github.com/gregghz/angulate2.git /path/to/workdir/
cd /path/to/workdir/angulate2
sbt publishLocal

# 2.
git clone https://github.com/gregghz/angulate2-play-example.git /path/to/workdir/

# 3.
cd /path/to/workdir/angulate2-play-example
sbt server/run
```
