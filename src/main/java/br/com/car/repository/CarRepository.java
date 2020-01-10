package br.com.car.repository;

import br.com.car.model.Car;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {

    /**
     * Método responsável por listar todos os veículos
     * @return
     */
    public List<Car> listAll() {
        return listAll();
    }

    /**
     * Método responável por listar todos os veículos disponíveis para venda
     * @return List<Car>
     */
    public List<Car> listAllCarToSale() {
        return list("isAvailableSale", true);
    }

    /**
     * Método responsável por listar os veículos ordenados por Nome e Marca
     * @return List<Car>
     */
    public List<Car> listCarSortNameAndBrand() {
        return list("order by name, brand");
    }

    /**
     * Método responsável por listar os veículos por ano (parâmetro)
     * @param year
     * @return List<Car>
     */
    public List<Car> listCarsByYear(int year) {
        return find("year(modelYear) = :year", Parameters.with("year", year)).list();
    }

    /**
     * Método responsável por retornar a quantidade de veículos cadastrados no banco de dados.
     * @return long
     */
    public long countCar() {
        return count();
    }

    /**
     * Método responsável por retornar a quantidade de veículos disponíveis para venda
     * @return Long
     */
    public Long countCarsAvaiableSale() {
        return count("isAvailableSale", true);
    }

    /**
     * Método responsável por listar os veículos com paginação
     * @param page
     * @param size
     * @return List<Car>
     */
    public List<Car> listCarByPage(int page, int size) {
        PanacheQuery<Car> listCars = find("isAvailableSale", true);
        return listCars.page(Page.of(page, size)).list();
    }

    /**
     * Método responsável por retornar o veículo através do nome
     * @param name
     * @return Car
     */
    public Car findByName(String name){
        return find("name", name).firstResult();
    }

    /**
     * Método responsável por salvar veículos
     * @param car
     * @return Car
     */
    @Transactional
    public Car save(Car car) {
        persist(car);
        return car;
    }

    /**
     * Método responsável por atualizar os dados de um veículo
     * @param id
     * @param car
     * @return Car
     */
    @Transactional
    public Car update(Long id, Car car) {
        Car carEntity = findById(id);

        if (carEntity == null) {
            throw new WebApplicationException("Car with id of " + id + " does not exist.", Response.Status.NOT_FOUND);
        }

        carEntity.setName(car.getName());
        carEntity.setBrand(car.getBrand());
        persist(carEntity);
        return carEntity;
    }

    /**
     * Método responsável por remover um veículo
     * @param id
     */
    @Transactional
    public void remove(Long id) {
        Car carEntity = findById(id);

        if (carEntity == null) {
            throw new WebApplicationException("Car with id " + id + " does not exist.", Response.Status.NOT_FOUND);
        }
        delete(carEntity);
    }
}


