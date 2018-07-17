@Path("/")
public interface ReportRestServiceApi  {

    /**
     * Generates the report for the given customer
     */
    @GET
    @Path("/report/generate")
    @Produces({ "application/json" })
   AppReportModel generate(@QueryParam("id") @NotNull @Min(0) Long id);
}
