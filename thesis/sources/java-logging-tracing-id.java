@Provider
public static class MDCContainerRequestFilter
  implements ContainerRequestFilter {

  @Inject
  private Instance<Scope> scopeInstance;

  @Override
  public void filter(ContainerRequestContext requestContext)
    throws IOException {
    // Uber specific format 'aaa:ffff:0:1'
    final String tracingId = scopeInstance.get().span()
                              .context().toString()
                              .split(":")[0];
    MDC.put("transaction.id", tracingId);
  }
}
