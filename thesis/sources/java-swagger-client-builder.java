Client client;
ReportRestServiceApi api;
ResteasyClientBuilder builder = new ResteasyClientBuilder();

// Configure and build client
client = builder.connectionCheckoutTimeout(2, TimeUnit.SECONDS)
                .establishConnectionTimeout(2, TimeUnit.SECONDS)
                .socketTimeout(2, TimeUnit.SECONDS)
                .connectionTTL(2, TimeUnit.SECONDS)
                .connectionPoolSize(200)
                // Appends Tracing feature for jaxrs client
                .register(ClientTracingFeature.class)
                // Sets OAuth token on Authentication header
                .register(AppendOAuthFilter.class)
                .build();
                
// Create proxy for JAX-RS interface
api = ProxyBuilder.builder(ReportRestServiceApi.class,
                           client.target(url))
                  // If rest operation consumes all types,
                  // then use 'text/plain'
                  .defaultConsumes(MediaType.TEXT_PLAIN)
                  .build();
