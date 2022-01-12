# Leiningen Template: Simple Clojure App

A Leiningen template intended for creating new Clojure CLI app or tool projects using a simplified / stripped-down base.

This template primarily exists for my own personal use, so some stuff is definitely more oriented towards
my own particular preferences regarding setup and organization of a Clojure project.

## Usage

```text
$ lein new net.gered/simple-app [your-project-name-here]
```

The resulting project starts up via a `main` function and during startup expects to be able to read an EDN configuration file
located in the current working directory called `config.edn`.

The project can be run simply by:

```text
$ lein run
```

A nREPL server will be started which can be connected to on port 7000 (configured via the aforementioned `config.edn`).

## Other Templates!

I have a few other "simple" Leiningen project templates that are along the same vein as this one:

* [Simple Clojure Web Service](https://github.com/gered/simple-web-service-template) - For web services to be consumed by other apps.
* [Simple Clojure Web Site](https://github.com/gered/simple-web-site-template) - For web sites using only server-side rendered HTML (**no** ClojureScript!).
* [Simple Clojure / ClojureScript Web App](https://github.com/gered/simple-web-app-template) - For web apps using Clojure and ClojureScript.

## License

Copyright © 2021 Gered King

Distributed under the the MIT License. See LICENSE for more details.
