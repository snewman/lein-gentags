# lein-gentags

Ever wanted to navigate your Clojure code more effectively when in Emacs? Tags are the answer. lein-gentags will generate a TAGS file, which Emacs can then use to enable code navigation features.

## Usage

```
lein plugin install lein-gentags "0.0.1-SNAPSHOT"
```

Then you can run:

```
lein gentags
```

To search for a method definition or namespace delclaration, type:

```
M-. [symbol]
```

And when prompted navigate to the newly created TAGS file. When this file changes, you'll be prompted to reload the file, although it [is possible](http://stackoverflow.com/questions/4096580/how-to-make-emacs-reload-the-tags-file-automatically) to do this autoamtically.

## Thanks

Thanks go to Nurullah Akkaya for his [blog post](http://nakkaya.com/2009/12/13/getting-etags-to-index-clojure-files/) outlining the steps to get etags generating the right output for Clojure code. 

## License

Copyright (C) 2012 Sam Newman

Distributed under the Eclipse Public License, the same as Clojure.