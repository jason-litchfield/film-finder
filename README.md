# Film Finder
A simple Android application for viewing and filtering movie data from www.themoviedb.org.

This project uses view binding, ViewModel, and LiveData concepts from Android Architecture components.

Dependency injection is handled using the Dagger/Hilt framework. https://dagger.dev/hilt/

Remote web client requests are made using the Retrofit2 framework. https://square.github.io/retrofit/

## The Movie Database API
To access The Movie Database API endpoints, register for an account on www.themoviedb.org and
copy your API read access token (v4 auth).

Create a property in your global gradle.properties file named `tmdb_bearer_token` and set it equal
to your v4 authentication value.