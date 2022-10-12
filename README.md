# Paypal Playground

This repository is used as a playground to experiment on building and testing an integration to the Paypal API.

## Test the application

Some of the tests will run against a local wiremock stub while others will run against the Paypal API in their sandbox.

In order to make sure all the tests can run you can simply create an `application-credentials.properties` under `src/main/resources` with the following properties:

```
paypal.auth.client-id=<your-sandbox-client-id>
paypal.auth.secret=<your-sandbox-secret>
```

Then simply run:

```
./mvnw clean test
```
