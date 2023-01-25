# gph-html

An ultra-light change-friendly dsl for generating html output.

## Features

* The usual benefit of a dsl: reads and scans easily.
* Easy factoring and composition, by method or class extraction.
* Basic tag model that is easily extended.
* No implementation inheritance.
* No external dependencies.

## Downsides

* No maven dependency yet, you'll have to build it.
* Very incomplete, though still easy to add to.
* Does not yet support the css model I want to use.

## Sample Code

```kotlin
val page = BasicHtmlPage.page {
    head {
        title("My Cool Page")
        meta {
            attributes["charset"] = "utf-8"
        }
        link("/gph.css", "stylesheet")
    }
    body {
        // extracted fragment to a new custom class
        +Header()

        // extracted fragment to a new method
        banner()

        // raw direct text
        +"This is raw output."

        // safe direct text
        -"This is uuencoded output."

        // basic tags already present
        div("blog-text") {
            +ArticleColumn(metaData, text)
            +ArticleSidebar(metaData)
        }
    }
```

## Near-Term

This dsl is in use as of 2023-01-25, but there is still a lot to do:

* More tests.
* Maven repository.
* Pretty-printing on output.
* A CSS and Styles model.

## More Info

Please check the project's wiki for more thorough documentation.