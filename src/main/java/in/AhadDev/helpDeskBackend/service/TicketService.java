package in.AhadDev.helpDeskBackend.service;

import in.AhadDev.helpDeskBackend.entity.Ticket;
import in.AhadDev.helpDeskBackend.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    // create ticket
    @Transactional
    public Ticket createTicket(Ticket ticket){
        ticket.setId(null);
        return ticketRepository.save(ticket);
    }

    // get ticket
    public Ticket getTicket(Long id){
        return ticketRepository.findById(id).orElse(null);
    }

    //get ticket by email
    public Ticket getTicketByEmail(String email){
        return ticketRepository.findByEmail(email).orElse(null);
    }

    // updaet ticket
//    public Ticket updateTicket(Long id, Ticket updatedTicket) {
//
//        Ticket existingTicket = ticketRepository.findById(id)
//                .orElseThrow(() ->
//                        new RuntimeException("Ticket not found: " + id));
//
//        existingTicket.setSummary(updatedTicket.getSummary());
//        existingTicket.setPriority(updatedTicket.getPriority());
//        existingTicket.setStatus(updatedTicket.getStatus());
//        existingTicket.setUsername(updatedTicket.getUsername());
//
//        return ticketRepository.save(existingTicket);
//    }

    public Ticket updateTicket( Ticket ticket){
        return ticketRepository.save(ticket);
    }
}
