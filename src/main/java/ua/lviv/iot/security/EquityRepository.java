package ua.lviv.iot.security;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.iot.security.models.Equity;

public interface EquityRepository extends CrudRepository<Equity, Integer> {
}