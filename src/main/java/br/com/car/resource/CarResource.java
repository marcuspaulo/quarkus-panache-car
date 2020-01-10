package br.com.car.resource;

import br.com.car.model.Car;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarResource {

    @GET
    public List<Car> listAll() {
        return Car.listAll();
    }

    @GET
    @Path("/isAvaliableSale")
    public List<Car> listAllCarToSale() {
        return Car.list("isAvailableSale", true);
    }

    @GET
    @Path("/listCarSortNameAndBrand")
    public List<Car> listCarSortNameAndBrand() {
        return Car.list("order by name, brand");
    }

    @GET
    @Path("/listCarsByYear")
    public List<Car> listCarsByYear(@QueryParam("year") int year) {
        return Car.find("year(modelYear) = :year", Parameters.with("year", year)).list();
    }

    @GET
    @Path("/count")
    public Long count() {
        return Car.count();
    }

    @GET
    @Path("/countCarsAvaiableSale")
    public Long countCarsAvaiableSale() {
        return Car.count("isAvailableSale", true);
    }

    @GET
    @Path("/listByPage")
    public List<Car> listCarByPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        PanacheQuery<Car> listCars = Car.find("isAvailableSale", true);
        return listCars.page(Page.of(page, size)).list();
    }

    @POST
    @Transactional
    public Response create(Car car) {
        Car.persist(car);
        return Response.ok(car).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Car car) {

        Car carEntity = Car.findById(id);

        if (carEntity == null) {
            throw new WebApplicationException("Car with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        carEntity.setName(car.getName());
        carEntity.setBrand(car.getBrand());

        return Response.ok(carEntity).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Car carEntity = Car.findById(id);

        if (carEntity == null) {
            throw new WebApplicationException("Car with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        carEntity.delete();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}