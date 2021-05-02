package br.com.zupacademy.rafaela.casadocodigo.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

    @Query("select s from State s where s.country.id = :countryId")
    List<StateProjection> findStateIdByCountryId(Long countryId);
}
