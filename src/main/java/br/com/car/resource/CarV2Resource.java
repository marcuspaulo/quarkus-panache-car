package br.com.car.resource;

import br.com.car.model.Car;
import br.com.car.repository.CarRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Path("/cars/v2")
@Produces(MediaType.APPLICATION_JSON)
public class CarV2Resource {

    @Inject
    private CarRepository carRepository;

    @GET
    public List<Car> listAll() {
        return carRepository.listAll();
    }

    @GET
    @Path("/isAvaliableSale")
    public List<Car> listAllCarToSale() {
        return carRepository.listAllCarToSale();
    }

    @GET
    @Path("/listCarSortNameAndBrand")
    public List<Car> listCarSortNameAndBrand() {
        return carRepository.listCarSortNameAndBrand();
    }

    @GET
    @Path("/listCarsByYear")
    public List<Car> listCarsByYear(@QueryParam("year") int year) {
        return carRepository.listCarsByYear(year);
    }

    @GET
    @Path("/count")
    public Long count() {
        return carRepository.countCar();
    }

    @GET
    @Path("/countCarsAvaiableSale")
    public Long countCarsAvaiableSale() {
        return carRepository.countCarsAvaiableSale();
    }

    @GET
    @Path("/listByPage")
    public List<Car> listCarByPage(@QueryParam("page") int page, @QueryParam("size") int size) {
        return carRepository.listCarByPage(page, size);
    }

    @POST
    public Response create(Car car) {
        Car carEntity = carRepository.save(car);
        return Response.ok(car).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Car car) {

        Car carUpdated = carRepository.update(id, car);

        return Response.ok(carUpdated).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        carRepository.remove(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}