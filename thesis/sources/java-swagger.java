@Path("/report")
@Api(value = "ReportRestService",
     description = "The api for generating reports for customers")
public interface ReportRestService {

    @Path("/generate")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Generate report for the given customer id",
                  response = ReportModelDto.class)
    ReportModelDto generate(@QueryParam("id") @NotNull @Min(0) Long id);
}
