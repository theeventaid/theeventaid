package com.tgj.eventaid.repositories;

import com.tgj.eventaid.models.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends CrudRepository<Venue, Long> {}
