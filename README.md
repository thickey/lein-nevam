# lein-nevam

A Leiningen plugin to convert Maven pom.xml files to project.clj files.

## Usage

Put `[lein-nevam "0.1.2"]` into the `:plugins` vector of your
`:user` profile, as shown in the [Leiningen documentation](https://github.com/technomancy/leiningen/blob/stable/doc/PROFILES.md#default-profiles).

lein-nevam is mean to be run in project directory that has an existing pom.xml file but has no project.clj.

    $ lein nevam

## Known Issues
- when running against 2.0.0-peview1, if you first run nevam outside of an existing project (as intented) you may see an [org.sonatype.aether.resolution.DependencyResolutionException](https://gist.github.com/2001365/ff53f1f984c390b84c7cfff79965b0620e422d91). Simply run `lein nevam` once from within an existing lein project. This is fixed in leiningen master.
- you'll need to have removed your repositories entry for clojars or it will clash with lein defaults, (see: ["java.lang.IllegalArgumentException: Duplicate key: clojars"] (https://groups.google.com/d/topic/leiningen/9h9zL8rQkVo/discussion)). This may not be an issue with 2.0.0-preview1
- you will need to exclude swank-clojure from dependencies to avoid conflcts (see: ["java.lang.IllegalArgumentException: No value supplied for key: true"](https://github.com/technomancy/leiningen/issues/313)).

## TODO
- support 1.x
- allow overwriting of existing project.clj file
- keep track of non-translatable pom setting (perhaps in :lein-nevam/pom-only) and hook into lein pom task to reinsert them into pom
    - perhaps print out information about the non-translatable things in pom

## License

Copyright © 2012 Tom Hickey

Distributed under the Eclipse Public License, the same as Clojure.
