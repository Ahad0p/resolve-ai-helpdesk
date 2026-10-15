package in.AhadDev.helpDeskBackend.repository;

import in.AhadDev.helpDeskBackend.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

//    Optional<Ticket> findByTicketId(Long ticketId);
    Optional<Ticket> findByEmail(String email);
}
