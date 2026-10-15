package in.AhadDev.helpDeskBackend.tools;

import in.AhadDev.helpDeskBackend.dto.CreateTicketDTO;
import in.AhadDev.helpDeskBackend.entity.Ticket;
import in.AhadDev.helpDeskBackend.repository.TicketRepository;
import in.AhadDev.helpDeskBackend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;
    private final TicketRepository ticketRepository;

    // create ticket tool
    @Tool(description = "Create a new help desk ticket")
    public String createTicketTool(
            @ToolParam(description = "Fields required to create a ticket")
            CreateTicketDTO dto) {

        try {
            Ticket ticket = Ticket.builder()
                    .summary(dto.getSummary())
                    .email(dto.getEmail())
                    .priority(dto.getPriority())
                    .category(dto.getCategory())
                    .description(dto.getDescription())
                    .status(dto.getStatus())
                    .build();

            Ticket savedTicket = ticketService.createTicket(ticket);

            return """
                {"success":true,"ticketId":%d,"message":"Ticket created successfully"}
                """.formatted(savedTicket.getId()).trim();

        } catch (Exception e) {
            e.printStackTrace();
            return """
                {"success":false,"message":"Ticket creation failed"}
                """;
        }
    }

    @Tool(description = "This tool helps to get ticket by username.")
    public Ticket getTicketByEmail(@ToolParam(description = " email of whose ticket is required ") String email){
        return ticketService.getTicketByEmail(email);
    }

    @Tool(description = "This tool helps to update ticket.")
    public Ticket updateTicket(@ToolParam(description = "new ticket fields required to update with ticket id.") Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    // get current system time
    @Tool(description = "This tool helps to get current system time.")
    public String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }
}
