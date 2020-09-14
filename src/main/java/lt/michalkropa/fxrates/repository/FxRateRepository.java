package lt.michalkropa.fxrates.repository;

import lt.michalkropa.fxrates.entity.FxRateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FxRateRepository extends CrudRepository<FxRateEntity, Long> {
    FxRateEntity findByCurrency(String currency);

    List<FxRateEntity> findAllByDateEquals(LocalDate date);
}
