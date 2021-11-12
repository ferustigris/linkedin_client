# Public APIs console client

The application allows creating of requests for different publicly available APIs.
The list of available APIs available if run the application without any parameters.

Different APIs have different queries, that you can see running the application with
name of the API as a first parameter.

# List of available APIs

java rest_api_client


REST API Query for open data from [https://datausa.io/](https://datausa.io/)

Example of data request:

```curl https://datausa.io/api/data?measures=Population```

Another examples could be found [here](https://datausa.io/profile/geo/united-states)


REST API Query for open data from [https://api.github.com/](https://api.github.com/)

Example of data request:
```curl https://api.github.com/organizations```

Another examples could be found [here](https://docs.github.com/en/rest/reference)
