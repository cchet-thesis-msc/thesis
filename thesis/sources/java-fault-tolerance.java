@Produces   // CDI PRoducer
@OAuthToken // CDI Qualifier
@Dependent  // CDI Scope
// Retries 5 times with 100ms delay on given exceptions
@Retry(delay = 100L, maxRetries = 5, retryOn = {
  TokenResponseException.class})
// Timeout invocation after 5 seconds
@Timeout(value = 5L, unit = ChronoUnit.SECONDS)
String obtainOauthToken() throws IOException {
    return tokenRequest.execute().getAccessToken();
}
