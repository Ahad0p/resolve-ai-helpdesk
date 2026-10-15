package in.AhadDev.helpDeskBackend.dto;

import in.AhadDev.helpDeskBackend.entity.Priority;
import in.AhadDev.helpDeskBackend.entity.Status;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTicketDTO {

    private String summary;
    private String email;
    private Priority priority;
    private String category;
    private String description;
    private Status status;
}